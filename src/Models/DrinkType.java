package Models;

import java.util.HashMap;
import java.util.Map;

public enum DrinkType {
    NONE(0),
    COFFEE(1),
    TEA(2),
    CHOCOLATE(3),
    ORANGE(4);

    private static Map map = new HashMap<>();
    public int getValue() {
        return value;
    }

    private int value;

    static {
        for (DrinkType drinkType : DrinkType.values()) {
            map.put(drinkType.value, drinkType);
        }
    }

    public static DrinkType valueOf(int drinkType) {
        return (DrinkType) map.get(drinkType);
    }

    private DrinkType(int value) {
        this.value = value;
    }

    }
