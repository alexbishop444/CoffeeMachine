import Models.Drink;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeMachineTests {
    DrinkMakerInterface drinkMaker = new DrinkMaker();
    OrderConverterInterface orderConverter = new OrderConverter();
    DrinkListInterface drinkList = new DrinkList();
    OrderServiceInterface orderService = new OrderService(drinkList);
    ReportInterface report = new Report();
    Drink[] drinks = drinkList.getDrinks();

    @Test
    public void underPaidTest() {
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        Drink[] input = coffeeMachine.processUserInput("1","2","0.1","n",drinks);
        BigDecimal actual = input[0].amountSold;
        BigDecimal expected = drinks[0].amountSold = new BigDecimal("0");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void exactPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        Drink[] input = coffeeMachine.processUserInput("1","2","0.6","n",drinks);
        BigDecimal actual = input[0].amountSold;
        BigDecimal expected = drinks[0].amountSold = new BigDecimal("1");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void OverPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        Drink[] input = coffeeMachine.processUserInput("1","2","33","n",drinks);
        BigDecimal actual = input[0].amountSold;
        BigDecimal expected = drinks[0].amountSold = new BigDecimal("1");
        Assert.assertEquals(expected,actual);
    }
}
