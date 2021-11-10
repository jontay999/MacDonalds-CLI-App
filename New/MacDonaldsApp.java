package MacDonalds.New;

import java.time.LocalTime;
import java.util.Scanner;

public class MacDonaldsApp {
    public static Scanner scanner = new Scanner(System.in);
    public static Restaurant MacDonalds;

    public static void main(String[] args){


        new initMenu().getMenu(0).printMenu();;

        LocalTime openingTime = LocalTime.parse("09:00");
        LocalTime closingTime = LocalTime.parse("18:00");
        MacDonalds = new Restaurant("REP-Donalds", "Banyanyan Hall", openingTime, closingTime);

        //add tables, 5 tables each of 2,4,6,8 capacities
        for(int i = 0;i<20;i++){
            int capacity = ((i/5)+1)*2;
            MacDonalds.addTable(capacity);
        }

        //add staff

        //add menu


        //Starting Menu Options
        System.out.println("Hello! Welcome to " + MacDonalds.getRestaurantName() + " at " + MacDonalds.getLocation());
        String[]options={"Menu","Reservation", "Seat Customers", "Orders", "Restaurant", "Quit"};
        int selection=0;
        while(selection!=options.length){
            selection = getUserInput("OPTIONS", options);
        }
    }




    public static int getUserInput(String title, String []options){
        System.out.println("\n"+title);
        int count=0;
        for(String opt:options){
            count++;
            System.out.println(count+"."+opt);
        }
        while(true){
            System.out.print("\nEnter your selection: ");
            int selection = scanner.nextInt();
            if(selection<=count){
                return selection;
            }
            else{
                System.out.println("Invalid selection! Please try again.");
            }
        }
    }
}
