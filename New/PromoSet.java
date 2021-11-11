package MacDonalds.New;

/**
 Represents a PromoSet Item
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class PromoSet extends Set implements Promotion {
    private float finalPrice;

    PromoSet(String name, String description, float finalPrice) {
        super(name, description);
        this.finalPrice=finalPrice;
    }

    public float getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public float getDiscount() {
        float initialPrice=this.getPrice();
        return (initialPrice-this.finalPrice)/initialPrice;
    }

}
