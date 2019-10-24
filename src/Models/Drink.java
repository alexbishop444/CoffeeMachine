package Models;

import java.math.BigDecimal;

public class Drink {
    public BigDecimal price;
    public DrinkType drinktype;
    public DrinkOption[] drinkOptions;
    public int waterRequirement;
    public int milkRequirement;

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                ", drinktype=" + drinktype +
                ", drinkOptions=" + drinkOptions +
                '}';
    }

    public Drink(DrinkType drinktype, BigDecimal price, DrinkOption[] drinkOptions,int waterRequirement, int milkRequirement) {
        this.price = price;
        this.drinktype = drinktype;
        this.drinkOptions = drinkOptions;
        this.waterRequirement = waterRequirement;
        this.milkRequirement = milkRequirement;
    }
}
