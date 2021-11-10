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

    Order(Customer customer, Staff staff, int tableId){
        this.customer=customer;
        this.staff=staff;
        this.dateTime=LocalDateTime.now();
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
        int i=1;
        for(Alacarte item:alacarteList){
            System.out.printf("%d. %s: S$%.2f\n",i,item.getName(),item.getPrice());
            i++;
        }
        System.out.println("\nSet Items");
        System.out.println("------------------------");
        int j=1;
        for(Set item:setList){
            System.out.printf("%d. %s: S$%.2f\n",j,item.getName(),item.getPrice());
            j++;
        }
    }

    public void printOrderInvoice() {
        System.out.printf("\n------------------Table %d------------------\n\n",this.tableId);
        this.viewOrder();
        System.out.printf("\nTotal price: S$%.2f\nThank you and hope to see you again!\n",this.totalPrice);
    }
    
}
