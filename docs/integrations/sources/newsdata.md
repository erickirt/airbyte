# Newsdata API

## Sync overview

This source retrieves the latests news from the [Newsdata API](https://newsdata.io/).

### Output schema

This source is capable of syncing the following streams:

- `latest`
- `sources`
  - **NOTE**: `category`, `language` and `country` input parameters only accept a single value, not multiple like `latest` stream.
    Thus, if several values are supplied, the first one will be the one to be used.

If there are more endpoints you'd like Airbyte to support, please [create an issue.](https://github.com/airbytehq/airbyte/issues/new/choose)

### Features

| Feature           | Supported? | Notes |
| :---------------- | ---------- | :---- |
| Full Refresh Sync | Yes        |       |
| Incremental Sync  | No         |       |

### Performance considerations

The News API free tier only allows 200 requests per day, and only up to 10
news per request.

The free tier does not allow to perform advanced search queries.

## Getting started

### Requirements

1. A Newsdata API key. You can get one [here](https://newsdata.io/register).

### Setup guide

The following fields are required fields for the connector to work:

- `api_key`: Your Newsdata API key.

## Changelog

<details>
  <summary>Expand to review</summary>

| Version | Date       | Pull Request                                             | Subject                                                                         |
| :------ | :--------- | :------------------------------------------------------- | :------------------------------------------------------------------------------ |
| 0.2.14 | 2025-08-02 | [64193](https://github.com/airbytehq/airbyte/pull/64193) | Update dependencies |
| 0.2.13 | 2025-07-26 | [63852](https://github.com/airbytehq/airbyte/pull/63852) | Update dependencies |
| 0.2.12 | 2025-07-19 | [63402](https://github.com/airbytehq/airbyte/pull/63402) | Update dependencies |
| 0.2.11 | 2025-07-12 | [63170](https://github.com/airbytehq/airbyte/pull/63170) | Update dependencies |
| 0.2.10 | 2025-07-05 | [62606](https://github.com/airbytehq/airbyte/pull/62606) | Update dependencies |
| 0.2.9 | 2025-06-21 | [61912](https://github.com/airbytehq/airbyte/pull/61912) | Update dependencies |
| 0.2.8 | 2025-05-24 | [60439](https://github.com/airbytehq/airbyte/pull/60439) | Update dependencies |
| 0.2.7 | 2025-04-27 | [59066](https://github.com/airbytehq/airbyte/pull/59066) | Update dependencies |
| 0.2.6 | 2025-03-29 | [56672](https://github.com/airbytehq/airbyte/pull/56672) | Update dependencies |
| 0.2.5 | 2025-03-08 | [55469](https://github.com/airbytehq/airbyte/pull/55469) | Update dependencies |
| 0.2.4 | 2025-01-25 | [52240](https://github.com/airbytehq/airbyte/pull/52240) | Update dependencies |
| 0.2.3 | 2025-01-04 | [50896](https://github.com/airbytehq/airbyte/pull/50896) | Update dependencies |
| 0.2.2 | 2024-12-12 | [47812](https://github.com/airbytehq/airbyte/pull/47812) | Update dependencies |
| 0.2.1 | 2024-08-16 | [44196](https://github.com/airbytehq/airbyte/pull/44196) | Bump source-declarative-manifest version |
| 0.2.0 | 2024-08-15 | [44113](https://github.com/airbytehq/airbyte/pull/44113) | Refactor connector to manifest-only format |
| 0.1.15 | 2024-08-10 | [43517](https://github.com/airbytehq/airbyte/pull/43517) | Update dependencies |
| 0.1.14 | 2024-08-03 | [43271](https://github.com/airbytehq/airbyte/pull/43271) | Update dependencies |
| 0.1.13 | 2024-07-27 | [42783](https://github.com/airbytehq/airbyte/pull/42783) | Update dependencies |
| 0.1.12 | 2024-07-20 | [42378](https://github.com/airbytehq/airbyte/pull/42378) | Update dependencies |
| 0.1.11 | 2024-07-13 | [41791](https://github.com/airbytehq/airbyte/pull/41791) | Update dependencies |
| 0.1.10 | 2024-07-10 | [41567](https://github.com/airbytehq/airbyte/pull/41567) | Update dependencies |
| 0.1.9 | 2024-07-09 | [41138](https://github.com/airbytehq/airbyte/pull/41138) | Update dependencies |
| 0.1.8 | 2024-07-06 | [40852](https://github.com/airbytehq/airbyte/pull/40852) | Update dependencies |
| 0.1.7 | 2024-06-25 | [40361](https://github.com/airbytehq/airbyte/pull/40361) | Update dependencies |
| 0.1.6 | 2024-06-22 | [40082](https://github.com/airbytehq/airbyte/pull/40082) | Update dependencies |
| 0.1.5 | 2024-06-06 | [39160](https://github.com/airbytehq/airbyte/pull/39160) | [autopull] Upgrade base image to v1.2.2 |
| 0.1.4 | 2024-05-28 | [38731](https://github.com/airbytehq/airbyte/pull/38731) | Make compatible with the builder |
| 0.1.3 | 2024-04-19 | [37203](https://github.com/airbytehq/airbyte/pull/37203) | Upgrade to CDK 0.80.0 and manage dependencies with Poetry. |
| 0.1.2 | 2024-04-15 | [37203](https://github.com/airbytehq/airbyte/pull/37203) | Base image migration: remove Dockerfile and use the python-connector-base image |
| 0.1.1 | 2024-04-12 | [37203](https://github.com/airbytehq/airbyte/pull/37203) | schema descriptions |
| 0.1.0 | 2022-10-21 | [18576](https://github.com/airbytehq/airbyte/pull/18576) | 🎉 New Source: Newsdata |

</details>
