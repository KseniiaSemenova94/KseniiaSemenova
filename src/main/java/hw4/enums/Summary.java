package hw4.enums;

public enum Summary {

    SUMMARY_1("1"),
    SUMMARY_2("2"),
    SUMMARY_3("3"),
    SUMMARY_4("4"),
    SUMMARY_5("5"),
    SUMMARY_6("6"),
    SUMMARY_7("7"),
    SUMMARY_8("8");

    final String name;

    Summary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
