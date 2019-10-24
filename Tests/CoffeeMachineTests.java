//import Models.Drink;
//import Models.DrinkOptionType;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.HashMap;
//
//public class CoffeeMachineTests {
//    DrinkMakerInterface drinkMaker = new DrinkMaker();
//    OrderConverterInterface orderConverter = new OrderConverter();
//    DrinkServiceInterface drinkList = new DrinkService();
//    OrderServiceInterface orderService = new OrderService();
//    ReportInterface report = new Report();
//    Drink[] drinks = drinkList.getDrinks();
//    HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();
//
//    @Test
//    public void underPaidTest() {
//        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
//        Drink[] input = coffeeMachine.processUserInput("1","0.1",drinks,userSelection);
//        int actual = input[0].amountSold;
//        int expected = drinks[0].amountSold = 0;
//        Assert.assertEquals(expected,actual);
//    }
//    @Test
//    public void exactPaidTest() {
//
//        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
//        Drink[] input = coffeeMachine.processUserInput("1","0.6",drinks,userSelection);
//        int actual = input[0].amountSold;
//        int expected = drinks[0].amountSold = 1;
//        Assert.assertEquals(expected,actual);
//    }
//    @Test
//    public void OverPaidTest() {
//
//        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
//        Drink[] input = coffeeMachine.processUserInput("1","2",drinks,userSelection);
//        int actual = input[0].amountSold;
//        int expected = drinks[0].amountSold = 1;
//        Assert.assertEquals(expected,actual);
//    }
//}
