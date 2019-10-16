package Models;

import java.math.BigDecimal;

public class Drink {
    public BigDecimal price;
    public DrinkType drinktype;
    public DrinkOptions drinkOptions;
    public int amountSold;

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }

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
        this.amountSold = 0;
    }

    public DrinkOptions getDrinkOptions() {
        return drinkOptions;
    }
}
