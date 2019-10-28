import Converters.OrderConverter;
import Converters.OrderConverterInterface;
import Core.CoffeeMachine;
import Core.CoffeeMachineInterface;
import Core.DrinkMaker;
import Core.DrinkMakerInterface;
import Reports.Report;
import Reports.ReportInterface;
import Service.DrinkService;
import Service.DrinkServiceInterface;
import Service.OrderService;
import Service.OrderServiceInterface;

public class Main {

    public static void main(String[] args) {
        DrinkMakerInterface drinkMaker = new DrinkMaker();
        OrderConverterInterface orderConverter = new OrderConverter();
        DrinkServiceInterface drinks = new DrinkService();
        OrderServiceInterface orderService = new OrderService();
        ReportInterface report = new Report();
        CoffeeMachineInterface coffeeMachine = new CoffeeMachine(drinkMaker,orderConverter,orderService,report, drinks);
        UserInterface start = new UserInterface(coffeeMachine);
        start.runMachine();
    }
}