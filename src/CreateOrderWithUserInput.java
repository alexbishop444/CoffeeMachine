import Models.Drink;
import Models.DrinkOptionType;

import java.util.HashMap;
import java.util.Scanner;

public class CreateOrderWithUserInput {
    private Scanner scanner = new Scanner(System.in);
    private ReportInterface reportInterface = new Report();
    private Boolean machineRunning = true;

    public Drink[] runUserInput(CoffeeMachineInterface coffeeMachineInterface, Drink[] drinks) {
        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea, 3 for Chocolate or 4 for Orange juice");
        String drinkInput = scanner.nextLine();
        HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();
        Drink drink = drinks[(Integer.parseInt(drinkInput) - 1)];
        for (int i = 0; i < drink.drinkOptions.length; i++) {
            System.out.println(drink.drinkOptions[i].getQuestion());
            String userInput = scanner.nextLine();
            DrinkOptionType drinkOptionType = drink.drinkOptions[i].getDrinkOptionType();
            userSelection.put(drinkOptionType,userInput);
        }
        System.out.println("Enter money");
        String moneyInput = scanner.nextLine();


        return coffeeMachineInterface.processUserInput(drinkInput, moneyInput, drinks, userSelection);
    }

    public void runMachine(CoffeeMachineInterface coffeeMachineInterface) {
        Drink[] drinks = coffeeMachineInterface.returnDrinks();

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
