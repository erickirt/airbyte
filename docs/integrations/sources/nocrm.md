# NoCRM
[NoCRM](https://nocrm.io) connector enables seamless data integration between NoCRM.io, a lead management tool, and other platforms or data warehouses. It allows for the automated extraction and synchronization of lead data, activities, and contact details from NoCRM.io into analytics  systems, supporting data-driven decisions and streamlined workflows. 

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key. API key to use. Generate it from the admin section of your noCRM.io account. |  |
| `subdomain` | `string` | Subdomain. The subdomain specific to your noCRM.io account, e.g., &#39;yourcompany&#39; in &#39;yourcompany.nocrm.io&#39;. |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| steps | id | No pagination | ✅ |  ❌  |
| pipelines | id | No pagination | ✅ |  ❌  |
| clients_folders | id | No pagination | ✅ |  ❌  |
| categories | id | No pagination | ✅ |  ❌  |
| predefined_tags | id | No pagination | ✅ |  ❌  |
| fields | id | No pagination | ✅ |  ❌  |
| leads | id | DefaultPaginator | ✅ |  ❌  |
| follow_ups | id | No pagination | ✅ |  ❌  |
| users | id | No pagination | ✅ |  ❌  |
| teams | id | No pagination | ✅ |  ❌  |
| webhooks | id | No pagination | ✅ |  ❌  |
| webhook_events | id | No pagination | ✅ |  ❌  |
| activities | id | No pagination | ✅ |  ❌  |
| prospecting_lists | id | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.30 | 2025-08-02 | [64203](https://github.com/airbytehq/airbyte/pull/64203) | Update dependencies |
| 0.0.29 | 2025-07-26 | [63919](https://github.com/airbytehq/airbyte/pull/63919) | Update dependencies |
| 0.0.28 | 2025-07-19 | [63430](https://github.com/airbytehq/airbyte/pull/63430) | Update dependencies |
| 0.0.27 | 2025-07-12 | [63253](https://github.com/airbytehq/airbyte/pull/63253) | Update dependencies |
| 0.0.26 | 2025-07-05 | [62633](https://github.com/airbytehq/airbyte/pull/62633) | Update dependencies |
| 0.0.25 | 2025-06-28 | [62376](https://github.com/airbytehq/airbyte/pull/62376) | Update dependencies |
| 0.0.24 | 2025-06-21 | [61929](https://github.com/airbytehq/airbyte/pull/61929) | Update dependencies |
| 0.0.23 | 2025-06-14 | [61025](https://github.com/airbytehq/airbyte/pull/61025) | Update dependencies |
| 0.0.22 | 2025-05-24 | [60153](https://github.com/airbytehq/airbyte/pull/60153) | Update dependencies |
| 0.0.21 | 2025-05-03 | [59095](https://github.com/airbytehq/airbyte/pull/59095) | Update dependencies |
| 0.0.20 | 2025-04-19 | [58475](https://github.com/airbytehq/airbyte/pull/58475) | Update dependencies |
| 0.0.19 | 2025-04-12 | [57879](https://github.com/airbytehq/airbyte/pull/57879) | Update dependencies |
| 0.0.18 | 2025-04-05 | [57289](https://github.com/airbytehq/airbyte/pull/57289) | Update dependencies |
| 0.0.17 | 2025-03-29 | [56730](https://github.com/airbytehq/airbyte/pull/56730) | Update dependencies |
| 0.0.16 | 2025-03-22 | [56223](https://github.com/airbytehq/airbyte/pull/56223) | Update dependencies |
| 0.0.15 | 2025-03-08 | [55514](https://github.com/airbytehq/airbyte/pull/55514) | Update dependencies |
| 0.0.14 | 2025-03-01 | [54767](https://github.com/airbytehq/airbyte/pull/54767) | Update dependencies |
| 0.0.13 | 2025-02-22 | [54343](https://github.com/airbytehq/airbyte/pull/54343) | Update dependencies |
| 0.0.12 | 2025-02-15 | [53864](https://github.com/airbytehq/airbyte/pull/53864) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53245](https://github.com/airbytehq/airbyte/pull/53245) | Update dependencies |
| 0.0.10 | 2025-02-01 | [52736](https://github.com/airbytehq/airbyte/pull/52736) | Update dependencies |
| 0.0.9 | 2025-01-25 | [52266](https://github.com/airbytehq/airbyte/pull/52266) | Update dependencies |
| 0.0.8 | 2025-01-18 | [51812](https://github.com/airbytehq/airbyte/pull/51812) | Update dependencies |
| 0.0.7 | 2025-01-11 | [51187](https://github.com/airbytehq/airbyte/pull/51187) | Update dependencies |
| 0.0.6 | 2024-12-28 | [50667](https://github.com/airbytehq/airbyte/pull/50667) | Update dependencies |
| 0.0.5 | 2024-12-21 | [50090](https://github.com/airbytehq/airbyte/pull/50090) | Update dependencies |
| 0.0.4 | 2024-12-14 | [49635](https://github.com/airbytehq/airbyte/pull/49635) | Update dependencies |
| 0.0.3 | 2024-12-12 | [49252](https://github.com/airbytehq/airbyte/pull/49252) | Update dependencies |
| 0.0.2 | 2024-12-11 | [48944](https://github.com/airbytehq/airbyte/pull/48944) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.1 | 2024-11-08 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
