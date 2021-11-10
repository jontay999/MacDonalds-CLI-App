package MacDonalds.New;

import java.time.LocalDateTime;

public class Reservation implements Comparable<Object>{
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

    public void printReservation(){
        System.out.print("Reservation Date Time: " + getReservationDateTime().toString() + " | Customer Name: " + customer.getName() + " | Customer Contact Number: " + customer.getContact() + " | Pax: " + numberOfPax);
    }


    @Override
    public int compareTo(Object o) {
        Reservation r1 = (Reservation) o;
        return r1.getReservationDateTime().compareTo(this.getReservationDateTime());
    }
}
