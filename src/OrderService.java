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
        switch (drinkInput) {
            case "1":
                drink = drinks[0];
                break;
            case "2":
                drink = drinks[1];
                break;
            case "3":
                drink = drinks[2];
                break;
            case "4":
                drink = drinks[3];
        }

        int sugars = Integer.parseInt(sugarInput);
        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(moneyInput));

        if(extraHotInput.equals("y")) {
            extraHot = true;
        }

        return new Order(sugars, drink, money,extraHot);
    }
}
