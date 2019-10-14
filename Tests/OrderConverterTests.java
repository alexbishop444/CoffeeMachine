import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderConverterTests {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,new Drink(DrinkType.TEA,new BigDecimal(0.5)),new BigDecimal(0.5));
        OrderConverter converter = new OrderConverter();
        String expected = "T:1:0";
        String actual = converter.convertOrder(order);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,new Drink(DrinkType.COFFEE,new BigDecimal(0.5)),new BigDecimal(0.5));
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "C::";
        Assert.assertEquals(expected,actual);
    }
}
