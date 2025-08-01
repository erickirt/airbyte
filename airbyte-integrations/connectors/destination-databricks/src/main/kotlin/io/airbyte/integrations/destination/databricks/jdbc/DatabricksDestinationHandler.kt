/*
 * Copyright (c) 2024 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.integrations.destination.databricks.jdbc

import com.fasterxml.jackson.databind.JsonNode
import io.airbyte.cdk.db.jdbc.JdbcDatabase
import io.airbyte.cdk.integrations.base.JavaBaseConstants
import io.airbyte.cdk.integrations.base.JavaBaseConstants.COLUMN_NAME_AB_EXTRACTED_AT
import io.airbyte.cdk.integrations.base.JavaBaseConstants.COLUMN_NAME_AB_GENERATION_ID
import io.airbyte.cdk.integrations.base.JavaBaseConstants.COLUMN_NAME_AB_META
import io.airbyte.cdk.integrations.base.JavaBaseConstants.COLUMN_NAME_AB_RAW_ID
import io.airbyte.cdk.integrations.destination.jdbc.ColumnDefinition
import io.airbyte.cdk.integrations.destination.jdbc.TableDefinition
import io.airbyte.integrations.base.destination.operation.AbstractStreamOperation
import io.airbyte.integrations.base.destination.typing_deduping.AirbyteProtocolType
import io.airbyte.integrations.base.destination.typing_deduping.AirbyteProtocolType.STRING
import io.airbyte.integrations.base.destination.typing_deduping.AirbyteProtocolType.TIMESTAMP_WITH_TIMEZONE
import io.airbyte.integrations.base.destination.typing_deduping.DestinationHandler
import io.airbyte.integrations.base.destination.typing_deduping.DestinationInitialStatus
import io.airbyte.integrations.base.destination.typing_deduping.InitialRawTableStatus
import io.airbyte.integrations.base.destination.typing_deduping.Sql
import io.airbyte.integrations.base.destination.typing_deduping.StreamConfig
import io.airbyte.integrations.base.destination.typing_deduping.StreamId
import io.airbyte.integrations.base.destination.typing_deduping.migrators.MinimumDestinationState
import io.github.oshai.kotlinlogging.KotlinLogging
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Objects
import java.util.Optional
import java.util.UUID
import kotlin.streams.asSequence

class DatabricksDestinationHandler(
    private val sqlGenerator: DatabricksSqlGenerator,
    private val databaseName: String,
    private val jdbcDatabase: JdbcDatabase,
) : DestinationHandler<MinimumDestinationState.Impl> {

    private val log = KotlinLogging.logger {}

    override fun execute(sql: Sql) {
        val transactions: List<List<String>> = sql.transactions
        val queryId = UUID.randomUUID()
        for (transaction in transactions) {
            val transactionId = UUID.randomUUID()
            log.info { "Executing sql $queryId-$transactionId: ${transactions.joinToString("\n")}" }
            val startTime = System.currentTimeMillis()

            try {
                // Databricks DOES NOT support autocommit false. ACID guarantees are within a single
                // table
                // so only MERGE is the supported way if updates/deletes to be done in source &
                // target table.
                // CREATE OR REPLACE...SELECT * from... for swapping a table.
                transaction.forEach { jdbcDatabase.execute(it) }
            } catch (e: SQLException) {
                log.error(e) {
                    "Sql $queryId-$transactionId failed in ${System.currentTimeMillis() - startTime} ms"
                }
                throw e
            }
            log.info {
                "Sql $queryId-$transactionId completed in ${System.currentTimeMillis() - startTime} ms"
            }
        }
    }

    override fun gatherInitialState(
        streamConfigs: List<StreamConfig>
    ): List<DestinationInitialStatus<MinimumDestinationState.Impl>> {
        val streamIds = streamConfigs.stream().map { it.id }.toList()
        val existingTables = findExistingTable(streamIds)
        return streamConfigs
            .stream()
            .asSequence()
            .map {
                val namespace = it.id.finalNamespace
                val name = it.id.finalName
                val initialRawTableStatus = getInitialRawTableState(it.id, suffix = "")
                val initialTempRawTableStatus =
                    getInitialRawTableState(
                        it.id,
                        suffix = AbstractStreamOperation.TMP_TABLE_SUFFIX,
                    )
                if (
                    existingTables.contains(namespace) &&
                        existingTables[namespace]?.contains(name) == true
                ) {
                    // The final table exists. Do some extra querying to find out what it looks
                    // like.
                    val isFinalTableSchemaMismatch =
                        !isSchemaMatch(it, existingTables[namespace]?.get(name)!!)
                    val isFinalTableEmpty = isFinalTableEmpty(it.id)
                    DestinationInitialStatus(
                        it,
                        isFinalTablePresent = true,
                        initialRawTableStatus = initialRawTableStatus,
                        initialTempRawTableStatus = initialTempRawTableStatus,
                        isFinalTableSchemaMismatch,
                        isFinalTableEmpty,
                        MinimumDestinationState.Impl(needsSoftReset = false),
                        // for now, just use 0. this means we will always use a temp final table.
                        // platform has a workaround for this, so it's OK.
                        // TODO only fetch this on truncate syncs
                        // TODO once we have destination state, use that instead of a query
                        finalTableGenerationId = 0,
                        finalTempTableGenerationId = null,
                    )
                } else {
                    // The final table doesn't exist, so no further querying to do.
                    DestinationInitialStatus(
                        it,
                        isFinalTablePresent = false,
                        initialRawTableStatus = initialRawTableStatus,
                        initialTempRawTableStatus = initialTempRawTableStatus,
                        isSchemaMismatch = false,
                        isFinalTableEmpty = true,
                        destinationState = MinimumDestinationState.Impl(needsSoftReset = false),
                        finalTableGenerationId = null,
                        finalTempTableGenerationId = null,
                    )
                }
            }
            .toList()
    }

    override fun createNamespaces(schemas: Set<String>) {
        for (schema in schemas) {
            // TODO: Optimize by running SHOW SCHEMAS; rather than CREATE SCHEMA if not exists
            execute(sqlGenerator.createSchema(schema))
        }
    }

    private fun findExistingTable(
        streamIds: List<StreamId>
    ): Map<String, LinkedHashMap<String, TableDefinition>> {
        // Databricks has a limit of 256 parameters per query
        // We use 1 parameter for table_catalog + 2N parameters (N for schemas, N for table names)
        // So we need to ensure 1 + 2*batchSize <= 256, which means batchSize <= 127.5
        // Using 125 to be safe
        val batchSize = 125
        val allResults = mutableListOf<JsonNode>()

        // Process streams in batches to avoid exceeding parameter limit
        for (batch in streamIds.chunked(batchSize)) {
            val paramHolder = IntRange(1, batch.size).joinToString { "?" }

            val infoSchemaQuery =
                """
                |SELECT table_schema, table_name, column_name, data_type, is_nullable
                |FROM ${databaseName.lowercase()}.information_schema.columns
                |WHERE
                |   table_catalog = ?
                |   AND table_schema IN ($paramHolder)
                |   AND table_name IN ($paramHolder)
                |ORDER BY table_schema, table_name, ordinal_position
            """.trimMargin()

            val namespaces = batch.asSequence().map { it.finalNamespace }.toList().toTypedArray()
            val names = batch.asSequence().map { it.finalName }.toList().toTypedArray()
            val batchResults =
                jdbcDatabase.queryJsons(
                    infoSchemaQuery,
                    databaseName.lowercase(),
                    *namespaces,
                    *names
                )

            allResults.addAll(batchResults)
        }

        // GroupBys and Associates preserve original iteration order, we used LinkedHashMap in old
        // java land so adapting to it.
        return allResults
            .groupBy { it.get("table_schema").asText()!! }
            .mapValues { (_, v) ->
                v.groupBy { it.get("table_name").asText()!! }
                    .mapValuesTo(LinkedHashMap()) { (_, v) ->
                        TableDefinition(
                            v.associateTo(LinkedHashMap()) {
                                it.get("column_name").asText()!! to
                                    ColumnDefinition(
                                        it.get("column_name").asText(),
                                        it.get("data_type").asText(),
                                        0,
                                        it.get("is_nullable")
                                            .asText()
                                            .equals("YES", ignoreCase = true),
                                    )
                            },
                        )
                    }
            }
    }

    private fun isSchemaMatch(
        streamConfig: StreamConfig,
        tableDefinition: TableDefinition
    ): Boolean {
        val isAbRawIdMatch =
            tableDefinition.columns.contains(COLUMN_NAME_AB_RAW_ID) &&
                DatabricksSqlGenerator.toDialectType(STRING) ==
                    tableDefinition.columns[COLUMN_NAME_AB_RAW_ID]?.type
        val isAbExtractedAtMatch =
            tableDefinition.columns.contains(COLUMN_NAME_AB_EXTRACTED_AT) &&
                DatabricksSqlGenerator.toDialectType(TIMESTAMP_WITH_TIMEZONE) ==
                    tableDefinition.columns[COLUMN_NAME_AB_EXTRACTED_AT]?.type
        val isAbMetaMatch =
            tableDefinition.columns.contains(COLUMN_NAME_AB_META) &&
                DatabricksSqlGenerator.toDialectType(STRING) ==
                    tableDefinition.columns[COLUMN_NAME_AB_META]?.type
        val isAbGenerationMatch =
            tableDefinition.columns.contains(COLUMN_NAME_AB_GENERATION_ID) &&
                DatabricksSqlGenerator.toDialectType(AirbyteProtocolType.INTEGER) ==
                    tableDefinition.columns[COLUMN_NAME_AB_GENERATION_ID]?.type
        if (!isAbRawIdMatch || !isAbExtractedAtMatch || !isAbMetaMatch || !isAbGenerationMatch)
            return false

        val expectedColumns =
            streamConfig.columns.entries.associate {
                it.key.name to DatabricksSqlGenerator.toDialectType(it.value)
            }
        val actualColumns =
            tableDefinition.columns.entries
                .filter {
                    (it.key != COLUMN_NAME_AB_RAW_ID &&
                        it.key != COLUMN_NAME_AB_EXTRACTED_AT &&
                        it.key != COLUMN_NAME_AB_META &&
                        it.key != COLUMN_NAME_AB_GENERATION_ID)
                }
                .associate {
                    it.key to if (it.value.type != "DECIMAL") it.value.type else "DECIMAL(38, 10)"
                }
        return actualColumns == expectedColumns
    }

    private fun isFinalTableEmpty(id: StreamId): Boolean {
        return !jdbcDatabase.queryBoolean(
            "SELECT EXISTS (SELECT 1 from $databaseName.${
                id.finalTableId(
                    DatabricksSqlGenerator.QUOTE,
                )
            });",
        )
    }

    private fun findLastLoadedTs(query: String): Optional<Instant> {
        return jdbcDatabase
            .bufferedResultSetQuery(
                { connection: Connection -> connection.createStatement().executeQuery(query) },
                { resultSet: ResultSet ->
                    resultSet.getObject("last_loaded_at", LocalDateTime::class.java)
                },
            )
            .stream()
            .filter { ts: LocalDateTime? -> Objects.nonNull(ts) }
            .findFirst()
            .map {
                // Databricks doesn't have offset stored, so we always use UTC as the supposed
                // timezone
                it.toInstant(ZoneOffset.UTC)
            }
    }

    private fun getInitialRawTableState(id: StreamId, suffix: String): InitialRawTableStatus {
        jdbcDatabase
            .executeMetadataQuery { metadata ->
                // Handle resultset call in the function which will be closed
                // after the scope is exited
                val resultSet =
                    metadata.getTables(
                        databaseName,
                        id.rawNamespace,
                        id.rawName + suffix,
                        null,
                    )
                resultSet?.next() ?: false
            }
            .let {
                if (!it) {
                    return InitialRawTableStatus(
                        rawTableExists = false,
                        hasUnprocessedRecords = false,
                        maxProcessedTimestamp = Optional.empty(),
                    )
                }
            }

        val minExtractedAtLoadedNotNullQuery =
            """
            |SELECT min(`$COLUMN_NAME_AB_EXTRACTED_AT`) as last_loaded_at
            |FROM $databaseName.${id.rawTableId(DatabricksSqlGenerator.QUOTE, suffix)}
            |WHERE ${JavaBaseConstants.COLUMN_NAME_AB_LOADED_AT} IS NULL
            |""".trimMargin()
        val maxExtractedAtQuery =
            """
            |SELECT max(`$COLUMN_NAME_AB_EXTRACTED_AT`) as last_loaded_at
            |FROM $databaseName.${id.rawTableId(DatabricksSqlGenerator.QUOTE, suffix)}
        """.trimMargin()

        findLastLoadedTs(minExtractedAtLoadedNotNullQuery)
            .map { it.minusSeconds(1) }
            .let {
                if (it.isPresent)
                    return InitialRawTableStatus(
                        rawTableExists = true,
                        hasUnprocessedRecords = true,
                        maxProcessedTimestamp = it,
                    )
            }
        findLastLoadedTs(maxExtractedAtQuery).let {
            return InitialRawTableStatus(
                rawTableExists = true,
                hasUnprocessedRecords = false,
                maxProcessedTimestamp = it,
            )
        }
    }

    override fun commitDestinationStates(
        destinationStates: Map<StreamId, MinimumDestinationState.Impl>
    ) {
        // do Nothing
    }

    fun query(query: String): List<JsonNode> = jdbcDatabase.queryJsons(query)
}
