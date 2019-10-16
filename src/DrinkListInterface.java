import Models.Drink;

public interface DrinkListInterface {
    Drink[] createDrinks();
    Drink[] sugarDrinks();
    Drink[] extraHotDrinks();
    Drink[] getDrinks();
}
