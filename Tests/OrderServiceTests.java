import Models.Drink;
import Models.DrinkType;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTests {
    DrinkListInterface drinkList = new DrinkList();
    private OrderService orderService = new OrderService(drinkList);


    @Test
    public void makeTeaOrder() {
        String actual = orderService.createOrder("2","1","0.4","n",drinkList.getDrinks()).drink.toString();
        Order order = new Order(1,new Drink(DrinkType.TEA,new BigDecimal("0.4")),new BigDecimal("0.4"),true);
        order.drink.drinkOptions.setSugars(true);
        order.drink.drinkOptions.setExtraHot(true);
        String expected = order.drink.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeOrder() {
        String actual = orderService.createOrder("1","1","0.6","n",drinkList.getDrinks()).drink.toString();
        Order order = new Order(1,new Drink(DrinkType.COFFEE,new BigDecimal("0.6")),new BigDecimal("0.6"),true);
        order.drink.drinkOptions.setSugars(true);
        order.drink.drinkOptions.setExtraHot(true);
        String expected = order.drink.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateOrder() {
        String actual = orderService.createOrder("3","1","0.5","n",drinkList.getDrinks()).drink.toString();
        Order order = new Order(1,new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5")),new BigDecimal("0.5"),true);
        order.drink.drinkOptions.setSugars(true);
        order.drink.drinkOptions.setExtraHot(true);
        String expected = order.drink.toString();
        Assert.assertEquals(expected,actual);
    }
}
