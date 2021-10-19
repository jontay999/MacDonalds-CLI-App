import java.time.LocalDate;
import java.util.ArrayList;

public class PromotionalSet extends Promotion {
    int promotionId;
    List<MenuItems> menuItems = new ArrayList<MenuItems>();
    public PromotionalSet(float originalPrice, float discountedPrice, LocalDate startDate, LocalDate endDate, int promotionId) {
        super(originalPrice, discountedPrice, startDate, endDate);
        this.promotionId=promotionId;
    }

    public int getPromotionId() {
        return this.promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public MenuItems[] getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItems(MenuItems[] newItem) {
        menuItems.add(newItem);
    }

    
}
