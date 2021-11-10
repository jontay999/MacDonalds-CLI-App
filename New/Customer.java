package MacDonalds.New;

public class Customer extends Person {
    private Order order;
    private int contact;
    Membership membership;

    Customer(String name, int contact, Membership membership){
        this.name=name;
        this.contact=contact;
        this.membership = membership;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getContact() {
        return this.contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Membership getMembership() {
        return this.membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }


}
