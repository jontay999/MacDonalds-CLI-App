package MacDonalds.New;



public class Membership {
    String type;
    double discount;

    Membership(String type, double discount){
        this.type = type;
        this.discount = discount;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
