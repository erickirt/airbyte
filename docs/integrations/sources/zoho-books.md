# Zoho Books
The Zoho Books connector  enables seamless integration of financial data, automating the flow of invoices, payments, expenses, and bank transactions into your data systems. With this connector, businesses can streamline bookkeeping processes, ensuring accurate financial reporting and real-time insights.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `region` | `string` | Region. The region code for the Zoho Books API, such as `com`, `eu`, `in`, etc. |  |
| `client_id` | `string` | OAuth Client ID.  |  |
| `client_secret` | `string` | OAuth Client Secret.  |  |
| `refresh_token` | `string` | OAuth Refresh Token.  |  |
| `start_date` | `string` | Start date.  |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| users | user_id | DefaultPaginator | ✅ |  ❌  |
| banking | account_id | DefaultPaginator | ✅ |  ❌  |
| organizations | organization_id | DefaultPaginator | ✅ |  ❌  |
| contacts | contact_id | DefaultPaginator | ✅ |  ❌  |
| bills | bill_id | DefaultPaginator | ✅ |  ✅  |
| estimates | estimate_id | DefaultPaginator | ✅ |  ✅  |
| items | item_id | DefaultPaginator | ✅ |  ❌  |
| invoices | invoice_id | DefaultPaginator | ✅ |  ✅  |
| expenses | expense_id | DefaultPaginator | ✅ |  ✅  |
| creditnotes | creditnote_id | DefaultPaginator | ✅ |  ✅  |
| customerpayments | payment_id | DefaultPaginator | ✅ |  ✅  |
| purchaseorders | purchaseorder_id | DefaultPaginator | ✅ |  ✅  |
| salesorders | salesorder_id | DefaultPaginator | ✅ |  ✅  |
| journals | journal_id | DefaultPaginator | ✅ |  ✅  |
| taxes | tax_id | DefaultPaginator | ✅ |  ❌  |
| transactions |  | DefaultPaginator | ✅ |  ✅  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.30 | 2025-07-26 | [64069](https://github.com/airbytehq/airbyte/pull/64069) | Update dependencies |
| 0.0.29 | 2025-07-19 | [63613](https://github.com/airbytehq/airbyte/pull/63613) | Update dependencies |
| 0.0.28 | 2025-07-12 | [63242](https://github.com/airbytehq/airbyte/pull/63242) | Update dependencies |
| 0.0.27 | 2025-07-05 | [62740](https://github.com/airbytehq/airbyte/pull/62740) | Update dependencies |
| 0.0.26 | 2025-06-28 | [62269](https://github.com/airbytehq/airbyte/pull/62269) | Update dependencies |
| 0.0.25 | 2025-06-21 | [61756](https://github.com/airbytehq/airbyte/pull/61756) | Update dependencies |
| 0.0.24 | 2025-06-15 | [61218](https://github.com/airbytehq/airbyte/pull/61218) | Update dependencies |
| 0.0.23 | 2025-05-24 | [59958](https://github.com/airbytehq/airbyte/pull/59958) | Update dependencies |
| 0.0.22 | 2025-05-04 | [59536](https://github.com/airbytehq/airbyte/pull/59536) | Update dependencies |
| 0.0.21 | 2025-04-26 | [58924](https://github.com/airbytehq/airbyte/pull/58924) | Update dependencies |
| 0.0.20 | 2025-04-19 | [58537](https://github.com/airbytehq/airbyte/pull/58537) | Update dependencies |
| 0.0.19 | 2025-04-13 | [58054](https://github.com/airbytehq/airbyte/pull/58054) | Update dependencies |
| 0.0.18 | 2025-04-05 | [57378](https://github.com/airbytehq/airbyte/pull/57378) | Update dependencies |
| 0.0.17 | 2025-03-29 | [56845](https://github.com/airbytehq/airbyte/pull/56845) | Update dependencies |
| 0.0.16 | 2025-03-22 | [56330](https://github.com/airbytehq/airbyte/pull/56330) | Update dependencies |
| 0.0.15 | 2025-03-09 | [55663](https://github.com/airbytehq/airbyte/pull/55663) | Update dependencies |
| 0.0.14 | 2025-03-01 | [55169](https://github.com/airbytehq/airbyte/pull/55169) | Update dependencies |
| 0.0.13 | 2025-02-23 | [54629](https://github.com/airbytehq/airbyte/pull/54629) | Update dependencies |
| 0.0.12 | 2025-02-15 | [54111](https://github.com/airbytehq/airbyte/pull/54111) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53596](https://github.com/airbytehq/airbyte/pull/53596) | Update dependencies |
| 0.0.10 | 2025-02-01 | [53114](https://github.com/airbytehq/airbyte/pull/53114) | Update dependencies |
| 0.0.9 | 2025-01-25 | [52545](https://github.com/airbytehq/airbyte/pull/52545) | Update dependencies |
| 0.0.8 | 2025-01-18 | [51940](https://github.com/airbytehq/airbyte/pull/51940) | Update dependencies |
| 0.0.7 | 2025-01-11 | [51470](https://github.com/airbytehq/airbyte/pull/51470) | Update dependencies |
| 0.0.6 | 2024-12-28 | [50839](https://github.com/airbytehq/airbyte/pull/50839) | Update dependencies |
| 0.0.5 | 2024-12-21 | [50386](https://github.com/airbytehq/airbyte/pull/50386) | Update dependencies |
| 0.0.4 | 2024-12-14 | [49447](https://github.com/airbytehq/airbyte/pull/49447) | Update dependencies |
| 0.0.3 | 2024-11-04 | [48173](https://github.com/airbytehq/airbyte/pull/48173) | Update dependencies |
| 0.0.2 | 2024-10-28 | [47582](https://github.com/airbytehq/airbyte/pull/47582) | Update dependencies |
| 0.0.1 | 2024-10-19 | | Initial release by [@bishalbera](https://github.com/bishalbera) via Connector Builder |

</details>
