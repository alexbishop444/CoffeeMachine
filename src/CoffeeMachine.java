public class CoffeeMachine implements CoffeeMachineInterface{
    private DrinkMakerInterface drinkMaker;
    private OrderConverterInterface orderConverter;
    private OrderServiceInterface orderService;
    private DrinkListInterface drinkList;

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter, OrderServiceInterface orderService, DrinkListInterface drinkList) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.drinkList = drinkList;
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
