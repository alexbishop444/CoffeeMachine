package Models;

import java.math.BigDecimal;

public class DrinkReportData {
    public BigDecimal totalAmount;
    public int numberOfDrinksSold;
    public DrinkType drinkType;

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public DrinkReportData(BigDecimal totalAmount, int numberOfDrinksSold, DrinkType drinkType) {
        this.totalAmount = totalAmount;
        this.numberOfDrinksSold = numberOfDrinksSold;
        this.drinkType = drinkType;
    }

    @Override
    public String toString() {
        return "DrinkReportData{" +
                "totalAmount=" + totalAmount +
                ", numberOfDrinksSold=" + numberOfDrinksSold +
                ", drinkType=" + drinkType +
                '}';
    }
}
