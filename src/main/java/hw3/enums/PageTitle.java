package hw3.enums;

public enum PageTitle {

    HOME_PAGE("Home Page"),
    TABLE_WITH_PAGES("Table with pages"),
    METAL_AND_COLORS("Metal and Colors");

    final String name;

    PageTitle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
