import java.time.LocalDate;

public class Promotion {
    double originalPrice;
    double discountedPrice;
    LocalDate startDate;
    LocalDate endDate;

    public Promotion(double originalPrice, double discountedPrice, LocalDate startDate, LocalDate endDate){
        this.originalPrice=originalPrice;
        this.discountedPrice=discountedPrice;
        this.startDate=startDate;
        this.endDate=endDate;
    }
    public double getDiscount(){
        return(((originalPrice-discountedPrice)/originalPrice)*100);
    }
    public boolean isAvailable(){
        LocalDate curDate = LocalDate.now();
        return(curDate.isAfter(startDate)&&curDate.isBefore(endDate));
    }

    public double getOriginalPrice() {
        return this.originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
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
