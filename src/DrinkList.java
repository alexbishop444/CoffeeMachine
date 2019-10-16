import Models.Drink;
import Models.DrinkType;

import java.math.BigDecimal;

public class DrinkList implements DrinkListInterface {
    private Drink[] drinks = new Drink[4];

    public Drink[] createDrinks() {
        drinks[0] = new Drink(DrinkType.COFFEE,new BigDecimal("0.6"));
        drinks[1] = new Drink(DrinkType.TEA,new BigDecimal("0.4"));
        drinks[2] = new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5"));
        drinks[3] = new Drink(DrinkType.ORANGE,new BigDecimal("0.6"));
        return drinks;
    }

    public Drink[] sugarDrinks() { ;
        Drink[] drinks = createDrinks();
        System.out.println(drinks[0].getDrinkOptions());
        for (Drink drink:drinks) {
            if(drink.drinktype != DrinkType.ORANGE) {
                drink.drinkOptions.setSugars(true);
            }
        }
        return drinks;
    }


    public Drink[] extraHotDrinks() {
        Drink[] drinks = sugarDrinks();
        for (Drink drink : drinks) {
            if (drink.drinktype != DrinkType.ORANGE) {
                drink.drinkOptions.setExtraHot(true);
            }
        }
        return drinks;
    }

    public Drink[] getDrinks() {
        Drink[] drinks = extraHotDrinks();
        return drinks;
    }

}