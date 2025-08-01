# Google Analytics 4 (GA4)

<HideInUI>

This page contains the setup guide and reference information for the [Google Analytics 4 (GA4)](https://developers.google.com/analytics) source connector.

</HideInUI>

Google Analytics 4 (GA4) is the latest version of Google Analytics, introduced in 2020. It offers a new data model that emphasizes events and user properties, rather than pageviews and sessions. This updated model allows for more flexibility and customization in reporting, and provides more accurate measurement of user behavior across various devices and platforms.

:::note
The [Google Analytics Universal Analytics (UA) connector](https://docs.airbyte.com/integrations/sources/google-analytics-v4) utilizes the older version of Google Analytics, which was the standard for tracking website and app user behavior before the introduction of GA4. Please note that the UA connector is being deprecated in favor of this one. As of July 1, 2023, standard Universal Analytics properties no longer process hits. For further reading on the transition from UA to GA4, refer to [Google's official support page](https://support.google.com/analytics/answer/11583528).
:::

## Prerequisites

- A Google Analytics account with access to the GA4 Property(Property Ids) you want to sync

## Setup guide

### Step 1: Set up Google Analytics 4 (GA4)

<!-- env:oss -->

#### Create a Service Account for authentication

1. Sign in to the Google Account you are using for Google Analytics as an admin.
2. Go to the [Service Accounts](https://console.developers.google.com/iam-admin/serviceaccounts) page in the Google Developers console.
3. Select the project you want to use (or create a new one) and click **Continue**.
4. Click **+ Create Service Account** at the top of the page.
5. Enter a name for the service account, and optionally, a description. Click **Create and Continue**.
6. Choose the role for the service account. We recommend the **Viewer** role (Read & Analyze permissions). Click **Continue**.
7. Select your new service account from the list, and open the **Keys** tab. Click **Add Key** > **Create New Key**.
8. Select **JSON** as the Key type. This will generate and download the JSON key file that you'll use for authentication. Click **Continue**.

#### Enable the Google Analytics APIs

Before you can use the service account to access Google Analytics data, you need to enable the required APIs:

1. Go to the [Google Analytics Reporting API dashboard](https://console.developers.google.com/apis/api/analyticsreporting.googleapis.com/overview). Make sure you have selected the associated project for your service account, and enable the API. You can also set quotas and check usage.
2. Go to the [Google Analytics API dashboard](https://console.developers.google.com/apis/api/analytics.googleapis.com/overview). Make sure you have selected the associated project for your service account, and enable the API.
3. Go to the [Google Analytics Data API dashboard](https://console.developers.google.com/apis/api/analyticsdata.googleapis.com/overview). Make sure you have selected the associated project for your service account, and enable the API.

<!-- /env:oss -->

<!-- env:cloud -->

### For Airbyte Cloud:

1. [Log into your Airbyte Cloud](https://cloud.airbyte.com/workspaces) account.
2. Click Sources and then click + New source.
3. On the Set up the source page, select Google Analytics 4 (GA4) from the Source type dropdown.
4. Enter a name for the Google Analytics 4 (GA4) connector.
5. Select **Authenticate via Google (Oauth)** from the dropdown menu and click **Authenticate your Google Analytics 4 (GA4) account**. This will open a pop-up window where you can log in to your Google account and grant Airbyte access to your Google Analytics account.
6. Enter the **Property ID** whose events are tracked. This ID should be a numeric value, such as `123456789`. If you are unsure where to find this value, refer to [Google's documentation](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id#what_is_my_property_id).
   :::note
   If the Property Settings shows a "Tracking Id" such as "UA-123...-1", this denotes that the property is a Universal Analytics property, and the Analytics data for that property cannot be reported on using this connector. You can create a new Google Analytics 4 property by following [these instructions](https://support.google.com/analytics/answer/9744165?hl=en).
   :::

7. (Optional) In the **Start Date** field, use the provided datepicker or enter a date programmatically in the format `YYYY-MM-DD`. All data added from this date onward will be replicated. Note that this setting is _not_ applied to custom Cohort reports.
8. (Optional) In the **Custom Reports** field, you may optionally describe any custom reports you want to sync from Google Analytics. See the [Custom Reports](#custom-reports) section below for more information on formulating these reports.
9. (Optional) In the **Data Request Interval (Days)** field, you can specify the interval in days (ranging from 1 to 364) used when requesting data from the Google Analytics API. The bigger this value is, the faster the sync will be, but the more likely that sampling will be applied to your data, potentially causing inaccuracies in the returned results. We recommend setting this to 1 unless you have a hard requirement to make the sync faster at the expense of accuracy. This field does not apply to custom Cohort reports. See the [Data Sampling](#data-sampling-and-data-request-intervals) section below for more context on this field.

:::caution

It's important to consider how dimensions like `month` or `yearMonth` are specified. These dimensions organize the data according to your preferences.
However, keep in mind that the data presentation is also influenced by the chosen date range for the report. In cases where a very specific date range is selected, such as a single day (**Data Request Interval (Days)** set to one day), duplicated data entries for each day might appear.
To mitigate this, we recommend adjusting the **Data Request Interval (Days)** value to 364. By doing so, you can obtain more precise results and prevent the occurrence of duplicated data.

:::

10. Click **Set up source** and wait for the tests to complete.

<!-- /env:cloud -->

<!-- env:oss -->

### For Airbyte Open Source:

1. Navigate to the Airbyte Open Source dashboard.
2. In the left navigation bar, click **Sources**. In the top-right corner, click **+ New source**.
3. Find and select **Google Analytics 4 (GA4)** from the list of available sources.
4. Select **Service Account Key Authenication** dropdown list and enter **Service Account JSON Key** from Step 1.
5. Enter the **Property ID** whose events are tracked. This ID should be a numeric value, such as `123456789`. If you are unsure where to find this value, refer to [Google's documentation](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id#what_is_my_property_id).
   :::note
   If the Property Settings shows a "Tracking Id" such as "UA-123...-1", this denotes that the property is a Universal Analytics property, and the Analytics data for that property cannot be reported on in the Data API. You can create a new Google Analytics 4 property by following [these instructions](https://support.google.com/analytics/answer/9744165?hl=en).
   :::

6. (Optional) In the **Start Date** field, use the provided datepicker or enter a date programmatically in the format `YYYY-MM-DD`. All data added from this date onward will be replicated. Note that this setting is _not_ applied to custom Cohort reports.

:::note
If the start date is not provided, the default value will be used, which is two years from the initial sync.
:::

:::caution
Many analyses and data investigations may require 24-48 hours to process information from your website or app. To ensure the accuracy of the data, we subtract two days from the starting date. For more details, please refer to [Google's documentation](https://support.google.com/analytics/answer/9333790?hl=en).
:::

7. (Optional) Toggle the switch **Keep Empty Rows** if you want each row with all metrics equal to 0 to be returned.
8. (Optional) In the **Custom Reports** field, you may optionally describe any custom reports you want to sync from Google Analytics. See the [Custom Reports](#custom-reports) section below for more information on formulating these reports.
9. (Optional) In the **Data Request Interval (Days)** field, you can specify the interval in days (ranging from 1 to 364) used when requesting data from the Google Analytics API. The bigger this value is, the faster the sync will be, but the more likely that sampling will be applied to your data, potentially causing inaccuracies in the returned results. We recommend setting this to 1 unless you have a hard requirement to make the sync faster at the expense of accuracy. This field does not apply to custom Cohort reports. See the [Data Sampling](#data-sampling-and-data-request-intervals) section below for more context on this field.
10. (Optional) In the **Lookback window (Days)** field, you can specify how many days in the past we should refresh the data in every run. Since attribution changes after the event date, and Google Analytics has a data processing latency this is key to keep up with consistent information. If you set it at 5 days, in every sync it will fetch the last bookmark date minus 5 days..

:::caution

It's important to consider how dimensions like `month` or `yearMonth` are specified. These dimensions organize the data according to your preferences.
However, keep in mind that the data presentation is also influenced by the chosen date range for the report. In cases where a very specific date range is selected, such as a single day (**Data Request Interval (Days)** set to one day), duplicated data entries for each day might appear.
To mitigate this, we recommend adjusting the **Data Request Interval (Days)** value to 364. By doing so, you can obtain more precise results and prevent the occurrence of duplicated data.

:::

11. Click **Set up source** and wait for the tests to complete.
<!-- /env:oss -->

## Supported sync modes

The Google Analytics 4 (GA4) source connector supports the following [sync modes](https://docs.airbyte.com/cloud/core-concepts/#connection-sync-modes):

- [Full Refresh - Overwrite](https://docs.airbyte.com/understanding-airbyte/connections/full-refresh-overwrite)
- [Full Refresh - Append](https://docs.airbyte.com/understanding-airbyte/connections/full-refresh-append)
- [Incremental - Append](https://docs.airbyte.com/understanding-airbyte/connections/incremental-append)
- [Incremental - Append + Deduped](https://docs.airbyte.com/understanding-airbyte/connections/incremental-append-deduped)

## Supported Streams

This connector outputs the following incremental streams:

- Preconfigured streams:
  - [daily_active_users](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [devices](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [four_weekly_active_users](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [locations](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [pages](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_sources](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [website_overview](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [weekly_active_users](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_medium_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_source_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_source_medium_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_source_platform_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_campaign_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_google_ads_ad_network_type_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [user_acquisition_first_user_google_ads_ad_group_name_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_acquisition_session_source_medium_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_acquisition_session_medium_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_acquisition_session_source_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_acquisition_session_campaign_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_acquisition_session_default_channel_grouping_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [traffic_acquisition_session_source_platform_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [events_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [weekly_events_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [conversions_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [pages_title_and_screen_class_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [pages_path_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [pages_title_and_screen_name_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [content_group_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_name_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_id_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_category_report_combined](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_category_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_category_2_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_category_3_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_category_4_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_category_5_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [ecommerce_purchases_item_brand_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [publisher_ads_ad_unit_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [publisher_ads_page_path_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [publisher_ads_ad_format_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [publisher_ads_ad_source_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_country_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_region_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_city_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_language_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_age_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_gender_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [demographic_interest_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_browser_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_device_category_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_device_model_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_screen_resolution_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_app_version_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_platform_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_platform_device_category_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_operating_system_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
  - [tech_os_with_version_report](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)
- [Custom stream\(s\)](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport)

## Connector-specific features

### Custom Reports

Custom reports in Google Analytics allow for flexibility in querying specific data tailored to your needs. You can define the following components:

- **Name**: The name of the custom report.
- **Dimensions**: An array of categories for data, such as city, user type, etc.
- **Metrics**: An array of quantitative measurements, such as active users, page views, etc.
- **CohortSpec**: (Optional) An object containing specific cohort analysis settings, such as cohort size and date range. More information on this object can be found in [the GA4 documentation](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/CohortSpec).
- **Pivots**: (Optional) An array of pivot tables for data, such as page views by city, etc. More information on pivots can be found in [the GA4 documentation](https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/Pivot).

A full list of dimensions and metrics supported in the API can be found [here](https://developers.google.com/analytics/devguides/reporting/data/v1/api-schema). To ensure your dimensions and metrics are compatible for your GA4 property, you can use the [GA4 Dimensions & Metrics Explorer](https://ga-dev-tools.google/ga4/dimensions-metrics-explorer/).

The following is an example of a basic User Engagement report to track sessions and bounce rate, segmented by city:

```json
[
  {
    "name": "User Engagement Report",
    "dimensions": ["city"],
    "metrics": ["sessions", "bounceRate"]
  }
]
```

By specifying a cohort with a 7-day range and pivoting on the city dimension, the report can be further tailored to offer a detailed view of engagement trends within the top 50 cities for the specified date range.

```json
[
  {
    "name": "User Engagement Report",
    "dimensions": ["city"],
    "metrics": ["sessions", "bounceRate"],
    "cohortSpec": {
      "cohorts": [
        {
          "name": "Last 7 Days",
          "dateRange": {
            "startDate": "2023-07-27",
            "endDate": "2023-08-03"
          }
        }
      ],
      "cohortReportSettings": {
        "accumulate": true
      }
    },
    "pivots": [
      {
        "fieldNames": ["city"],
        "limit": 50,
        "metricAggregations": ["TOTAL"]
      }
    ]
  }
]
```

### Data Sampling and Data Request Intervals

Data sampling in Google Analytics 4 refers to the process of estimating analytics data when the amount of data in an account exceeds Google's predefined compute thresholds. To mitigate the chances of data sampling being applied to the results, the **Data Request Interval** field allows users to specify the interval used when requesting data from the Google Analytics API.

By setting the interval to 1 day, users can reduce the data processed per request, minimizing the likelihood of data sampling and ensuring more accurate results. While larger time intervals (up to 364 days) can speed up the sync, we recommend choosing a smaller value to prioritize data accuracy unless there is a specific need for faster synchronization at the expense of some potential inaccuracies. Please note that this field does _not_ apply to custom Cohort reports.

Refer to the [Google Analytics documentation](https://support.google.com/analytics/answer/13331292?sjid=10678419627000327283) for more information on data sampling.

## Performance Considerations

The Google Analytics connector is subject to Google Analytics Data API quotas. Please refer to [Google's documentation](https://developers.google.com/analytics/devguides/reporting/data/v1/quotas) for specific breakdowns on these quotas.

## Data type map

| Integration Type | Airbyte Type |
|:-----------------|:-------------|
| `string`         | `string`     |
| `number`         | `number`     |
| `array`          | `array`      |
| `object`         | `object`     |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version        | Date       | Pull Request                                             | Subject                                                                                                                                                                |
|:---------------|:-----------|:---------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 2.9.6 | 2025-08-02 | [64254](https://github.com/airbytehq/airbyte/pull/64254) | Update dependencies |
| 2.9.5 | 2025-07-26 | [63820](https://github.com/airbytehq/airbyte/pull/63820) | Update dependencies |
| 2.9.4 | 2025-07-19 | [63528](https://github.com/airbytehq/airbyte/pull/63528) | Update dependencies |
| 2.9.3 | 2025-07-16 | [63339](https://github.com/airbytehq/airbyte/pull/63339) | Promoting release candidate 2.9.3-rc.2 to a main version. |
| 2.9.3-rc.2 | 2025-07-15 | [63297](https://github.com/airbytehq/airbyte/pull/63297) | Enable progressive rollout |
| 2.9.3-rc.1 | 2025-07-15 | [63297](https://github.com/airbytehq/airbyte/pull/63297) | Fix bug where concurrent partitions are not merged back together properly so sequential state can't progress to the latest record |
| 2.9.2 | 2025-07-12 | [63129](https://github.com/airbytehq/airbyte/pull/63129) | Update dependencies |
| 2.9.1 | 2025-07-05 | [61135](https://github.com/airbytehq/airbyte/pull/61135) | Update dependencies |
| 2.9.0 | 2025-07-03 | [62507](https://github.com/airbytehq/airbyte/pull/62507) | Promoting release candidate 2.9.0-rc.1 to a main version. |
| 2.9.0-rc.1     | 2025-06-30 | [61550](https://github.com/airbytehq/airbyte/pull/61550) | Unwrap to manifest-only                                                                                                                                                |
| 2.8.2          | 2025-06-17 | [61678](https://github.com/airbytehq/airbyte/pull/61678) | Bump Memory on CHECK to 1600Mi |
| 2.8.1          | 2025-06-12 | [61555](https://github.com/airbytehq/airbyte/pull/61555) | Fixes time data parsing issue |
| 2.8.0          | 2025-06-11 | [61533](https://github.com/airbytehq/airbyte/pull/61533) | Promoting release candidate 2.8.0-rc.2 to a main version. |
| 2.8.0-rc.2     | 2025-06-11 | [61491](https://github.com/airbytehq/airbyte/pull/61491) | Fixed cohort check, record extractor and discovery                                                                                                                     |
| 2.8.0-rc.1     | 2025-05-20 | [60342](https://github.com/airbytehq/airbyte/pull/60342) | Migrate to low-code                                                                                                                                                    |
| 2.7.7          | 2025-05-17 | [60708](https://github.com/airbytehq/airbyte/pull/60708) | Update dependencies                                                                                                                                                    |
| 2.7.6          | 2025-05-10 | [59870](https://github.com/airbytehq/airbyte/pull/59870) | Update dependencies                                                                                                                                                    |
| 2.7.5          | 2025-05-03 | [59225](https://github.com/airbytehq/airbyte/pull/59225) | Update dependencies                                                                                                                                                    |
| 2.7.4          | 2025-04-26 | [58808](https://github.com/airbytehq/airbyte/pull/58808) | Update dependencies                                                                                                                                                    |
| 2.7.3          | 2025-04-12 | [57703](https://github.com/airbytehq/airbyte/pull/57703) | Update dependencies                                                                                                                                                    |
| 2.7.2          | 2025-04-05 | [57063](https://github.com/airbytehq/airbyte/pull/57063) | Update dependencies                                                                                                                                                    |
| 2.7.1          | 2025-03-29 | [50048](https://github.com/airbytehq/airbyte/pull/50048) | Update dependencies                                                                                                                                                    |
| 2.7.0          | 2025-02-12 | [48381](https://github.com/airbytehq/airbyte/pull/48381) | add end date optional parameter                                                                                                                                        |
| 2.6.2          | 2024-12-14 | [48649](https://github.com/airbytehq/airbyte/pull/48649) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 2.6.1          | 2024-10-29 | [47899](https://github.com/airbytehq/airbyte/pull/47899) | Update dependencies                                                                                                                                                    |
| 2.6.0          | 2024-10-28 | [47013](https://github.com/airbytehq/airbyte/pull/47013) | Migrate to CDK v5                                                                                                                                                      |
| 2.5.13         | 2024-10-28 | [47061](https://github.com/airbytehq/airbyte/pull/47061) | Update dependencies                                                                                                                                                    |
| 2.5.12         | 2024-10-12 | [46819](https://github.com/airbytehq/airbyte/pull/46819) | Update dependencies                                                                                                                                                    |
| 2.5.11         | 2024-10-05 | [46475](https://github.com/airbytehq/airbyte/pull/46475) | Update dependencies                                                                                                                                                    |
| 2.5.10         | 2024-09-28 | [46158](https://github.com/airbytehq/airbyte/pull/46158) | Update dependencies                                                                                                                                                    |
| 2.5.9          | 2024-09-21 | [45773](https://github.com/airbytehq/airbyte/pull/45773) | Update dependencies                                                                                                                                                    |
| 2.5.8          | 2024-09-14 | [45503](https://github.com/airbytehq/airbyte/pull/45503) | Update dependencies                                                                                                                                                    |
| 2.5.7          | 2024-09-07 | [45289](https://github.com/airbytehq/airbyte/pull/45289) | Update dependencies                                                                                                                                                    |
| 2.5.6          | 2024-08-31 | [44980](https://github.com/airbytehq/airbyte/pull/44980) | Update dependencies                                                                                                                                                    |
| 2.5.5          | 2024-08-24 | [44645](https://github.com/airbytehq/airbyte/pull/44645) | Update dependencies                                                                                                                                                    |
| 2.5.4          | 2024-08-17 | [44337](https://github.com/airbytehq/airbyte/pull/44337) | Update dependencies                                                                                                                                                    |
| 2.5.3          | 2024-08-13 | [43929](https://github.com/airbytehq/airbyte/pull/43929) | Increase streams max_time to backoff                                                                                                                                   |
| 2.5.2          | 2024-08-12 | [43909](https://github.com/airbytehq/airbyte/pull/43909) | Update dependencies                                                                                                                                                    |
| 2.5.1          | 2024-08-10 | [43289](https://github.com/airbytehq/airbyte/pull/43289) | Update dependencies                                                                                                                                                    |
| 2.5.0          | 2024-08-07 | [42841](https://github.com/airbytehq/airbyte/pull/42841) | Upgrade to CDK 3                                                                                                                                                       |
| 2.4.14         | 2024-07-27 | [42746](https://github.com/airbytehq/airbyte/pull/42746) | Update dependencies                                                                                                                                                    |
| 2.4.13         | 2024-07-20 | [42347](https://github.com/airbytehq/airbyte/pull/42347) | Update dependencies                                                                                                                                                    |
| 2.4.12         | 2024-07-13 | [41801](https://github.com/airbytehq/airbyte/pull/41801) | Update dependencies                                                                                                                                                    |
| 2.4.11         | 2024-07-10 | [41561](https://github.com/airbytehq/airbyte/pull/41561) | Update dependencies                                                                                                                                                    |
| 2.4.10         | 2024-07-09 | [41295](https://github.com/airbytehq/airbyte/pull/41295) | Update dependencies                                                                                                                                                    |
| 2.4.9          | 2024-07-06 | [40935](https://github.com/airbytehq/airbyte/pull/40935) | Update dependencies                                                                                                                                                    |
| 2.4.8          | 2024-06-25 | [40429](https://github.com/airbytehq/airbyte/pull/40429) | Update dependencies                                                                                                                                                    |
| 2.4.7          | 2024-06-22 | [40140](https://github.com/airbytehq/airbyte/pull/40140) | Update dependencies                                                                                                                                                    |
| 2.4.6          | 2024-06-21 | [39916](https://github.com/airbytehq/airbyte/pull/39916) | Added ability to skip `missing stream` in the CATALOG                                                                                                                  |
| 2.4.5          | 2024-06-06 | [38884](https://github.com/airbytehq/airbyte/pull/38884) | Make lookback window configurable.                                                                                                                                     |
| 2.4.4          | 2024-06-06 | [39209](https://github.com/airbytehq/airbyte/pull/39209) | [autopull] Upgrade base image to v1.2.2                                                                                                                                |
| 2.4.3          | 2024-06-03 | [38865](https://github.com/airbytehq/airbyte/pull/38865) | Enforce unique property IDs                                                                                                                                            |
| 2.4.2          | 2024-03-20 | [36302](https://github.com/airbytehq/airbyte/pull/36302) | Don't extract state from the latest record if stream doesn't have a cursor_field                                                                                       |
| 2.4.1          | 2024-02-09 | [35073](https://github.com/airbytehq/airbyte/pull/35073) | Manage dependencies with Poetry.                                                                                                                                       |
| 2.4.0          | 2024-02-07 | [34951](https://github.com/airbytehq/airbyte/pull/34951) | Replace the spec parameter from previous version to convert all `conversions:*` fields                                                                                 |
| 2.3.0          | 2024-02-06 | [34907](https://github.com/airbytehq/airbyte/pull/34907) | Add new parameter to spec to convert `conversions:purchase` field to float                                                                                             |
| 2.2.2          | 2024-02-01 | [34708](https://github.com/airbytehq/airbyte/pull/34708) | Add rounding integer values that may be float                                                                                                                          |
| 2.2.1          | 2024-01-18 | [34352](https://github.com/airbytehq/airbyte/pull/34352) | Add incorrect custom reports config handling                                                                                                                           |
| 2.2.0          | 2024-01-10 | [34176](https://github.com/airbytehq/airbyte/pull/34176) | Add a report option keepEmptyRows                                                                                                                                      |
| 2.1.1          | 2024-01-08 | [34018](https://github.com/airbytehq/airbyte/pull/34018) | prepare for airbyte-lib                                                                                                                                                |
| 2.1.0          | 2023-12-28 | [33802](https://github.com/airbytehq/airbyte/pull/33802) | Add `CohortSpec` to custom report in specification                                                                                                                     |
| 2.0.3          | 2023-11-03 | [32149](https://github.com/airbytehq/airbyte/pull/32149) | Fixed bug with missing `metadata` when the credentials are not valid                                                                                                   |
| 2.0.2          | 2023-11-02 | [32094](https://github.com/airbytehq/airbyte/pull/32094) | Added handling for `JSONDecodeError` while checking for `api qouta` limits                                                                                             |
| 2.0.1          | 2023-10-18 | [31543](https://github.com/airbytehq/airbyte/pull/31543) | Base image migration: remove Dockerfile and use the python-connector-base image                                                                                        |
| 2.0.0          | 2023-09-29 | [30930](https://github.com/airbytehq/airbyte/pull/30930) | Use distinct stream naming in case there are multiple properties in the config.                                                                                        |
| 1.6.0          | 2023-09-19 | [30460](https://github.com/airbytehq/airbyte/pull/30460) | Migrated custom reports from string to array; add `FilterExpressions` support                                                                                          |
| 1.5.1          | 2023-09-20 | [30608](https://github.com/airbytehq/airbyte/pull/30608) | Revert `:` auto replacement name to underscore                                                                                                                         |
| 1.5.0          | 2023-09-18 | [30421](https://github.com/airbytehq/airbyte/pull/30421) | Add `yearWeek`, `yearMonth`, `year` dimensions cursor                                                                                                                  |
| 1.4.1          | 2023-09-17 | [30506](https://github.com/airbytehq/airbyte/pull/30506) | Fix None type error when metrics or dimensions response does not have name                                                                                             |
| 1.4.0          | 2023-09-15 | [30417](https://github.com/airbytehq/airbyte/pull/30417) | Change start date to optional; add suggested streams and update errors handling                                                                                        |
| 1.3.1          | 2023-09-14 | [30424](https://github.com/airbytehq/airbyte/pull/30424) | Fixed duplicated stream issue                                                                                                                                          |
| 1.3.0          | 2023-09-13 | [30152](https://github.com/airbytehq/airbyte/pull/30152) | Ability to add multiple property ids                                                                                                                                   |
| 1.2.0          | 2023-09-11 | [30290](https://github.com/airbytehq/airbyte/pull/30290) | Add new preconfigured reports                                                                                                                                          |
| 1.1.3          | 2023-08-04 | [29103](https://github.com/airbytehq/airbyte/pull/29103) | Update input field descriptions                                                                                                                                        |
| 1.1.2          | 2023-07-03 | [27909](https://github.com/airbytehq/airbyte/pull/27909) | Limit the page size of custom report streams                                                                                                                           |
| 1.1.1          | 2023-06-26 | [27718](https://github.com/airbytehq/airbyte/pull/27718) | Limit the page size when calling `check()`                                                                                                                             |
| 1.1.0          | 2023-06-26 | [27738](https://github.com/airbytehq/airbyte/pull/27738) | License Update: Elv2                                                                                                                                                   |
| 1.0.0          | 2023-06-22 | [26283](https://github.com/airbytehq/airbyte/pull/26283) | Added primary_key and lookback window                                                                                                                                  |
| 0.2.7          | 2023-06-21 | [27531](https://github.com/airbytehq/airbyte/pull/27531) | Fix formatting                                                                                                                                                         |
| 0.2.6          | 2023-06-09 | [27207](https://github.com/airbytehq/airbyte/pull/27207) | Improve api rate limit messages                                                                                                                                        |
| 0.2.5          | 2023-06-08 | [27175](https://github.com/airbytehq/airbyte/pull/27175) | Improve Error Messages                                                                                                                                                 |
| 0.2.4          | 2023-06-01 | [26887](https://github.com/airbytehq/airbyte/pull/26887) | Remove `authSpecification` from connector spec in favour of `advancedAuth`                                                                                             |
| 0.2.3          | 2023-05-16 | [26126](https://github.com/airbytehq/airbyte/pull/26126) | Fix pagination                                                                                                                                                         |
| 0.2.2          | 2023-05-12 | [25987](https://github.com/airbytehq/airbyte/pull/25987) | Categorized Config Errors Accurately                                                                                                                                   |
| 0.2.1          | 2023-05-11 | [26008](https://github.com/airbytehq/airbyte/pull/26008) | Added handling for `429 - potentiallyThresholdedRequestsPerHour` error                                                                                                 |
| 0.2.0          | 2023-04-13 | [25179](https://github.com/airbytehq/airbyte/pull/25179) | Implement support for custom Cohort and Pivot reports                                                                                                                  |
| 0.1.3          | 2023-03-10 | [23872](https://github.com/airbytehq/airbyte/pull/23872) | Fix parse + cursor for custom reports                                                                                                                                  |
| 0.1.2          | 2023-03-07 | [23822](https://github.com/airbytehq/airbyte/pull/23822) | Improve `rate limits` customer faced error messages and retry logic for `429`                                                                                          |
| 0.1.1          | 2023-01-10 | [21169](https://github.com/airbytehq/airbyte/pull/21169) | Slicer updated, unit tests added                                                                                                                                       |
| 0.1.0          | 2023-01-08 | [20889](https://github.com/airbytehq/airbyte/pull/20889) | Improved config validation, SAT                                                                                                                                        |
| 0.0.3          | 2022-08-15 | [15229](https://github.com/airbytehq/airbyte/pull/15229) | Source Google Analytics Data Api: code refactoring                                                                                                                     |
| 0.0.2          | 2022-07-27 | [15087](https://github.com/airbytehq/airbyte/pull/15087) | fix documentationUrl                                                                                                                                                   |
| 0.0.1          | 2022-05-09 | [12701](https://github.com/airbytehq/airbyte/pull/12701) | Introduce Google Analytics Data API source                                                                                                                             |

</details>
