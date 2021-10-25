package MacDonalds;
import java.time.LocalDate;
import java.util.ArrayList;

public class PromotionalSet extends Promotion {
    int promotionId;
    String name;
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    public PromotionalSet(String name, double originalPrice, double discountedPrice, LocalDate startDate, LocalDate endDate, int promotionId) {
        super(originalPrice, discountedPrice, startDate, endDate);
        this.promotionId=promotionId;
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getPromotionId() {
        return this.promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems){
        this.menuItems=menuItems;
    }

    public void addMenuItem(MenuItem newItem) {
        menuItems.add(newItem);
    }

    public void removeMenuItem(int index) {
        if(index>=menuItems.size())System.out.println("Item not found! Please try again");
        else menuItems.remove(index);
    }

    public ArrayList<String> getItemNames(){
        ArrayList<String> names = new ArrayList<String>();
        for(MenuItem item:menuItems){
            names.add(item.getName());
        }
        return names;
    }
}
