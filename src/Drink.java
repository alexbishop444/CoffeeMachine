import java.math.BigDecimal;

public class Drink {
    BigDecimal price;
    DrinkType drinktype;

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                ", drinktype=" + drinktype +
                '}';
    }

    public Drink(DrinkType drinktype, BigDecimal price) {
        this.price = price;
        this.drinktype = drinktype;
    }
}
