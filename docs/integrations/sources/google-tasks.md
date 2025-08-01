# Google Tasks
This page contains the setup guide and reference information for the [Google Tasks](https://tasksboard.com/app) source connector.

## Documentation reference:
Visit `https://developers.google.com/tasks/reference/rest` for API documentation

## Authentication setup
`Source-productive` uses bearer token authentication,
Visit `https://support.google.com/googleapi/answer/6158849?hl=en&amp;ref_topic=7013279` for getting bearer token via OAuth2.0

## Setting postman for getting bearer token
Currently Code granted OAuth 2.0 is not directly supported by airbyte, thus you could setup postman for getting the bearer token which could be used as `api_key`,
Steps:
- Visit google cloud `https://console.cloud.google.com/apis/api/tasks.googleapis.com/metrics` and enable the tasks api service
- Go to the consent screen `https://console.cloud.google.com/apis/credentials/consent` and add your email for enabling postman testing access
- Visit `https://console.cloud.google.com/apis/credentials` and create new credentails for OAuth 2.0 and copy client id and client secret 
- Add callback url `https://oauth.pstmn.io/v1/callback` while credential creation
- Goto postman client and select new tab for setting authorization to OAuth 2.0
  - Set scope as `https://www.googleapis.com/auth/tasks https://www.googleapis.com/auth/tasks.readonly`
  - Set access token URL as `https://accounts.google.com/o/oauth2/token`
  - Set auth URL as `https://accounts.google.com/o/oauth2/v2/auth`
  - Click `Get New Access Token` and authorize via your google account
  - Copy the resulted bearer token and use it as credential for the connector

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key.  |  |
| `start_date` | `string` | Start date.  |  |
| `records_limit` | `string` | Records Limit. The maximum number of records to be returned per request | 50 |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| tasks | id | DefaultPaginator | ✅ |  ✅  |
| lists_tasks | id | DefaultPaginator | ✅ |  ✅  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version | Date | Pull Request | Subject |
| ------------------ | ------------ | --- | ---------------- |
| 0.0.33 | 2025-08-02 | [64184](https://github.com/airbytehq/airbyte/pull/64184) | Update dependencies |
| 0.0.32 | 2025-07-26 | [63874](https://github.com/airbytehq/airbyte/pull/63874) | Update dependencies |
| 0.0.31 | 2025-07-19 | [63502](https://github.com/airbytehq/airbyte/pull/63502) | Update dependencies |
| 0.0.30 | 2025-07-12 | [63099](https://github.com/airbytehq/airbyte/pull/63099) | Update dependencies |
| 0.0.29 | 2025-07-05 | [62639](https://github.com/airbytehq/airbyte/pull/62639) | Update dependencies |
| 0.0.28 | 2025-06-21 | [61840](https://github.com/airbytehq/airbyte/pull/61840) | Update dependencies |
| 0.0.27 | 2025-06-14 | [60652](https://github.com/airbytehq/airbyte/pull/60652) | Update dependencies |
| 0.0.26 | 2025-05-10 | [59815](https://github.com/airbytehq/airbyte/pull/59815) | Update dependencies |
| 0.0.25 | 2025-05-03 | [59281](https://github.com/airbytehq/airbyte/pull/59281) | Update dependencies |
| 0.0.24 | 2025-04-26 | [58757](https://github.com/airbytehq/airbyte/pull/58757) | Update dependencies |
| 0.0.23 | 2025-04-19 | [58209](https://github.com/airbytehq/airbyte/pull/58209) | Update dependencies |
| 0.0.22 | 2025-04-12 | [57747](https://github.com/airbytehq/airbyte/pull/57747) | Update dependencies |
| 0.0.21 | 2025-04-05 | [57032](https://github.com/airbytehq/airbyte/pull/57032) | Update dependencies |
| 0.0.20 | 2025-03-29 | [56682](https://github.com/airbytehq/airbyte/pull/56682) | Update dependencies |
| 0.0.19 | 2025-03-22 | [56038](https://github.com/airbytehq/airbyte/pull/56038) | Update dependencies |
| 0.0.18 | 2025-03-08 | [55482](https://github.com/airbytehq/airbyte/pull/55482) | Update dependencies |
| 0.0.17 | 2025-03-01 | [54781](https://github.com/airbytehq/airbyte/pull/54781) | Update dependencies |
| 0.0.16 | 2025-02-22 | [54296](https://github.com/airbytehq/airbyte/pull/54296) | Update dependencies |
| 0.0.15 | 2025-02-15 | [53794](https://github.com/airbytehq/airbyte/pull/53794) | Update dependencies |
| 0.0.14 | 2025-02-08 | [53310](https://github.com/airbytehq/airbyte/pull/53310) | Update dependencies |
| 0.0.13 | 2025-02-01 | [52863](https://github.com/airbytehq/airbyte/pull/52863) | Update dependencies |
| 0.0.12 | 2025-01-25 | [52372](https://github.com/airbytehq/airbyte/pull/52372) | Update dependencies |
| 0.0.11 | 2025-01-18 | [51805](https://github.com/airbytehq/airbyte/pull/51805) | Update dependencies |
| 0.0.10 | 2025-01-11 | [51191](https://github.com/airbytehq/airbyte/pull/51191) | Update dependencies |
| 0.0.9 | 2024-12-28 | [50647](https://github.com/airbytehq/airbyte/pull/50647) | Update dependencies |
| 0.0.8 | 2024-12-21 | [50091](https://github.com/airbytehq/airbyte/pull/50091) | Update dependencies |
| 0.0.7 | 2024-12-14 | [49594](https://github.com/airbytehq/airbyte/pull/49594) | Update dependencies |
| 0.0.6 | 2024-12-12 | [49223](https://github.com/airbytehq/airbyte/pull/49223) | Update dependencies |
| 0.0.5 | 2024-12-11 | [48949](https://github.com/airbytehq/airbyte/pull/48949) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.4 | 2024-11-05 | [48366](https://github.com/airbytehq/airbyte/pull/48366) | Revert to source-declarative-manifest v5.17.0 |
| 0.0.3 | 2024-11-05 | [47770](https://github.com/airbytehq/airbyte/pull/47770) | Update dependencies |
| 0.0.2 | 2024-10-28 | [47550](https://github.com/airbytehq/airbyte/pull/47550) | Update dependencies |
| 0.0.1 | 2024-09-12 | [45427](https://github.com/airbytehq/airbyte/pull/45427) | Initial release by [@btkcodedev](https://github.com/btkcodedev) via Connector Builder |

</details>
