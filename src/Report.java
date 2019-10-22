import Models.Drink;

import java.math.BigDecimal;

public class Report implements ReportInterface {
    public String printReport(Drink[] drinks) {
        String result = "";
        double total = 0;
        for (Drink drink:drinks) {
            total += drink.amountSold * drink.price.doubleValue();
        }
        for (Drink drink:drinks) {
                result += drink.drinktype + "'S Sold: " + drink.amountSold + " ";

        }
        String end = result + "Total profit for the day: $" + total;
        return end;
    }
}
