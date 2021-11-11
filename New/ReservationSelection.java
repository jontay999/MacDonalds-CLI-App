package MacDonalds.New;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class ReservationSelection {
    Restaurant MacDonalds=MacDonaldsApp.MacDonalds;
    Scanner scanner = MacDonaldsApp.scanner;

    ReservationSelection(){
        String[] options = {"View Reservations", "Make a Reservation","Remove Reservations","Back"};
        int selection = HelperFunctions.getUserInput("RESERVATION OPTIONS", options);
        if(selection == 1) viewAllReservations();
        else if(selection == 2) makeReservation();
        else if(selection==3) RemoveReservations();
        else if(selection == 4) return;
        else HelperFunctions.forStupid();
    }

    public void viewAllReservations(){
        ArrayList<Reservation> allReservations = MacDonalds.getAllReservations();
        System.out.println("\nViewing All Reservations");
        System.out.println("======================");
        if(allReservations.size() == 0){
            System.out.println("\nNo current reservations");
        }else{
            for (Reservation r : allReservations) {
                r.printReservation();
            }
        }
        System.out.println();
    }

    public void makeReservation(){

        Customer currCustomer = SeatCustomerSelection.createCustomerIfNotExist(MacDonalds);
        System.out.println("How many people are coming?");
        int numberOfPax = scanner.nextInt();
        System.out.println("\nWhat date would " + currCustomer.getName() + " like to reserve? (Enter in format dd/mm/yyyy)");
        String reservationDate = scanner.next();

        //error checking here to make sure valid reservation date
        LocalDate date = LocalDate.parse(reservationDate, MacDonaldsApp.dateFormatter);
        if(date.isBefore(LocalDate.now())){
            HelperFunctions.forStupid();
            return;
        }
        Map<LocalTime, ArrayList<Table>> availableTimings = MacDonalds.getAvailableTimings(date, numberOfPax);

        ArrayList<LocalTime> timings = new ArrayList<>(availableTimings.keySet());
        Collections.sort(timings);
        if(timings.size() == 0){
            System.out.println("Sorry, there are no available tables!");
            return;
        }
        for(int i = 0;i<timings.size();i++){
            System.out.println((i+1) + ". " + timings.get(i).toString());
        }
        System.out.println("Select a time slot: ");
        int selection = scanner.nextInt();

        //assume they r not dumb
        if(selection > 0 && selection <= timings.size()){
            LocalTime reservationTime= timings.get(selection-1);
            //get first available Table
            Table reservedTable = availableTimings.get(reservationTime).get(0);
            LocalDateTime reservationDateTime = LocalDateTime.of(date, reservationTime);
            reservedTable.makeReservation(currCustomer, reservationDateTime, numberOfPax);
        }
    }

    public void RemoveReservations(){
        System.out.println("\nEnter contact number of Customer: ");
        int contact = scanner.nextInt();
        System.out.println("Enter Date of Reservation (in format dd/mm/yyyy) : ");
        String date = scanner.next();
        LocalDate formattedDate = LocalDate.parse(date, MacDonaldsApp.dateFormatter);
        System.out.println("Enter time of Reservation (in format HH:MM) : ");
        String time = scanner.next();
        LocalTime formattedTime = LocalTime.parse(time);
        LocalDateTime formattedDateTime = LocalDateTime.of(formattedDate, formattedTime);
        Table reservationTable = MacDonalds.findReservationTable(contact, formattedDateTime);
        if(reservationTable != null){
            reservationTable.removeReservation(contact, formattedDateTime);
            System.out.println("\nReservation successfully removed");
        }else{
            System.out.println("\nNo reservation could be found for that contact number at that time.");
        }
    }
}
