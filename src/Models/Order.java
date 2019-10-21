package Models;

import Models.Drink;

import java.math.BigDecimal;
import java.util.HashMap;

public class Order {
    public Drink drink;
    public BigDecimal money;
    public HashMap<DrinkOptionType, String> userSelection;

    public Order(HashMap<DrinkOptionType, String> userSelection , Drink drink, BigDecimal money) {
        this.drink = drink;
        this.money = money;
        this.userSelection = userSelection;
    }
}
