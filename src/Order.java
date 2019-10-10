import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);
    int sugars;
    DrinkType drinkType;

    public Order(int sugars, DrinkType drinkType) {
        this.sugars = sugars;
        this.drinkType = drinkType;
    }

    public Order createOrder() {
        System.out.println("What drink do you want? 1 for Coffee, 2 for Tea or 3 for Chocolate");
        String drinkInput = scanner.nextLine();
        switch (drinkInput) {
            case "1":
                drinkType = DrinkType.COFFEE;
                break;
            case "2":
                drinkType = DrinkType.TEA;
                break;
            case "3":
                drinkType = DrinkType.CHOCOLATE;
                break;
        }
        System.out.println("How many sugars?");
        String sugarInput = scanner.nextLine();
        sugars = Integer.parseInt(sugarInput);
        return new Order(sugars,drinkType);
    }
}
