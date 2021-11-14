package MacDonalds.New;
import java.util.ArrayList;

/**
 Represents a Menu of the Restaurant
 @author Dhruval Kothari
 @version 1.0
 @since 2021-11-09
  * */
public class Menu implements MenuControl {

    /**
     * All AlaCarte Items available in the Menu
     * */
    private ArrayList<Alacarte> alacarteList = new ArrayList<>();

    /**
     * All Set Items available in the Menu
     * */
    private ArrayList<Set> setList = new ArrayList<>();

    /**
     * The name of the Menu
     * */
    private String name;


    /**
     * Creates the Menu
     * @param name The name of the Menu
     * */
    Menu(String name){
        this.name=name;
    }

    /**
     * Returns all the AlaCarte items in the Menu
     * */
    public ArrayList<Alacarte> getAlacarteList(){
        return this.alacarteList;
    }

    /**
     * Return all the Set items in the Menu
     * */
    public ArrayList<Set> getSetList(){
        return this.setList;
    }

    /**
     * Add a Set Item into the Menu
     * */
    public void addItem(Set item) {
        this.setList.add(item);        
    }

    /**
     * Add an AlaCarte Item into the Menu
     * */
    public void addItem(Alacarte item) {
        this.alacarteList.add(item);        
    }

    public void removeItem(Alacarte item){
        this.alacarteList.remove(item);
    }

    public void removeItem(Set item){
        this.setList.remove(item);
    }

    /**
     * Return Name of Menu
     * */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the menu
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Maximum String Length of an Ala Carte Item
     * */
    public int getMaxAlacarteLength(){
        int maxItemLength = 0;
        for(MenuItem item:alacarteList){
            if (item.getName().length() > maxItemLength) maxItemLength= item.getName().length();
        }
        return maxItemLength;
    }

    /**
     * Get Maximum String Length of a Set Item
     * */
    public int getMaxSetLength(){
        int maxItemLength = 0;
        for(Set item:setList){
            if (item.getName().length()+ item.getSetItems().length()> maxItemLength) maxItemLength= item.getName().length()+item.getSetItems().length();
        }
        return maxItemLength;
    }


    /**
     * Print the Menu by Category
     * @param category Category to be printed
     * */
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

    /**
     * Print everything on the Menu
     * */
    public void printMenu(){
        for(int i=0;i<getMaxAlacarteLength()*2+30;i++)System.out.print("-");
        System.out.println("");
        for(int i=0;i<getMaxAlacarteLength()+5;i++)System.out.print(" ");
        System.out.println("MacDonalds " +this.name);
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
        System.out.println("\nSets:");
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
