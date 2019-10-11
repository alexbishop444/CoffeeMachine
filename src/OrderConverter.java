public class OrderConverter implements OrderConverterInterface {
    public String convertOrder(Order order) {
        char drinkTypeValue = 'N';
        switch (order.drinkType) {
            case TEA: drinkTypeValue = 'T';
            break;
            case CHOCOLATE: drinkTypeValue = 'H';
            break;
            case COFFEE: drinkTypeValue = 'C';
            break;
        }

        String stick = "";
        String sugars = "";
        if (order.sugars > 0) {
            stick = "0";
            sugars = String.valueOf(order.sugars);
        }

        return String.format("%c:%s:%s", drinkTypeValue, sugars, stick);
    }
}
