package MacDonalds.New;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order implements OrderManager {
    Customer customer;
    Staff staff;
    LocalDateTime dateTime;
    int tableId;
    ArrayList<Alacarte> alacarteList = new ArrayList<Alacarte>();
    ArrayList<Set> setList = new ArrayList<Set>();
    float totalPrice=0;

    Order(Customer customer, Staff staff, LocalDateTime dateTime, int tableId){
        this.customer=customer;
        this.staff=staff;
        this.dateTime=dateTime;
        this.tableId=tableId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTableId() {
        return this.tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public void addItem(Set item) {
        this.setList.add(item);
        this.totalPrice+=item.getPrice();
    }

    public void addItem(Alacarte item) {
        this.alacarteList.add(item);
        this.totalPrice+=item.getPrice();
    }

    public void removeItem(int index, boolean isSet) {
        if(isSet){
            Set toRemoveItem = setList.get(index);
            this.totalPrice-=toRemoveItem.getPrice();
            setList.remove(index);
        }
        else{
            Alacarte toRemoveItem = alacarteList.get(index);
            this.totalPrice-=toRemoveItem.getPrice();
            alacarteList.remove(index);}
    }

    public void viewOrder() {
        System.out.println("\nAlacarte Items");
        System.out.println("------------------------");
        for(Alacarte item:alacarteList){
            System.out.printf("%s: S$%.2f\n",item.getName(),item.getPrice());
        }
        System.out.println("\nSet Items");
        System.out.println("------------------------");
        for(Set item:setList){
            System.out.printf("%s: S$%.2f\n",item.getName(),item.getPrice());
        }
    }

    public void printOrderInvoice() {
        System.out.println("This order is for table: "+this.tableId);
        System.out.println("Order details are as follows:");
        this.viewOrder();
        System.out.println("Total price: "+this.totalPrice);
    }
    
}
