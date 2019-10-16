import Models.Drink;

import java.util.ArrayList;

public interface DrinkListInterface {
    Drink[] createDrinks();
    Drink[] sugarDrinks(ArrayList<String> cantAddSugarDrinks);
    Drink[] extraHotDrinks(ArrayList<String> cantAddHotDrinks);
    Drink[] getDrinks();
}
