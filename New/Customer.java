package MacDonalds.New;

/**
 Represents a Customer
 Inherits from Person Class
 @author Dhruval Kothari
 @version 1.0
 @since 2021-11-09
  * */
public class Customer extends Person {
    /**
     * Current Order of the Customer
     * */
    private Order order;

    /**
     * The Contact number of the Customer
     * */
    private int contact;

    /**
     * The Membership that the Customer has
     * is null if there is no membership
     * */
    private Membership membership;


    /**
     * Creates the Customer
     * @param name the name of the Customer
     * @param contact the contact number of the customer
     * @param membership the Membership of the customer
     * */
    Customer(String name, int contact, Membership membership){
        this.name=name;
        this.contact=contact;
        this.membership = membership;
    }

    /**
     * Returns the Customer's current Order
     * */
    public Order getOrder() {
        return this.order;
    }

    /**
     * Sets the Customer's current Order
     * @param order Customer's current order
     * */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Returns the Contact Number of Customer
     * */
    public int getContact() {
        return this.contact;
    }

    /**
     * Returns the Membership of the Customer
     * Returns null if no Membership
     * */
    public Membership getMembership() {
        return this.membership;
    }



}
