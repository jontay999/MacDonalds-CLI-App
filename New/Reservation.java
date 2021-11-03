package MacDonalds.New;

import java.time.LocalDateTime;

public class Reservation {
    int customerContact;
    String customerName;
    LocalDateTime reservationDateTime;
    int numberOfPax;

    Reservation( int customerContact, String customerName, LocalDateTime reservationDateTime, int numberOfPax){
        this.customerContact = customerContact;
        this.customerName = customerName;
        this.reservationDateTime = reservationDateTime;
        this.numberOfPax = numberOfPax;
    }



    public int getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(int customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
