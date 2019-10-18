import Models.Drink;


public interface CoffeeMachineInterface {
    Drink[] processUserInput(String drinkInput, String sugarInput, String moneyInput, String extraHotInput, Drink[] drinks);
    Drink[] returnDrinks();
}
