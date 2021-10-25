package MacDonalds;

public class Membership {
    private String type;
    private int discount;

    public Membership(String m, int d) {
        type = m;
        discount = d;
    }

    public String getType() { return type; }
    public int getDiscount() { return discount; }

    public void setType(String type) { this.type = type; }
    public void setDiscount(int discount) { this.discount = discount; }

}
