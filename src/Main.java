public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        DrinkServiceInterface drinks = new DrinkService();
        OrderServiceInterface orderService = new OrderService();
        ReportInterface report = new Report();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report, drinks);
        UserInterface start = new UserInterface(coffeeMachine, report);
        start.runMachine();
    }
}