import Models.*;

import java.util.HashMap;

public class CoffeeMachine implements CoffeeMachineInterface{
    private DrinkMakerInterface drinkMaker;
    private OrderConverterInterface orderConverter;
    private OrderServiceInterface orderService;
    private ReportInterface reportInterface;
    private DrinkServiceInterface drinkServiceInterface;

    private int waterAmount;
    private int milkAmount;

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter, OrderServiceInterface orderService, ReportInterface reportInterface, DrinkServiceInterface drinkServiceInterface) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.reportInterface = reportInterface;
        this.drinkServiceInterface = drinkServiceInterface;

        waterAmount = 100;
        milkAmount = 100;
    }

    public DrinkOption[] GetDrinkOptions(DrinkType drinkType)
    {
        drinkServiceInterface.getDrinkOptions(drinkType);
    }

    public void printReport()
    {
        reportInterface.printReport(report);
    }

    public boolean processUserInput(String drinkInput, String moneyInput, HashMap<DrinkOptionType,String> userSelection) {
        Drink[] drinks = drinkServiceInterface.getDrinks();
        Order order = orderService.createOrder(drinkInput, moneyInput,userSelection, drinks);

        if(order.drink.price.compareTo(order.money) == 1) {
            System.out.println("You dont have enough money. You are $" + order.drink.price.subtract(order.money) + " short.");
            return false;
        }

        // if (!isEmpty(drinkType));
        //      email thingy, return false

        String drinkMakerProtocolMessage = orderConverter.convertOrder(order);
        System.out.println(drinkMakerProtocolMessage);

        String output = drinkMaker.makeDrink(drinkMakerProtocolMessage);
        System.out.println(output);

        reportInterface.drinkSold(order.drink.drinktype, order.drink.price);

        return true;
    }


}