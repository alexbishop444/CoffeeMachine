import java.math.BigDecimal;

public class Order {
    int sugars;
    Drink drink;
    BigDecimal money;

    public Order(int sugars, Drink drink, BigDecimal money) {
        this.sugars = sugars;
        this.drink = drink;
        this.money = money;
    }
}
