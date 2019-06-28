package hw3.enums;

public enum HeaderMenuItem {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String name;

    HeaderMenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
