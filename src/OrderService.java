import java.math.BigDecimal;

public class OrderService implements OrderServiceInterface {
    public Order createOrder(String drinkInput, String sugarInput, String moneyInput) {

        Drink drink = new Drink(DrinkType.COFFEE,new BigDecimal(0.6));
        switch (drinkInput) {
            case "1":
                drink = new Drink(DrinkType.COFFEE,new BigDecimal(0.6));
                break;
            case "2":
                drink = new Drink(DrinkType.TEA,new BigDecimal(0.4));
                break;
            case "3":
                drink = new Drink(DrinkType.CHOCOLATE,new BigDecimal(0.5));
                break;
        }

        int sugars = Integer.parseInt(sugarInput);
        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(moneyInput));

        return new Order(sugars, drink, money);
    }
}
