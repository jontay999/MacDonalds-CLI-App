package MacDonalds.New;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/**
 Represents a Table in the restaurant
 Many tables can be in a restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Table implements ManageReservation {

    /**
     * All the reservations contained within the table
     * */
    private ArrayList<Reservation> reservations;

    /**
     * Table Number created in ascending order
     * */
    private int tableNumber;

    /**
     * The capacity of the table
     * */
    private int capacity;

    /**
     * Date Time formatter to print date time in a readable fashion
     * */
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    /**
     * Current customer occupying the table
     * Will be null if there is no customer
     * */
    private Customer occupyingCustomer;

    /**
     * Creates a new table with unique table number and given capacity
     * The given capacity should be a multiple of 2
     * Occupying Customer is originally set to null
     * @param tableNumber This Table's Number
     * @param capacity This Table's maximum capacity
     * */
    Table(int tableNumber, int capacity){
        this.reservations = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.occupyingCustomer = null;
    }

    /**
     * Makes a Reservation for a customer for the current table
     * Adds the new reservation to Table's ArrayList of Reservations
     * @param customer The Customer making the reservation on the table
     * @param timing The DateTime of Reservation
     * @param numberOfPax The Number of Pax reserved for
     * */
    public void makeReservation(Customer customer, LocalDateTime timing, int numberOfPax){
        clearOldReservations();
        Reservation newReservation = new Reservation(customer, timing, numberOfPax);
        this.reservations.add(newReservation);
        System.out.println("\nReservation confirmed!\n");
        printReservationConfirmation(customer.getContact(), timing);
    };

    /**
     * Find the reservation of the customer with the contact number made at the timing
     * Remove the reservation from Table's ArrayList of reservations
     * @param contact The Contact of the Customer that made the Reservation
     * @param timing The DateTime of Reservation
     * */
    public void removeReservation(int contact, LocalDateTime timing){
        clearOldReservations();
        this.reservations.removeIf(r -> r.getCustomer().getContact() == contact && r.getReservationDateTime().isEqual(timing));
    }

    /**
     * Find the reservation of the customer with the contact number made at the timing
     * Return the Reservation if found, else return null
     * @param contact The Contact of the Customer making the reservation on the table
     * @param timing The DateTime of Reservation
     * */
    public Reservation checkReservation(int contact, LocalDateTime timing){
        clearOldReservations();
        for(Reservation r: reservations){
            if(r.getCustomer().getContact() == contact && r.getReservationDateTime().isEqual(timing)){
                return r;
            }
        }
        return null;
    };


    /**
     * Print Reservation Details for the customer with the contact number made at the timing
     * Return the Reservation if found, else return null
     * @param contact The Contact of the Customer that made the reservation on the table
     * @param timing The DateTime of Reservation
     * */
    public void printReservationConfirmation(int contact, LocalDateTime timing){
        clearOldReservations();
        for(Reservation r: reservations){
            if(r.getCustomer().getContact() == contact && r.getReservationDateTime() == timing){
                System.out.println("Reservation Details:");
                System.out.println("======================");
                System.out.println("Customer name: " + r.getCustomer().getName());
                System.out.println("Customer contact: " +r.getCustomer().getContact());
                System.out.println("Number of Pax: " + r.getNumberOfPax());
                System.out.println("Reservation Timing: " + r.getReservationDateTime());
                return;
            }
        }
        System.out.println("No such reservation found.");
    };

    /**
     * Checks if Table is available to seat the customer
     * Return False if is currently occupied or reserved
     * */
    public boolean isAvailable(){
        if(occupyingCustomer == null){
            LocalDateTime currReservationTime = LocalDateTime.now();
            currReservationTime = currReservationTime.minusMinutes(currReservationTime.getMinute());
            currReservationTime = currReservationTime.minusSeconds(currReservationTime.getSecond());

            for(Reservation r: reservations){
                if(r.getReservationDateTime() == currReservationTime){
                    //not occupied but reserved
                    return false;
                }
            }
            //not occupied and not reserved
            return true;
        }
        //is occupied
        return false;
    }

    /**
     * Expire and remove reservations that are more than 1 hour before current time
     * */
    public void clearOldReservations(){
        LocalDateTime timeExpiry = LocalDateTime.now().minusHours(1);
        this.reservations.removeIf(r -> r.getReservationDateTime().isBefore(timeExpiry));
    }

    /**
     * Gets the ArrayList of all current reservations of the table
     * */
    public ArrayList<Reservation> getReservations(){
        clearOldReservations();
        return this.reservations;
    }

    /**
     * Gets the current Table Number
     * */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Gets the current table's capacity
     * */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets current occupying customer if there is a customer
     * Returns null if not currently occupied
     * */
    public Customer getOccupyingCustomer() {
        return this.occupyingCustomer;
    }

    /**
     * Occupies the table with the customer
     * @param customer The Customer occupying the table now
     * */
    public void setOccupyingCustomer(Customer customer) {
        this.occupyingCustomer = customer;
    }

    /**
     * Print the Table Details as well as if it is available now
     * */
    public void printTable(){
        System.out.println("Table Number " + getTableNumber() + " | Capacity: " + getCapacity() + " | Is Available Now: " + (isAvailable() ? "Yes" : "No"));
    }



}
