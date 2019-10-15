import Models.Drink;
import Models.DrinkType;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderConverterTests {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,new Drink(DrinkType.TEA,new BigDecimal("0.5")),new BigDecimal("0.5"),false);
        OrderConverter converter = new OrderConverter();
        String expected = "T:1:0";
        String actual = converter.convertOrder(order);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,new Drink(DrinkType.COFFEE,new BigDecimal("0.5")),new BigDecimal("0.5"),false);
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "C::";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeExtraHot() {
        Order order = new Order(0,new Drink(DrinkType.COFFEE,new BigDecimal("0.5")),new BigDecimal("0.5"),true);
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "Ch::";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateExtraHot() {
        Order order = new Order(0,new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5")),new BigDecimal("0.5"),true);
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "Hh::";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeOrangeJuice() {
        Order order = new Order(0,new Drink(DrinkType.ORANGE,new BigDecimal("0.5")),new BigDecimal("0.5"),false);
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "O::";
        Assert.assertEquals(expected,actual);
    }
}
