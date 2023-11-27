package rupizza;

/**
 * The Topping enum represents different toppings for pizza.
 * @author Dany Chucri, Madhur Nutulapati
 */
public enum Topping {
    SAUSAGE("Sausage"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    HAM("Ham"),
    BLACK_OLIVE("Black Olive"),
    BEEF("Beef"),
    SHRIMP("Shrimp"),
    SQUID("Squid"),
    CRAB_MEATS("Crab Meats"),
    CHICKEN("Chicken"),
    PINEAPPLE("Pineapple");

    private final String displayName;

    /**
     * Constructs a Topping enum with the specified display name.
     *
     * @param displayName The display name of the topping.
     */
    Topping(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the topping.
     *
     * @return The display name of the topping.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
