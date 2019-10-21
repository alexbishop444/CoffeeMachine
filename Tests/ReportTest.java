import Models.Drink;
import Models.DrinkType;
import Models.Order;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ReportTest {

    private DrinkList drinklist;

    @Test
    public void printReportForTwoDrinksSold() {
        Drink[] drinks = new Drink[2];
        drinks[0] = new Drink(DrinkType.COFFEE,new BigDecimal("0.6"));
        drinks[0].setAmountSold(new BigDecimal("5"));
        drinks[1] = new Drink(DrinkType.TEA,new BigDecimal("0.4"));
        drinks[1].setAmountSold(new BigDecimal("3"));
        Report report = new Report();
        String actual = report.printReport(drinks);
        String expected = "COFFEE'S Sold: 5 TEA'S Sold: 3 Total profit for the day: $4.2";
        Assert.assertEquals(expected,actual);
    }
}
