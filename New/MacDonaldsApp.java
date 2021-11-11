package MacDonalds.New;

import java.time.format.DateTimeFormatter;
import java.util.*;


public class MacDonaldsApp {
    public static Scanner scanner = new Scanner(System.in);
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/y");
    public static final Category[] allCategories = Category.values();
    public static Restaurant MacDonalds;

    public static void main(String[] args){

        MacDonalds = new InitRestaurant().getRestaurant();

        //Starting Options
        System.out.println("Hello! Welcome to " + MacDonalds.getRestaurantName() + " at " + MacDonalds.getLocation());
        String[]options={"Menu","Reservation", "Seat Customers", "Orders", "Restaurant", "Quit"};
        int selection;
        while(true){
            selection = HelperFunctions.getUserInput("OPTIONS", options);
            switch(selection){
                case 1:
                    new MenuSelection();
                    break;
                case 2:
                    new ReservationSelection();
                    break;
                case 3:
                    new SeatCustomerSelection();
                    break;
                case 4:
                    new OrderSelection();
                    break;
                case 5:
                    new RestaurantSelection();
                    break;
                default:
                    System.out.println("Exiting application");
                    System.exit(0);
            }
        }
    }
}
