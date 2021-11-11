package MacDonalds.New;

import java.time.Month;
import java.util.ArrayList;

/**
 Represents a Monthly Revenue Report
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class MonthlyRevenueReport extends RevenueReport {
    /**
     * Month of the Revenue Report
     * */
    private final Month month;

    /**
     * Year of the Revenue Report
     * */
    private final int year;
    MonthlyRevenueReport(ArrayList<Order> allOrders, Month month, int year){
        this.month = month;
        this.year = year;
        findOrders(allOrders);
        calculateRevenue();
        populateDictionary();
    }

    /**
     * Adds all Orders in the specified month and year to the Revenue Report's Orders
     * @param allOrders All of the Restaurant's orders
     * */
    public void findOrders(ArrayList<Order> allOrders){
        for(Order o: allOrders){
            if(o.getDateTime().getMonth().equals(month) && o.getDateTime().getYear() == year){
                this.orders.add(o);
            }
        }
    }
}
