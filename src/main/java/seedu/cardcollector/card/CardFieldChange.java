package seedu.cardcollector.card;

/**
 * Stores the previous and current values of a changed card field.
 */
public record CardFieldChange(String previous, String current) {}
