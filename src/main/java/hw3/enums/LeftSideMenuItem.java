package hw3.enums;

public enum LeftSideMenuItem {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements pack");

    final String name;

    LeftSideMenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
