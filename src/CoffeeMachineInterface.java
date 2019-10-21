import Models.Drink;
import Models.DrinkOptionType;

import java.util.HashMap;


public interface CoffeeMachineInterface {
    Drink[] processUserInput(String drinkInput, String moneyInput, Drink[] drinks, HashMap<DrinkOptionType,String> userSelection);
    Drink[] returnDrinks();
}
