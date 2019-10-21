package Models;

import java.math.BigDecimal;

public class Drink {
    public BigDecimal price;
    public DrinkType drinktype;
    public DrinkOption[] drinkOptions;
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

    public Drink(DrinkType drinktype, BigDecimal price, DrinkOption[] drinkOptions) {
        this.price = price;
        this.drinktype = drinktype;
        this.drinkOptions = drinkOptions;
        this.amountSold = new BigDecimal("0");
    }
}
