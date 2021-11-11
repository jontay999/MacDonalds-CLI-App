package MacDonalds.New;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order implements OrderManager {
    private Customer customer;
    private Staff staff;
    private LocalDateTime dateTime;
    private int tableId;
    private ArrayList<Alacarte> alacarteList = new ArrayList<Alacarte>();
    private ArrayList<Set> setList = new ArrayList<Set>();
    private float totalPrice=0;

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
        System.out.printf("\nTotal price: S$%.2f",this.totalPrice);
        float discountApplied = (float)(this.totalPrice*this.customer.getMembership().getDiscount());
        System.out.printf("\nMembership discount: (S$%.2f)",discountApplied);
        System.out.printf("\nGST Applied(inclusive): (S$%.2f)",(0.07*(this.totalPrice-discountApplied)));
        System.out.printf("\nFinal Price to Pay: S$%.2f\n",(float)(this.totalPrice-discountApplied));
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ArrayList<Alacarte> getAlacarteList() {
        return this.alacarteList;
    }

    public void setAlacarteList(ArrayList<Alacarte> alacarteList) {
        this.alacarteList = alacarteList;
    }

    public ArrayList<Set> getSetList() {
        return this.setList;
    }

    public void setSetList(ArrayList<Set> setList) {
        this.setList = setList;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    
}
