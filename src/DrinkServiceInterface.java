import Models.Drink;
import Models.DrinkOption;
import Models.DrinkType;


public interface DrinkServiceInterface {
    Drink[] getDrinks();
    DrinkOption[] getDrinkOptions(DrinkType drinkType);
    Drink getDrink(DrinkType drinkType);
}
