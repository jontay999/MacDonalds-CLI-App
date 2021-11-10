package MacDonalds.New;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu implements MenuControl {
    // private ArrayList<MenuItem> menuItemsList = new ArrayList<MenuItem>();
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

    public void printMenu(Category category) {
        for(Alacarte item:alacarteList){
            if(item.getCategory()==category){
                System.out.println(item.getName()+": "+item.getPrice());
            }
        }
    }

    public void printMenu() {
        for(Alacarte item:alacarteList){
            System.out.println(item.getName()+": "+item.getPrice());
        }
        for(Set item:setList){
            System.out.println(item.getName()+": "+item.getPrice());
        }
        
    }
    
}
