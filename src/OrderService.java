import java.math.BigDecimal;

public class OrderService implements OrderServiceInterface {
    public Order createOrder(String drinkInput, String sugarInput, String moneyInput) {
        Drink[] drinks = new DrinkList().buildDrinksList();

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
        }

        int sugars = Integer.parseInt(sugarInput);
        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(moneyInput));

        return new Order(sugars, drink, money);
    }
}
