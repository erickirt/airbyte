# NewsData.io
Connector for NewsData.io to get the latest news in pagination and the latest news from specific countries, categories and domains. You can also get the news sources from specific categories, countries and languages.

:::info
Historical News is only available for premium users of NewsData service.
:::

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key.  |  |
| `start_date` | `string` | Start Date.  |  |
| `end_date` | `string` | End Date.  |  |
| `categories` | `string` | Categories to filter news.  |  |
| `countries` | `string` | Countries to filter news.  |  |
| `languages` | `string` | Language to filter news.  |  |
| `domains` | `string` | Specific domains to filter news  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| latest_news | `article_id` | DefaultPaginator | ✅ |  ❌  |
| historical_news | `article_id` | DefaultPaginator | ✅ |  ✅  |


## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.31 | 2025-08-02 | [64276](https://github.com/airbytehq/airbyte/pull/64276) | Update dependencies |
| 0.0.30 | 2025-07-26 | [63855](https://github.com/airbytehq/airbyte/pull/63855) | Update dependencies |
| 0.0.29 | 2025-07-19 | [63446](https://github.com/airbytehq/airbyte/pull/63446) | Update dependencies |
| 0.0.28 | 2025-07-12 | [63239](https://github.com/airbytehq/airbyte/pull/63239) | Update dependencies |
| 0.0.27 | 2025-07-05 | [62569](https://github.com/airbytehq/airbyte/pull/62569) | Update dependencies |
| 0.0.26 | 2025-06-28 | [62325](https://github.com/airbytehq/airbyte/pull/62325) | Update dependencies |
| 0.0.25 | 2025-06-21 | [61915](https://github.com/airbytehq/airbyte/pull/61915) | Update dependencies |
| 0.0.24 | 2025-06-14 | [60542](https://github.com/airbytehq/airbyte/pull/60542) | Update dependencies |
| 0.0.23 | 2025-05-10 | [60065](https://github.com/airbytehq/airbyte/pull/60065) | Update dependencies |
| 0.0.22 | 2025-05-03 | [59466](https://github.com/airbytehq/airbyte/pull/59466) | Update dependencies |
| 0.0.21 | 2025-04-27 | [59099](https://github.com/airbytehq/airbyte/pull/59099) | Update dependencies |
| 0.0.20 | 2025-04-19 | [58465](https://github.com/airbytehq/airbyte/pull/58465) | Update dependencies |
| 0.0.19 | 2025-04-12 | [57844](https://github.com/airbytehq/airbyte/pull/57844) | Update dependencies |
| 0.0.18 | 2025-04-05 | [57285](https://github.com/airbytehq/airbyte/pull/57285) | Update dependencies |
| 0.0.17 | 2025-03-29 | [56793](https://github.com/airbytehq/airbyte/pull/56793) | Update dependencies |
| 0.0.16 | 2025-03-22 | [56045](https://github.com/airbytehq/airbyte/pull/56045) | Update dependencies |
| 0.0.15 | 2025-03-08 | [55513](https://github.com/airbytehq/airbyte/pull/55513) | Update dependencies |
| 0.0.14 | 2025-03-01 | [54779](https://github.com/airbytehq/airbyte/pull/54779) | Update dependencies |
| 0.0.13 | 2025-02-22 | [54292](https://github.com/airbytehq/airbyte/pull/54292) | Update dependencies |
| 0.0.12 | 2025-02-15 | [53792](https://github.com/airbytehq/airbyte/pull/53792) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53259](https://github.com/airbytehq/airbyte/pull/53259) | Update dependencies |
| 0.0.10 | 2025-02-01 | [52723](https://github.com/airbytehq/airbyte/pull/52723) | Update dependencies |
| 0.0.9 | 2025-01-25 | [52262](https://github.com/airbytehq/airbyte/pull/52262) | Update dependencies |
| 0.0.8 | 2025-01-18 | [51801](https://github.com/airbytehq/airbyte/pull/51801) | Update dependencies |
| 0.0.7 | 2025-01-11 | [51173](https://github.com/airbytehq/airbyte/pull/51173) | Update dependencies |
| 0.0.6 | 2024-12-28 | [50643](https://github.com/airbytehq/airbyte/pull/50643) | Update dependencies |
| 0.0.5 | 2024-12-21 | [50097](https://github.com/airbytehq/airbyte/pull/50097) | Update dependencies |
| 0.0.4 | 2024-12-14 | [49630](https://github.com/airbytehq/airbyte/pull/49630) | Update dependencies |
| 0.0.3 | 2024-12-12 | [49259](https://github.com/airbytehq/airbyte/pull/49259) | Update dependencies |
| 0.0.2 | 2024-12-11 | [48999](https://github.com/airbytehq/airbyte/pull/48999) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.1 | 2024-11-08 | | Initial release by [@faria-karim-porna](https://github.com/faria-karim-porna) via Connector Builder |

</details>
