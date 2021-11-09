package MacDonalds.New;

public class PromoAlacarte extends Alacarte implements Promotion{
    private float finalPrice;

    PromoAlacarte(String name, String description, float price,float finalPrice, Category category) {
        super(name, description, price, category);
        this.finalPrice=finalPrice;
    }

    public float getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public float getDiscount() {
        float initialPrice = this.getPrice();
        return (initialPrice-finalPrice)/initialPrice;
    }
}
