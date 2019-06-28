package hw3.enums;

public enum HeaderMenu {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String name;

    HeaderMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
