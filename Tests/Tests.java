import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void makeTeaWithTwoSugars() {
        Order order = new Order(1,DrinkType.TEA);
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        System.out.println(orderString);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 tea with 1 sugar and a stick";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,DrinkType.COFFEE);
        OrderConverter converter = new OrderConverter();
        String orderString = converter.convertOrder(order);
        System.out.println(orderString);
        DrinkMaker drinkMaker = new DrinkMaker();
        String actual = drinkMaker.makeDrink(orderString);
        String expected = "Drink maker makes 1 coffee with no sugar - and therefore no stick";
        Assert.assertEquals(expected,actual);
    }
}
