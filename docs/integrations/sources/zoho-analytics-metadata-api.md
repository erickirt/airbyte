# Zoho Analytics Metadata API
Zoho Analytics Metadata api connector enables seamless data syncing from Zoho Analytics metadata into data warehouses or BI tools. This connector automates OAuth authentication and ensures reliable data transfer, empowering businesses to streamline analytics workflows and gain deeper insights efficiently.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `org_id` | `number` | Org Id.  |  |
| `data_center` | `string` | Data Center.  | `com` |
| `client_id` | `string` | OAuth Client ID.  |  |
| `client_secret` | `string` | OAuth Client Secret.  |  |
| `refresh_token` | `string` | OAuth Refresh Token.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| users | emailId | No pagination | ✅ |  ❌  |
| workspaces | workspaceId | No pagination | ✅ |  ❌  |
| organizations | orgId | No pagination | ✅ |  ❌  |
| views | viewId | No pagination | ✅ |  ❌  |
| dashboards | viewId | No pagination | ✅ |  ❌  |
| trash | viewId | No pagination | ✅ |  ❌  |
| workspace_users | emailId | No pagination | ✅ |  ❌  |
| folders | folderId | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.29 | 2025-07-26 | [64068](https://github.com/airbytehq/airbyte/pull/64068) | Update dependencies |
| 0.0.28 | 2025-07-20 | [63654](https://github.com/airbytehq/airbyte/pull/63654) | Update dependencies |
| 0.0.27 | 2025-07-12 | [63229](https://github.com/airbytehq/airbyte/pull/63229) | Update dependencies |
| 0.0.26 | 2025-07-05 | [62685](https://github.com/airbytehq/airbyte/pull/62685) | Update dependencies |
| 0.0.25 | 2025-06-28 | [62246](https://github.com/airbytehq/airbyte/pull/62246) | Update dependencies |
| 0.0.24 | 2025-06-21 | [61774](https://github.com/airbytehq/airbyte/pull/61774) | Update dependencies |
| 0.0.23 | 2025-06-15 | [61164](https://github.com/airbytehq/airbyte/pull/61164) | Update dependencies |
| 0.0.22 | 2025-05-24 | [60777](https://github.com/airbytehq/airbyte/pull/60777) | Update dependencies |
| 0.0.21 | 2025-05-10 | [60009](https://github.com/airbytehq/airbyte/pull/60009) | Update dependencies |
| 0.0.20 | 2025-05-04 | [59540](https://github.com/airbytehq/airbyte/pull/59540) | Update dependencies |
| 0.0.19 | 2025-04-26 | [58927](https://github.com/airbytehq/airbyte/pull/58927) | Update dependencies |
| 0.0.18 | 2025-04-20 | [58577](https://github.com/airbytehq/airbyte/pull/58577) | Update dependencies |
| 0.0.17 | 2025-04-12 | [58034](https://github.com/airbytehq/airbyte/pull/58034) | Update dependencies |
| 0.0.16 | 2025-04-05 | [57396](https://github.com/airbytehq/airbyte/pull/57396) | Update dependencies |
| 0.0.15 | 2025-03-29 | [56849](https://github.com/airbytehq/airbyte/pull/56849) | Update dependencies |
| 0.0.14 | 2025-03-22 | [56335](https://github.com/airbytehq/airbyte/pull/56335) | Update dependencies |
| 0.0.13 | 2025-03-09 | [55655](https://github.com/airbytehq/airbyte/pull/55655) | Update dependencies |
| 0.0.12 | 2025-03-01 | [55163](https://github.com/airbytehq/airbyte/pull/55163) | Update dependencies |
| 0.0.11 | 2025-02-23 | [54631](https://github.com/airbytehq/airbyte/pull/54631) | Update dependencies |
| 0.0.10 | 2025-02-16 | [54121](https://github.com/airbytehq/airbyte/pull/54121) | Update dependencies |
| 0.0.9 | 2025-02-08 | [53600](https://github.com/airbytehq/airbyte/pull/53600) | Update dependencies |
| 0.0.8 | 2025-02-01 | [53118](https://github.com/airbytehq/airbyte/pull/53118) | Update dependencies |
| 0.0.7 | 2025-01-25 | [52542](https://github.com/airbytehq/airbyte/pull/52542) | Update dependencies |
| 0.0.6 | 2025-01-18 | [51930](https://github.com/airbytehq/airbyte/pull/51930) | Update dependencies |
| 0.0.5 | 2025-01-11 | [51462](https://github.com/airbytehq/airbyte/pull/51462) | Update dependencies |
| 0.0.4 | 2024-12-28 | [50837](https://github.com/airbytehq/airbyte/pull/50837) | Update dependencies |
| 0.0.3 | 2024-12-21 | [50384](https://github.com/airbytehq/airbyte/pull/50384) | Update dependencies |
| 0.0.2 | 2024-12-14 | [49450](https://github.com/airbytehq/airbyte/pull/49450) | Update dependencies |
| 0.0.1 | 2024-11-07 | | Initial release by [@bishalbera](https://github.com/bishalbera) via Connector Builder |

</details>
