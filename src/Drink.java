import java.math.BigDecimal;

public class Drink {
    BigDecimal price;
    DrinkType drinktype;

    public Drink(DrinkType drinktype, BigDecimal price) {
        this.price = price;
        this.drinktype = drinktype;
    }
}
