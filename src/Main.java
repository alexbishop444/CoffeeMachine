public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        DrinkListInterface drinks = new DrinkList();
        OrderServiceInterface orderService = new OrderService(drinks);
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        CreateOrderWithUserInput start = new CreateOrderWithUserInput();
        start.runUserInput(coffeeMachine);
    }
}