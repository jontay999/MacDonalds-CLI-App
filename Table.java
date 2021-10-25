package MacDonalds;

public class Table {
    private int tableNum;
    private int size;
    private boolean isOccupied;
    private boolean isReserved;
    private MacDonalds.Reservation currentReservation;
    private MacDonalds.Reservation[] fulfilledReservations;
    private MacDonalds.Reservation[] pendingReservations;
    private LocalDateTime[] reservedTimings;
    private LocalDateTime nextReservationTime;
    Table(){
        size=0;
        tableNum=0;
    }
    Table(int tableNum, int size){
        this.tableNum = tableNum;
        this.size = size;
    }

    public int getReservationID() {
        return this.currentReservation.getReservationID();
    }

    public int getSize() {
        return size;
    }

    public int getTableNum() {
        return tableNum;
    }

    public LocalDateTime getNextReservationTime() {
        return nextReservationTime;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public LocalDateTime[] getReservedTimings() {
        return reservedTimings;
    }

    public MacDonalds.Reservation getCurrentReservation() {
        return currentReservation;
    }

    public MacDonalds.Reservation[] getFulfilledReservations() {
        return fulfilledReservations;
    }

    public MacDonalds.Reservation[] getPendingReservations() {
        return pendingReservations;
    }

    public void setCurrentReservation(MacDonalds.Reservation currentReservation) {
        this.currentReservation = currentReservation;
    }

    public void setFulfilledReservations(MacDonalds.Reservation[] fulfilledReservations) {
        this.fulfilledReservations = fulfilledReservations;
    }

    public void setPendingReservations(MacDonalds.Reservation[] pendingReservations) {
        this.pendingReservations = pendingReservations;
    }

    public void setReservedTimings(LocalDateTime[] reservedTimings) {
        this.reservedTimings = reservedTimings;
    }

    public void setNextReservationTime(LocalDateTime nextReservationTime) {
        this.nextReservationTime = nextReservationTime;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setReservationID(int reservationID) {
        this.currentReservation.setReservationID(reservationID);
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
    public boolean isAvailable(LocalDateTime time){
        boolean availability = true;
        for(int i = 0; i<this.getReservedTimings().length; i++){
           if(this.getReservedTimings()[i] == time){
               availability = false;
           }
       }
       return availability;
    }
}
