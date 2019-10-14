public class OrderConverter implements OrderConverterInterface {
    public String convertOrder(Order order) {
        char money = 'N';
        char drinkTypeValue = 'N';
        switch (order.drinkType) {
            case TEA:
                drinkTypeValue = 'T';
                break;
            case CHOCOLATE:
                drinkTypeValue = 'H';
                break;
            case COFFEE:
                drinkTypeValue = 'C';
                break;
        }

        String stick = "";
        String sugars = "";
        if (order.sugars > 0) {
            stick = "0";
            sugars = String.valueOf(order.sugars);
        }
        if (order.money < order.drinkType.getValue()) {
            money = 'N';
        } else {
            money = 'Y';
        }

        return String.format("%c:%s:%s:%c", drinkTypeValue, sugars, stick,money);
    }
}
