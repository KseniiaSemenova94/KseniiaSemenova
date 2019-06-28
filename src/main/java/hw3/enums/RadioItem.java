package hw3.enums;

public enum RadioItem {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String name;

    RadioItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
