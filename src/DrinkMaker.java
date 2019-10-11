import java.util.Arrays;

public class DrinkMaker implements DrinkMakerInterface {

    public String makeDrink(String order) {
        String[] test = order.split(":",5);
//        System.out.println(Arrays.toString(test));
        String drinkFromOrder = test[0];
        String sugars = test[1];
        String drink = "";
        switch (drinkFromOrder) {
            case "T": drink = "tea";
            break;
            case "H": drink = "chocolate";
            break;
            case "C": drink = "coffee";
            break;
        }
        if(sugars.equals(":")) {
            return "Drink maker makes 1 " + drink + " with no sugar - and therefore no stick";
        }
        return "Drink maker makes 1 " + drink +  " with " + sugars +  " sugars and a stick";
    }
}
