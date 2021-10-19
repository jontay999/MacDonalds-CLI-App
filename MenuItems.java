import java.time.LocalDate;

public class MenuItems extends Promotion {
    String name;
    String description;
    int promotionId;
    enum Category{
        MAIN_COURSE,
        DRINK,
        DESSERT,
        SIDES
    };
    Category category;
    public MenuItems(float originalPrice, float discountedPrice, LocalDate startDate, LocalDate endDate, String name, String description, int promotionId, Category category) {
        super(originalPrice, discountedPrice, startDate, endDate);
        this.name = name;
        this.description = description;
        this.promotionId = promotionId;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPromotionId() {
        return this.promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }    
}
