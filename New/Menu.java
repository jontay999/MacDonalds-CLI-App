package MacDonalds.New;

import java.time.LocalDateTime;
import java.util.ArrayList;

import MacDonalds.MenuItem;

public class Menu {
    private ArrayList<MenuItem> menuItemsList = new ArrayList<MenuItem>();
    private String name;
    private LocalDateTime lastUpdated;

    ArrayList<MenuItem> getItems(){
        return this.menuItemsList;
    }

    public void addItem(MenuItem item){
        this.menuItemsList.add(item);
    }

    public void removeItem(int index){
        this.menuItemsList.remove(index);
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
    
}
