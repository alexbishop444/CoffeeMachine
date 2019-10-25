package Service;

import Models.Drink;
import Models.DrinkOptionType;
import Models.Order;

import java.util.HashMap;

public interface OrderServiceInterface {
    Order createOrder(String drinkInput, String moneyInput, HashMap<DrinkOptionType, String> userSelection, Drink[] drinks);
}
