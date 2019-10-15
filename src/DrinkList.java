import Models.Drink;
import Models.DrinkType;

import java.math.BigDecimal;

public class DrinkList implements DrinkListInterface {
    private Drink[] drinks = new Drink[4];

    public Drink[] getDrinks() {
        drinks[0] = new Drink(DrinkType.COFFEE,new BigDecimal("0.6"));
        drinks[1] = new Drink(DrinkType.TEA,new BigDecimal("0.4"));
        drinks[2] = new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5"));
        drinks[3] = new Drink(DrinkType.ORANGE,new BigDecimal("0.6"));
        return drinks;
    }

}