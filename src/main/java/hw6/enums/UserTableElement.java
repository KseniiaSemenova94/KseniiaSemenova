package hw6.enums;

public enum UserTableElement {

    NUMBER_TYPE_DROPDOWN("NUMBER_TYPE_DROPDOWN"),
    USER_NAME("USER_NAME"),
    DESCRIPTION_IMAGE("DESCRIPTION_IMAGE"),
    DESCRIPTION_TEXT("DESCRIPTION_TEXT"),
    CHECKBOX("CHECKBOX");

    final String name;

    UserTableElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
