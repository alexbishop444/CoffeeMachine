public enum DrinkType {
    NONE(0),
    COFFEE(0.6),
    TEA(0.4),
    CHOCOLATE(0.5);

    public double getValue() {
        return value;
    }

    private double value;

    private DrinkType(double value) {
        this.value = value;
    }

    }
