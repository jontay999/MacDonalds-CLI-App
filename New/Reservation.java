package MacDonalds.New;

import java.time.LocalDateTime;

public class Reservation {
    LocalDateTime reservationDateTime;
    Customer customer;
    int numberOfPax;

    Reservation( Customer customer, LocalDateTime reservationDateTime, int numberOfPax){
        this.customer = customer;
        this.reservationDateTime = reservationDateTime;
        this.numberOfPax = numberOfPax;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public int getNumberOfPax() {
        return numberOfPax;
    }

    public void setNumberOfPax(int numberOfPax) {
        this.numberOfPax = numberOfPax;
    }


}
