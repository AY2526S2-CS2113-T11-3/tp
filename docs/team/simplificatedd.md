# Raven Tang - Project Portfolio Page

## Overview

CardCollector is a desktop application for trading card collectors who prefer a fast CLI workflow over a GUI. It helps users manage an inventory and wishlist of cards, track metadata such as set and rarity, and review collection history directly from the terminal.

I focused mainly on persistence and inventory-management usability. My work covered local storage, import/export support, tag or folder-based organization, analytics, in-app help, and list-related behavior and documentation.

### Summary of Contributions

#### Code contributed

- [RepoSense contribution dashboard](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=Simplificatedd&tabRepo=AY2526S2-CS2113-T11-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false&chartGroupIndex=18&chartIndex=4)

#### Enhancements implemented

- **Implemented local storage for application state**
  - What it does: Allows CardCollector to save inventory data locally and restore it when the application is launched again, instead of losing all cards after each run.
  - Justification: This is a core feature for a collection-management application because users expect their card collection to persist across sessions.
  - Completeness: The enhancement covers the end-to-end persistence flow, including application state integration, storage-layer behavior, and tests for storage behavior.
  - Depth and difficulty: This required more than adding a file write operation. I had to connect the in-memory application state to the storage layer, ensure the saved data could be loaded back into the same model structure, and account for failure cases where storage behavior should not corrupt the running application state.
  - Relevant merge: [#62](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/93e1b15512365646573a4cd78ffbe9941ab7ec07)

- **Implemented upload/download support for storage snapshots**
  - What it does: Adds commands for exporting the current state to a user-specified file and importing a saved state back into the application later.
  - Justification: This improves portability and safety because users can back up their collection, move it between machines, or restore a previous snapshot.
  - Completeness: The feature supports both directions of the workflow: downloading/exporting the current state and uploading/importing a saved state. I also implemented `undoupload` support so a mistaken import can be rolled back.
  - Depth and difficulty: The import path was challenging because it replaces the full application state, not just a single card. This meant the command had to preserve enough previous state for rollback, validate and load the imported data, and integrate cleanly with existing command execution behavior without leaving the application in a partially replaced state.
  - Relevant merge: [#64](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/47b474fe29b172dbea70a5f81ef8c62e029dfe3c)

- **Implemented tag/folder support and tag filtering support**
  - What it does: Allows users to organize cards using tag/folder-style labels and retrieve grouped cards through `filter /t TAG` and tag-aware `find` workflows.
  - Justification: This significantly improves inventory-management usability because collectors often group cards by deck, set, rarity, trade status, or other personal categories. Tags give users a lightweight way to manage these categories without duplicating card entries.
  - Completeness: The enhancement was implemented across the parser, command layer, model/state representation, and user-facing output, so the feature works as part of the normal command workflow instead of being an isolated data field.
  - Depth and difficulty: This was a cross-cutting enhancement because tags had to be represented in the data model, parsed from user input, applied through commands, displayed back to users, persisted to storage, and made useful through filtering behavior. The main difficulty was keeping the behavior consistent across multiple workflows while preserving the CLI command style used by the rest of the application.
  - Relevant merge: [#79](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5f6c83b696be165702b939119b87e1a5ea5a0fc5)

- **Implemented the `analytics` command**
  - What it does: Displays summary insights for the active inventory or wishlist, including distinct card count, total quantity, total value, top cards by price and holding value, cheapest cards, top sets by count and value, price distribution, and metadata coverage.
  - Justification: This improves the product because collectors need more than raw storage. Analytics helps users understand the value and composition of their collection at a glance, such as which cards or sets contribute the most value.
  - Completeness: The command works for both inventory and wishlist through the normal command flow, supports the `stats` alias, and is documented in both the User Guide and Developer Guide.
  - Depth and difficulty: This required designing an analytics data model instead of printing calculations directly from the command. The computation is separated across `CardsList`, `CardsAnalytics`, and `Ui`, which keeps calculation, data transfer, and presentation responsibilities distinct. The feature also had to handle empty lists, missing set information, price buckets, and ranking logic consistently.
  - Relevant PR: [#80](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/80)

- **Implemented the `help` command**
  - What it does: Provides a compact command overview, detailed help for specific commands, support for `COMMAND /h`, and search behavior for help topics.
  - Justification: This improves usability for a CLI application because users should not need to leave the app or search the full User Guide just to recall a command format.
  - Completeness: The help system covers the application commands in a central topic list, supports aliases such as `stats` and `folder`, handles exact matches and broader searches, and returns no-result feedback when a query does not match a known topic.
  - Depth and difficulty: This was more involved than adding a static help string. I had to define a reusable help-topic structure, connect parser behavior for `help` and `/h`, support multiple help modes, and keep command syntax examples consistent with the rest of the CLI.
  - Relevant PR: [#88](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/88)

- **Contributed to the list feature**
  - What it does: Added support for list-related command behavior in the application flow during the earlier project stage.
  - Justification: Listing is one of the main ways users inspect their collection, so this formed part of the foundation for later usability improvements such as filtering by organization labels.
  - Depth and difficulty: This required working with the command flow at an early stage of the project, when the architecture was still evolving. The work helped establish the baseline behavior that later list-related enhancements could build on.
  - Relevant merge: [#19](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/761d375c5ffd7d9ec2d4ac44d6bea6709af0e6ab)

#### Documentation contributions

- Wrote and updated the User Guide and Developer Guide sections for the commands and features I implemented, especially the storage import/export flow, tag or folder support, analytics, and help.
- Added user-facing command examples and usage details so users can understand how to save, export, import, undo imports, organize their collection with tags/folders, view analytics, and get command help.
- Updated developer-facing explanations for the storage, organization, and analytics features so future maintainers can understand how these commands affect application state, persistence, tag filtering behavior, and computation responsibilities.
- Relevant merges and PRs: [#64](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/47b474fe29b172dbea70a5f81ef8c62e029dfe3c), [#79](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5f6c83b696be165702b939119b87e1a5ea5a0fc5), [#80](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/80), [#88](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/88)

#### Contributions to project quality

- Added assertions for list-related logic to make failures surface earlier during development and strengthen defensive programming around command execution. Relevant commit: [Add Assertions for List](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5d42d2a6ed416825e5b628b24ac18f4d2ffae1c5)
- Added and maintained tests for storage-related behavior, which was important because persistence failures can otherwise silently affect user data across application runs.
- Added test coverage for analytics computation and help/parser behavior so user-facing command output and command routing remain reliable.
