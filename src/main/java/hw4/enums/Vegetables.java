package hw4.enums;

public enum Vegetables {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    final String name;

    Vegetables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
