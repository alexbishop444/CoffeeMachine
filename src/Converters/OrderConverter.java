package Converters;

import Models.DrinkOptionType;
import Models.Order;

public class OrderConverter implements OrderConverterInterface {
    public String convertOrder(Order order) {
        char drinkTypeValue = 'N';
        String extraHotValue = "";
        switch (order.drink.drinktype) {
            case TEA:
                drinkTypeValue = 'T';
                break;
            case CHOCOLATE:
                drinkTypeValue = 'H';
                break;
            case COFFEE:
                drinkTypeValue = 'C';
                break;
            case ORANGE:
                drinkTypeValue = 'O';
                break;
        }

        String stick = "";
        String sugars = "";

        if(order.userSelection.containsKey(DrinkOptionType.EXTRAHOT)) {
            String userInputForExtraHot = order.userSelection.get(DrinkOptionType.EXTRAHOT);
            if(userInputForExtraHot.equals("y")) {
                extraHotValue = "h";
            }
        }

        if(order.userSelection.containsKey(DrinkOptionType.NUMBEROFSUGARS)) {
            String sugarString = order.userSelection.get(DrinkOptionType.NUMBEROFSUGARS);
            int sugarsConverted = Integer.parseInt(sugarString);
            if (sugarsConverted > 0) {
                stick = "0";
                sugars = sugarString;
            }

        }

        return String.format("%c%s:%s:%s", drinkTypeValue, extraHotValue, sugars, stick);
    }
}



//        if(extraHotInput.equals("y")) {
//            extraHot = true;
//        }

//    int sugarsConverted = Integer.parseInt(DrinkOptionType.NUMBEROFSUGARS);