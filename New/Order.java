package MacDonalds.New;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 Represents an Order made by a Customer at a Restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Order implements OrderManager, ItemManager {
    /**
     * Customer that made the Order
     * */
    private Customer customer;
    /**
     * Staff that took the Order
     * */
    private Staff staff;
    /**
     * The DateTime that the Order was made
     * */
    private LocalDateTime dateTime;

    /**
     * Table at which Order was made
     * */
    private Table table;

    /**
     * All Ala Carte Items in the Order
     * */
    private ArrayList<Alacarte> alacarteList = new ArrayList<>();

    /**
     * All Set Items in the Order
     * */
    private ArrayList<Set> setList = new ArrayList<>();

    /**
     * Total Price of all items in the Order
     * */
    float totalPrice = 0;

    /**
     * Create an Order
     * @param customer Customer making the Order
     * @param staff Staff that took the Order
     * @param table Table that Order was made at
     * */
    Order(Customer customer, Staff staff, Table table){
        this.customer=customer;
        this.staff=staff;
        this.dateTime=LocalDateTime.now();
        this.table=table;
    }

    /**
     * Get the Date Time at which Order was made
     * */
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    /**
     * Add Set Item to the Order Set List
     * @param item Set Item to be added
     * */
    public void addItem(Set item) {
        this.setList.add(item);
        this.totalPrice+=item.getPrice();
    }

    /**
     * Add Ala Carte Item to the Order Ala Carte List
     * @param item Set Item to be added
     * */
    public void addItem(Alacarte item) {
        this.alacarteList.add(item);
        this.totalPrice+=item.getPrice();
    }

    /**
     * Remove Ala Carte Item to the Order Set List
     * @param item Ala Carte Item to be added
     * */
    public void removeItem(Alacarte item){
        this.alacarteList.remove(item);
        this.totalPrice-=item.getPrice();
    }

    /**
     * Remove Set Item to the Order Set List
     * @param item Set Item to be added
     * */
    public void removeItem(Set item){
        this.setList.remove(item);
        this.totalPrice-=item.getPrice();
    }

    /**
     * View Order Details
     * Print items ordered by Ala Carte and Set Categories
     * */
    public void viewOrder() {
        System.out.println("\nAlacarte Items");
        System.out.println("------------------------");
        int i=1;
        if(alacarteList.size()==0)System.out.println("There are no items to show.");
        else{
            for(Alacarte item:alacarteList){
                System.out.printf("%d. %s: S$%.2f\n",i,item.getName(),item.getPrice());
                i++;
            }
        }
        System.out.println("\nSet Items");
        System.out.println("------------------------");
        int j=1;
        if(setList.size()==0)System.out.println("There are no items to show.");
        else{
            for(Set item:setList){
                System.out.printf("%d. %s: S$%.2f\n",j,item.getName(),item.getPrice());
                j++;
            }
        }
    }

    /**
     * Print Details of Order Invoice with Final Price
     * */
    public void printOrderInvoice() {
        System.out.printf("\n------------------Table %d------------------\n",this.table.getTableNumber());
        System.out.println("\nStaff assigned: "+this.staff.getName());
        System.out.println("Order placed at: "+this.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS")));
        this.viewOrder();
        System.out.printf("\nTotal price: S$%.2f",this.totalPrice);
        float discountApplied;
        if(this.customer.getMembership()!=null){
            discountApplied = (float)(this.totalPrice*this.customer.getMembership().getDiscount());
        } else{
            discountApplied=0;
        }
        System.out.printf("\nMembership discount: (S$%.2f)",discountApplied);
        System.out.printf("\nGST Applied(inclusive): (S$%.2f)",(0.07*(this.totalPrice-discountApplied)));
        System.out.printf("\nFinal Price to Pay: S$%.2f\n",(this.totalPrice-discountApplied));
    }

    /**
     * Returns the List of Ala Carte Items in the Order
     * */
    public ArrayList<Alacarte> getAlacarteList() {
        return this.alacarteList;
    }

    /**
     * Returns the List of Set Items in the Order
     * */
    public ArrayList<Set> getSetList() {
        return this.setList;
    }
}
