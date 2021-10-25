package MacDonalds;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private Membership customerMembership;
    private ArrayList<Order> customerOrders = new ArrayList<Order>();

    public Customer(String n, Membership m){
        customerName = n;
        customerMembership = m;
    }

    public String getCustomerName() { return customerName; }
    public Membership getCustomerMembership() { return customerMembership; }
    public ArrayList<Order> getCustomerOrders() { return customerOrders; }


    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setCustomerMembership(Membership customerMembership) { this.customerMembership = customerMembership; }

    public void setCustomerOrders(ArrayList<Order> customerOrders) { this.customerOrders = customerOrders; }
    public void addCustomerOrder(Order newOrder) { customerOrders.add(newOrder); }
}
