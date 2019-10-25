import Models.Drink;
import Models.DrinkOptionType;
import Models.Order;
import Service.DrinkService;
import Service.OrderService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class OrderServiceTests {
    private OrderService orderService = new OrderService();
    private HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();
    private Drink[] drinks = new DrinkService().getDrinks();

    @Test
    public void makeTeaOrder() {
        String actual = orderService.createOrder("2","0.6",userSelection,drinks).drink.toString();
        Order order = new Order(userSelection,drinks[1],new BigDecimal("0.5"));
        String expected = order.drink.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeOrder() {
        String actual = orderService.createOrder("1","0.6",userSelection,drinks).drink.toString();
        Order order = new Order(userSelection,drinks[0],new BigDecimal("0.5"));
        String expected = order.drink.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateOrder() {
        String actual = orderService.createOrder("3","0.6",userSelection,drinks).drink.toString();
        Order order = new Order(userSelection,drinks[2],new BigDecimal("0.5"));
        String expected = order.drink.toString();
        Assert.assertEquals(expected,actual);
    }
}
