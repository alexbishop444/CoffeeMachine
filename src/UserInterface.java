import Models.Drink;
import Models.DrinkOption;
import Models.DrinkOptionType;
import Models.DrinkType;

import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private CoffeeMachineInterface coffeeMachineInterface;

    public UserInterface(CoffeeMachineInterface coffeeMachineInterface, ReportInterface reportInterface) {
        this.coffeeMachineInterface = coffeeMachineInterface;
    }

    private Scanner scanner = new Scanner(System.in);
    private Boolean machineRunning = true;

    private void runUserInput() {
//        coffeeMachineInterface.PrintAvailableDrinks();
        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea, 3 for Chocolate or 4 for Orange juice");
        String drinkInput = scanner.nextLine();
        HashMap<DrinkOptionType, String> userSelection = new HashMap<DrinkOptionType, String>();

        DrinkType selectedDrinkType = DrinkType.valueOf(Integer.parseInt(drinkInput) - 1);
        DrinkOption[] drinkOptions = coffeeMachineInterface.GetDrinkOptions(selectedDrinkType);
        for (int i = 0; i < drinkOptions.length; i++) {
            System.out.println(drinkOptions[i].getQuestion());
            String userInput = scanner.nextLine();
            DrinkOptionType drinkOptionType = drinkOptions[i].getDrinkOptionType();
            userSelection.put(drinkOptionType,userInput);
        }

        System.out.println("Enter money");
        String moneyInput = scanner.nextLine();

        coffeeMachineInterface.processUserInput(drinkInput,moneyInput,userSelection);
    }

    public void runMachine() {
        do {
            runUserInput();
            System.out.println("Continue orders? y or n? n prints out report and exits.");
            String userInput = scanner.nextLine();
            if(userInput.equals("n")) {
                machineRunning = false;
            }
        } while(machineRunning);

        coffeeMachineInterface.printReport();
    }
}
