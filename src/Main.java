public class Main {

    public static void main(String[] args) {
        DrinkMaker drinkMaker = new DrinkMaker();
        OrderConverter orderConverter = new OrderConverter();
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter);
        coffeeMachine.start();
    }
}
