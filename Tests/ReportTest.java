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
//    @Test
//    public void printReportForFiveDrinksSold() {
//        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
//        soldDrinks.add(new Drink(DrinkType.TEA,new BigDecimal("0.4")));
//        soldDrinks.add(new Drink(DrinkType.CHOCOLATE,new BigDecimal("0.5")));
//        soldDrinks.add(new Drink(DrinkType.ORANGE,new BigDecimal("0.6")));
//        soldDrinks.add(new Drink(DrinkType.TEA,new BigDecimal("0.4")));
//        soldDrinks.get(0).setAmountSold(1);
//        soldDrinks.get(1).setAmountSold(2);
//        soldDrinks.get(2).setAmountSold(1);
//        soldDrinks.get(3).setAmountSold(1);
//        soldDrinks.get(4).setAmountSold(2);
//        Report report = new Report();
//        String actual = report.printReport(soldDrinks);
//        String expected = "COFFEE'S Sold: 1 TEA'S Sold: 2 CHOCOLATE'S Sold: 1 ORANGE'S Sold: 1 Total profit for the day: $2.5";
//        Assert.assertEquals(expected,actual);
//    }
//    @Test
//    public void printReportForFiveSameDrinksSold() {
//        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
//        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
//        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
//        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
//        soldDrinks.add(new Drink(DrinkType.COFFEE,new BigDecimal("0.6")));
//        soldDrinks.get(0).setAmountSold(5);
//        soldDrinks.get(1).setAmountSold(5);
//        soldDrinks.get(2).setAmountSold(5);
//        soldDrinks.get(3).setAmountSold(5);
//        soldDrinks.get(4).setAmountSold(5);
//        Report report = new Report();
//        String actual = report.printReport(soldDrinks);
//        String expected = "COFFEE'S Sold: 5 Total profit for the day: $3.0";
//        Assert.assertEquals(expected,actual);
//    }
}
