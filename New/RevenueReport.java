package MacDonalds.New;

import java.util.ArrayList;

public abstract class RevenueReport {
    double salesVolume;
    double revenue;
    ArrayList<Order> orders;

    void calculateRevenue(){
        double totalSales = 0;
        double totalVolume = 0;
        for(Order o: orders){
            for(Alacarte a: o.alacarteList){
                totalSales += a.getPrice();
                totalVolume++;
            }
            for(Set s: o.setList){
                totalSales += s.getPrice();
                totalVolume++;
            }
        }
        setSalesVolume(totalVolume);
        setRevenue(totalSales);
    };

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
