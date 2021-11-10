package MacDonalds.New;

import java.util.ArrayList;

public class PromoSet extends Set implements Promotion {
    private float finalPrice;

    PromoSet(String name, String description, float finalPrice, ArrayList<Alacarte>alacarteItems) {
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
