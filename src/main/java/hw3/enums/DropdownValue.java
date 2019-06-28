package hw3.enums;

public enum DropdownValue {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String name;

    DropdownValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
