package MacDonalds.New;

import java.time.LocalDateTime;

/**
 Represents a ManageReservation Interface
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */


public interface ManageReservation {
    /**
     * Makes a Reservation with Customer, DateTime and Number of Pax
     * @param customer Customer making the reservation
     * @param timing The DateTime of Reservation
     * @param numberOfPax The Number of Pax reserved for
     * */
    void makeReservation(Customer customer, LocalDateTime timing, int numberOfPax);

    /**
     * Find the reservation of the customer with the contact number made at the timing and remove it
     * @param contact The Contact of the Customer that made the Reservation
     * @param timing The DateTime of Reservation
     * */
    void removeReservation(int contact, LocalDateTime timing);

    /**
     * Returns the Reservation if it exists for that Customer contact number at a particular time
     * @param contact Contact Number of the Customer
     * @param timing Reservation DateTime
     * */
    Reservation checkReservation(int contact, LocalDateTime timing);

    /**
     * Prints the Reservation Details to confirm that Reservation has been made
     * @param contact Number of the Customer that made the Reservation
     * @param timing Timing of the Reservation
     * */
    void printReservationConfirmation(int contact, LocalDateTime timing);
}
