package seedu.cardcollector.card;

/**
 * Represents the type of change recorded in a card history entry.
 * The three main types ({@code ADDED}, {@code REMOVED}, {@code MODIFIED}) are mutually exclusive.
 * <p>
 * The fourth {@code ENTIRE} is a special value used ONLY for filtering operations,
 * it is not assigned to individual history entries. Instructs the system
 * to display entries from all three main categories.
 */
public enum CardHistoryType {
    ADDED("added"),
    REMOVED("removed"),
    MODIFIED("modified"),
    ENTIRE("entire");

    private final String keyword;

    CardHistoryType(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
