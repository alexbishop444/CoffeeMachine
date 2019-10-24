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
        return drinkServiceInterface.getDrinkOptions(drinkType);
    }

    public void printReport()
    {
        reportInterface.printReport();
        System.out.println(reportInterface.printReport());
    }

    public boolean isEmpty(DrinkType drinkType) {
        Drink drink = drinkServiceInterface.getDrink(drinkType);
        if(drink.milkRequirement > milkAmount || drink.waterRequirement > waterAmount) {
            return true;
        }
        return false;
    }

    public void notifyMissingDrink(DrinkType drinkType) {
        Drink drink = drinkServiceInterface.getDrink(drinkType);
        System.out.println("You are lacking Milk and/or water");
        System.out.println("Milk amount = " + milkAmount);
        System.out.println("Water amount = " + waterAmount);
        System.out.println(drink.drinktype.toString() + " requires " + drink.waterRequirement + " water and " + drink.milkRequirement + " milk");
    }

    public boolean processUserInput(String drinkInput, String moneyInput, HashMap<DrinkOptionType,String> userSelection) {
        Drink[] drinks = drinkServiceInterface.getDrinks();
        Order order = orderService.createOrder(drinkInput, moneyInput,userSelection, drinks);

        if(order.drink.price.compareTo(order.money) == 1) {
            System.out.println("You dont have enough money. You are $" + order.drink.price.subtract(order.money) + " short.");
            return false;
        }

         if (isEmpty(order.drink.drinktype)) {
             notifyMissingDrink(order.drink.drinktype);
             return false;
        }
        waterAmount = waterAmount - order.drink.waterRequirement;
        milkAmount = milkAmount - order.drink.milkRequirement;
        String drinkMakerProtocolMessage = orderConverter.convertOrder(order);
        System.out.println(drinkMakerProtocolMessage);
        System.out.println("Machine has water  " + waterAmount + " and milk " + milkAmount);
        String output = drinkMaker.makeDrink(drinkMakerProtocolMessage);
        System.out.println(output);

        reportInterface.drinkSold(order.drink.drinktype, order.drink.price);

        return true;
    }


}