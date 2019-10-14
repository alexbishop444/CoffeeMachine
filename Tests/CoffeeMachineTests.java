import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CoffeeMachineTests {
    @Test
    public void underPaidTest() {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        OrderServiceInterface orderService = new OrderService();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.2");
        Assert.assertEquals(false,actual);
    }
    @Test
    public void exactPaidTest() {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        OrderServiceInterface orderService = new OrderService();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.6");
        Assert.assertEquals(true,actual);
    }
    @Test
    public void OverPaidTest() {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        OrderServiceInterface orderService = new OrderService();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","333");
        Assert.assertEquals(true,actual);
    }
}
