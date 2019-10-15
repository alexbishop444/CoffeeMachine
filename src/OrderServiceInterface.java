import Models.Order;

public interface OrderServiceInterface {
    Order createOrder(String drinkInput, String sugarInput, String moneyInput, String extraHotInput);
}
