import java.util.ArrayList;
import java.util.Arrays;

public class OrderConverter implements OrderConverterInterface {
    ArrayList<String>  baseString = new ArrayList<>();
    public String convertOrder(Order order) {
        switch (order.drinkType) {
            case TEA: baseString.add("T:");
            break;
            case CHOCOLATE: baseString.add("H:");
            break;
            case COFFEE: baseString.add("C:");
            break;
        }
        if (order.sugars == 0) {
            baseString.add(":");
        } else {
            baseString.add(order.sugars + ":0");
        }
        return Arrays.toString(baseString.toArray()).replace(",","").replace(" ","").replace("[","").replace("]","");
    }
}
