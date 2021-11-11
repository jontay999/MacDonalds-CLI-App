package MacDonalds.New;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 Represents a Restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Restaurant implements ManageRevenueReport{
    /**
     * All the Tables in the restaurant
     * */
    private ArrayList<Table> allTables;

    /**
     * All the Staff working in the restaurant
     * */
    private ArrayList<Staff> allStaff;

    /**
     * All the Orders made in the restaurant
     * */
    private ArrayList<Order> allOrders;

    /**
     * All the Customers that have ordered/reserved at the restaurant
     * */
    private ArrayList<Customer> allCustomers;

    /**
     * All the available Menus in the restaurant
     * */
    private ArrayList<Menu> allMenus;

    /**
     * All the Memberships in the Restaurant
     * */
    private ArrayList<Membership> allMemberships;

    /**
     * The opening time of the restaurant
     * */
    private LocalTime openingTime;

    /**
     * The closing time of the restaurant
     * */
    private LocalTime closingTime;

    /**
     * The name of the restaurant
     * */
    private String restaurantName;

    /**
     * The location of the restaurant
     * */
    private String location;

    /**
     * Creates a new restaurant with its name, location, and opening hours
     * @param restaurantName This Restaurant's Name
     * @param location This Restaurant's Location
     * @param openingTime This Restaurant's opening time
     * @param closingTime This Restaurant's closing time
     * */
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

    /**
     * Adds a new customer to the ArrayList of Customers in the Restaurant
     * @param c The new Customer being added
     * */
    public void addCustomer(Customer c){
        this.allCustomers.add(c);
    }

    /**
     * Adds a new order to the ArrayList of Orders in the Restaurant
     * @param o The new Order being added
     * */
    public void addOrder(Order o){
        this.allOrders.add(o);
    }

    /**
     * Adds a new menu to the available Menus in the Restaurant
     * @param menu The new Menu being added
     * */
    public void addMenu(Menu menu){
        allMenus.add(menu);
    }

    /**
     * Adds a new membership to the Restaurant's available Memberships
     * @param membership The new Membership being added
     * */
    public void addMembership(Membership membership){
        allMemberships.add(membership);
    }

    /**
     * Adds a new Table to the Restaurant's available Tables
     * Table Number is Auto-Incremented in this function
     * @param capacity The capacity of the new table being added
     * */
    public void addTable(int capacity){
        int tableNumber = allTables.size()+1;
        Table newTable = new Table(tableNumber, capacity);
        allTables.add(newTable);
    }

    /**
     * Adds a new Staff to the Restaurant
     * @param name The name of the staff
     * @param title The JobTitle of the staff
     * @param gender The Gender of the staff
     * */
    public void addStaff(String name, JobTitle title, Gender gender){
        Staff newStaff = new Staff(name, gender, title);
        allStaff.add(newStaff);
    }

    /**
     * Returns all the available Menus
     * */
    public ArrayList<Menu> getAllMenus() {
        return allMenus;
    }


    /**
     * Returns all the available Memberships
     * */
    public ArrayList<Membership> getAllMemberships() {
        return allMemberships;
    }

    /**
     * Finds the customer by contact if they exist. Otherwise return null
     * @param contact Contact number of customer being found
     * */
    public Customer findCustomer(int contact){
        for(Customer c: allCustomers){
            if(c.getContact() == contact) return c;
        }
        return null;
    }

    /**
     * Returns the first Table found that has sufficient capacity
     * Returns null if there is no available Table
     * @param numPax minimum capacity of desired Table
     * */
    public Table getAvailableTable(int numPax){
        for(Table t: allTables){
            if(t.isAvailable() && t.getCapacity() >= numPax){
                return t;
            }
        }
        return null;
    }

    /**
     * Returns the reserved Table if the customer has a valid reservation
     * Otherwise returns null
     * @param c The Customer to check if they have a valid Reservation
     * */
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

    /**
     * Returns all the Restaurant's Current Reservations sorted by ascending order
     * */
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

    /**
     * Returns all the Staff working in the Restaurant
     * */
    public ArrayList<Staff> getAllStaff(){
        return allStaff;
    }

    /**
     * Returns the opening time of the Restaurant
     * */
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the Restaurant
     * */
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the name of the Restaurant
     * */
    public String getRestaurantName(){
        return this.restaurantName;
    }

    /**
     * Returns the location of the Restaurant
     * */
    public String getLocation(){
        return this.location;
    }

    /**
     * Get all available timings given a Date and the Number of Pax
     * Returns a HashMap with a timing as a key and an ArrayList of available tables at this time
     * Filters out Tables have a reservation at that timing
     * @param date Date of desired Reservation
     * @param numPax Number of Persons for the Reservation
     * */
    public Map<LocalTime, ArrayList<Table>> getAvailableTimings(LocalDate date, int numPax){
        Map<LocalTime, ArrayList<Table>> availableTimes = getPossibleTimings(numPax);
        for(int i = 0;i<allTables.size();i++){
            Table currTable = allTables.get(i);
            ArrayList<Reservation> tableReservations = currTable.getReservations();
            for(int j = 0;j<tableReservations.size();j++){
                LocalDateTime reservationTime = tableReservations.get(j).getReservationDateTime();
                if(reservationTime.toLocalDate().isEqual(date)){
                    LocalTime unavailableTime = reservationTime.toLocalTime();
                    availableTimes.get(unavailableTime).remove(currTable);
                }
            }
        }
        //remove timing if no tables available
        availableTimes.entrySet().removeIf(elem->elem.getValue().size() == 0);
        return availableTimes;
    }

    /**
     * Get all Possible Timings in 1 hour intervals from opening time to closing time
     * Returns a HashMap with key of time and the value as an ArrayList of Tables
     * Tables that do not have sufficient capacity to fit the number of pax will be filtered out
     * @param numPax minimum capacity of Table needed
     * */
    public Map<LocalTime, ArrayList<Table>> getPossibleTimings(int numPax){
        Map<LocalTime, ArrayList<Table>> allTimes = new HashMap<>();
        LocalTime currTime = openingTime;
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


    /**
     * Returns all the Tables in the Restaurant
     * */
    public ArrayList<Table> getAllTables(){
        return this.allTables;
    }

    /**
     * Returns all the Tables that are currently occupied by a Customer
     * */
    public ArrayList<Table> getOccupiedTables(){
        ArrayList<Table> occupiedTables = new ArrayList<>();
        for(Table t: allTables){
            if(t.getOccupyingCustomer() != null){
                occupiedTables.add(t);
            }
        }
        return occupiedTables;
    }

    /**
     * Finds the Table that was reserved
     * @param contact Contact Number of customer that made the reservation
     * @param timing Reservation DateTime
     * */
    public Table findReservationTable(int contact, LocalDateTime timing){
        for(Table t: allTables){
            Reservation r = t.checkReservation(contact, timing);
            if(r != null) return t;
        }
        return null;
    }

    /**
     * Generate and Print Yearly Revenue Report
     * @param year Year for Revenue Report
     * */
    public void generateRevenueReport(int year) {
        RevenueReport report = new YearlyRevenueReport(allOrders, year);
        System.out.println("Yearly Revenue Report for the Year " + year);
        report.printRevenueReport();
    }

    /**
     * Generate and Print the Monthly Revenue Report
     * @param month Month of Revenue Report
     * @param year Year of Revenue Report
     * */
    public void generateRevenueReport(Month month, int year) {
        RevenueReport report = new MonthlyRevenueReport(allOrders,month, year);
        System.out.println("Monthly Revenue Report for " + month + ", " + year);
        report.printRevenueReport();
    }

    /**
     * Generate and Print Daily Revenue Report
     * @param date Date for Revenue Report
     * */
    public void generateRevenueReport(LocalDate date) {
        RevenueReport report = new DailyRevenueReport(getAllOrders(), date);
        System.out.println("Daily Revenue Report for " +  date.toString());
        System.out.println();
        report.printRevenueReport();
    }

    /**
     * Returns all the Orders in the Restaurant
     * */
    public ArrayList<Order> getAllOrders(){
        return allOrders;
    }
}
