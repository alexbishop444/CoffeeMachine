import org.junit.Assert;
import org.junit.Test;

public class OrderTest {
    @Test
    public void makeTeaWithOneSugar() {
        Order order = new Order(1,DrinkType.TEA);
        System.out.println(order);
    }
}
