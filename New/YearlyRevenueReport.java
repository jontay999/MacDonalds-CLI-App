package MacDonalds.New;


import java.util.ArrayList;


/**
 Represents a Yearly Revenue Report
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class YearlyRevenueReport extends RevenueReport{
    /**
     * Year of the revenue report
     * */
    private final int year;

    /**
     * Creates a Yearly Revenue Report with the appropriate period
     * @param allOrders All of the Restaurant's orders
     * @param year The Year for the Revenue Report
     * */
    YearlyRevenueReport(ArrayList<Order> allOrders, int year){
        this.year = year;
        findOrders(allOrders);
        calculateRevenue();
        populateDictionary();
    }

    /**
     * Adds all Orders in the specified year to the Revenue Report's Orders
     * @param allOrders All of the Restaurant's orders
     * */
    public void findOrders(ArrayList<Order> allOrders){
        for(Order o: allOrders){
            if( o.getDateTime().getYear() == this.year){
                this.orders.add(o);
            }
        }
    }
}
