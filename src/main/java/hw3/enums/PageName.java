package hw3.enums;

public enum PageName {

    INDEX_PAGE_NAME("index.html"),
    DIFFERENT_ELEMENTS_PAGE_NAME("different-elements.html");

    final String name;

    PageName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
