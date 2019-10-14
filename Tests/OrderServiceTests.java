import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTests {
    @Test
    public void makeCoffeeOrder() {
        OrderService orderService = new OrderService();
        String expected = "Order{sugars=1, drink=Drink{price=0.6, drinktype=COFFEE}, money=0.6}";
        String actual = new Order(1,new Drink(DrinkType.COFFEE,new BigDecimal("0.6")),new BigDecimal("0.6")).toString();
        Assert.assertEquals(expected,actual);
    }
}
