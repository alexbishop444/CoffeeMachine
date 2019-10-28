package Core;

public class DrinkMaker implements DrinkMakerInterface {

    //Split the message between multiple methods?

    public String makeDrink(String order) {
        String[] orderArray = order.split(":",5);
        char[] drinkFromOrder = orderArray[0].toCharArray();
        char drinkType = drinkFromOrder[0];
        char extraHot = 'N';
        if(drinkFromOrder.length > 1) {
            extraHot = drinkFromOrder[1];
        }
        String sugarMessage = " with no sugar - and therefore no stick";
        String sugars = orderArray[1];
        String drink = "";
        switch (drinkType) {
            case 'T': drink = "tea";
            break;
            case 'H': drink = "hot chocolate";
            break;
            case 'C': drink = "coffee";
            break;
            case 'O': drink = "orange juice";
            break;
        }
        String willMake = " makes 1 " + drink;
        if(!sugars.equals("")) {
            sugarMessage = " with " + sugars + " sugars and a stick";
        }
        if(extraHot == 'h') {
            willMake = " makes an extra hot " + drink;
        }
        return "Models.Drink maker" + willMake + sugarMessage;
    }
}
