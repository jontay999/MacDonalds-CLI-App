package MacDonalds;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.*;

public class Order {
    LocalDateTime dateTime;
    int orderId;
    int tableId;
    int staffId;
    Customer customer;
    ArrayList<MenuItem> allMenuItems;
    ArrayList<PromotionalSet> allPromoSets;

    public Order (LocalDateTime create, int order, int table, int staff, Customer c, ArrayList<MenuItem> menuSet, ArrayList<PromotionalSet> promoSet) {
        dateTime = create;
        orderId = order;
        tableId = table;
        staffId = staff;
        customer = c;
        allMenuItems = menuSet;
        allPromoSets = promoSet;
    }

    public LocalDateTime getCreated() { return dateTime; }
    public int getOrderId() { return orderId; }
    public int getTableId() { return tableId; }
    public int getStaffId() { return staffId; }
    public Customer getCustomer() { return customer; }
    public ArrayList<MenuItem> getOrderMenuItems() { return allMenuItems; }
    public ArrayList<PromotionalSet> getOrderPromoSets() { return allPromoSets; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setTableId(int tableId) { this.tableId = tableId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public void addMenuItem(MenuItem item){
        allMenuItems.add(item);
    }
    public void addPromoItem(PromotionalSet item){
        allPromoSets.add(item);
    }

    public int getTotalPrice(){
        int total = 0;
        for (MenuItem item:allMenuItems){
            total += item.originalPrice;
        }
        for (Promotion item:allPromoSets){
            total += item.discountedPrice;
        }
        return total;
    }

    public ArrayList<String> allOrders(){
        ArrayList<String> orders = new ArrayList<String>();
        for (MenuItem item:allMenuItems){
            orders.add(item.getName());
        }
        for (PromotionalSet item:allPromoSets){
            orders.add(item.getName());
        }
        return orders;
    }

    public int totalCount(String orderItem){
        int count = 0;
        for (String item:allOrders()){
            if (Objects.equals(orderItem, item)) count += 1;
        }
        return count;
    }

    public double getTax(double net){
        return net*0.17;
    }

    public void getOrderInvoice(){
        System.out.println("Your Receipt: ");
        for (int i=0;i<10;i++) System.out.print("===");
        double totalCost = 0;

        // menu items
        Set<MenuItem> uniqueMenuOrders = new LinkedHashSet<MenuItem>(allMenuItems);
        for (MenuItem s:uniqueMenuOrders){
            double net = totalCount(s.getName())*s.originalPrice;
            double taxes = getTax(net);
            double total = taxes+net;
            totalCost += total;

            System.out.printf("Item: %s x%d\n", s.getName(), totalCount(s.getName()));
            System.out.printf("Net: $%.2f\n", net);
            System.out.printf("Taxes: $%.2f\n", taxes);
            System.out.printf("Total: $%.2f\n", total);
        }

        System.out.println("Promo Items");
        for (int i=0;i<10;i++) System.out.print("---");
        Set<PromotionalSet> uniquePromoOrders = new LinkedHashSet<PromotionalSet>(allPromoSets);
        for (PromotionalSet s:uniquePromoOrders){
            double net = totalCount(s.getName())*s.discountedPrice;
            double taxes = getTax(net);
            double total = taxes+net;
            totalCost += total;

            System.out.printf("Item: %s x%d\n", s.getName(), totalCount(s.getName()));
            System.out.printf("Net: $%.2f\n", net);
            System.out.printf("Taxes: $%.2f\n", taxes);
            System.out.printf("Total: $%.2f\n", total);
        }
        for (int i=0;i<10;i++) System.out.print("===");
        System.out.printf("Total Cost: $%.2f\n", totalCost);

    }


}

