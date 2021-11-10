package MacDonalds;
import java.time.LocalDateTime;

/**
 Represents a Table in the restaurant
 Many tables can be in a restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
 * */

public class Table {
    /**
     * Table Number created in ascending order
     * */
    private int tableNum;

    /**
     * The capacity of the table
     * */
    private int size;
    private boolean isOccupied;
    private boolean isReserved;
    private Reservation reservation;

    Table(){
        size=0;
        tableNum=0;
    }
    Table(int tableNum, int size){
        this.tableNum = tableNum;
        this.size = size;
    }

    public Reservation getReservation() {
        return this.reservation;
    }

    public int getSize() {
        return size;
    }

    public int getTableNum() {
        return tableNum;
    }


    public boolean getIsOccupied() {
        return isOccupied;
    }

    public boolean getIsReserved() {
        return isReserved;
    }


    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public MacDonalds.Reservation setReservation(LocalDateTime reservationTiming, int reservationID, LocalDateTime createdAt, int numPax, String customerName, String restaurantName, String status) {
        return new MacDonalds.Reservation(reservationTiming, reservationID, createdAt, numPax, customerName, restaurantName, status);
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }
    public boolean isAvailable(LocalDateTime time) {
        return this.reservation.getReservationTime() == time && isOccupied;
    }
}
