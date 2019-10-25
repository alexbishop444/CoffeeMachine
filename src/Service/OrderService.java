package Service;

import Models.Drink;
import Models.DrinkOptionType;
import Models.Order;

import java.math.BigDecimal;
import java.util.HashMap;

public class OrderService implements OrderServiceInterface {
    public OrderService() {
    }

    public Order createOrder(String drinkInput, String moneyInput, HashMap<DrinkOptionType, String> userSelection, Drink[] drinks) {

        Drink drink = drinks[0];

        for (int i = 0; i < drinks.length + 1; i++) {
            if(drinkInput.equals(Integer.toString(i))) {
                drink = drinks[i - 1];
            }
        }

        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(moneyInput));

        return new Order(userSelection,drink, money);
    }
}
