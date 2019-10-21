import Models.Drink;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateOrderWithUserInput {
    private Scanner scanner = new Scanner(System.in);
    private ReportInterface reportInterface = new Report();
    private Boolean machineRunning = true;
    private ArrayList<Drink> drinkClone;

    public Drink[] runUserInput(CoffeeMachineInterface coffeeMachineInterface, Drink[] drinks) {
        String extraHotInput = "n";
        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea, 3 for Chocolate or 4 for Orange juice");
        String drinkInput = scanner.nextLine();
        String sugarInput = "0";
        Drink drink = drinks[(Integer.parseInt(drinkInput) - 1)];
        if(drink.drinkOptions.isExtraHot()) {
            System.out.println("Extra hot? y or n?");
            extraHotInput = scanner.nextLine();
        }
        if(drink.drinkOptions.isSugars()) {
            System.out.println("Enter sugars");
            sugarInput = scanner.nextLine();
        }
        System.out.println("Enter money");
        String moneyInput = scanner.nextLine();


        return coffeeMachineInterface.processUserInput(drinkInput, sugarInput, moneyInput, extraHotInput, drinks);
    }

    public void runMachine(CoffeeMachineInterface coffeeMachineInterface) {
        Drink[] drinks = coffeeMachineInterface.returnDrinks(); //Keeps going back to this

        do {
            drinks = runUserInput(coffeeMachineInterface, drinks);
            System.out.println("Continue orders? y or n? n prints out report and exits.");
            String userInput = scanner.nextLine();
            if(userInput.equals("n")) {
                machineRunning = false;
            }
        } while(machineRunning);

        System.out.println(reportInterface.printReport(drinks));
    }
}
