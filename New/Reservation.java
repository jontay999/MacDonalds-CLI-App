package MacDonalds.New;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 Represents a Reservation
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Reservation implements Comparable<Object>{
    /**
     * DateTime of the Reservation
     * */
    private LocalDateTime reservationDateTime;

    /**
     * Customer that made the Reservation
     * */
    private Customer customer;

    /**
     * Number of Pax reserved for
     * */
    private int numberOfPax;


    /**
     * Creates a new Reservation with the Customer, DateTime and Number of peopl
     * @param customer The Customer making the Reservation
     * @param reservationDateTime This DateTime of the Reservation
     * @param numberOfPax The number of people reserved for
     * */
    Reservation( Customer customer, LocalDateTime reservationDateTime, int numberOfPax){
        this.customer = customer;
        this.reservationDateTime = reservationDateTime;
        this.numberOfPax = numberOfPax;
    }

    /**
     * Returns the Customer that made the Reservation
     * */
    public Customer getCustomer(){
        return this.customer;
    }

    /**
     * Returns the Date Time of the Reservation
     * */
    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    /**
     * Returns the Number of Pax the Reservation is for
     * */
    public int getNumberOfPax() {
        return numberOfPax;
    }

    /**
     * Prints the Reservation Details
     * */
    public void printReservation(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        System.out.print("Reservation Date Time: " + dtf.format(getReservationDateTime()) + " | Customer Name: " + customer.getName() + " | Customer Contact Number: " + customer.getContact() + " | Pax: " + numberOfPax + "\n");
    }

    /**
     * Ensure that Reservations are sorted chronologically
     * */
    @Override
    public int compareTo(Object o) {
        Reservation r1 = (Reservation) o;
        return r1.getReservationDateTime().compareTo(this.getReservationDateTime());
    }
}
