package hw4.enums;

public enum DataTableEvent {

    SEARCH("search"),
    LENGTH("length");

    final String name;

    DataTableEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
