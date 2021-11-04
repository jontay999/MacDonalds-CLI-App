package MacDonalds.New;

import java.time.LocalDateTime;

public interface MakeReservation {
    public void makeReservation(Customer customer, LocalDateTime timing, int numberOfPax);
    public void removeReservation(int contact, LocalDateTime timing);
    public Reservation checkReservation(int contact, LocalDateTime timing);
    public void printReservationConfirmation(int contact, LocalDateTime timing);
}
