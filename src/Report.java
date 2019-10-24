import Models.*;

import java.math.BigDecimal;

public class Report implements ReportInterface {

    private ReportData reportData = new ReportData();
    private DrinkReportData[] drinkReportData = reportData.createDrinkReportData();

    public String printReport() {
        String result = "";
        double total = 0;
        for (DrinkReportData drink:drinkReportData) {
            total += drink.numberOfDrinksSold * drink.totalAmount.doubleValue();
        }
        for (DrinkReportData drink:drinkReportData) {
                if (drink.drinkType != DrinkType.NONE) {
                    result += drink.drinkType + "'S Sold: " + drink.numberOfDrinksSold + " ";
                }

        }
        String end = result + "Total profit for the day: $" + total;
        return end;
    }

    public void drinkSold(DrinkType drinkType, BigDecimal price) {
            for (DrinkReportData item: drinkReportData){
                if(item.drinkType == drinkType) {
                    item.numberOfDrinksSold += 1;
                    item.setTotalAmount(price.plus());
                }
        }
    }
}
