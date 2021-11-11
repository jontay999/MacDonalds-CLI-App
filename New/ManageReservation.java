package MacDonalds.New;

import java.time.LocalDateTime;

/**
 Represents a Restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */


public interface MakeReservation {
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
     * */
    Reservation checkReservation(int contact, LocalDateTime timing);
    void printReservationConfirmation(int contact, LocalDateTime timing);
}
