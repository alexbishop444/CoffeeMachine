import Models.Drink;
import Models.Order;

import java.math.BigDecimal;

public class OrderService implements OrderServiceInterface {
    private DrinkListInterface drinkList;
    public OrderService(DrinkListInterface drinkList) {
        this.drinkList = drinkList;
    }

    public Order createOrder(String drinkInput, String sugarInput, String moneyInput, String extraHotInput, Drink[] drinks) {

        boolean extraHot = false;
        Drink drink = drinks[0];

        for (int i = 0; i < drinks.length + 1; i++) {
            if(drinkInput.equals(Integer.toString(i))) {
                drink = drinks[i - 1];
            }
        }

        int sugars = Integer.parseInt(sugarInput);
        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(moneyInput));

        if(extraHotInput.equals("y")) {
            extraHot = true;
        }

        return new Order(sugars, drink, money,extraHot);
    }
}
