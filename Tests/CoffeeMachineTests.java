import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CoffeeMachineTests {
    DrinkMakerInterface drinkMaker = new DrinkMaker();
    OrderConverterInterface orderConverter = new OrderConverter();
    DrinkListInterface drinkList = new DrinkList();
    OrderServiceInterface orderService = new OrderService(drinkList);
    @Test
    public void underPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.2","n");
        Assert.assertEquals(false,actual);
    }
    @Test
    public void exactPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.6","n");
        Assert.assertEquals(true,actual);
    }
    @Test
    public void OverPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","333","n");
        Assert.assertEquals(true,actual);
    }
    @Test
    public void CoffeeExtraHotTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        Boolean actual = coffeeMachine.processUserInput("1","2","0.6","y");
        Assert.assertEquals(true,actual);
    }
}
