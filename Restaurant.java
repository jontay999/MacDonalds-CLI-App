package MacDonalds;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime; // Import the LocalDateTime class
import java.util.ArrayList;
import java.util.Date;

public class Restaurant {
    private Table[] allTables;
    private Staff[] allStaff;
    private Menu[] allMenus;
    private Reservation[] allReservations;
    public String description;
    public String location;
    public String name;
    public LocalTime closingTime;
    public LocalTime openingTime;

    Restaurant(String name,String description, String location, LocalTime openingTime, LocalTime closingTime){
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.description = description;
        this.location = location;
    }

    public ArrayList<LocalTime> getAvailableTime(LocalDate reservationDate, int pax){
        ArrayList<LocalTime> availableTimes = generateAllPossibleTimes();
        for(int i = 0;i<allReservations.length;i++){
            LocalDateTime reservationDateTime = allReservations[i].dateTime;
            if(reservationDateTime.toLocalDate().equals(reservationDate)){
                availableTimes.remove(reservationDateTime.toLocalTime());
            }
            //if date == allReservationDate
        }
        return availableTimes;
    }

    private ArrayList<LocalTime> generateAllPossibleTimes(){
        ArrayList<LocalTime> allPossibleTimes = new ArrayList<LocalTime>();
        LocalTime currTime = getOpeningTime();
        while(currTime.isBefore(getClosingTime())){
            allPossibleTimes.add(currTime);
            currTime.plusMinutes(30);
        }
        return allPossibleTimes;
    }

    public boolean isOpen(LocalTime checkingTime){
        return checkingTime.isBefore(getClosingTime()) && checkingTime.isAfter(getOpeningTime());
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
