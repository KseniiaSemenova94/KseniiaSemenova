package hw4.enums;

public enum Colors {

    COLORS("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String name;

    Colors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
