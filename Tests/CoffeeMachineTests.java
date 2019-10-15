import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CoffeeMachineTests {
    DrinkMakerInterface drinkMaker = new DrinkMaker();
    OrderConverterInterface orderConverter = new OrderConverter();
    OrderServiceInterface orderService = new OrderService();
    DrinkListInterface drinkList = new DrinkList();
    @Test
    public void underPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,drinkList);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.2");
        Assert.assertEquals(false,actual);
    }
    @Test
    public void exactPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,drinkList);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.6");
        Assert.assertEquals(true,actual);
    }
    @Test
    public void OverPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,drinkList);
        Boolean actual = coffeeMachine.processUserInput("1","2","333");
        Assert.assertEquals(true,actual);
    }
}
