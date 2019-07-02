package hw4.enums;

public enum EntriesFieldValue {

    VALUE_5("5"),
    VALUE_10("10"),
    VALUE_15("15"),
    VALUE_20("20");

    final String name;

    EntriesFieldValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
