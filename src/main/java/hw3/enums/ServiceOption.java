package hw3.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ServiceOption {

    SUPPORT("Support"),
    DATES("Dates"),
    SEARCH("Search"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    final String name;

    ServiceOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getAllValues() {
        return Stream.of(ServiceOption.values()).map(el -> el.getName().toUpperCase())
                .collect(Collectors.toList());
    }
}
