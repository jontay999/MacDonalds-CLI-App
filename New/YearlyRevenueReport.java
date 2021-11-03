package MacDonalds.New;


import java.util.ArrayList;

public class YearlyRevenueReport extends RevenueReport{
    int year;
    YearlyRevenueReport(ArrayList<Order> allOrders, int year){
        this.year = year;
        findOrders(allOrders, year);
        calculateRevenue();
    }

    public void findOrders(ArrayList<Order> allOrders, int year){
        for(Order o: allOrders){
            if( o.getDateTime().getYear() == year){
                this.orders.add(o);
            }
        }
    }
}
