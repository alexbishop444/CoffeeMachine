package Service;

import Models.Drink;
import Models.DrinkOption;
import Models.DrinkOptionType;
import Models.DrinkType;

import java.math.BigDecimal;

public class DrinkService implements DrinkServiceInterface {
    private Drink[] drinks;

    public Drink[] getDrinks() {
        if(drinks == null) {
            drinks = new Drink[DrinkType.values().length - 1];
            DrinkOption drinkOptionExtraHot = new DrinkOption(DrinkOptionType.EXTRAHOT, "Extra hot? y or n?");
            DrinkOption drinkOptionHasSugar = new DrinkOption(DrinkOptionType.NUMBEROFSUGARS, "How many sugars do you want?");
            drinks[0] = new Drink(DrinkType.COFFEE, new BigDecimal("0.6"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar},20,20);
            drinks[1] = new Drink(DrinkType.TEA, new BigDecimal("0.4"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar},110,30);
            drinks[2] = new Drink(DrinkType.CHOCOLATE, new BigDecimal("0.5"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar},30,20);
            drinks[3] = new Drink(DrinkType.ORANGE, new BigDecimal("0.6"), new DrinkOption[]{},0,0);
        }
        return drinks;
    }

    public DrinkOption[] getDrinkOptions(DrinkType drinkType) {
        drinks = getDrinks();
        for (Drink drink:drinks) {
            if(drink.drinktype == drinkType) {
                return drink.drinkOptions;
            }
        }
        // find drink from drinks[] of drinkType, report its options
        return drinks[0].drinkOptions;
    }

    public Drink getDrink(DrinkType drinkType) {
        drinks = getDrinks();
        for (Drink drink:drinks) {
            if(drink.drinktype == drinkType) {
                return drink;
            }
        }
        // find drink from drinks[] of drinkType, report its options
        return drinks[0];
    }
}