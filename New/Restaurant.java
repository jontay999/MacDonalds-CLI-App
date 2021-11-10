package MacDonalds.New;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Restaurant implements ManageRevenueReport{
    ArrayList<Table> allTables;
    ArrayList<Staff> allStaff;
    ArrayList<Order> allOrders;
    ArrayList<Customer> allCustomers;
    ArrayList<Menu> allMenus;
    ArrayList<Membership> allMemberships;
    LocalTime openingTime;
    LocalTime closingTime;
    String restaurantName;
    String location;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    Restaurant(String restaurantName, String location, LocalTime openingTime, LocalTime closingTime){
        this.restaurantName = restaurantName;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.allTables = new ArrayList<>();
        this.allStaff = new ArrayList<>();
        this.allOrders = new ArrayList<>();
        this.allCustomers = new ArrayList<>();
        this.allMenus = new ArrayList<>();
        this.allMemberships = new ArrayList<>();
    }

    public void addCustomer(Customer c){
        this.allCustomers.add(c);
    }

    public void addOrder(Order o){
        this.allOrders.add(o);
    }

    public void addMenu(Menu menu){
        allMenus.add(menu);
    }

    public void addMembership(Membership membership){
        allMemberships.add(membership);
    }

    public void addTable(int capacity){
        Table newTable = new Table(allTables.size()+1, capacity);
        allTables.add(newTable);
    }

    public void addStaff(String name, JobTitle title, Gender gender){
        Staff newStaff = new Staff(name, gender, title);
        allStaff.add(newStaff);
    }

    public ArrayList<Menu> getAllMenus() {
        return allMenus;
    }

    public ArrayList<Membership> getAllMemberships() {
        return allMemberships;
    }

    public Customer findCustomer(int contact){
        for(Customer c: allCustomers){
            if(c.getContact() == contact) return c;
        }
        return null;
    }



    public Table getAvailableTable(int numPax){
        for(Table t: allTables){
            if(t.isAvailable()){
                return t;
            }
        }
        return null;
    }

    public Table getReservedTable(Customer c){
        LocalDateTime currReservationTime = LocalDateTime.now();
        currReservationTime = currReservationTime.minusMinutes(currReservationTime.getMinute());
        currReservationTime = currReservationTime.minusSeconds(currReservationTime.getSecond());

        Reservation customerReservation = null;
        for(Table t: allTables){
            customerReservation = t.checkReservation(c.getContact(), currReservationTime);
            if(customerReservation != null){
                return t;
            }
        }
        return null;
    }

    //sorted by date time
    public ArrayList<Reservation> getAllReservations(){
        ArrayList<Reservation> allReservations = new ArrayList<>();
        for(Table t: allTables){
            for(Reservation r: t.getReservations()){
                allReservations.add(r);
            }
        }
        Collections.sort(allReservations);
        return allReservations;
    }

    public ArrayList<Staff> getAllStaff(){
        return allStaff;
    }

    public String getRestaurantName(){
        return this.restaurantName;
    }

    public String getLocation(){
        return this.location;
    }


    //returns map with key localtime, and value: arraylist of tables that are free during that time
    public Map<LocalTime, ArrayList<Table>> getAvailableTimings(LocalDate date, int numPax){
        Map<LocalTime, ArrayList<Table>> availableTimes = getPossibleTimings(numPax);
        for(int i = 0;i<allTables.size();i++){
            Table currTable = allTables.get(i);
            ArrayList<Reservation> tableReservations = currTable.getReservations();
            for(int j = 0;j<tableReservations.size();j++){
                LocalDateTime reservationTime = tableReservations.get(j).getReservationDateTime();
                if(reservationTime.toLocalDate() == date){
                    LocalTime unavailableTime = reservationTime.toLocalTime();
                    availableTimes.get(unavailableTime).remove(currTable);
                }
            }
        }
        return availableTimes;
    }

    //returns map with key of localtime, value: arraylist of tables that can fit the pax
    public Map<LocalTime, ArrayList<Table>> getPossibleTimings(int numPax){
        Map<LocalTime, ArrayList<Table>> allTimes = new HashMap<>();
        LocalTime currTime = openingTime;
//        System.out.println("Opening time: " + openingTime.toString());
//        System.out.println("Closing time: " + closingTime.toString());
//        System.out.println("All Tables Size: " + getAllTables().size());
        while(currTime.isBefore(closingTime)){
            ArrayList<Table> tableList = new ArrayList<>();
            for(int i = 0;i < getAllTables().size();i++){
                Table currTable = getAllTables().get(i);
                if(currTable.getCapacity() >= numPax){
                    tableList.add(currTable);
                }
            }
            allTimes.put(currTime, tableList);
            currTime = currTime.plusHours(1);
        }
        return allTimes;
    }

    public ArrayList<Table> getAllTables(){
        return this.allTables;
    }

    public ArrayList<Customer> getAllCustomers(){
        return this.allCustomers;
    }


    //Printing Revenue Reports
    public void generateRevenueReport(int year) {
        RevenueReport report = new YearlyRevenueReport(allOrders, year);
        System.out.println("Yearly Revenue Report for the Year " + year);
        report.printRevenueReport();
    }

    public void generateRevenueReport(Month month, int year) {
        RevenueReport report = new MonthlyRevenueReport(allOrders,month, year);
        System.out.println("Monthly Revenue Report for " + month + ", " + year);
        report.printRevenueReport();
    }
    public void generateRevenueReport(LocalDate date) {
        RevenueReport report = new DailyRevenueReport(allOrders, date);
        System.out.println("Daily Revenue Report for " +  date.format(formatter));
        System.out.println();
        report.printRevenueReport();
    }
}
