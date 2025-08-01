# Instagram

<HideInUI>

This page contains the setup guide and reference information for the [Instagram](https://www.instagram.com/) source connector.

</HideInUI>

## Prerequisites

- [Meta for Developers account](https://developers.facebook.com)
- [Instagram business account](https://www.facebook.com/business/help/898752960195806) to your
  Facebook page
- [Facebook ad account ID number](https://www.facebook.com/business/help/1492627900875762) (you'll
  use this to configure Instagram as a source in Airbyte

<!-- env:oss -->

- [Instagram Graph API](https://developers.facebook.com/docs/instagram-api/) to your Facebook app
- [Facebook Instagram OAuth Reference](https://developers.facebook.com/docs/instagram-platform/reference/oauth-authorize/)

<!-- /env:oss -->

## Setup guide

### Set up Instagram

<!-- env:cloud -->

#### For Airbyte Cloud:

1. [Log into your Airbyte Cloud](https://cloud.airbyte.com/workspaces) account.
2. Click Sources and then click + New source.
3. On the Set up the source page, select Instagram from the Source type dropdown.
4. Enter a name for the Instagram connector.
5. Click **Authenticate your Instagram account**.
6. Log in and authorize the Instagram account.
7. (Optional) Enter the **Start Date** in YYYY-MM-DDTHH:mm:ssZ format. All data generated after this
   date will be replicated. If left blank, the start date will be set to 2 years before the present
   date.
8. Click **Set up source**.

<!-- /env:cloud -->

<!-- env:oss -->

#### For Airbyte Open Source:

1. Navigate to the Airbyte Open Source dashboard.
2. Click **Sources** and then click **+ New source**.
3. On the Set up the source page, select **Instagram** from the **Source type** dropdown.
4. Enter a name for your source.
5. Enter **Access Token** generated
   using [Graph API Explorer](https://developers.facebook.com/tools/explorer/)
   or [by using an app you can create on Facebook](https://developers.facebook.com/docs/instagram-basic-display-api/getting-started/)
   with the required permissions: instagram_basic, instagram_manage_insights, pages_show_list,
   pages_read_engagement.
6. (Optional) Enter the **Start Date** in YYYY-MM-DDTHH:mm:ssZ format. All data generated after this
   date will be replicated. If left blank, the start date will be set to 2 years before the present
   date.
7. Click **Set up source**.

<!-- /env:oss -->

<HideInUI>

## Supported sync modes

The Instagram source connector supports the following [sync modes](https://docs.airbyte.com/cloud/core-concepts/#connection-sync-modes):

- [Full Refresh - Overwrite](https://docs.airbyte.com/understanding-airbyte/connections/full-refresh-overwrite/)
- [Full Refresh - Append](https://docs.airbyte.com/understanding-airbyte/connections/full-refresh-append)
- [Incremental - Append](https://docs.airbyte.com/understanding-airbyte/connections/incremental-append)
- [Incremental - Append + Deduped](https://docs.airbyte.com/understanding-airbyte/connections/incremental-append-deduped)

:::note

Incremental sync modes are only available for
the [User Insights](https://developers.facebook.com/docs/instagram-api/reference/ig-user/insights)
stream.

:::

## Supported Streams

The Instagram source connector supports the following streams. For more information, see
the [Instagram Graph API](https://developers.facebook.com/docs/instagram-api/)
and [Instagram Insights API documentation](https://developers.facebook.com/docs/instagram-api/guides/insights/).

- [User](https://developers.facebook.com/docs/instagram-api/reference/ig-user)
    - [User Insights](https://developers.facebook.com/docs/instagram-api/reference/ig-user/insights)
- [Media](https://developers.facebook.com/docs/instagram-api/reference/ig-user/media)
    - [Media Insights](https://developers.facebook.com/docs/instagram-api/reference/ig-media/insights)
- [Stories](https://developers.facebook.com/docs/instagram-api/reference/ig-user/stories/)
    - [Story Insights](https://developers.facebook.com/docs/instagram-api/reference/ig-media/insights)

:::info
The Instagram connector syncs data related to Users, Media, and Stories and their insights from
the [Instagram Graph API](https://developers.facebook.com/docs/instagram-api/). For performance data
related to Instagram Ads, use the Facebook Marketing source.
:::

### Entity-Relationship Diagram (ERD)
<EntityRelationshipDiagram></EntityRelationshipDiagram>

## Data type map

AirbyteRecords are required to conform to
the [Airbyte type](https://docs.airbyte.com/understanding-airbyte/supported-data-types/) system.
This means that all sources must produce schemas and records within these types and all destinations
must handle records that conform to this type system.

| Integration Type | Airbyte Type |
|:-----------------|:-------------|
| `string`         | `string`     |
| `number`         | `number`     |
| `array`          | `array`      |
| `object`         | `object`     |

## Limitations & Troubleshooting

<details>
<summary>
Expand to see details about Instagram connector limitations and troubleshooting.
</summary>

### Connector limitations

#### Rate limiting

Instagram limits the number of requests that can be made at a time. See
Facebook's [documentation on rate limiting](https://developers.facebook.com/docs/graph-api/overview/rate-limiting/#instagram-graph-api)
for more information.

### Troubleshooting

- Check out common troubleshooting issues for the Instagram source connector on
  our [Airbyte Forum](https://github.com/airbytehq/airbyte/discussions).

</details>

## Changelog

<details>
  <summary>Expand to review</summary>

| Version    | Date       | Pull Request                                             | Subject                                                                                                                                                                |
|:-----------|:-----------|:---------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 4.2.2 | 2025-08-02 | [64281](https://github.com/airbytehq/airbyte/pull/64281) | Update dependencies |
| 4.2.1 | 2025-07-19 | [60614](https://github.com/airbytehq/airbyte/pull/60614) | Update dependencies |
| 4.2.0 | 2025-07-17 | [63358](https://github.com/airbytehq/airbyte/pull/63358) | Promoting release candidate 4.2.0-rc.1 to a main version. |
| 4.2.0-rc.1 | 2025-07-16 | [62954](https://github.com/airbytehq/airbyte/pull/62954)     | Migrate to manifest-only format.                                                                                                                                       |
| 4.1.0      | 2025-07-14 | [63289](https://github.com/airbytehq/airbyte/pull/63289) | Promoting release candidate 4.1.0-rc.3 to a main version. |
| 4.1.0-rc.3 | 2025-07-10 | [62902](https://github.com/airbytehq/airbyte/pull/62902)     | Revert add `views` metric to `StoryInsights` and `MediaInsights` streams.                                                                                              |
| 4.1.0-rc.2 | 2025-07-09 | [62844](https://github.com/airbytehq/airbyte/pull/62844) | Migrate `UserInsights` stream to low-code                                                                                                                              |
| 4.1.0-rc.1 | 2025-05-27 | [60848](https://github.com/airbytehq/airbyte/pull/60848) | Add `views` metric to `StoryInsights` and `MediaInsights` streams.                                                                                                     |
| 4.0.5      | 2025-05-10 | [59798](https://github.com/airbytehq/airbyte/pull/59798) | Update dependencies                                                                                                                                                    |
| 4.0.4      | 2025-05-03 | [59243](https://github.com/airbytehq/airbyte/pull/59243) | Update dependencies                                                                                                                                                    |
| 4.0.3      | 2025-04-26 | [58773](https://github.com/airbytehq/airbyte/pull/58773) | Update dependencies                                                                                                                                                    |
| 4.0.2      | 2025-04-19 | [58167](https://github.com/airbytehq/airbyte/pull/58167) | Update dependencies                                                                                                                                                    |
| 4.0.1      | 2025-04-12 | [57704](https://github.com/airbytehq/airbyte/pull/57704) | Update dependencies                                                                                                                                                    |
| 4.0.0      | 2025-04-07 | [55860](https://github.com/airbytehq/airbyte/pull/55860) | Remove deprecated metrics from `StoryInsights`, `UserInsights` and `MediaInsights` streams.                                                                            |
| 3.2.5      | 2025-04-05 | [57069](https://github.com/airbytehq/airbyte/pull/57069) | Update dependencies                                                                                                                                                    |
| 3.2.4      | 2025-03-29 | [56666](https://github.com/airbytehq/airbyte/pull/56666) | Update dependencies                                                                                                                                                    |
| 3.2.3      | 2025-03-22 | [56020](https://github.com/airbytehq/airbyte/pull/56020) | Update dependencies                                                                                                                                                    |
| 3.2.2      | 2025-03-10 | [55685](https://github.com/airbytehq/airbyte/pull/55685) | Disable cache for InstagramMediaChildrenTransformation                                                                                                                 |
| 3.2.1      | 2025-03-08 | [55463](https://github.com/airbytehq/airbyte/pull/55463) | Update dependencies                                                                                                                                                    |
| 3.2.0      | 2025-02-28 | [54364](https://github.com/airbytehq/airbyte/pull/54364) | Update to CDK v6                                                                                                                                                       |
| 3.1.9      | 2025-03-01 | [54789](https://github.com/airbytehq/airbyte/pull/54789) | Update dependencies                                                                                                                                                    |
| 3.1.8      | 2025-02-22 | [54364](https://github.com/airbytehq/airbyte/pull/54364) | Update dependencies                                                                                                                                                    |
| 3.1.7      | 2025-02-15 | [53846](https://github.com/airbytehq/airbyte/pull/53846) | Update dependencies                                                                                                                                                    |
| 3.1.6      | 2025-02-08 | [53291](https://github.com/airbytehq/airbyte/pull/53291) | Update dependencies                                                                                                                                                    |
| 3.1.5      | 2025-02-06 | [53171](https://github.com/airbytehq/airbyte/pull/53171) | Fix missing OAuth fields                                                                                                                                               |
| 3.1.4      | 2025-02-01 | [52260](https://github.com/airbytehq/airbyte/pull/52260) | Update dependencies                                                                                                                                                    |
| 3.1.3      | 2025-01-20 | [52035](https://github.com/airbytehq/airbyte/pull/52035) | Upgrade to API v21.0                                                                                                                                                   |
| 3.1.2      | 2025-01-11 | [44223](https://github.com/airbytehq/airbyte/pull/44223) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 3.1.1      | 2025-01-09 | [51018](https://github.com/airbytehq/airbyte/pull/51018) | Remove deprecated metrics from `StoryInsights` and `MediaInsights` streams.                                                                                            |
| 3.1.0      | 2024-07-13 | [41937](https://github.com/airbytehq/airbyte/pull/41937) | New metrics added for `StoryInsights` and `MediaInsights` streams.                                                                                                     |
| 3.0.22     | 2024-07-27 | [42721](https://github.com/airbytehq/airbyte/pull/42721) | Update dependencies                                                                                                                                                    |
| 3.0.21     | 2024-07-20 | [42346](https://github.com/airbytehq/airbyte/pull/42346) | Update dependencies                                                                                                                                                    |
| 3.0.20     | 2024-07-13 | [41784](https://github.com/airbytehq/airbyte/pull/41784) | Update dependencies                                                                                                                                                    |
| 3.0.19     | 2024-07-10 | [41586](https://github.com/airbytehq/airbyte/pull/41586) | Update dependencies                                                                                                                                                    |
| 3.0.18     | 2024-07-09 | [41109](https://github.com/airbytehq/airbyte/pull/41109) | Update dependencies                                                                                                                                                    |
| 3.0.17     | 2024-07-08 | [41046](https://github.com/airbytehq/airbyte/pull/41046) | Use latest `CDK` version possible                                                                                                                                      |
| 3.0.16     | 2024-07-06 | [40903](https://github.com/airbytehq/airbyte/pull/40903) | Update dependencies                                                                                                                                                    |
| 3.0.15     | 2024-07-02 | [40569](https://github.com/airbytehq/airbyte/pull/40569) | Migrate MediaInsights and StoryInsights to low-code                                                                                                                    |
| 3.0.14     | 2024-06-26 | [40524](https://github.com/airbytehq/airbyte/pull/40524) | Fix Api stream when the results contain not business accounts                                                                                                          |
| 3.0.13     | 2024-06-25 | [40456](https://github.com/airbytehq/airbyte/pull/40456) | Update dependencies                                                                                                                                                    |
| 3.0.12     | 2024-06-24 | [39504](https://github.com/airbytehq/airbyte/pull/39504) | Migrate Media, Users, UserLifeTimeInsights and Stories to low-code                                                                                                     |
| 3.0.11     | 2024-06-22 | [40127](https://github.com/airbytehq/airbyte/pull/40127) | Update dependencies                                                                                                                                                    |
| 3.0.10     | 2024-06-06 | [39303](https://github.com/airbytehq/airbyte/pull/39303) | [autopull] Upgrade base image to v1.2.2                                                                                                                                |
| 3.0.9      | 2024-05-21 | [38554](https://github.com/airbytehq/airbyte/pull/38554) | Upgrade to API v19.0                                                                                                                                                   |
| 3.0.8      | 2024-05-20 | [38268](https://github.com/airbytehq/airbyte/pull/38268) | Replace AirbyteLogger with logging.Logger                                                                                                                              |
| 3.0.7      | 2024-04-19 | [36643](https://github.com/airbytehq/airbyte/pull/36643) | Updating to 0.80.0 CDK                                                                                                                                                 |
| 3.0.6      | 2024-04-12 | [36643](https://github.com/airbytehq/airbyte/pull/36643) | Schema descriptions                                                                                                                                                    |
| 3.0.5      | 2024-03-20 | [36314](https://github.com/airbytehq/airbyte/pull/36314) | Unpin CDK version                                                                                                                                                      |
| 3.0.4      | 2024-03-07 | [35875](https://github.com/airbytehq/airbyte/pull/35875) | Remove `total_interactions` from the `MediaInsights` queries.                                                                                                          |
| 3.0.3      | 2024-02-12 | [35177](https://github.com/airbytehq/airbyte/pull/35177) | Manage dependencies with Poetry                                                                                                                                        |
| 3.0.2      | 2024-01-15 | [34254](https://github.com/airbytehq/airbyte/pull/34254) | Prepare for airbyte-lib                                                                                                                                                |
| 3.0.1      | 2024-01-08 | [33989](https://github.com/airbytehq/airbyte/pull/33989) | Remove metrics from video feed                                                                                                                                         |
| 3.0.0      | 2024-01-05 | [33930](https://github.com/airbytehq/airbyte/pull/33930) | Upgrade to API v18.0                                                                                                                                                   |
| 2.0.1      | 2024-01-03 | [33889](https://github.com/airbytehq/airbyte/pull/33889) | Change requested metrics for stream `media_insights`                                                                                                                   |
| 2.0.0      | 2023-11-17 | [32500](https://github.com/airbytehq/airbyte/pull/32500) | Add primary keys for UserLifetimeInsights and UserInsights; add airbyte_type to timestamp fields                                                                       |
| 1.0.16     | 2023-11-17 | [32627](https://github.com/airbytehq/airbyte/pull/32627) | Fix start_date type; fix docs                                                                                                                                          |
| 1.0.15     | 2023-11-14 | [32494](https://github.com/airbytehq/airbyte/pull/32494) | Marked start_date as optional; set max retry time to 10 minutes; add suggested streams                                                                                 |
| 1.0.14     | 2023-11-13 | [32423](https://github.com/airbytehq/airbyte/pull/32423) | Capture media_product_type column in media and stories stream                                                                                                          |
| 1.0.13     | 2023-11-10 | [32245](https://github.com/airbytehq/airbyte/pull/32245) | Add skipping reading MediaInsights stream if an error code 10 is received                                                                                              |
| 1.0.12     | 2023-11-07 | [32200](https://github.com/airbytehq/airbyte/pull/32200) | The backoff strategy has been updated to make some errors retriable                                                                                                    |
| 1.0.11     | 2023-08-03 | [29031](https://github.com/airbytehq/airbyte/pull/29031) | Reverted `advancedAuth` spec changes                                                                                                                                   |
| 1.0.10     | 2023-08-01 | [28910](https://github.com/airbytehq/airbyte/pull/28910) | Updated `advancedAuth` broken references                                                                                                                               |
| 1.0.9      | 2023-07-01 | [27908](https://github.com/airbytehq/airbyte/pull/27908) | Fix bug when `user_lifetime_insights` stream returns `Key Error (end_time)`, refactored `state` to use `IncrementalMixin`                                              |
| 1.0.8      | 2023-05-26 | [26767](https://github.com/airbytehq/airbyte/pull/26767) | Handle permission error for `insights`                                                                                                                                 |
| 1.0.7      | 2023-05-26 | [26656](https://github.com/airbytehq/airbyte/pull/26656) | Remove `authSpecification` from connector specification in favour of `advancedAuth`                                                                                    |
| 1.0.6      | 2023-03-28 | [26599](https://github.com/airbytehq/airbyte/pull/26599) | Handle error for Media posted before business account conversion                                                                                                       |
| 1.0.5      | 2023-03-28 | [24634](https://github.com/airbytehq/airbyte/pull/24634) | Add user-friendly message for no instagram_business_accounts case                                                                                                      |
| 1.0.4      | 2023-03-15 | [23671](https://github.com/airbytehq/airbyte/pull/23671) | Add info about main permissions in spec and doc links in error message to navigate user                                                                                |
| 1.0.3      | 2023-03-14 | [24043](https://github.com/airbytehq/airbyte/pull/24043) | Do not emit incomplete records for `user_insights` stream                                                                                                              |
| 1.0.2      | 2023-03-14 | [24042](https://github.com/airbytehq/airbyte/pull/24042) | Test publish flow                                                                                                                                                      |
| 1.0.1      | 2023-01-19 | [21602](https://github.com/airbytehq/airbyte/pull/21602) | Handle abnormally large state values                                                                                                                                   |
| 1.0.0      | 2022-09-23 | [17110](https://github.com/airbytehq/airbyte/pull/17110) | Remove custom read function and migrate to per-stream state                                                                                                            |
| 0.1.11     | 2022-09-08 | [16428](https://github.com/airbytehq/airbyte/pull/16428) | Fix requests metrics for Reels media product type                                                                                                                      |
| 0.1.10     | 2022-09-05 | [16340](https://github.com/airbytehq/airbyte/pull/16340) | Update to latest version of the CDK (v0.1.81)                                                                                                                          |
| 0.1.9      | 2021-09-30 | [6438](https://github.com/airbytehq/airbyte/pull/6438)   | Annotate Oauth2 flow initialization parameters in connector specification                                                                                              |
| 0.1.8      | 2021-08-11 | [5354](https://github.com/airbytehq/airbyte/pull/5354)   | Added check for empty state and fixed tests                                                                                                                            |
| 0.1.7      | 2021-07-19 | [4805](https://github.com/airbytehq/airbyte/pull/4805)   | Add support for previous `STATE` format                                                                                                                                |
| 0.1.6      | 2021-07-07 | [4210](https://github.com/airbytehq/airbyte/pull/4210)   | Refactor connector to use CDK: - improve error handling - fix sync fail with HTTP status 400 - integrate SAT                                                           |

</details>

</HideInUI>
