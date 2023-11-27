package rupizza;
public enum Size {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String displayName;

    Size(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}


