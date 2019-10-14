import java.util.ArrayList;
import java.util.Arrays;

public class DrinkMaker implements DrinkMakerInterface {

    public String makeDrink(String order) {
        String[] test = order.split(":",5);
//        System.out.println(Arrays.toString(test));
        String drinkFromOrder = test[0];
        String sugars = test[1];
        String money = test[3];
        System.out.println(money);
        String drink = "";
        switch (drinkFromOrder) {
            case "T": drink = "tea";
            break;
            case "H": drink = "hot chocolate";
            break;
            case "C": drink = "coffee";
            break;
        }
        if(money.equals("N")) {
            return "You don't have enough money";
        }
        if(sugars.equals("")) {
            return "Drink maker makes 1 " + drink + " with no sugar - and therefore no stick";
        }
        return "Drink maker makes 1 " + drink +  " with " + sugars +  " sugars and a stick";
    }
}
