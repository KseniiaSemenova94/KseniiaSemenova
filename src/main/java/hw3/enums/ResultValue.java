package hw3.enums;

public enum ResultValue {
    COLOR("Color"),
    METAL("Metal"),
    SUMMARY("Summary"),
    ELEMENTS("Elements"),
    VEGETABLES("Vegetables");

    final String name;

    ResultValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
