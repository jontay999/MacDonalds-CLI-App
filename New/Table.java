package MacDonalds.New;

import java.time.LocalDateTime;

public class Table {
    Reservation[] reservations;
    int tableNumber;
    int capacity;
    LocalDateTime[] timingsAvailable;

    Table(Reservation [] reservations, int tableNumber, int capacity, LocalDateTime[] timingsAvailable){
        this.reservations = reservations;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.timingsAvailable = timingsAvailable;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime[] getTimingsAvailable() {
        return timingsAvailable;
    }

    public void setTimingsAvailable(LocalDateTime[] timingsAvailable) {
        this.timingsAvailable = timingsAvailable;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    boolean isOccupied;
}
