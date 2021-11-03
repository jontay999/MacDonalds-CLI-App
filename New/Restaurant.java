package MacDonalds.New;

import java.time.LocalTime;
import java.util.ArrayList;

public class Restaurant {
    ArrayList<Table> allTables;
    ArrayList<Staff> allStaff;
    ArrayList<Order> allOrders;
    LocalTime openingTime;
    LocalTime closingTime;
    String restaurantName;
    String location;

    Restaurant(String restaurantName, String location, LocalTime openingTime, LocalTime closingTime){
        this.restaurantName = restaurantName;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.allTables = new ArrayList<>();
        this.allStaff = new ArrayList<>();
        this.allOrders = new ArrayList<>();
    }

    public void addTable(int capacity){
        Table newTable = new Table(allTables.size()+1, capacity);
        allTables.add(newTable);
    }



    //wait for dhruval
//    public void addStaff(String name, JobTitle title, Gender gender){
//        Staff newStaff = new Staff(name, title, gender);
//    }




}
