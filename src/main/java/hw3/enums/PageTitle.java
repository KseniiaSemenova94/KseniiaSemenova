package hw3.enums;

public enum PageTitle {

    HOME_PAGE("Home Page"),
    TABLE_WITH_PAGES("Table with pages");

    final String name;

    PageTitle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
