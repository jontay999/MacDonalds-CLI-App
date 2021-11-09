package MacDonalds.New;

import java.util.ArrayList;

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

    public void printSet(){
        for(Alacarte item:alacarteItems){
            System.out.println("The item is: "+item.getName()+": "+item.getDescription());
        }
    }
}
