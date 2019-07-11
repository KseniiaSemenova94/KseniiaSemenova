package hw6.enums;

public enum Element {

    TYPE_DROPDOWN("TYPE_DROPDOWN"),
    USER_NAME("USER_NAME"),
    DESCRIPTION_IMAGE("DESCRIPTION_IMAGE"),
    DESCRIPTION_TEXT("DESCRIPTION_TEXT"),
    CHECKBOX("CHECKBOX"),
    PICTURE("PICTURE"),
    TEXT_UNDER_PICTURE("TEXT_UNDER_PICTURE"),
    HEADLINE_TEXT("HEADLINE_TEXT"),
    RADIO("RADIO"),
    DROPDOWN("DROPDOWN"),
    BUTTON("BUTTON");


    final String name;

    Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
