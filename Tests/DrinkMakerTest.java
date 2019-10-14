import org.junit.Assert;
import org.junit.Test;

public class DrinkMakerTest {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,DrinkType.TEA,1);
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 tea with 1 sugars and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,DrinkType.COFFEE,1);
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 coffee with no sugar - and therefore no stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeHotChocolateWith55Sugars() {
        Order order = new Order(55,DrinkType.CHOCOLATE,1);
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 hot chocolate with 55 sugars and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void underPaidTest() {
        Order order = new Order(55,DrinkType.CHOCOLATE,0.1);
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "You don't have enough money";
        Assert.assertEquals(expected,actual);
    }
}
