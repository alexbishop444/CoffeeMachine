import Models.Drink;
import Models.DrinkOptionType;
import Models.Order;
import Service.DrinkService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class DrinkMakerTests {
    HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();
    Drink[] drinks = new DrinkService().getDrinks();
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(userSelection,drinks[1],new BigDecimal("0.5"));
        order.userSelection.put(DrinkOptionType.NUMBEROFSUGARS,"1");
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Models.Drink maker makes 1 tea with 1 sugars and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(userSelection,drinks[0],new BigDecimal("0.5"));
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Models.Drink maker makes 1 coffee with no sugar - and therefore no stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateWith55Sugars() {
        Order order = new Order(userSelection,drinks[2],new BigDecimal("0.5"));
        order.userSelection.put(DrinkOptionType.NUMBEROFSUGARS,"55");
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Models.Drink maker makes 1 hot chocolate with 55 sugars and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeExtraHot() {
        Order order = new Order(userSelection,drinks[2],new BigDecimal("0.5"));
        order.userSelection.put(DrinkOptionType.EXTRAHOT,"y");
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Models.Drink maker makes an extra hot hot chocolate with no sugar - and therefore no stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeOrange() {
        Order order = new Order(userSelection,drinks[3],new BigDecimal("0.5"));
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Models.Drink maker makes 1 orange juice with no sugar - and therefore no stick";
        Assert.assertEquals(expected,actual);
    }
}
