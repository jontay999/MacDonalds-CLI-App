package MacDonalds.New;



/**
 Represents a PromoAlaCarte Item
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class PromoAlacarte extends Alacarte implements Promotion{
    /**
     * Final Price of the Ala Carte Item on Promotion
     * */
    private float finalPrice;

    /**
     * Create a Promotional Ala Carte item
     * @param name Name of Item
     * @param description Description of Item
     * @param price Original Price of Ala Carte Item
     * @param finalPrice Final Price of Ala Carte Item
     * @param category Category of Item
     * */
    PromoAlacarte(String name, String description, float price,float finalPrice, Category category) {
        super(name, description, price, category);
        this.finalPrice=finalPrice;
    }

    /**
     * Return the discount of the Promotional Ala Carte Item
     * */
    public float getDiscount() {
        float initialPrice = this.getPrice();
        return (initialPrice-finalPrice)/initialPrice;
    }
}
