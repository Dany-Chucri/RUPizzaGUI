package rupizza;
public enum Sauce {
    TOMATO("Tomato"),
    ALFREDO("Alfredo");

    private final String displayName;

    Sauce(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}


