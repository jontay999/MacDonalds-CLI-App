package MacDonalds.New;

import java.util.ArrayList;

/**
 Represents a Set Item of the Menu
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Set extends MenuItem {
    private ArrayList<Alacarte> alacarteItems = new ArrayList<Alacarte>();

    Set(String name,String description){
        setName(name);
        setDescription(description);
    }

    public ArrayList<Alacarte> getAlacarteItem(){
        return this.alacarteItems;
    }

    public void addAlacarteItem(Alacarte item){
        alacarteItems.add(item);
        float prevPrice = this.getPrice();
        this.setPrice(prevPrice+item.getPrice());
    }

    public void removeAlacarteItem(int index){
        this.alacarteItems.remove(index);
        float itemPrice = alacarteItems.get(index).getPrice();
        float prevPrice = this.getPrice();
        this.setPrice(prevPrice-itemPrice);
    }

    public String getSetItems(){
        String itemNames="(";
        for(Alacarte item:alacarteItems){
            itemNames+=item.getName();
            itemNames+=", ";
        }
        itemNames=itemNames.substring(0, itemNames.length()-2);
        itemNames+=")";
        return itemNames;
    }
}
