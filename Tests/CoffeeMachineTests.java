import Models.Drink;
import Models.DrinkOptionType;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CoffeeMachineTests {
    DrinkMakerInterface drinkMaker = new DrinkMaker();
    OrderConverterInterface orderConverter = new OrderConverter();
    Service.DrinkServiceInterface drinkList = new Service.DrinkService();
    Service.OrderServiceInterface orderService = new Service.OrderService();
    ReportInterface report = new Report();
    HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();

    @Test
    public void underPaidTest() {
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        boolean expected = coffeeMachine.processUserInput("1","0.1",userSelection);
        boolean actual = false;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void exactPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        boolean expected = coffeeMachine.processUserInput("1","0.6",userSelection);
        boolean actual = true;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void OverPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        boolean expected = coffeeMachine.processUserInput("1","22",userSelection);
        boolean actual = true;
        Assert.assertEquals(expected,actual);
    }
}
