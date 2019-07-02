package hw4.enums;

public enum Metals {

    METALS("Metals"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String name;

    Metals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
