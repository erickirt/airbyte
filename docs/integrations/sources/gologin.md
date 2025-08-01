# GoLogin
Website: https://app.gologin.com/
Postman API Reference: https://documenter.getpostman.com/view/21126834/Uz5GnvaL#intro

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `api_key` | `string` | API Key. API Key found at `https://app.gologin.com/personalArea/TokenApi` |  |
| `start_date` | `string` | Start date.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| profiles | id | DefaultPaginator | ✅ |  ✅  |
| browser_history | id | DefaultPaginator | ✅ |  ✅  |
| browser_cookies | uuid | DefaultPaginator | ✅ |  ✅  |
| folders | id | DefaultPaginator | ✅ |  ❌  |
| tags | _id | DefaultPaginator | ✅ |  ❌  |
| user | _id | DefaultPaginator | ✅ |  ✅  |
| user_metadata | _id | DefaultPaginator | ✅ |  ✅  |
| user_balance | uuid | DefaultPaginator | ✅ |  ❌  |
| user_timezones | uuid | DefaultPaginator | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.14 | 2025-08-02 | [64282](https://github.com/airbytehq/airbyte/pull/64282) | Update dependencies |
| 0.0.13 | 2025-07-26 | [63823](https://github.com/airbytehq/airbyte/pull/63823) | Update dependencies |
| 0.0.12 | 2025-07-19 | [63457](https://github.com/airbytehq/airbyte/pull/63457) | Update dependencies |
| 0.0.11 | 2025-07-12 | [63153](https://github.com/airbytehq/airbyte/pull/63153) | Update dependencies |
| 0.0.10 | 2025-07-05 | [62563](https://github.com/airbytehq/airbyte/pull/62563) | Update dependencies |
| 0.0.9 | 2025-06-21 | [61784](https://github.com/airbytehq/airbyte/pull/61784) | Update dependencies |
| 0.0.8 | 2025-06-14 | [61102](https://github.com/airbytehq/airbyte/pull/61102) | Update dependencies |
| 0.0.7 | 2025-05-24 | [60727](https://github.com/airbytehq/airbyte/pull/60727) | Update dependencies |
| 0.0.6 | 2025-05-10 | [59283](https://github.com/airbytehq/airbyte/pull/59283) | Update dependencies |
| 0.0.5 | 2025-04-26 | [58826](https://github.com/airbytehq/airbyte/pull/58826) | Update dependencies |
| 0.0.4 | 2025-04-19 | [58154](https://github.com/airbytehq/airbyte/pull/58154) | Update dependencies |
| 0.0.3 | 2025-04-12 | [57674](https://github.com/airbytehq/airbyte/pull/57674) | Update dependencies |
| 0.0.2 | 2025-04-05 | [57044](https://github.com/airbytehq/airbyte/pull/57044) | Update dependencies |
| 0.0.1 | 2025-04-04 | [57010](https://github.com/airbytehq/airbyte/pull/57010) | Initial release by [@btkcodedev](https://github.com/btkcodedev) via Connector Builder |

</details>
