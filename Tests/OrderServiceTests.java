import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTests {
    private OrderService orderService = new OrderService();


    @Test
    public void makeTeaOrder() {
        String actual = orderService.createOrder("2","1","0.4").toString();
        String expected = new Order(1,new Drink(DrinkType.TEA,new BigDecimal("0.4")),new BigDecimal("0.4")).toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeOrder() {
        String actual = orderService.createOrder("1","1","0.6").toString();
        String expected = new Order(1,new Drink(DrinkType.COFFEE,new BigDecimal("0.6")),new BigDecimal("0.6")).toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateOrder() {
        String actual = orderService.createOrder("3","1","0.5").toString();
        String expected = new Order(1,new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5")),new BigDecimal("0.5")).toString();
        Assert.assertEquals(expected,actual);
    }
}
