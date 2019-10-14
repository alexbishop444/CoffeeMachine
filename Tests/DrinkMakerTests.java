import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkMakerTests {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,new Drink(DrinkType.TEA,new BigDecimal(0.5)),new BigDecimal(0.5));
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 tea with 1 sugars and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,new Drink(DrinkType.COFFEE,new BigDecimal(0.5)),new BigDecimal(0.5));
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 coffee with no sugar - and therefore no stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateWith55Sugars() {
        Order order = new Order(55,new Drink(DrinkType.CHOCOLATE,new BigDecimal(0.5)),new BigDecimal(0.5));
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 hot chocolate with 55 sugars and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void underPaidTest() {
        Order order = new Order(1,new Drink(DrinkType.CHOCOLATE,new BigDecimal(0.5)),new BigDecimal(0.4));
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "You don't have enough money";
        Assert.assertEquals(expected,actual);
    }
}
