# GitBook
GitBook connector  enables seamless data integration from GitBook into your data pipelines. It efficiently extracts content, such as documentation and pages, allowing teams to sync and analyze information across platforms.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `access_token` | `string` | Access Token. Personal access token for authenticating with the GitBook API. You can view and manage your access tokens in the Developer settings of your GitBook user account. |  |
| `space_id` | `string` | Space Id.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| users |  | DefaultPaginator | ✅ |  ❌  |
| organizations | id | DefaultPaginator | ✅ |  ❌  |
| insights | timestamp | DefaultPaginator | ✅ |  ❌  |
| content | id | DefaultPaginator | ✅ |  ❌  |
| org_members | id | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.30 | 2025-08-02 | [64204](https://github.com/airbytehq/airbyte/pull/64204) | Update dependencies |
| 0.0.29 | 2025-07-26 | [63902](https://github.com/airbytehq/airbyte/pull/63902) | Update dependencies |
| 0.0.28 | 2025-07-19 | [63478](https://github.com/airbytehq/airbyte/pull/63478) | Update dependencies |
| 0.0.27 | 2025-07-12 | [63133](https://github.com/airbytehq/airbyte/pull/63133) | Update dependencies |
| 0.0.26 | 2025-07-05 | [62614](https://github.com/airbytehq/airbyte/pull/62614) | Update dependencies |
| 0.0.25 | 2025-06-28 | [62173](https://github.com/airbytehq/airbyte/pull/62173) | Update dependencies |
| 0.0.24 | 2025-06-21 | [61820](https://github.com/airbytehq/airbyte/pull/61820) | Update dependencies |
| 0.0.23 | 2025-06-14 | [61079](https://github.com/airbytehq/airbyte/pull/61079) | Update dependencies |
| 0.0.22 | 2025-05-24 | [60366](https://github.com/airbytehq/airbyte/pull/60366) | Update dependencies |
| 0.0.21 | 2025-05-10 | [60039](https://github.com/airbytehq/airbyte/pull/60039) | Update dependencies |
| 0.0.20 | 2025-05-03 | [58840](https://github.com/airbytehq/airbyte/pull/58840) | Update dependencies |
| 0.0.19 | 2025-04-19 | [58351](https://github.com/airbytehq/airbyte/pull/58351) | Update dependencies |
| 0.0.18 | 2025-04-12 | [57825](https://github.com/airbytehq/airbyte/pull/57825) | Update dependencies |
| 0.0.17 | 2025-04-05 | [57195](https://github.com/airbytehq/airbyte/pull/57195) | Update dependencies |
| 0.0.16 | 2025-03-29 | [55996](https://github.com/airbytehq/airbyte/pull/55996) | Update dependencies |
| 0.0.15 | 2025-03-08 | [55329](https://github.com/airbytehq/airbyte/pull/55329) | Update dependencies |
| 0.0.14 | 2025-03-01 | [54993](https://github.com/airbytehq/airbyte/pull/54993) | Update dependencies |
| 0.0.13 | 2025-02-22 | [54383](https://github.com/airbytehq/airbyte/pull/54383) | Update dependencies |
| 0.0.12 | 2025-02-15 | [53739](https://github.com/airbytehq/airbyte/pull/53739) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53344](https://github.com/airbytehq/airbyte/pull/53344) | Update dependencies |
| 0.0.10 | 2025-02-01 | [52856](https://github.com/airbytehq/airbyte/pull/52856) | Update dependencies |
| 0.0.9 | 2025-01-25 | [52358](https://github.com/airbytehq/airbyte/pull/52358) | Update dependencies |
| 0.0.8 | 2025-01-18 | [51632](https://github.com/airbytehq/airbyte/pull/51632) | Update dependencies |
| 0.0.7 | 2025-01-11 | [51061](https://github.com/airbytehq/airbyte/pull/51061) | Update dependencies |
| 0.0.6 | 2024-12-28 | [50563](https://github.com/airbytehq/airbyte/pull/50563) | Update dependencies |
| 0.0.5 | 2024-12-21 | [50002](https://github.com/airbytehq/airbyte/pull/50002) | Update dependencies |
| 0.0.4 | 2024-12-14 | [49517](https://github.com/airbytehq/airbyte/pull/49517) | Update dependencies |
| 0.0.3 | 2024-12-12 | [49166](https://github.com/airbytehq/airbyte/pull/49166) | Update dependencies |
| 0.0.2 | 2024-12-11 | [48910](https://github.com/airbytehq/airbyte/pull/48910) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.1 | 2024-10-30 | | Initial release by [@bishalbera](https://github.com/bishalbera) via Connector Builder |

</details>
