import org.junit.Assert;
import org.junit.Test;

public class OrderConverterTests {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,DrinkType.TEA);
        OrderConverter converter = new OrderConverter();
        String expected = "T:1:0";
        String actual = converter.convertOrder(order);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,DrinkType.COFFEE);
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "C::";
        Assert.assertEquals(expected,actual);
    }
}
