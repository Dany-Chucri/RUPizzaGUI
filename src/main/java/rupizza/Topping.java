package rupizza;
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

    Topping(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
