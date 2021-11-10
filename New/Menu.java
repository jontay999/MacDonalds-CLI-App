package MacDonalds.New;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu implements MenuControl {
    private ArrayList<Alacarte> alacarteList = new ArrayList<Alacarte>();
    private ArrayList<Set> setList = new ArrayList<Set>();
    private String name;
    private LocalDateTime lastUpdated;

    Menu(String name){
        this.name=name;
        this.lastUpdated=LocalDateTime.now();
    }

    public void addItem(Set item) {
        this.setList.add(item);        
    }

    public void addItem(Alacarte item) {
        this.alacarteList.add(item);        
    }

    public void removeItem(int index, boolean isSet) {
        if(isSet){
            setList.remove(index);
        }
        else{
            alacarteList.remove(index);}
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getMaxAlacarteLength(){
        int maxItemLength = 0;
        for(MenuItem item:alacarteList){
            if (item.getName().length() > maxItemLength) maxItemLength= item.getName().length();
        }
        return maxItemLength;
    }

    public int getMaxSetLength(){
        int maxItemLength = 0;
        for(Set item:setList){
            if (item.getName().length()+ item.getSetItems().length()> maxItemLength) maxItemLength= item.getName().length()+item.getSetItems().length();
        }
        return maxItemLength;
    }


    public void printMenu(Category category){
        int count=0;
        for(Alacarte item:alacarteList){
            if (item.getCategory() == category){
                System.out.print(item.getName());
                for(int i=0;i<getMaxAlacarteLength()-item.getName().length()+2;i++)System.out.print(" ");
                System.out.printf(" - $%.2f",item.getPrice());
                for(int i=0;i<5;i++)System.out.print(" ");
                // System.out.print(item.getName()+" - $"+item.getDiscountedPrice());
                if(count%2!=0)System.out.println("");
                count++;
            }
        }
        if(count%2!=0)System.out.println("");
    }
        
    public void printMenu(){
        for(int i=0;i<getMaxAlacarteLength()*2+30;i++)System.out.print("-");
        System.out.println("");
        for(int i=0;i<getMaxAlacarteLength()+5;i++)System.out.print(" ");
        System.out.println("MacDonalds " +this.name+" menu ");
        for(int i=0;i<getMaxAlacarteLength()*2+30;i++)System.out.print("-");
        System.out.println("");
        System.out.println("\nAla-Carte Items:");
        for(int i=0;i<getMaxAlacarteLength()*2+30;i++)System.out.print("-");
        System.out.println("\nMain Course: ");
        for(int i=0;i<12;i++)System.out.print("-");
        System.out.println("");
        printMenu(Category.MAIN_COURSE);
        System.out.println("\nSides: ");
        for(int i=0;i<6;i++)System.out.print("-");
        System.out.println("");
        printMenu(Category.SIDES);
        System.out.println("\nDrinks: ");
        for(int i=0;i<6;i++)System.out.print("-");
        System.out.println("");
        printMenu(Category.DRINKS);
        System.out.println("\nDessert: ");
        for(int i=0;i<8;i++)System.out.print("-");
        System.out.println("");
        printMenu(Category.DESSERT);
        System.out.println("\nPromotional Sets:");
        for(int i=0;i<getMaxAlacarteLength()*2+30;i++)System.out.print("-");
        System.out.println("");
        for(Set item:setList){
            System.out.print(item.getName());
            System.out.print(item.getSetItems());
            for(int i=0;i<getMaxSetLength()-item.getName().length()-item.getSetItems().length();i++)System.out.print(" ");
            System.out.printf(" - $%.2f\n",item.getPrice());
        }
    }
}
