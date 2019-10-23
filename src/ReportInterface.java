import Models.DrinkReportData;
import Models.DrinkType;
import Models.ReportData;

import java.math.BigDecimal;

public interface ReportInterface {
    String printReport();
    void drinkSold(DrinkType drinkType, BigDecimal price);
}
