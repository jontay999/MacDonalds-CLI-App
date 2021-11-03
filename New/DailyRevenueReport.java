package MacDonalds.New;

import java.time.LocalDate;
import java.util.ArrayList;

public class DailyRevenueReport extends RevenueReport{
    LocalDate date;
    DailyRevenueReport(ArrayList<Order> allOrders, LocalDate date){
        this.date = date;
        findOrders(allOrders, date);
        calculateRevenue();
    }

    public void findOrders(ArrayList<Order> allOrders, LocalDate date){
        for(Order o: allOrders){
            if(o.getDateTime().toLocalDate().equals(date)){
                this.orders.add(o);
            }
        }
    }
}
