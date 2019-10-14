import java.math.BigDecimal;

public class DrinkList {
    private Drink[] drinks = new Drink[2];

    public Drink[] buildDrinksList() {
        drinks[0] = new Drink(DrinkType.COFFEE,new BigDecimal("0.6"));
        drinks[1] = new Drink(DrinkType.TEA,new BigDecimal("0.4"));
        drinks[2] = new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5"));
        return drinks;
    }

}