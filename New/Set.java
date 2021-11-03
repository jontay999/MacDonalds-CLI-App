package MacDonalds.New;

import java.util.ArrayList;

public class Set extends MenuItem {
    private ArrayList<Alacarte> alacarteItems = new ArrayList<Alacarte>();

    public ArrayList<Alacarte> getAlacarteItem(){
        return this.alacarteItems;
    }

    public void addAlacarteItem(Alacarte item){
        alacarteItems.add(item);
    }

    public void removeAlacarteItem(int index){
        this.alacarteItems.remove(index);
    }

    // public String getItemDescr(){

    // }
}
