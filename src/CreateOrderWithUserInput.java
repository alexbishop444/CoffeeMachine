import java.util.Scanner;

public class CreateOrderWithUserInput {
    Scanner scanner = new Scanner(System.in);

    public void runUserInput(CoffeeMachineInterface coffeeMachineInterface) {
        String extraHotInput = "n";

        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea, 3 for Chocolate or 4 for Orange juice");
        String drinkInput = scanner.nextLine();
        String sugarInput = "0";

        if(drinkInput.equals("1") || drinkInput.equals("2") || drinkInput.equals("3")) {
            System.out.println("Do you want it extra hot?");
            extraHotInput = scanner.nextLine();
            System.out.println("How many sugars?");
            sugarInput = scanner.nextLine();
        }

        System.out.println("Enter money");
        String moneyInput = scanner.nextLine();


        coffeeMachineInterface.processUserInput(drinkInput, sugarInput, moneyInput, extraHotInput);
    }
}
