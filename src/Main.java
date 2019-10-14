public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        OrderServiceInterface orderService = new OrderService();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        CreateOrderWithUserInput start = new CreateOrderWithUserInput();
        start.runUserInput(coffeeMachine);
    }
}