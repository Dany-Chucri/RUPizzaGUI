package rupizza;

/**
 * The Size enum represents different sizes for pizza.
 * @author Dany Chucri, Madhur Nutulapati
 */
public enum Size {
    /**
     * Represents a small-sized pizza.
     */
    SMALL("small"),

    /**
     * Represents a medium-sized pizza.
     */
    MEDIUM("medium"),

    /**
     * Represents a large-sized pizza.
     */
    LARGE("large");

    private final String displayName;

    /**
     * Constructs a Size enum with the specified display name.
     *
     * @param displayName The display name of the size.
     */
    Size(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the size.
     *
     * @return The display name of the size.
     */
    @Override
    public String toString() {
        return displayName;
    }
}


