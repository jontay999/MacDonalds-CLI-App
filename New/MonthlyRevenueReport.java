package MacDonalds.New;

import java.time.Month;
import java.util.ArrayList;

public class MonthlyRevenueReport extends RevenueReport {
    Month month;
    int year;
    MonthlyRevenueReport(ArrayList<Order> allOrders, Month month, int year){
        this.month = month;
        this.year = year;
        findOrders(allOrders, month, year);
        calculateRevenue();
    }

    public void findOrders(ArrayList<Order> allOrders, Month month, int year){
        for(Order o: allOrders){
            if(o.getDateTime().getMonth().equals(month) && o.getDateTime().getYear() == year){
                this.orders.add(o);
            }
        }
    }
}
