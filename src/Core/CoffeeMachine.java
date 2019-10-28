package Core;

import Converters.OrderConverterInterface;
import Models.*;
import Reports.ReportInterface;
import Service.DrinkServiceInterface;
import Service.OrderServiceInterface;

import java.util.HashMap;

public class CoffeeMachine implements CoffeeMachineInterface{
    private DrinkMakerInterface drinkMaker;
    private OrderConverterInterface orderConverter;
    private OrderServiceInterface orderService;
    private ReportInterface reportInterface;
    private DrinkServiceInterface drinkServiceInterface;

    private int currentWaterMl;
    private int currentMilkMl;

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter, OrderServiceInterface orderService, ReportInterface reportInterface, DrinkServiceInterface drinkServiceInterface) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.reportInterface = reportInterface;
        this.drinkServiceInterface = drinkServiceInterface;
        currentWaterMl = 100;
        currentMilkMl = 100;
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

    private boolean isEmpty(DrinkType drinkType) {
        Drink drink = drinkServiceInterface.getDrink(drinkType);
        if(drink.milkMlRequired > currentMilkMl || drink.waterMlRequired > currentWaterMl) {
            return true;
        }
        return false;
    }

    public void notifyMissingDrink(DrinkType drinkType) {
        Drink drink = drinkServiceInterface.getDrink(drinkType);
        System.out.println("You are lacking Milk and/or water");
        System.out.println("Milk amount = " + currentMilkMl);
        System.out.println("Water amount = " + currentWaterMl);
        System.out.println(drink.drinktype.toString() + " requires " + drink.waterMlRequired + " water and " + drink.milkMlRequired + " milk");
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
        currentWaterMl = currentWaterMl - order.drink.waterMlRequired;
        currentMilkMl = currentMilkMl - order.drink.milkMlRequired;
        String drinkMakerProtocolMessage = orderConverter.convertOrder(order);
        System.out.println(drinkMakerProtocolMessage);
        System.out.println("Machine has water  " + currentWaterMl + " and milk " + currentMilkMl);
        String output = drinkMaker.makeDrink(drinkMakerProtocolMessage);
        System.out.println(output);

        reportInterface.drinkSold(order.drink.drinktype, order.drink.price);

        return true;
    }


}