import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu {
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    ArrayList<PromotionalSet> promoSets = new ArrayList<PromotionalSet>();
    String name;
    LocalDateTime lastUpdated;

    public Menu(String name){
        this.name=name;
        this.lastUpdated=LocalDateTime.now();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
        setLastUpdated(LocalDateTime.now());
    }

    public ArrayList<PromotionalSet> getPromoSets() {
        return this.promoSets;
    }

    public void setPromoSets(ArrayList<PromotionalSet> promoSets) {
        this.promoSets = promoSets;
        setLastUpdated(LocalDateTime.now());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        setLastUpdated(LocalDateTime.now());
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void addItem(MenuItem menuItem){
        menuItems.add(menuItem);
        setLastUpdated(LocalDateTime.now());
    }

    public void addItem(PromotionalSet promoItem){
        promoSets.add(promoItem);
        setLastUpdated(LocalDateTime.now());
    }

    public void removeMenuItem(int index){
        if(index>=menuItems.size())System.out.println("Item not found! Please try again");
        else menuItems.remove(index);
        setLastUpdated(LocalDateTime.now());
    }

    public void removePromoSet(int index){
        if(index>=menuItems.size())System.out.println("Item not found! Please try again");
        else promoSets.remove(index);
        setLastUpdated(LocalDateTime.now());
    }

    public void printMenu(){
        for(int i=0;i<70;i++)System.out.print("-");
        System.out.println("");
        for(int i=0;i<20;i++)System.out.print(" ");
        System.out.println("MacDonalds " +name+" menu ");
        for(int i=0;i<70;i++)System.out.print("-");
        System.out.println("");
        System.out.println("\nAla-Carte Items:");
        int count=0;
        for(MenuItem item:menuItems){
            System.out.print(item.getName());
            for(int i=0;i<20-item.getName().length();i++)System.out.print(" ");
            System.out.printf(" - $%.2f",item.getDiscountedPrice());
            for(int i=0;i<5;i++)System.out.print(" ");
            // System.out.print(item.getName()+" - $"+item.getDiscountedPrice());
            if(count%2!=0)System.out.println("");
            count++;
        }
        if(count%2!=0)System.out.println("");
        System.out.println("\nPromotional Sets:");
        for(PromotionalSet item:promoSets){
            System.out.print(item.getName());
            System.out.print(" ("+String.join(", ",item.getItemNames())+")");
            for(int i=0;i<20-item.getName().length();i++)System.out.print(" ");
            System.out.printf(" - $%.2f\n",item.getDiscountedPrice());
        }
    }
}
