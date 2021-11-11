package MacDonalds.New;

import java.util.ArrayList;

/**
 Represents a Set Item of the Menu
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Set extends MenuItem {
    /**
     * All the Ala Carte Items in the Set
     * */
    private ArrayList<Alacarte> alacarteItems = new ArrayList<>();

    /**
     * Create a Set Item
     * @param name Name of the Set
     * @param description Description of the Set
     * */
    Set(String name,String description){
        setName(name);
        setDescription(description);
    }

    /**
     * Add an Ala Carte Item into the Set
     * @param item Ala Carte Item to be added
     * */
    public void addAlacarteItem(Alacarte item){
        alacarteItems.add(item);
        float prevPrice = this.getPrice();
        this.setPrice(prevPrice+item.getPrice());
    }

    /**
     * Remove Ala Carte Item from the Set
     * @param index Index of Item to be removed
     * */
    public void removeAlacarteItem(int index){
        this.alacarteItems.remove(index);
        float itemPrice = alacarteItems.get(index).getPrice();
        float prevPrice = this.getPrice();
        this.setPrice(prevPrice-itemPrice);
    }

    /**
     * Return all the Items in the Set as a String
     * */
    public String getSetItems(){
        String itemNames=" (";
        for(Alacarte item:alacarteItems){
            itemNames+=item.getName();
            itemNames+=", ";
        }
        itemNames=itemNames.substring(0, itemNames.length()-2);
        itemNames+=")";
        return itemNames;
    }

    public ArrayList<Alacarte> getAlacarteItems(){
        return this.alacarteItems;

    }
}
