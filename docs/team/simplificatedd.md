# Raven Tang - Project Portfolio Page

## Project: CardCollector

CardCollector is a command-line desktop application for trading card collectors to manage an inventory and wishlist, track card metadata, and review collection information quickly from the terminal.

## Summary of Contributions

### Code Contributed

- [RepoSense contribution dashboard](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=Simplificatedd&tabRepo=AY2526S2-CS2113-T11-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false&chartGroupIndex=18&chartIndex=4)

### Enhancements Implemented

- **Implemented local storage for application state**
  - Allows CardCollector to save inventory data locally and restore it on the next launch.
  - This is a core feature for a collection manager because users expect their card data to persist across sessions.
  - The work covered state integration, storage-layer behavior, failure handling, and storage tests.
  - Relevant merge: [#62](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/93e1b15512365646573a4cd78ffbe9941ab7ec07)

- **Implemented upload/download support for storage snapshots**
  - Added commands for exporting the current application state to a user-specified file and importing a saved state later.
  - This improves portability and backup safety, and also supports `undoupload` so mistaken imports can be rolled back.
  - The import path was more complex because it replaces the full application state and needed to avoid leaving the app partially updated.
  - Relevant merge: [#64](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/47b474fe29b172dbea70a5f81ef8c62e029dfe3c)

- **Implemented tag/folder support and tag filtering**
  - Added tag/folder-style labels so users can organize cards by deck, set, rarity, trade status, or other personal categories.
  - Integrated tags across parsing, commands, model/state representation, user-facing output, persistence, and filtering through `filter /t TAG` and tag-aware `find` workflows.
  - Relevant merge: [#79](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5f6c83b696be165702b939119b87e1a5ea5a0fc5)

- **Implemented the `analytics` command**
  - Displays collection summaries such as distinct card count, total quantity, total value, top cards, cheapest cards, top sets, price distribution, and metadata coverage.
  - Works for both inventory and wishlist through the normal command flow, supports the `stats` alias, and handles empty lists and missing set information.
  - The computation is separated across `CardsList`, `CardsAnalytics`, and `Ui` so calculation, data transfer, and presentation responsibilities remain distinct.
  - Relevant PR: [#80](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/80)

- **Implemented the `help` command**
  - Provides a compact command overview, detailed help for specific commands, support for `COMMAND /h`, and search behavior for help topics.
  - Centralized help topics and aliases such as `stats` and `folder`, while keeping no-result feedback for unknown help queries.
  - Relevant PR: [#88](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/88)

- **Contributed to the `list` feature**
  - Added list-related command behavior during an earlier project stage.
  - This helped establish the baseline workflow for inspecting collections before later filtering and organization improvements.
  - Relevant merge: [#19](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/761d375c5ffd7d9ec2d4ac44d6bea6709af0e6ab)

### Documentation - User Guide

- Documented the storage import/export flow, tag/folder support, analytics command, and help command.
- Added user-facing command examples for saving, exporting, importing, undoing imports, organizing cards with tags/folders, viewing analytics, and getting command help.
- Relevant contributions: [#64](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/47b474fe29b172dbea70a5f81ef8c62e029dfe3c), [#79](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5f6c83b696be165702b939119b87e1a5ea5a0fc5), [#80](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/80), [#88](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/88)

### Documentation - Developer Guide

- Documented the storage, organization, and analytics implementations.
- Explained how these features affect application state, persistence, tag filtering, and analytics computation responsibilities.
- Relevant contributions: [#64](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/47b474fe29b172dbea70a5f81ef8c62e029dfe3c), [#79](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5f6c83b696be165702b939119b87e1a5ea5a0fc5), [#80](https://github.com/AY2526S2-CS2113-T11-3/tp/pull/80)

### Contributions to Team Project

- Added assertions for list-related logic so failures surface earlier during development. Relevant commit: [Add Assertions for List](https://github.com/AY2526S2-CS2113-T11-3/tp/commit/5d42d2a6ed416825e5b628b24ac18f4d2ffae1c5)
- Added and maintained tests for storage behavior, analytics computation, and help/parser behavior.
