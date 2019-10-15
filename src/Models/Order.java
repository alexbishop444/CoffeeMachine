package Models;

import Models.Drink;

import java.math.BigDecimal;

public class Order {
    public int sugars;
    public Drink drink;
    public BigDecimal money;
    public Boolean extraHot;

    @Override
    public String toString() {
        return "Models.Order{" +
                "sugars=" + sugars +
                ", drink=" + drink +
                ", money=" + money +
                ", extraHot=" + extraHot +
                '}';
    }



    public Order(int sugars, Drink drink, BigDecimal money, Boolean extraHot) {
        this.sugars = sugars;
        this.drink = drink;
        this.money = money;
        this.extraHot = extraHot;
    }
}
