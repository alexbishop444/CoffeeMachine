import org.junit.Assert;
import org.junit.Test;

public class OrderConverterTests {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,DrinkType.TEA,1);
        OrderConverter converter = new OrderConverter();
        String expected = "T:1:0:1.0";
        String actual = converter.convertOrder(order);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void makeCoffeeWithNoSugars() {
        Order order = new Order(0,DrinkType.COFFEE,8);
        OrderConverter converter = new OrderConverter();
        String actual = converter.convertOrder(order);
        String expected = "C:::8.0";
        Assert.assertEquals(expected,actual);
    }
}
