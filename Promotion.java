import java.time.LocalDate;

public class Promotion {
    float originalPrice;
    float discountedPrice;
    LocalDate startDate;
    LocalDate endDate;

    public Promotion(float originalPrice, float discountedPrice, LocalDate startDate, LocalDate endDate){
        this.originalPrice=originalPrice;
        this.discountedPrice=discountedPrice;
        this.startDate=startDate;
        this.endDate=endDate;
    }
    public float getDiscount(){
        return(((originalPrice-discountedPrice)/originalPrice)*100);
    }
    public boolean isAvailable(){
        LocalDate curDate = LocalDate.now();
        return(curDate.isAfter(startDate)&&curDate.isBefore(endDate));
    }

    public float getOriginalPrice() {
        return this.originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
