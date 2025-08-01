# Pocket

## Overview

The Pocket source connector only supports full refresh syncs

### Output schema

A single output stream is available from this source:

- [Retrieve](https://getpocket.com/developer/docs/v3/retrieve)

### Features

| Feature           | Supported? |
| :---------------- | :--------- |
| Full Refresh Sync | Yes        |
| Incremental Sync  | No         |

### Performance considerations

For more info on rate limiting, please refer to [Pocket Docs > Rate Limits](https://getpocket.com/developer/docs/rate-limits)

## Getting started

### Requirements

- Consumer Key
- Access Token

### Setup Guide

In order to obtain the Consumer Key and Access Token, please follow the official [Pocket Authentication docs](https://getpocket.com/developer/docs/authentication).

It's nevertheless, very recommended to follow [this guide](https://www.jamesfmackenzie.com/getting-started-with-the-pocket-developer-api/) by James Mackenzie, which is summarized below:

1. Create an App in the [Pocket Developer Portal](https://getpocket.com/developer/apps/new), give it Retrieve permissions and get your Consumer Key.
2. Obtain a Request Token. To do so, you need to issue a POST request to get a temporary Request Token. You can execute the command below:

```sh
curl --insecure -X POST -H 'Content-Type: application/json' -H 'X-Accept: application/json' \
    https://getpocket.com/v3/oauth/request  -d '{"consumer_key":"REPLACE-ME","redirect_uri":"http://www.google.com"}'
```

3. Visit the following website from your browser, and authorize the app: `https://getpocket.com/auth/authorize?request_token=REPLACE-ME&redirect_uri=http://www.google.com`
4. Convert your Request Token Into a Pocket Access Token. To do so, you can execute the following command:

```sh
curl --insecure -X POST -H 'Content-Type: application/json' -H 'X-Accept: application/json' \
    https://getpocket.com/v3/oauth/authorize  -d '{"consumer_key":"REPLACE-ME","code":"REQUEST-TOKEN"}'
```

## Changelog

<details>
  <summary>Expand to review</summary>

| Version | Date       | Pull Request                                             | Subject                                                                         |
| :------ | :--------- | :------------------------------------------------------- | :------------------------------------------------------------------------------ |
| 0.2.29 | 2025-08-02 | [64252](https://github.com/airbytehq/airbyte/pull/64252) | Update dependencies |
| 0.2.28 | 2025-07-26 | [63895](https://github.com/airbytehq/airbyte/pull/63895) | Update dependencies |
| 0.2.27 | 2025-07-19 | [63403](https://github.com/airbytehq/airbyte/pull/63403) | Update dependencies |
| 0.2.26 | 2025-07-12 | [63223](https://github.com/airbytehq/airbyte/pull/63223) | Update dependencies |
| 0.2.25 | 2025-07-05 | [62599](https://github.com/airbytehq/airbyte/pull/62599) | Update dependencies |
| 0.2.24 | 2025-06-28 | [62327](https://github.com/airbytehq/airbyte/pull/62327) | Update dependencies |
| 0.2.23 | 2025-06-21 | [61901](https://github.com/airbytehq/airbyte/pull/61901) | Update dependencies |
| 0.2.22 | 2025-06-14 | [61030](https://github.com/airbytehq/airbyte/pull/61030) | Update dependencies |
| 0.2.21 | 2025-05-24 | [60434](https://github.com/airbytehq/airbyte/pull/60434) | Update dependencies |
| 0.2.20 | 2025-05-10 | [59510](https://github.com/airbytehq/airbyte/pull/59510) | Update dependencies |
| 0.2.19 | 2025-04-27 | [59074](https://github.com/airbytehq/airbyte/pull/59074) | Update dependencies |
| 0.2.18 | 2025-04-19 | [58470](https://github.com/airbytehq/airbyte/pull/58470) | Update dependencies |
| 0.2.17 | 2025-04-12 | [57924](https://github.com/airbytehq/airbyte/pull/57924) | Update dependencies |
| 0.2.16 | 2025-04-05 | [57316](https://github.com/airbytehq/airbyte/pull/57316) | Update dependencies |
| 0.2.15 | 2025-03-29 | [56219](https://github.com/airbytehq/airbyte/pull/56219) | Update dependencies |
| 0.2.14 | 2025-03-08 | [55551](https://github.com/airbytehq/airbyte/pull/55551) | Update dependencies |
| 0.2.13 | 2025-03-01 | [55016](https://github.com/airbytehq/airbyte/pull/55016) | Update dependencies |
| 0.2.12 | 2025-02-23 | [54594](https://github.com/airbytehq/airbyte/pull/54594) | Update dependencies |
| 0.2.11 | 2025-02-15 | [54018](https://github.com/airbytehq/airbyte/pull/54018) | Update dependencies |
| 0.2.10 | 2025-02-08 | [53457](https://github.com/airbytehq/airbyte/pull/53457) | Update dependencies |
| 0.2.9 | 2025-02-01 | [53006](https://github.com/airbytehq/airbyte/pull/53006) | Update dependencies |
| 0.2.8 | 2025-01-25 | [52462](https://github.com/airbytehq/airbyte/pull/52462) | Update dependencies |
| 0.2.7 | 2025-01-18 | [51887](https://github.com/airbytehq/airbyte/pull/51887) | Update dependencies |
| 0.2.6 | 2025-01-11 | [51366](https://github.com/airbytehq/airbyte/pull/51366) | Update dependencies |
| 0.2.5 | 2024-12-28 | [50740](https://github.com/airbytehq/airbyte/pull/50740) | Update dependencies |
| 0.2.4 | 2024-12-21 | [50282](https://github.com/airbytehq/airbyte/pull/50282) | Update dependencies |
| 0.2.3 | 2024-12-14 | [49671](https://github.com/airbytehq/airbyte/pull/49671) | Update dependencies |
| 0.2.2 | 2024-12-12 | [47783](https://github.com/airbytehq/airbyte/pull/47783) | Update dependencies |
| 0.2.1 | 2024-10-28 | [47034](https://github.com/airbytehq/airbyte/pull/47034) | Update dependencies |
| 0.2.0 | 2024-10-21 | [47143](https://github.com/airbytehq/airbyte/pull/47143) | Migrate to manifest only format |
| 0.1.21 | 2024-10-12 | [46838](https://github.com/airbytehq/airbyte/pull/46838) | Update dependencies |
| 0.1.20 | 2024-10-05 | [46404](https://github.com/airbytehq/airbyte/pull/46404) | Update dependencies |
| 0.1.19 | 2024-09-28 | [46138](https://github.com/airbytehq/airbyte/pull/46138) | Update dependencies |
| 0.1.18 | 2024-09-21 | [45736](https://github.com/airbytehq/airbyte/pull/45736) | Update dependencies |
| 0.1.17 | 2024-09-14 | [45487](https://github.com/airbytehq/airbyte/pull/45487) | Update dependencies |
| 0.1.16 | 2024-09-07 | [45225](https://github.com/airbytehq/airbyte/pull/45225) | Update dependencies |
| 0.1.15 | 2024-08-31 | [44994](https://github.com/airbytehq/airbyte/pull/44994) | Update dependencies |
| 0.1.14 | 2024-08-24 | [44321](https://github.com/airbytehq/airbyte/pull/44321) | Update dependencies |
| 0.1.13 | 2024-08-10 | [43116](https://github.com/airbytehq/airbyte/pull/43116) | Update dependencies |
| 0.1.12 | 2024-07-27 | [42775](https://github.com/airbytehq/airbyte/pull/42775) | Update dependencies |
| 0.1.11 | 2024-07-20 | [42385](https://github.com/airbytehq/airbyte/pull/42385) | Update dependencies |
| 0.1.10 | 2024-07-13 | [41923](https://github.com/airbytehq/airbyte/pull/41923) | Update dependencies |
| 0.1.9 | 2024-07-10 | [41457](https://github.com/airbytehq/airbyte/pull/41457) | Update dependencies |
| 0.1.8 | 2024-07-09 | [41294](https://github.com/airbytehq/airbyte/pull/41294) | Update dependencies |
| 0.1.7 | 2024-07-06 | [41001](https://github.com/airbytehq/airbyte/pull/41001) | Update dependencies |
| 0.1.6 | 2024-06-25 | [40308](https://github.com/airbytehq/airbyte/pull/40308) | Update dependencies |
| 0.1.5 | 2024-06-22 | [39957](https://github.com/airbytehq/airbyte/pull/39957) | Update dependencies |
| 0.1.4 | 2024-06-06 | [39298](https://github.com/airbytehq/airbyte/pull/39298) | [autopull] Upgrade base image to v1.2.2 |
| 0.1.3 | 2024-04-19 | [37228](https://github.com/airbytehq/airbyte/pull/37228) | Upgrade to CDK 0.80.0 and manage dependencies with Poetry. |
| 0.1.2 | 2024-04-15 | [37228](https://github.com/airbytehq/airbyte/pull/37228) | Base image migration: remove Dockerfile and use the python-connector-base image |
| 0.1.1 | 2024-04-12 | [37228](https://github.com/airbytehq/airbyte/pull/37228) | schema descriptions |
| 0.1.0 | 2022-10-30 | [18655](https://github.com/airbytehq/airbyte/pull/18655) | 🎉 New Source: Pocket |

</details>
