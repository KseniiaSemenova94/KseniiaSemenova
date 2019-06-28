package hw3.enums;

public enum CheckboxItem {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final String name;

    CheckboxItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
