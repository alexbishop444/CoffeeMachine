import Models.Drink;

import java.util.Scanner;

public class CreateOrderWithUserInput {
    Scanner scanner = new Scanner(System.in);

    public void runUserInput(CoffeeMachineInterface coffeeMachineInterface, DrinkListInterface drinkListInterface) {
        String extraHotInput = "n";
        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea, 3 for Chocolate or 4 for Orange juice");
        String drinkInput = scanner.nextLine();
        String sugarInput = "0";
        Drink drink = drinkListInterface.getDrinks()[(Integer.parseInt(drinkInput) - 1)];
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


        coffeeMachineInterface.processUserInput(drinkInput, sugarInput, moneyInput, extraHotInput);
    }
}
