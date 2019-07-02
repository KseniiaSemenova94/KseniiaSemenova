package hw4.enums;

public enum FormField {

    COLOR("Color"),
    METAL("Metal"),
    SUMMARY("Summary"),
    ELEMENTS("Elements"),
    VEGETABLES("Vegetables");

    final String name;

    FormField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
