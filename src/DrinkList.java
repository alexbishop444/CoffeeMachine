import Models.Drink;
import Models.DrinkType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DrinkList implements DrinkListInterface {
    private Drink[] drinks = new Drink[DrinkType.values().length - 1];

    public Drink[] createDrinks() {
        drinks[0] = new Drink(DrinkType.COFFEE,new BigDecimal("0.6"));
        drinks[1] = new Drink(DrinkType.TEA,new BigDecimal("0.4"));
        drinks[2] = new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5"));
        drinks[3] = new Drink(DrinkType.ORANGE,new BigDecimal("0.6"));
        return drinks;
    }

    //method drinks that can add sugar
    //list = orange,apple juice

    public ArrayList<String> isSugarable() {
        ArrayList<String> cantAddSugarDrinks = new ArrayList<>();
        cantAddSugarDrinks.add("ORANGE");
        return cantAddSugarDrinks;
    }

    public ArrayList<String> isHotable() {
        ArrayList<String> cantAddHotDrinks = new ArrayList<>();
        cantAddHotDrinks.add("ORANGE");
        return cantAddHotDrinks;
    }

    public Drink[] sugarDrinks(ArrayList<String> cantAddSugarDrinks) { ;

        Drink[] drinks = createDrinks();
        for (String item:cantAddSugarDrinks){

            for (Drink drink : drinks) {
                if (!drink.drinktype.toString().equals(item)) {
                    drink.drinkOptions.setSugars(true);
                }
            }
        }
        return drinks;
    }


    public Drink[] extraHotDrinks(ArrayList<String> cantAddHotDrinks) {
        Drink[] drinks = sugarDrinks(isSugarable());
        for (String item:cantAddHotDrinks){

            for (Drink drink : drinks) {
                if (!drink.drinktype.toString().equals(item)) {
                    drink.drinkOptions.setExtraHot(true);
                }
            }
        }
        return drinks;
    }

    public Drink[] getDrinks() {
        Drink[] drinks = extraHotDrinks(isHotable());
        return drinks;
    }

}