# NinjaOne RMM
Website: https://app.ninjarmm.com/
API Reference: https://app.ninjarmm.com/apidocs/?links.active=core

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key. Token could be generated natively by authorize section of NinjaOne swagger documentation `https://app.ninjarmm.com/apidocs/?links.active=authorization` |  |
| `start_date` | `string` | Start date.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| organizations | id | DefaultPaginator | ✅ |  ❌  |
| policies | id | No pagination | ✅ |  ✅  |
| activities | id | DefaultPaginator | ✅ |  ✅  |
| automation_scripts | id | No pagination | ✅ |  ✅  |
| groups | id | No pagination | ✅ |  ✅  |
| locations | id | DefaultPaginator | ✅ |  ❌  |
| roles | id | No pagination | ✅ |  ✅  |
| software_products | id | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.14 | 2025-08-02 | [64230](https://github.com/airbytehq/airbyte/pull/64230) | Update dependencies |
| 0.0.13 | 2025-07-26 | [63812](https://github.com/airbytehq/airbyte/pull/63812) | Update dependencies |
| 0.0.12 | 2025-07-19 | [63445](https://github.com/airbytehq/airbyte/pull/63445) | Update dependencies |
| 0.0.11 | 2025-07-12 | [63218](https://github.com/airbytehq/airbyte/pull/63218) | Update dependencies |
| 0.0.10 | 2025-07-05 | [62621](https://github.com/airbytehq/airbyte/pull/62621) | Update dependencies |
| 0.0.9 | 2025-06-28 | [62358](https://github.com/airbytehq/airbyte/pull/62358) | Update dependencies |
| 0.0.8 | 2025-06-21 | [61905](https://github.com/airbytehq/airbyte/pull/61905) | Update dependencies |
| 0.0.7 | 2025-06-14 | [61033](https://github.com/airbytehq/airbyte/pull/61033) | Update dependencies |
| 0.0.6 | 2025-05-24 | [60495](https://github.com/airbytehq/airbyte/pull/60495) | Update dependencies |
| 0.0.5 | 2025-05-10 | [59093](https://github.com/airbytehq/airbyte/pull/59093) | Update dependencies |
| 0.0.4 | 2025-04-19 | [58525](https://github.com/airbytehq/airbyte/pull/58525) | Update dependencies |
| 0.0.3 | 2025-04-12 | [57868](https://github.com/airbytehq/airbyte/pull/57868) | Update dependencies |
| 0.0.2 | 2025-04-05 | [57325](https://github.com/airbytehq/airbyte/pull/57325) | Update dependencies |
| 0.0.1 | 2025-04-04 | [57013](https://github.com/airbytehq/airbyte/pull/57013) | Initial release by [@btkcodedev](https://github.com/btkcodedev) via Connector Builder |

</details>
