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
        if (order.sugars > 0) {
            stick = "0";
            sugars = String.valueOf(order.sugars);
        }

        if(order.extraHot) {
            extraHotValue = "h";
        }

        return String.format("%c%s:%s:%s", drinkTypeValue, extraHotValue, sugars, stick);
    }
}
