package MacDonalds.New;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 Represents a Restaurant's Revenue Report
 Revenue Reports can either be Daily, Monthly, Yearly
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public abstract class RevenueReport {
    /**
     * The total number of items (sets and ala cartes) sold
     * */
    int salesVolume;

    /**
     * The total revenue earned in the period
     * */
    double revenue;

    /**
     * All the orders that were made during this period
     * */
    ArrayList<Order> orders = new ArrayList<>();

    /**
     * A HashMap mapping a AlaCarte Items to the quantity sold during this period
     * */
    Map<MenuItem, Integer> alacarteDict = new HashMap<>();

    /**
     * A HashMap mapping a Set Item to the quantity sold during this period
     * */
    Map<MenuItem, Integer> setDict = new HashMap<>();


    /**
     * Calculates the Total Sales Revenue and Volume
     * Loops through the HashMaps of Set Items and Ala Carte items to calculate this
     * */
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

    /**
     * Populate the Hashmaps of Set Items and AlaCarte Items from all the orders in the period
     * */
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

    /**
     * Prints the menu item as a line in the revenue report
     * */
    void printMenuItem(MenuItem item, int numberSold){
        System.out.println(item.getName() + " | " + numberSold + " | " + item.getPrice()*numberSold);
    }

    /**
     * Prints the whole revenue report for the period
     * */
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

    /**
     * Gets the Sales Volume of the Report for the Current Period
     * */
    public int getSalesVolume(){
        return this.salesVolume;
    }

    /**
     * Gets the Sales Revenue of the Report for the Current Period
     * */
    public double getRevenue(){
        return this.revenue;
    }

    /**
     * Sets the Sales Volume of the Report for the Current Period
     * @param salesVolume Sales Volume for the period
     * */
    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    /**
     * Sets the Sales Revenue of the Revenue Report
     * @param revenue Sales Revenue for the period
     * */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
