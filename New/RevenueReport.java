package MacDonalds.New;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class RevenueReport {
    int salesVolume;
    double revenue;
    ArrayList<Order> orders = new ArrayList<>();
    Map<MenuItem, Integer> alacarteDict = new HashMap<>();
    Map<MenuItem, Integer> setDict = new HashMap<>();


    void calculateRevenue(){
        double totalSales = 0;
        int totalVolume = 0;

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

    void populateDictionary(){
        for(Order o:orders){
            for(MenuItem item: o.alacarteList){
                int count = alacarteDict.containsKey(item) ? alacarteDict.get(item) : 0;
                alacarteDict.put(item,count+1);
            }
            for(MenuItem item: o.setList){
                int count = setDict.containsKey(item) ? setDict.get(item) : 0;
                setDict.put(item,count+1);
            }
        }
    }

    void printMenuItem(MenuItem item, int numberSold){
        System.out.println(item.getName() + " | " + numberSold + " | " + item.getPrice()*numberSold);
    }

    void printRevenueReport(){
        System.out.println("Ala Carte Items");
        System.out.println("================");
        System.out.println("Item Name | Sales Volume | Revenue");
        if(alacarteDict.entrySet().size() == 0) System.out.println("No Ala Carte Items ordered");
        for (Map.Entry<MenuItem, Integer> entry : alacarteDict.entrySet()) {
            printMenuItem(entry.getKey(), entry.getValue());
        }
        System.out.println("----------------");
        System.out.println("Set Items");
        System.out.println("================");
        System.out.println("Item Name | Sales Volume | Revenue");
        if(setDict.entrySet().size() == 0) System.out.println("No Set Items ordered");
        for (Map.Entry<MenuItem, Integer> entry : setDict.entrySet()) {
            printMenuItem(entry.getKey(), entry.getValue());
        }
        System.out.println("----------------");
        System.out.println("Total Sales Volume: " + getSalesVolume());
        System.out.println("Total Revenue: " + getRevenue());
    }

    public int getSalesVolume(){
        return this.salesVolume;
    }

    public double getRevenue(){
        return this.revenue;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
