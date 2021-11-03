package MacDonalds.New;

public class PromoSet extends Set implements Promotion {
    float finalPrice;

    public float getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getDiscount() {
        return 0;
    }

}
