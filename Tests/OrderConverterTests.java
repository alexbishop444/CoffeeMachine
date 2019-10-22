import Models.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class OrderConverterTests {
    HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();
    Drink[] drinks = new DrinkList().getDrinks();
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(userSelection,drinks[1],new BigDecimal("0.5"));
        order.userSelection.put(DrinkOptionType.NUMBEROFSUGARS,"1");
        OrderConverter converter = new OrderConverter();
        String expected = "T:1:0";
        String actual = converter.convertOrder(order);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(userSelection,drinks[0],new BigDecimal("0.5"));
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "C::";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeExtraHot() {
        Order order = new Order(userSelection,drinks[0],new BigDecimal("0.5"));
        order.userSelection.put(DrinkOptionType.EXTRAHOT,"y");
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "Ch::";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateExtraHot() {
        Order order = new Order(userSelection,drinks[2],new BigDecimal("0.5"));
        order.userSelection.put(DrinkOptionType.EXTRAHOT,"y");
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "Hh::";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeOrangeJuice() {
        Order order = new Order(userSelection,drinks[3],new BigDecimal("0.5"));
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "O::";
        Assert.assertEquals(expected,actual);
    }
}
