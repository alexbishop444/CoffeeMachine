import Models.*;

import java.math.BigDecimal;

public class Report implements ReportInterface {

    private ReportData reportData = new ReportData();

    public String printReport(ReportData reportData) {
        String result = "";
        double total = 0;
        for (Drink drink:reportData.drinkReportDatas) {
            total += drink.amountSold * drink.price.doubleValue();
        }
        for (Drink drink:drinks) {
                result += drink.drinktype + "'S Sold: " + drink.amountSold + " ";

        }
        String end = result + "Total profit for the day: $" + total;
        return end;
    }

    public void drinkSold(DrinkType drinkType, BigDecimal price) {
        DrinkReportData[] drinkReportData = reportData.createDrinkReportData();
        {
            for (DrinkReportData item: drinkReportData){
                if(item.drinkType == drinkType) {
                    item.numberOfDrinksSold += 1;
                    item.totalAmount.add(price);
                }
        }
            // get drinkreportdata by drinkType, add price and increment count by 1
        }
    }
}
