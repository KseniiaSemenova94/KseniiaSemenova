package hw6.enums;

public enum UserTableUserIndex {
    ROMAN(1),
    SERGEY_IVAN(2),
    VLADZIMIR(3),
    HELEN_BENNETT(4),
    YOSHI_TANNAMURI(5),
    GIOVANNI_ROVELLI(6);

    final Integer index;

    UserTableUserIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
