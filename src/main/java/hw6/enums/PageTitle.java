package hw6.enums;

public enum PageTitle {

    HOME_PAGE("Home Page"),
    DIFFERENT_ELEMENTS("Different Elements"),
    USER_TABLE("User Table");

    final String name;

    PageTitle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
