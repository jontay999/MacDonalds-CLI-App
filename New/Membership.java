package MacDonalds.New;


/**
 Represents a Membership of the Restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */
public class Membership {
    /**
     * The type (name) of the membership
     * */
    String type;

    /**
     * The discount that the Membership is entitled to
     * */
    double discount;

    /**
     * Creates the Membership
     * @param type The name of the Membership
     * @param discount The discount of the Membership
     * */
    Membership(String type, double discount){
        this.type = type;
        this.discount = discount;
    }

    /**
     * Get the Type of the Membership
     * */
    public String getType() {
        return this.type;
    }

    /**
     * Get the discount that the Membership is entitled to
     * */
    public double getDiscount() {
        return this.discount;
    }

}
