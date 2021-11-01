package MacDonalds.New;

import java.time.LocalDateTime;

public class Reservation {
    long reservationId;
    int customerContact;
    String customerName;
    LocalDateTime reservationTime;

    Reservation(long reservationId, int customerContact, String customerName, LocalDateTime reservationTime){
        this.reservationId = reservationId;
        this.customerContact = customerContact;
        this.customerName = customerName;
        this.reservationTime = reservationTime;
    }



    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
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

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }




}
