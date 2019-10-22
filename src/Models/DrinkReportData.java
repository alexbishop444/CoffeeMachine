package Models;

import java.math.BigDecimal;

public class DrinkReportData {
    public BigDecimal totalAmount;
    public int numberOfDrinksSold;
    public DrinkType drinkType;

    public DrinkReportData(BigDecimal totalAmount, int numberOfDrinksSold, DrinkType drinkType) {
        this.totalAmount = totalAmount;
        this.numberOfDrinksSold = numberOfDrinksSold;
        this.drinkType = drinkType;
    }
}
