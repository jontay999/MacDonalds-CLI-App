package MacDonalds.New;

import java.time.LocalDate;
import java.time.Month;

public interface ManageRevenueReport {
    public void generateRevenueReport(LocalDate date);
    public void generateRevenueReport(Month month, int year);
    public void generateRevenueReport(int year);
}
