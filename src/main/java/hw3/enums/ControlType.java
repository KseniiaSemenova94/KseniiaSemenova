package hw3.enums;

public enum ControlType {
    RADIO("RADIO"),
    CHECKBOX("CHECKBOX"),
    DROPDOWN("DROPDOWN"),
    BUTTON("BUTTON");

    final String name;

    ControlType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}