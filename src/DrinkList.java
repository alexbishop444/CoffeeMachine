import Models.Drink;
import Models.DrinkOption;
import Models.DrinkOptionType;
import Models.DrinkType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DrinkList implements DrinkListInterface {
    private Drink[] drinks;

    public Drink[] getDrinks() {
        if(drinks == null) {
            drinks = new Drink[DrinkType.values().length - 1];
            DrinkOption drinkOptionExtraHot = new DrinkOption(DrinkOptionType.EXTRAHOT, "Extra hot? y or n?");
            DrinkOption drinkOptionHasSugar = new DrinkOption(DrinkOptionType.NUMBEROFSUGARS, "How many sugars do you want?");
            drinks[0] = new Drink(DrinkType.COFFEE, new BigDecimal("0.6"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar});
            drinks[1] = new Drink(DrinkType.TEA, new BigDecimal("0.4"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar});
            drinks[2] = new Drink(DrinkType.CHOCOLATE, new BigDecimal("0.5"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar});
            drinks[3] = new Drink(DrinkType.ORANGE, new BigDecimal("0.6"), new DrinkOption[]{});
        }
        return drinks;
    }

}