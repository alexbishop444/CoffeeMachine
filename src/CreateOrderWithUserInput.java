import java.util.Scanner;

public class CreateOrderWithUserInput {
    Scanner scanner = new Scanner(System.in);

    public void runUserInput(CoffeeMachineInterface coffeeMachineInterface) {

        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea or 3 for Chocolate");
        String drinkInput = scanner.nextLine();

        System.out.println("How many sugars?");
        String sugarInput = scanner.nextLine();

        System.out.println("Enter money");
        String moneyInput = scanner.nextLine();

        coffeeMachineInterface.processUserInput(drinkInput, sugarInput, moneyInput);
    }
}
