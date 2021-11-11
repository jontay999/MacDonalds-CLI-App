package MacDonalds.New;

import java.time.LocalDate;
import java.time.Month;
/**
 Represents a ManageRevenueReport interface
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */
public interface ManageRevenueReport {
    /**
     * Generate and Print the Daily Revenue Report
     * @param date Date of Revenue Report
     * */
    void generateRevenueReport(LocalDate date);

    /**
     * Generate and Print the Monthly Revenue Report
     * @param month Month of Revenue Report
     * @param year Year of Revenue Report
     * */
    void generateRevenueReport(Month month, int year);

    /**
     * Generate and Print the Yearly Revenue Report
     * @param year Year of Revenue Report
     * */
    void generateRevenueReport(int year);
}
