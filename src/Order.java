import java.math.BigDecimal;

public class Order {
    int sugars;
    Drink drink;
    BigDecimal money;

    @Override
    public String toString() {
        return "Order{" +
                "sugars=" + sugars +
                ", drink=" + drink +
                ", money=" + money +
                '}';
    }

    public Order(int sugars, Drink drink, BigDecimal money) {
        this.sugars = sugars;
        this.drink = drink;
        this.money = money;
    }
}
