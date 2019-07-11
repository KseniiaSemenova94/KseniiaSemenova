package hw6.enums;

public enum CommonComponent {

    HEADER("HEADER"),
    LEFT_SECTION("LEFT_SECTION"),
    RIGHT_SECTION("RIGHT_SECTION");

    final String name;

    CommonComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
