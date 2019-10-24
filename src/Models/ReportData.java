package Models;

import java.math.BigDecimal;

public class ReportData {
    public DrinkReportData[] drinkReportDatas = new DrinkReportData[DrinkType.values().length];

    public DrinkReportData[] createDrinkReportData() {
        for (int i = 0; i < DrinkType.values().length; i++) {
            drinkReportDatas[i] = new DrinkReportData(new BigDecimal("0"),0,DrinkType.valueOf(i));
        }
        return drinkReportDatas;
    }
}
