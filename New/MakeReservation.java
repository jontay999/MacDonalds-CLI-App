package MacDonalds.New;

import java.time.LocalDateTime;

public interface MakeReservation {
    public void makeReservation(long id, int contact, String name, LocalDateTime timing);
    public void removeReservation(long id);
    public Reservation checkReservation(long id);
    public void printReservationConfirmation(long id);
}
