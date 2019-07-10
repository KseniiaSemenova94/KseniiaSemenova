package hw6.enums;

public enum UserTableUser {
    ROMAN("roman"),
    SERGEY_IVAN("ivan"),
    VLADZIMIR("vlad"),
    HELEN_BENNETT("helen"),
    YOSHI_TANNAMURI("yoshi"),
    GIOVANNI_ROVELLI("gio");

    final String name;

    UserTableUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
