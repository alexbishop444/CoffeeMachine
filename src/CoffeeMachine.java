import Models.Drink;
import Models.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine implements CoffeeMachineInterface{
    private DrinkMakerInterface drinkMaker;
    private OrderConverterInterface orderConverter;
    private OrderServiceInterface orderService;
    private ReportInterface reportInterface;
    private DrinkListInterface drinkListInterface;

    public CoffeeMachine(DrinkMakerInterface drinkMaker, OrderConverterInterface orderConverter, OrderServiceInterface orderService, ReportInterface reportInterface, DrinkListInterface drinkListInterface) {
        this.drinkMaker = drinkMaker;
        this.orderConverter = orderConverter;
        this.orderService = orderService;
        this.reportInterface = reportInterface;
        this.drinkListInterface = drinkListInterface;
    }

    public Drink[] returnDrinks() {
        return drinkListInterface.getDrinks();
    }

    public Drink[] processUserInput(String drinkInput, String sugarInput, String moneyInput, String extraHotInput, Drink[] drinks) {
        Order order = orderService.createOrder(drinkInput,sugarInput,moneyInput, extraHotInput, drinks);

        if(order.drink.price.compareTo(order.money) == 1) {
            System.out.println("You dont have enough money. You are $" + order.drink.price.subtract(order.money) + " short.");
            return drinks;

            //if statement here to check if drink can be made
        }
        for (Drink drink:drinks) {
            if(order.drink.drinktype == drink.drinktype) {
                order.drink.setAmountSold(order.drink.amountSold.add(new BigDecimal("1")));
            }
        }
        //take in drinks array here, change the amount sold to + 1.
        System.out.println(order.drink.amountSold);
        String drinkMakerProtocolMessage = orderConverter.convertOrder(order);
        System.out.println(drinkMakerProtocolMessage);

        String output = drinkMaker.makeDrink(drinkMakerProtocolMessage);
        System.out.println(output);
        return drinks;
    }


}