package rupizza;
/**
 * The Sauce enum represents different types of pizza sauces.
 * @author Dany Chucri, Madhur Nutulapati
 */
public enum Sauce {
    /**
     * Represents a tomato-based pizza sauce.
     */
    TOMATO("Tomato"),

    /**
     * Represents an Alfredo-based pizza sauce.
     */
    ALFREDO("Alfredo");

    private final String displayName;

    /**
     * Constructs a Sauce enum with the specified display name.
     *
     * @param displayName The display name of the sauce.
     */
    Sauce(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the sauce.
     *
     * @return The display name of the sauce.
     */
    @Override
    public String toString() {
        return displayName;
    }
}


