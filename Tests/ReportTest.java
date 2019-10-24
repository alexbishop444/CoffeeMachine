import Models.Drink;
import org.junit.Assert;
import org.junit.Test;

public class ReportTest {

    Drink[] drinks = new DrinkService().getDrinks();

    @Test
    public void printReportForTwoDrinksSold() {
        Report report = new Report();
        String actual = report.printReport();
        String expected = "COFFEE'S Sold: 3 TEA'S Sold: 0 CHOCOLATE'S Sold: 1 ORANGE'S Sold: 2 Total profit for the day: $3.5";
        Assert.assertEquals(expected,actual);
    }
}
