import Models.Drink;
import Models.DrinkOptionType;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CoffeeMachineTests {
    DrinkMakerInterface drinkMaker = new DrinkMaker();
    OrderConverterInterface orderConverter = new OrderConverter();
    DrinkListInterface drinkList = new DrinkList();
    OrderServiceInterface orderService = new OrderService();
    ReportInterface report = new Report();
    Drink[] drinks = drinkList.getDrinks();
    HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();

    @Test
    public void underPaidTest() {
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        Drink[] input = coffeeMachine.processUserInput("1","2",drinks,userSelection);
        BigDecimal actual = input[0].amountSold;
        BigDecimal expected = drinks[0].amountSold = new BigDecimal("0");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void exactPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        Drink[] input = coffeeMachine.processUserInput("1","2",drinks,userSelection);
        BigDecimal actual = input[0].amountSold;
        BigDecimal expected = drinks[0].amountSold = new BigDecimal("1");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void OverPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        Drink[] input = coffeeMachine.processUserInput("1","2",drinks,userSelection);
        BigDecimal actual = input[0].amountSold;
        BigDecimal expected = drinks[0].amountSold = new BigDecimal("1");
        Assert.assertEquals(expected,actual);
    }
}
