import java.util.ArrayList;
import java.util.Arrays;

public class DrinkMaker implements DrinkMakerInterface {

    public String makeDrink(String order) {
        String[] orderArray = order.split(":",5);
//        System.out.println(Arrays.toString(orderArray));
        String drinkFromOrder = orderArray[0];
        String sugars = orderArray[1];
        String drink = "";
        switch (drinkFromOrder) {
            case "T": drink = "tea";
            break;
            case "H": drink = "hot chocolate";
            break;
            case "C": drink = "coffee";
            break;
        }
        if(sugars.equals("")) {
            return "Drink maker makes 1 " + drink + " with no sugar - and therefore no stick";
        }
        return "Drink maker makes 1 " + drink +  " with " + sugars +  " sugars and a stick";
    }
}
