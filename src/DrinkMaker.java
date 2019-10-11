public class DrinkMaker implements DrinkMakerInterface {

    public String makeDrink(String order) {
        char[] orderAsCharArray = order.toCharArray();
        char drinkFromOrder = orderAsCharArray[0];
        char sugars = orderAsCharArray[2];
        String drink = "";
        switch (drinkFromOrder) {
            case 'T': drink = "tea";
            break;
            case 'H': drink = "chocolate";
            break;
            case 'C': drink = "coffee";
            break;
        }
        if(sugars == ':') {
            return "Drink maker makes 1 " + drink + " with no sugar - and therefore no stick";
        }
        return "Drink maker makes 1 " + drink +  " with " + sugars +  " sugars and a stick";
    }
}
