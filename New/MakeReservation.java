package MacDonalds.New;

import java.time.LocalDateTime;

public interface MakeReservation {
    public void makeReservation(int contact, String name, LocalDateTime timing, int numberOfPax);
    public void removeReservation(int contact, LocalDateTime timing);
    public boolean checkReservation(int contact, LocalDateTime timing);
    public void printReservationConfirmation(int contact, LocalDateTime timing);
}
