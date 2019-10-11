import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);
    int sugars;
    DrinkType drinkType;

    public Order(int sugars, DrinkType drinkType) {
        this.sugars = sugars;
        this.drinkType = drinkType;
    }
}
