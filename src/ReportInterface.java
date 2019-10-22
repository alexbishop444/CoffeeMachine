import Models.DrinkReportData;
import Models.DrinkType;
import Models.ReportData;

import java.math.BigDecimal;

public interface ReportInterface {
    String printReport(ReportData reportData);
    void drinkSold(DrinkType drinkType, BigDecimal price);
}
