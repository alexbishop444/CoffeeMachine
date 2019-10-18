import Models.Drink;

import java.math.BigDecimal;

public class Report implements ReportInterface {
    public String printReport(Drink[] drinks) {
        String result = "";
        BigDecimal total = new BigDecimal("0");
        for (Drink drink:drinks) {
            total = total.add(drink.amountSold.multiply(drink.price));
        }
        for (Drink drink:drinks) {
            if (!result.contains(drink.drinktype.toString())) {
                result += drink.drinktype + "'S Sold: " + drink.amountSold + " ";
            }
        }
        String end = result + "Total profit for the day: $" + total;
        return end;
    }
}
