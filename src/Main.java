public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        OrderServiceInterface orderService = new OrderService();
        DrinkListInterface drinkList = new DrinkList();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,drinkList);
        CreateOrderWithUserInput start = new CreateOrderWithUserInput();
        start.runUserInput(coffeeMachine);
    }
}