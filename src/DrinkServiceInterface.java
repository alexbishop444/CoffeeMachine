import Models.Drink;
import Models.DrinkOption;
import Models.DrinkType;

import java.util.ArrayList;

public interface DrinkServiceInterface {
    Drink[] getDrinks();
    DrinkOption[] getDrinkOptions(DrinkType drinkType);
}
