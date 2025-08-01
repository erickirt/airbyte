# Miro

Airbyte connector for Miro can be used to extract data related to board content, user activities, and collaboration metrics, enabling integration with data warehouses and further analysis of team interactions and productivity.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| boards | id | DefaultPaginator | ✅ |  ❌  |
| board_users |  | DefaultPaginator | ✅ |  ❌  |
| board_items |  | DefaultPaginator | ✅ |  ❌  |
| board_tags |  | DefaultPaginator | ✅ |  ❌  |
| board_groups |  | No pagination | ✅ |  ❌  |
| board_connectors | id | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.32 | 2025-08-02 | [64295](https://github.com/airbytehq/airbyte/pull/64295) | Update dependencies |
| 0.0.31 | 2025-07-26 | [63928](https://github.com/airbytehq/airbyte/pull/63928) | Update dependencies |
| 0.0.30 | 2025-07-19 | [63436](https://github.com/airbytehq/airbyte/pull/63436) | Update dependencies |
| 0.0.29 | 2025-07-12 | [63209](https://github.com/airbytehq/airbyte/pull/63209) | Update dependencies |
| 0.0.28 | 2025-07-05 | [62579](https://github.com/airbytehq/airbyte/pull/62579) | Update dependencies |
| 0.0.27 | 2025-06-28 | [62371](https://github.com/airbytehq/airbyte/pull/62371) | Update dependencies |
| 0.0.26 | 2025-06-21 | [61890](https://github.com/airbytehq/airbyte/pull/61890) | Update dependencies |
| 0.0.25 | 2025-06-14 | [61031](https://github.com/airbytehq/airbyte/pull/61031) | Update dependencies |
| 0.0.24 | 2025-05-24 | [60063](https://github.com/airbytehq/airbyte/pull/60063) | Update dependencies |
| 0.0.23 | 2025-05-03 | [59492](https://github.com/airbytehq/airbyte/pull/59492) | Update dependencies |
| 0.0.22 | 2025-04-27 | [59051](https://github.com/airbytehq/airbyte/pull/59051) | Update dependencies |
| 0.0.21 | 2025-04-19 | [58496](https://github.com/airbytehq/airbyte/pull/58496) | Update dependencies |
| 0.0.20 | 2025-04-12 | [57898](https://github.com/airbytehq/airbyte/pull/57898) | Update dependencies |
| 0.0.19 | 2025-04-05 | [57082](https://github.com/airbytehq/airbyte/pull/57082) | Update dependencies |
| 0.0.18 | 2025-03-29 | [56705](https://github.com/airbytehq/airbyte/pull/56705) | Update dependencies |
| 0.0.17 | 2025-03-22 | [56063](https://github.com/airbytehq/airbyte/pull/56063) | Update dependencies |
| 0.0.16 | 2025-03-08 | [55499](https://github.com/airbytehq/airbyte/pull/55499) | Update dependencies |
| 0.0.15 | 2025-03-01 | [54804](https://github.com/airbytehq/airbyte/pull/54804) | Update dependencies |
| 0.0.14 | 2025-02-22 | [54368](https://github.com/airbytehq/airbyte/pull/54368) | Update dependencies |
| 0.0.13 | 2025-02-15 | [53849](https://github.com/airbytehq/airbyte/pull/53849) | Update dependencies |
| 0.0.12 | 2025-02-08 | [53306](https://github.com/airbytehq/airbyte/pull/53306) | Update dependencies |
| 0.0.11 | 2025-02-01 | [52779](https://github.com/airbytehq/airbyte/pull/52779) | Update dependencies |
| 0.0.10 | 2025-01-25 | [52243](https://github.com/airbytehq/airbyte/pull/52243) | Update dependencies |
| 0.0.9 | 2025-01-18 | [51827](https://github.com/airbytehq/airbyte/pull/51827) | Update dependencies |
| 0.0.8 | 2025-01-11 | [51182](https://github.com/airbytehq/airbyte/pull/51182) | Update dependencies |
| 0.0.7 | 2024-12-28 | [50658](https://github.com/airbytehq/airbyte/pull/50658) | Update dependencies |
| 0.0.6 | 2024-12-21 | [50135](https://github.com/airbytehq/airbyte/pull/50135) | Update dependencies |
| 0.0.5 | 2024-12-14 | [49629](https://github.com/airbytehq/airbyte/pull/49629) | Update dependencies |
| 0.0.4 | 2024-12-12 | [48922](https://github.com/airbytehq/airbyte/pull/48922) | Update dependencies |
| 0.0.3 | 2024-11-04 | [48262](https://github.com/airbytehq/airbyte/pull/48262) | Update dependencies |
| 0.0.2 | 2024-10-29 | [47885](https://github.com/airbytehq/airbyte/pull/47885) | Update dependencies |
| 0.0.1 | 2024-10-18 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
