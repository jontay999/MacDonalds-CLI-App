package MacDonalds.New;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 Represents a Daily Revenue Report
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class DailyRevenueReport extends RevenueReport{
    /**
     * Date of the revenue report
     * */
    private final LocalDate date;

    /**
     * Creates a Daily Revenue Report with the appropriate date
     * @param allOrders All of the Restaurant's orders
     * @param date The Date for the Revenue Report
     * */
    DailyRevenueReport(ArrayList<Order> allOrders, LocalDate date){
        this.date = date;
        findOrders(allOrders);
        calculateRevenue();
        populateDictionary();
    }

    /**
     * Adds all Orders in the specified date to the Revenue Report's Orders
     * @param allOrders All of the Restaurant's orders
     * */
    public void findOrders(ArrayList<Order> allOrders){
        for(Order o: allOrders){
            if(o.getDateTime().toLocalDate().equals(date)){
                this.orders.add(o);
            }
        }
    }

}
