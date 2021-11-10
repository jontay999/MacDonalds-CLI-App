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
                case 3:
                    SeatCustomerSelection();
                    break;
                case 4:
                    OrderSelection();
                    break;
                case 5:
                    RestaurantSelection();
                    break;
                default:
                    System.out.println("Exiting application");
                    System.exit(0);
            }
        }
    }

    public static void RestaurantSelection(){
        String[] options = {"Tables", "Staff", "Revenue Report", "Restaurant Information"};
        int selection = getUserInput("Restaurant Info Options", options);
        switch(selection){
            case 1:
                TableSelection();
                break;
            case 2:
                StaffSelection();
                break;
            case 3:
                RevenueReportSelection();
                break;
            case 4:
                RestaurantInformation();
                break;
            default:
                forStupid();
        }
    }

    public static void RevenueReportSelection(){
        return;
    }

    public static void RestaurantInformation(){
        return;
    }

    public static void TableSelection(){
        String[] options= {"View All Tables", "Add a Table"};
        int selection = getUserInput("Table Options", options);
        if(selection == 1){
            for(Table t: MacDonalds.getAllTables()){
                t.printTable();
            }
        }else if(selection == 2){
            System.out.println("Enter capacity of table: ");
            int capacity = scanner.nextInt();
            MacDonalds.addTable(capacity);
        }
    }

    public static void forStupid(){
        System.out.println("Please don't stupid, make valid options pls...");
    }

    public static void StaffSelection(){
        String[] options = {"View All Staff", "Add Staff"};
        int selection = getUserInput("Staff Options", options);
        if(selection == 1){
            for(Staff s : MacDonalds.getAllStaff()){
                s.printStaffInfo();
            }
        }else if(selection == 2){
            System.out.println("Enter new staff name: ");
            String name = scanner.next();
            Gender gender;
            JobTitle jobTitle;
            System.out.println("Select staff gender");
            System.out.println("1. Male");
            System.out.println("2. Female");
            int genderSelection = scanner.nextInt();
            if(genderSelection == 1) gender = Gender.MALE;
            else if(genderSelection == 2) gender = Gender.FEMALE;
            else{
                forStupid();
                return;
            }

            System.out.println("Select job title");
            System.out.println("1. Employee");
            System.out.println("2. Manager");
            int jobTitleSelection = scanner.nextInt();
            if(jobTitleSelection == 1) jobTitle = JobTitle.EMPLOYEE;
            else if(jobTitleSelection == 2) jobTitle = JobTitle.MANAGER;
            else{
                forStupid();
                return;
            }

            MacDonalds.addStaff(name, jobTitle, gender);
        }
    }

    public static void SeatCustomerSelection(){
        Table assignedTable;
        Customer currCustomer = createCustomerIfNotExist();
        assignedTable = MacDonalds.getReservedTable(currCustomer);

        //no reservation
        if(assignedTable == null){
            System.out.println("How many people are there dining in?");
            int numPax = scanner.nextInt();
            assignedTable = MacDonalds.getAvailableTable(numPax);
            if(assignedTable == null){
                System.out.println("Sorry! There are no available tables at this time. Come back later!\n");
                return;
            }
        }

        System.out.println("Your table number is " + assignedTable.getTableNumber() + "\n");
        assignedTable.setOccupyingCustomer(currCustomer); //actually seat the customer
    }

    public static void OrderSelection(){
        return;
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

    public static Customer createCustomerIfNotExist(){
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
        return currCustomer;
    }

    public static void makeReservation(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        Customer currCustomer = createCustomerIfNotExist();
        System.out.println("How many people are coming?");
        int numberOfPax = scanner.nextInt();
        System.out.println("\nWhat date would " + currCustomer.getName() + " like to reserve? (Enter in format dd/mm/yy)");
        String reservationDate = scanner.next();

        //error checking here to make sure valid reservation date
        LocalDate date = LocalDate.parse(reservationDate, formatter);
        Map<LocalTime, ArrayList<Table>> availableTimings = MacDonalds.getAvailableTimings(date, numberOfPax);

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
