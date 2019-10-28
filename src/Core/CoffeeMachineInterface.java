package Core;

import Models.Drink;
import Models.DrinkOption;
import Models.DrinkOptionType;
import Models.DrinkType;

import java.util.HashMap;


public interface CoffeeMachineInterface {
    boolean processUserInput(String drinkInput, String moneyInput, HashMap<DrinkOptionType,String> userSelection);
    void notifyMissingDrink(DrinkType drinkType);
    void printReport();
    DrinkOption[] GetDrinkOptions(DrinkType drinkType);
}
