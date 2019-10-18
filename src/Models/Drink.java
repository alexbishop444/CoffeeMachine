package Models;

import java.math.BigDecimal;

public class Drink {
    public BigDecimal price;
    public DrinkType drinktype;
    public DrinkOptions drinkOptions;
    public BigDecimal amountSold;

    public void setAmountSold(BigDecimal amountSold) {
        this.amountSold = amountSold;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                ", drinktype=" + drinktype +
                ", drinkOptions=" + drinkOptions +
                ", amountSold=" + amountSold +
                '}';
    }

    public Drink(DrinkType drinktype, BigDecimal price) {
        this.price = price;
        this.drinktype = drinktype;
        this.drinkOptions = new DrinkOptions();
        this.amountSold = new BigDecimal("0");
    }

    public DrinkOptions getDrinkOptions() {
        return drinkOptions;
    }
}
