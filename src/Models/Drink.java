package Models;

import java.math.BigDecimal;

public class Drink {
    public BigDecimal price;
    public DrinkType drinktype;

    @Override
    public String toString() {
        return "Models.Drink{" +
                "price=" + price +
                ", drinktype=" + drinktype +
                '}';
    }

    public Drink(DrinkType drinktype, BigDecimal price) {
        this.price = price;
        this.drinktype = drinktype;
    }
}
