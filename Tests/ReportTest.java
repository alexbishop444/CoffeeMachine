import Models.Drink;
import Models.DrinkType;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ReportTest {

    Drink[] drinks = new DrinkList().getDrinks();

    @Test
    public void printReportForTwoDrinksSold() {
        Report report = new Report();
        String actual = report.printReport(drinks);
        String expected = "COFFEE'S Sold: 5 TEA'S Sold: 3 Total profit for the day: $4.2";
        Assert.assertEquals(expected,actual);
    }
}
