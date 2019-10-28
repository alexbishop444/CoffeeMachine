import Converters.OrderConverter;
import Converters.OrderConverterInterface;
import Core.CoffeeMachine;
import Core.CoffeeMachineInterface;
import Core.DrinkMaker;
import Core.DrinkMakerInterface;
import Models.Drink;
import Models.DrinkOption;
import Models.DrinkOptionType;
import Models.DrinkType;
import Reports.Report;
import Reports.ReportInterface;
import Service.DrinkService;
import Service.DrinkServiceInterface;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.mockito.Mockito.*;

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
        boolean actual = coffeeMachine.processUserInput("1","0.1",userSelection);
        Assert.assertFalse(actual);
    }
    @Test
    public void exactPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        boolean actual = coffeeMachine.processUserInput("1","0.6",userSelection);
        Assert.assertTrue(actual);
    }
    @Test
    public void OverPaidTest() {

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,drinkList);
        boolean actual = coffeeMachine.processUserInput("1","22",userSelection);
        Assert.assertTrue(actual);
    }
    @Test
    public void notEnoughWaterTest() {
        // you can mock concrete cl«asses, not only interfaces
        DrinkServiceInterface mockedDrinkInterface = mock(DrinkServiceInterface.class); // Mocking example

        DrinkOption drinkOptionExtraHot = new DrinkOption(DrinkOptionType.EXTRAHOT, "Extra hot? y or n?");
        DrinkOption drinkOptionHasSugar = new DrinkOption(DrinkOptionType.NUMBEROFSUGARS, "How many sugars do you want?");

        Drink drink = new Drink(DrinkType.TEA, new BigDecimal("0.4"), new DrinkOption[]{drinkOptionExtraHot, drinkOptionHasSugar},1000,30);

        when(mockedDrinkInterface.getDrinks()).thenReturn(new Drink[]{drink}); //Stubbing example

        // stubbing appears before the actual execution
        when(mockedDrinkInterface.getDrink(DrinkType.TEA)).thenReturn(drink);

        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,mockedDrinkInterface);
        boolean actual = coffeeMachine.processUserInput("2","2",userSelection);

        Assert.assertFalse(actual);
    }
    @Test
    public void spyTest() {
        // Arrange
        DrinkServiceInterface mockedDrinkInterface = Mockito.spy(new DrinkService());
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report,mockedDrinkInterface);

        // Act
        coffeeMachine.processUserInput("2","2",userSelection);

        // Assert
        Mockito.verify(mockedDrinkInterface, times(2)).getDrinks();
    }
}
