import Models.Drink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Report implements ReportInterface {
    public String printReport(ArrayList<Drink> soldDrinks) {
        String result = "";
        BigDecimal total = new BigDecimal("0");
        for (Drink drink:soldDrinks) {
            total = total.add(drink.price);
        }
        for (Drink drink:soldDrinks) {
            if (!result.contains(drink.drinktype.toString())) {
                result += drink.drinktype + "'S Sold: " + drink.amountSold + " ";
            }
        }
        String end = result + "Total profit for the day: $" + total;
        return end;
    }
}
