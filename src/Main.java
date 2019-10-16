public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        DrinkListInterface drinks = new DrinkList();
        OrderServiceInterface orderService = new OrderService(drinks);
        ReportInterface report = new Report();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report);
        CreateOrderWithUserInput start = new CreateOrderWithUserInput();
        start.runUserInput(coffeeMachine,drinks);
    }
}