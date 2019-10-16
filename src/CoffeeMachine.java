import Models.Order;

public class CoffeeMachine implements CoffeeMachineInterface{
    private DrinkMakerInterface drinkMaker;
    private OrderConverterInterface orderConverter;
    private OrderServiceInterface orderService;
    private ReportInterface reportInterface;

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter, OrderServiceInterface orderService, ReportInterface reportInterface) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.reportInterface = reportInterface;
    }

    public Boolean processUserInput(String drinkInput, String sugarInput, String moneyInput, String extraHotInput) {
        Order order = orderService.createOrder(drinkInput,sugarInput,moneyInput, extraHotInput);


        if(order.drink.price.compareTo(order.money) == 1) {
            System.out.println("You dont have enough money. You are $" + order.drink.price.subtract(order.money) + " short.");
            return false;
        }
        String drinkMakerProtocolMessage = orderConverter.convertOrder(order);
        System.out.println(drinkMakerProtocolMessage);

        String output = drinkMaker.makeDrink(drinkMakerProtocolMessage);
        System.out.println(output);
        return true;
    }
}
