public class OrderService implements OrderServiceInterface {
    public Order createOrder(String drinkInput, String sugarInput, String moneyInput) {

        DrinkType drinkType = DrinkType.NONE;
        switch (drinkInput) {
            case "1":
                drinkType = DrinkType.COFFEE;
                break;
            case "2":
                drinkType = DrinkType.TEA;
                break;
            case "3":
                drinkType = DrinkType.CHOCOLATE;
                break;
        }

        int sugars = Integer.parseInt(sugarInput);

        double money = Double.parseDouble(moneyInput);

        return new Order(sugars, drinkType, money);
    }
}
