public class CoffeeMachine {
    DrinkMakerInterface drinkMaker;
    OrderConverterInterface orderConverter;
    Order orderClass = new Order(1,DrinkType.CHOCOLATE);

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
    }

    public void start() {
        Order order = orderClass.createOrder();
        String input = orderConverter.convertOrder(order);
        String output = drinkMaker.makeDrink(input);
        System.out.println(output);
    }
}
