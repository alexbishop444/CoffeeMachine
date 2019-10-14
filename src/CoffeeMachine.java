public class CoffeeMachine implements CoffeeMachineInterface{
    private DrinkMakerInterface drinkMaker;
    private OrderConverterInterface orderConverter;
    private OrderServiceInterface orderService;

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter, OrderServiceInterface orderService) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
    }

    public Boolean processUserInput(String drinkInput, String sugarInput, String moneyInput) {
        Order order = orderService.createOrder(drinkInput,sugarInput,moneyInput);

        if(order.drink.price.compareTo(order.money) == 1) {
            System.out.println("You dont have enough money");
            return false;
        }
        String drinkMakerProtocolMessage = orderConverter.convertOrder(order);
        System.out.println(drinkMakerProtocolMessage);

        String output = drinkMaker.makeDrink(drinkMakerProtocolMessage);
        System.out.println(output);
        return true;
    }
}
