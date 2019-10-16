package Models;

import java.math.BigDecimal;

public class Drink {
    public BigDecimal price;
    public DrinkType drinktype;
    public DrinkOptions drinkOptions;

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
        this.drinkOptions = new DrinkOptions();
    }

    public DrinkOptions getDrinkOptions() {
        return drinkOptions;
    }
}
