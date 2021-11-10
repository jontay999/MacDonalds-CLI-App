package MacDonalds;

import java.time.LocalDateTime;

/**
 Represents a Table in the restaurant
 Many tables can be in a restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Reservation {
    private LocalDateTime reservationTiming;
    private int reservationID;
    private LocalDateTime createdAt;
    private int numPax;
    private String customerName;
    private String restaurantName;
    private String status;
    Reservation(){
    }
    Reservation(LocalDateTime reservationTiming, int reservationID, LocalDateTime createdAt, int numPax, String customerName, String restaurantName, String status){
        this.reservationTiming = reservationTiming;
        this.reservationID = reservationID;
        this.createdAt = createdAt;
        this.numPax = numPax;
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.status = status;
    }



    public int getReservationID() {
        return reservationID;
    }

    public int getNumPax() {
        return numPax;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getReservationTime() {
        return reservationTiming;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getStatus() {
        return status;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumPax(int numPax) {
        this.numPax = numPax;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTiming = reservationTime;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
