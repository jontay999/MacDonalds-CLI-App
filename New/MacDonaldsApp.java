package MacDonalds.New;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MacDonaldsApp {
    public static Scanner scanner = new Scanner(System.in);
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/y");
    public static DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("d/M/y H:m");
    private static final Category[] allCategories = Category.values();
    private static final DecimalFormat df = new DecimalFormat("0.00");
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
        MacDonalds.addTable(10);

        String[] memberships = {"Bronze", "Silver", "Gold"};
        for (int i = 1;i<=memberships.length;i++){
            Membership newMembership = new Membership(memberships[i-1], i*0.05);
            MacDonalds.addMembership(newMembership);
        }

        //add staff
        String[] names = new String[]{"Cady", "Grace", "Rihanna", "Taylor", "Dhruval", "Riley", "Marcus", "Pitbull"};
        for(int i = 0;i<names.length;i++){
            Gender gender = i > 4 ? Gender.MALE : Gender.FEMALE;
            JobTitle role = i > 6 ? JobTitle.MANAGER : JobTitle.EMPLOYEE;
            MacDonalds.addStaff(names[i], role, gender);
        }

        //add menu,
        MacDonalds.addMenu(new initMenu().getMenu(0));

        //Starting Options
        System.out.println("Hello! Welcome to " + MacDonalds.getRestaurantName() + " at " + MacDonalds.getLocation());
        String[]options={"Menu","Reservation", "Seat Customers", "Orders", "Restaurant", "Quit"};
        int selection;
        while(true){
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
        String[] options = {"Tables", "Staff", "Revenue Report", "Restaurant Information","Back"};
        int selection = getUserInput("RESTAURANT INFO OPTIONS", options);
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
            case 5:
                return;
            default:
                forStupid();
        }
    }

    public static void RevenueReportSelection(){
        String[] options = {"Daily Revenue Report", "Monthly Revenue Report", "Yearly Revenue Report"};
        int selection = getUserInput("REVENUE REPORT OPTIONS", options);
        if(selection == 1){
            System.out.println("Enter date (dd/mm/yyyy format) :");
            String inputDate = scanner.next();
            LocalDate formattedDate = LocalDate.parse(inputDate, dateFormatter);
            MacDonalds.generateRevenueReport(formattedDate);
        }else if(selection == 2){
            System.out.println("Enter month (1-12):");
            Month month = Month.of(scanner.nextInt());
            System.out.println("Enter year (e.g. 2021) : ");
            int year = scanner.nextInt();
            MacDonalds.generateRevenueReport(month, year);
        }else if(selection == 3){
            System.out.println("Enter year: ");
            int year = scanner.nextInt();
            MacDonalds.generateRevenueReport(year);
        }else{
            forStupid();
        }
    }

    public static void RestaurantInformation(){
        String[] options = {"Memberships", "Restaurant Details"};
        int selection = getUserInput("INFO OPTIONS", options);
        if(selection == 1){
            System.out.println("\nMembership Details");
            System.out.println("=====================");
            ArrayList<Membership> allMemberships = MacDonalds.getAllMemberships();
            if(allMemberships.size() == 0) System.out.println("No memberships currently");
            for(int i = 0;i<allMemberships.size();i++){
                System.out.println((i+1) + ". " + allMemberships.get(i).getType() + " | Discount: " + (int)(allMemberships.get(i).getDiscount()*100) + "%");
            }
        }else if(selection == 2){
            System.out.println("\nRestaurant Details");
            System.out.println("=====================");
            System.out.println("Restaurant Name: " + MacDonalds.getRestaurantName());
            System.out.println("Restaurant Location: " + MacDonalds.getLocation());
            System.out.println("Opening Time: " + MacDonalds.getOpeningTime().toString());
            System.out.println("Closing Time: " + MacDonalds.getClosingTime().toString());
            System.out.println("Number of Staff: " + MacDonalds.getAllStaff().size());
            System.out.println("Number of Tables: " + MacDonalds.getAllTables().size());
        }else{
            forStupid();
        }
    }


    public static void TableSelection(){
        String[] options= {"View All Tables", "Add a Table"};
        int selection = getUserInput("TABLE OPTIONS", options);
        if(selection == 1){
            System.out.println("\nViewing All Tables");
            System.out.println("=====================");
            for(Table t: MacDonalds.getAllTables()){
                t.printTable();
            }
        }else if(selection == 2){
            System.out.println("\nCreating new table");
            System.out.println("=====================");
            System.out.println("Enter capacity of table: ");
            int capacity = scanner.nextInt();
            MacDonalds.addTable(capacity);
            System.out.println("Table successfully created");
        }else{
            forStupid();
        }
    }

    public static void forStupid(){
        System.out.println("Please don't stupid, make valid options pls...");
    }

    public static void StaffSelection(){
        String[] options = {"View All Staff", "Add Staff"};
        int selection = getUserInput("STAFF OPTIONS", options);
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
        String[] options = {"New Order","Edit Order","View Order","Close Order","Back"};
        int selection = getUserInput("ORDER OPTIONS", options);
        if(selection==1) newOrder();
        else if(selection==2) editOrder();
        else if(selection==3) viewOrder();
        else if(selection==4) closeOrder();
        else if(selection==5) return;
    }

    public static void editOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = customer.getOrder();
        order.viewOrder();
        String [] options = {"Alacarte","Set","Done"};
        int selection = getUserInput("SELECT ITEM TYPE TO REMOVE", options);
        System.out.print("Enter index of item to edit: ");
        int toRemove = scanner.nextInt();
        order.removeItem(toRemove-1, selection==1?false:true);
    }

    public static void newOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = new Order(customer,MacDonalds.getAllStaff().get(2),table.getTableNumber());
        Menu menu = getMenuSelection();
        String [] options = {"Alacarte","Set","Done"};
        while(true){
            int selection = getUserInput("SELECT ITEM TYPE", options);
            if(selection==1)order.addItem(getAlacarteItemInput(menu));
            else if(selection==2)order.addItem(getSetItemInput(menu));
            else if(selection==3) break;
        }
        customer.setOrder(order);
    }

    public static void viewOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = customer.getOrder();
        order.viewOrder();
    }

    public static void closeOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = customer.getOrder();
        order.printOrderInvoice();
        table.setOccupyingCustomer(null);
    }

    public static Table getTableSelection(){
        ArrayList<Table> tables = MacDonalds.getOccupiedTables();
        String [] options = new String[tables.size()];
        int i=0;
        for(Table table:tables){
            options[i]="Table "+table.getTableNumber();
            i++;
        }
        int selection = getUserInput("SELECT TABLE", options);
        return tables.get(selection-1);
    }

    public static Menu getMenuSelection(){
        ArrayList<Menu> menus = MacDonalds.getAllMenus();
        String [] options = new String[menus.size()];
        int i=0;
        for(Menu menu:menus){
            options[i]=menu.getName();
        }
        int selection = getUserInput("SELECT MENU", options);
        return menus.get(selection-1);
    }

    public static Alacarte getAlacarteItemInput(Menu menu){
        ArrayList<Alacarte> items = menu.getAlacarteList();
        String [] options = new String[items.size()];
        int i=0;
        for(Alacarte item:items){
            options[i]=item.getName();
            i++;
        }
        int selection = getUserInput("SELECT ITEM", options);
        return items.get(selection-1);
    }

    public static Set getSetItemInput(Menu menu){
        ArrayList<Set> items = menu.getSetList();
        String [] options = new String[items.size()];
        int i=0;
        for(Set item:items){
            options[i]=item.getName();
            i++;
        }
        int selection = getUserInput("SELECT ITEM", options);
        return items.get(selection-1);
    }

    public static void ReservationSelection(){
        String[] options = {"View Reservations", "Make a Reservation","Remove Reservations", "Back"};
        int selection = getUserInput("RESERVATION OPTIONS", options);
        if(selection == 1) viewAllReservations();
        else if(selection == 2) makeReservation();
        else if(selection==3) RemoveReservations();
        else if(selection == 4) return;
        else forStupid();
    }

    public static void RemoveReservations(){
        System.out.println("Remove Reservation Options");
        System.out.println("======================");
        System.out.println("Enter contact number of Customer: ");
        int contact = scanner.nextInt();
        System.out.println("Enter Date Time of Reservation (in format DD/MM/YYYY HH:MM): ");
        String datetime = scanner.next();
        LocalDateTime formattedDateTime = LocalDateTime.parse(datetime, datetimeFormat);


    }

    public static void viewAllReservations(){
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

        Customer currCustomer = createCustomerIfNotExist();
        System.out.println("How many people are coming?");
        int numberOfPax = scanner.nextInt();
        System.out.println("\nWhat date would " + currCustomer.getName() + " like to reserve? (Enter in format dd/mm/yy)");
        String reservationDate = scanner.next();

        //error checking here to make sure valid reservation date
        LocalDate date = LocalDate.parse(reservationDate, dateFormatter);
        if(date.isBefore(LocalDate.now())){
            forStupid();
            return;
        }
        Map<LocalTime, ArrayList<Table>> availableTimings = MacDonalds.getAvailableTimings(date, numberOfPax);

        ArrayList<LocalTime> timings = new ArrayList<LocalTime>(availableTimings.keySet());
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
        }else{
            forStupid();
        }
    }

    public static void MenuSelection(){
        String[] options = {"Choose Menu","Create Menu","Back"};
        int selection = getUserInput("MENU OPTIONS", options);
        if(selection==1)pickMenu();
        else if(selection==2)createNewMenu();
        else if(selection==3)return;
    }

    public static void createNewMenu(){
        System.out.print("Enter a name: ");
        String name = scanner.next();
        Menu menu = new Menu(name);
        System.out.println(name);
        String [] options = {"Alacarte","Set","Done"};
        while(true){
            int selection = getUserInput("SELECT TYPE OF ITEM TO ADD", options);
            if(selection==1)menu.addItem(createItem());
            else if(selection==2)menu.addItem(createSet());
            else if(selection==3)break;
        }
        MacDonalds.addMenu(menu);
    }

    public static Alacarte createItem(){
        System.out.print("Enter item name: ");
        String name=scanner.next();
        System.out.print("Enter item description: ");
        String description=scanner.next();
        System.out.print("Enter item price: ");
        float price=(float)scanner.nextDouble();
        String [] cats = {"Main Course", "Drinks", "Dessert", "Sides"};
        int selection = getUserInput("Select item category", cats);
        Category category=allCategories[selection-1];
        Alacarte item = new Alacarte(name,description,price,category);
        return item;
    }

    public static Set createSet(){
        System.out.print("Enter Set name: ");
        String name=scanner.next();
        Set set = new Set(name,name);
        String [] options = {"Add Item","Done"};
        while(true){
            int selection = getUserInput("OPTIONS", options);
            if(selection==1)set.addAlacarteItem(createItem());
            else if(selection==2)break;
        }
        return set;
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
        if(selection2==2)editMenu(chosenMenu);
    }

    public static void editMenu(Menu menu){
        String [] options = {"Alacarte","Set"};
        int selection = getUserInput("TYPE OF ITEM TO EDIT", options);
        if(selection==1)editItem(getAlacarteItemInput(menu));
        else if(selection==2)editItem(getSetItemInput(menu));
    }

    public static void editItem(Alacarte item){
        String [] options = {"Name","Price"};
        int selection = getUserInput("FIELD TO EDIT", options);
        if(selection==1){
            System.out.println("Enter new name:");
            String name = scanner.next();
            item.setName(name);
        }
        else if(selection==2){
            System.out.println("Enter new price:");
            float price = (float)scanner.nextDouble();
            item.setPrice(price);
        }
    }

    public static void editItem(Set item){
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        item.setName(name);
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
