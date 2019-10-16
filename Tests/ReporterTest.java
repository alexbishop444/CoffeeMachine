import Models.Drink;
import Models.DrinkType;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ReporterTest {
    ArrayList<Drink> soldDrinks = new ArrayList<>();

    @Test
    public void buildReportForTwoDrinksSold() {
        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
        soldDrinks.add(new Drink(DrinkType.TEA,new BigDecimal("0.4")));
        Report report = new Report();
        String actual = report.buildReport(soldDrinks);
        String expected = "Coffee's Sold: 1 Tea'sold: 1 Total profit for the day: $1.0";
    }
}
