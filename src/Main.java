public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        OrderServiceInterface orderService = new OrderService();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService);
        UserInput start = new UserInput();
        start.runUserInput(coffeeMachine);
    }
}