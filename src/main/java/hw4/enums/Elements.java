package hw4.enums;

public enum Elements {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final String name;

    Elements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
