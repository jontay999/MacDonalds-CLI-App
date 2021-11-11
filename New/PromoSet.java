package MacDonalds.New;

/**
 Represents a PromoSet Item
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class PromoSet extends Set implements Promotion {
    /**
     * The Final Price of the PromoSet
     * */
    private float finalPrice;

    /**
     * Creates a Promotional Set
     * @param name Name of Promotional Set
     * @param description Description of Promotional Set
     * @param finalPrice Final Price of the Promotional Set
     * */
    PromoSet(String name, String description, float finalPrice) {
        super(name, description);
        this.finalPrice=finalPrice;
    }

    /**
     * Return the discount of the Promotional Set
     * */
    public float getDiscount() {
        float initialPrice=this.getPrice();
        return (initialPrice-this.finalPrice)/initialPrice;
    }

}
