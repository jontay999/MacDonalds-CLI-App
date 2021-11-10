package MacDonalds.New;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MacDonaldsApp {
    public static Scanner scanner = new Scanner(System.in);
    public static Restaurant MacDonalds;

    public static void main(String[] args){
        LocalTime openingTime = LocalTime.parse("09:00");
        LocalTime closingTime = LocalTime.parse("18:00");
        MacDonalds = new Restaurant("REP-Donalds", "Banyanyan Hall", openingTime, closingTime);

        //add tables, 5 tables each of 2,4,6,8 capacities
        for(int i = 0;i<20;i++){
            int capacity = ((i/5)+1)*2;
            MacDonalds.addTable(capacity);
        }

        //add staff
        String[] names = new String[]{"Cady", "Grace", "Rihanna", "Taylor", "Dhruval", "Riley", "Marcus", "Pitbull"};
        for(int i = 0;i<names.length;i++){
            Gender gender = i > 4 ? Gender.MALE : Gender.FEMALE;
            JobTitle role = i > 7 ? JobTitle.MANAGER : JobTitle.EMPLOYEE;
            MacDonalds.addStaff(names[i], role, gender);
        }

        //add menu, no sets, 5 promo alacarte, 5 alacarte, 1 promoset, 1  non promoset
        addMenus();

        //Starting Options
        System.out.println("Hello! Welcome to " + MacDonalds.getRestaurantName() + " at " + MacDonalds.getLocation());
        String[]options={"Menu","Reservation", "Seat Customers", "Orders", "Restaurant", "Quit"};
        int selection=0;
        while(selection!=options.length){
            selection = getUserInput("OPTIONS", options);
            switch(selection){
                case 1:
                    MenuSelection();
                    break;
                case 2:
                    ReservationSelection();
                    break;
                default:
                    System.out.println("Exiting application");
                    System.exit(0);
            }
        }
    }


    public static void ReservationSelection(){
        String[] options = {"View Reservations", "Make a Reservation"};
        int selection = getUserInput("Reservation Options", options);
        if(selection == 1) viewAllReservations();
        else if(selection == 2) makeReservation();
    }

    public static void viewAllReservations(){
        ArrayList<Reservation> allReservations = MacDonalds.getAllReservations();
        if(allReservations.size() == 0){
            System.out.println("\nNo current reservations\n");
        }else{
            for(int i = 0;i<allReservations.size();i++){
                allReservations.get(i).printReservation();
            }
        }
        System.out.println();

    }

    public static void makeReservation(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        System.out.println("Enter contact number: ");
        int contact = scanner.nextInt();
        Customer currCustomer = MacDonalds.findCustomer(contact);
        if(currCustomer == null){
            System.out.println("Enter name: ");
            String name = scanner.next();
            Membership customerMembership = null;
            ArrayList<Membership> allMemberships = MacDonalds.getAllMemberships();
            if(allMemberships.size() > 0){
                System.out.println("Select Membership: ");
                for(int i = 0;i<allMemberships.size();i++){
                    System.out.println(i+1 + ". " + allMemberships.get(i).getType());
                }
                System.out.println(allMemberships.size()+1 + ". " + "No Membership");
                int selection = scanner.nextInt();

                //assume not dumb as well
                if(selection > 0 && selection <= allMemberships.size()){
                    customerMembership = allMemberships.get(selection-1);
                }
            }
            currCustomer = new Customer(name, contact, customerMembership);
            MacDonalds.addCustomer(currCustomer);
        }
        System.out.println("How many people are coming?");
        int numberOfPax = scanner.nextInt();
        System.out.println("\nWhat date would " + currCustomer.getName() + " like to reserve? (Enter in format dd/mm/yy)");
        String reservationDate = scanner.next();

        //error checking here to make sure valid reservation date
        LocalDate date = LocalDate.parse(reservationDate, formatter);
        Map<LocalTime, ArrayList<Table>> availableTimings = MacDonalds.getAvailableTimings(date, numberOfPax);

        //idk if this actually sorts it...
        ArrayList<LocalTime> timings = new ArrayList(availableTimings.keySet());
        Collections.sort(timings);
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

    public static void MenuSelection(){
        String[] options = {"Choose Menu","Create Menu"};
        int selection = getUserInput("MENU OPTIONS", options);
        if(selection==1)pickMenu();
        else if(selection==2)System.out.println("CREATE NEW MENU");
    }

    public static void pickMenu(){
        ArrayList<Menu> menuList = MacDonalds.getAllMenus();
        String[] options=new String[menuList.size()];
        int count=0;
        for(Menu menu:menuList){
            options[count]=menu.getName();
            count++;
        }
        int chosenMenuNum = getUserInput("AVAILABLE MENUS", options);
        Menu chosenMenu = menuList.get(chosenMenuNum-1);
        String chosenMenuName = chosenMenu.getName();

        String[] options2 = {"Display Menu","Edit Menu"};
        int selection2 = getUserInput(chosenMenuName.toUpperCase()+" OPTIONS", options2);
        if(selection2==1)chosenMenu.printMenu();
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

    public static void addMenus(){
        for(int j = 0;j<2;j++){
            Menu newMenu = new Menu("Menu" + (j+1));
            PromoSet newPromoSet = new PromoSet("PromoSet " + (j*2+1), "Description of promoset "+(j+1), (float)((j+1)*6.35));
            Set newSet = new Set("PromoSet " + (j*2+2), "Description of promoset "+(j+1));
            for(int i = 0;i<10;i++){
                if(i<5){
                    Alacarte newItem = (Alacarte) generateAlaCarte(false, i+j*5);
                    newMenu.addItem(newItem);
                    if(i%2 == 1){
                        newSet.addAlacarteItem(newItem);
                    }
                }else{
                    Alacarte newItem = (Alacarte) generateAlaCarte(true, i+j*5);
                    newMenu.addItem(newItem);
                    if(i%2 == 1){
                        newPromoSet.addAlacarteItem(newItem);
                    }
                }
            }
            newMenu.addItem(newPromoSet);
            newMenu.addItem(newSet);
            MacDonalds.addMenu(newMenu);
        }
    }

    private static Category[] allCategories = Category.values();
    public static MenuItem generateAlaCarte( boolean isPromo, int id){
        MenuItem newItem;
        float price = (float) (id*0.25 + 0.1);
        float finalPrice = (float) (price*0.75);
        Category category = allCategories[id%allCategories.length];
        String description = "This is the description for item id number " + id;
        if(isPromo){
            newItem = new PromoAlacarte("PromoAlacarte " + id,description,price, finalPrice, category);
        }else{
            newItem = new Alacarte("Normal Alacarte " + id, description, price, category);
        }
        return newItem;
    }
}
