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

    boolean isOccupied;

    Table(int tableNumber, int capacity){
        this.reservations = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.timingsAvailable = new ArrayList<>();
        this.isOccupied = false;
    }

    public void makeReservation(int contact, String name, LocalDateTime timing, int numberOfPax){
        clearOldReservations();
        Reservation newReservation = new Reservation(contact, name, timing, numberOfPax);
        this.reservations.add(newReservation);
        System.out.println("Reservation for " + numberOfPax + " at " + timing.format(formatter) + "made by " + name + " at Table " + getTableNumber() +  ".");
    };

    public void removeReservation(int contact, LocalDateTime timing){
        clearOldReservations();
        this.reservations.removeIf(r -> r.getCustomerContact() == contact && r.getReservationDateTime() == timing);
    }

    public boolean checkReservation(int contact, LocalDateTime timing){
        clearOldReservations();
        for(Reservation r: reservations){
            if(r.getCustomerContact() == contact && r.getReservationDateTime() == timing){
                return true;
            }
        }
        return false;
    };

    public void printReservationConfirmation(int contact, LocalDateTime timing){
        clearOldReservations();
        for(Reservation r: reservations){
            if(r.getCustomerContact() == contact && r.getReservationDateTime() == timing){
                System.out.println("Reservation Details:");
                System.out.println("======================");
                System.out.println("Customer name: " + r.getCustomerName());
                System.out.println("Customer contact: " +r.getCustomerContact());
                System.out.println("Number of Pax" + r.getNumberOfPax());
                System.out.println("Reservation Timing: " + r.getReservationDateTime());
                return;
            }
        }
        System.out.println("No reservation could be found for the contact number " + contact + " at " + timing.format(formatter));
    };

    public void clearOldReservations(){
        LocalDateTime timeExpiry = LocalDateTime.now().minusHours(1);
        this.reservations.removeIf(r -> r.getReservationDateTime().isBefore(timeExpiry));
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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }



}
