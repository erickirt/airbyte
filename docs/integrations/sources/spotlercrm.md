# SpotlerCRM
The Airbyte connector for [Spotler CRM](https://spotler.com/) enables seamless data integration, allowing users to sync customer data from Spotler CRM into their data warehouses or other tools. It supports automated data extraction from Spotler CRM, making it easier to analyze and leverage customer insights across multiple platforms. With this connector, businesses can efficiently streamline their customer relationship data and maintain up-to-date records for improved decision-making and marketing efforts.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `access_token` | `string` | Access Token. Access Token to authenticate API requests. Generate it by logging into your CRM system, navigating to Settings / Integrations / API V4, and clicking &#39;generate new key&#39;. |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| accounts | id | DefaultPaginator | ✅ |  ❌  |
| contacts | id | DefaultPaginator | ✅ |  ❌  |
| opportunities | id | DefaultPaginator | ✅ |  ❌  |
| documents |  | DefaultPaginator | ✅ |  ❌  |
| campaigns | id | DefaultPaginator | ✅ |  ❌  |
|  cases | id | DefaultPaginator | ✅ |  ❌  |
| activities | id | DefaultPaginator | ✅ |  ❌  |
| opportunity_histories | id | DefaultPaginator | ✅ |  ❌  |
| opportunity_lines | id | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.27 | 2025-07-26 | [64000](https://github.com/airbytehq/airbyte/pull/64000) | Update dependencies |
| 0.0.26 | 2025-07-19 | [63647](https://github.com/airbytehq/airbyte/pull/63647) | Update dependencies |
| 0.0.25 | 2025-07-12 | [63079](https://github.com/airbytehq/airbyte/pull/63079) | Update dependencies |
| 0.0.24 | 2025-07-05 | [62743](https://github.com/airbytehq/airbyte/pull/62743) | Update dependencies |
| 0.0.23 | 2025-06-28 | [62225](https://github.com/airbytehq/airbyte/pull/62225) | Update dependencies |
| 0.0.22 | 2025-06-21 | [61829](https://github.com/airbytehq/airbyte/pull/61829) | Update dependencies |
| 0.0.21 | 2025-05-25 | [60538](https://github.com/airbytehq/airbyte/pull/60538) | Update dependencies |
| 0.0.20 | 2025-05-10 | [60174](https://github.com/airbytehq/airbyte/pull/60174) | Update dependencies |
| 0.0.19 | 2025-05-04 | [59580](https://github.com/airbytehq/airbyte/pull/59580) | Update dependencies |
| 0.0.18 | 2025-04-27 | [58980](https://github.com/airbytehq/airbyte/pull/58980) | Update dependencies |
| 0.0.17 | 2025-04-19 | [58434](https://github.com/airbytehq/airbyte/pull/58434) | Update dependencies |
| 0.0.16 | 2025-04-12 | [57936](https://github.com/airbytehq/airbyte/pull/57936) | Update dependencies |
| 0.0.15 | 2025-04-05 | [57448](https://github.com/airbytehq/airbyte/pull/57448) | Update dependencies |
| 0.0.14 | 2025-03-29 | [56812](https://github.com/airbytehq/airbyte/pull/56812) | Update dependencies |
| 0.0.13 | 2025-03-22 | [56312](https://github.com/airbytehq/airbyte/pull/56312) | Update dependencies |
| 0.0.12 | 2025-03-08 | [55144](https://github.com/airbytehq/airbyte/pull/55144) | Update dependencies |
| 0.0.11 | 2025-02-22 | [54517](https://github.com/airbytehq/airbyte/pull/54517) | Update dependencies |
| 0.0.10 | 2025-02-15 | [54033](https://github.com/airbytehq/airbyte/pull/54033) | Update dependencies |
| 0.0.9 | 2025-02-08 | [53537](https://github.com/airbytehq/airbyte/pull/53537) | Update dependencies |
| 0.0.8 | 2025-02-01 | [53079](https://github.com/airbytehq/airbyte/pull/53079) | Update dependencies |
| 0.0.7 | 2025-01-25 | [52433](https://github.com/airbytehq/airbyte/pull/52433) | Update dependencies |
| 0.0.6 | 2025-01-18 | [51967](https://github.com/airbytehq/airbyte/pull/51967) | Update dependencies |
| 0.0.5 | 2025-01-11 | [51391](https://github.com/airbytehq/airbyte/pull/51391) | Update dependencies |
| 0.0.4 | 2024-12-28 | [50770](https://github.com/airbytehq/airbyte/pull/50770) | Update dependencies |
| 0.0.3 | 2024-12-21 | [50322](https://github.com/airbytehq/airbyte/pull/50322) | Update dependencies |
| 0.0.2 | 2024-12-14 | [49436](https://github.com/airbytehq/airbyte/pull/49436) | Update dependencies |
| 0.0.1 | 2024-11-08 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
