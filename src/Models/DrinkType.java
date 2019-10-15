package Models;

public enum DrinkType {
    NONE(0),
    COFFEE(1),
    TEA(2),
    CHOCOLATE(3),
    ORANGE(4);

    public int getValue() {
        return value;
    }

    private int value;

    private DrinkType(int value) {
        this.value = value;
    }

    }
