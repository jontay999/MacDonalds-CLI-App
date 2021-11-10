package MacDonalds.New;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Table implements MakeReservation {
    ArrayList<Reservation> reservations;
    int tableNumber;
    int capacity;
    ArrayList<LocalDateTime> timingsAvailable;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    Customer occupyingCustomer;

    Table(int tableNumber, int capacity){
        this.reservations = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.timingsAvailable = new ArrayList<>();
        this.occupyingCustomer = null;
    }

    public void makeReservation(Customer customer, LocalDateTime timing, int numberOfPax){
        clearOldReservations();
        Reservation newReservation = new Reservation(customer, timing, numberOfPax);
        this.reservations.add(newReservation);
        System.out.println("\nReservation confirmed!\n");
        printReservationConfirmation(customer.getContact(), timing);
//        System.out.println("\nReservation for " + numberOfPax + " at " + timing.format(formatter) + " made by " + customer.getName() + " at Table " + getTableNumber() +  ".");
    };

    public void removeReservation(int contact, LocalDateTime timing){
        clearOldReservations();
        this.reservations.removeIf(r -> r.getCustomer().getContact() == contact && r.getReservationDateTime() == timing);
    }

    public Reservation checkReservation(int contact, LocalDateTime timing){
        clearOldReservations();
        for(Reservation r: reservations){
            if(r.getCustomer().getContact() == contact && r.getReservationDateTime() == timing){
                return r;
            }
        }
        return null;
    };



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
//                return;
            }
        }
//        System.out.println("No reservation could be found for the contact number " + contact + " at " + timing.format(formatter));
    };

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

    public void clearOldReservations(){
        LocalDateTime timeExpiry = LocalDateTime.now().minusHours(1);
        this.reservations.removeIf(r -> r.getReservationDateTime().isBefore(timeExpiry));
    }

    public ArrayList<Reservation> getReservations(){
        clearOldReservations();
        return this.reservations;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Customer getOccupyingCustomer() {
        return this.occupyingCustomer;
    }

    public void setOccupyingCustomer(Customer customer) {
        this.occupyingCustomer = customer;
    }

    public void printTable(){
        System.out.println("Table Number " + getTableNumber() + " | Capacity: " + getCapacity() + " | Is Available Now: " + (isAvailable() ? "Yes" : "No"));
    }



}
