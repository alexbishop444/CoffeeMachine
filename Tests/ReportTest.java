import Models.Drink;
import Models.DrinkType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ReportTest {

    Drink[] drinks = new DrinkService().getDrinks();

    @Test
    public void printReportForTwoDrinksSold() {
        Report report = new Report();
        report.drinkSold(DrinkType.ORANGE,new BigDecimal("0.6"));
        report.drinkSold(DrinkType.COFFEE,new BigDecimal("0.6"));
        report.drinkSold(DrinkType.COFFEE,new BigDecimal("0.6"));
        report.drinkSold(DrinkType.COFFEE,new BigDecimal("0.6"));
        report.drinkSold(DrinkType.CHOCOLATE,new BigDecimal("0.5"));
        String actual = report.printReport();
        String expected = "COFFEE'S Sold: 3 TEA'S Sold: 0 CHOCOLATE'S Sold: 1 ORANGE'S Sold: 1 Total profit for the day: $2.9";
        Assert.assertEquals(expected,actual);
    }
}
