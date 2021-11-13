package MacDonalds.New;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantSelection {
    Restaurant MacDonalds=MacDonaldsApp.MacDonalds;
    Scanner scanner = MacDonaldsApp.scanner;

    RestaurantSelection(){
        String[] options = {"Tables", "Staff", "Revenue Report", "Restaurant Information","Back"};
        int selection = HelperFunctions.getUserInput("RESTAURANT INFO OPTIONS", options);
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
                HelperFunctions.forStupid();
        }
    }

    public void TableSelection(){
        String[] options= {"View All Tables", "Add a Table"};
        int selection = HelperFunctions.getUserInput("TABLE OPTIONS", options);
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
            HelperFunctions.forStupid();
        }
    }

    public void StaffSelection(){
        String[] options = {"View All Staff", "Add Staff"};
        int selection = HelperFunctions.getUserInput("STAFF OPTIONS", options);
        if(selection == 1){
            for(Staff s : MacDonalds.getAllStaff()){
                s.printStaffInfo();
            }
        }else if(selection == 2){
            System.out.println("Enter new staff name: ");
            String name = scanner.nextLine();
            Gender gender;
            JobTitle jobTitle;
            System.out.println("Select staff gender");
            System.out.println("1. Male");
            System.out.println("2. Female");
            int genderSelection = scanner.nextInt();
            if(genderSelection == 1) gender = Gender.MALE;
            else if(genderSelection == 2) gender = Gender.FEMALE;
            else{
                HelperFunctions.forStupid();
                return;
            }

            System.out.println("Select job title");
            System.out.println("1. Employee");
            System.out.println("2. Manager");
            int jobTitleSelection = scanner.nextInt();
            if(jobTitleSelection == 1) jobTitle = JobTitle.EMPLOYEE;
            else if(jobTitleSelection == 2) jobTitle = JobTitle.MANAGER;
            else{
                HelperFunctions.forStupid();
                return;
            }

            MacDonalds.addStaff(name, jobTitle, gender);
        }
    }

    public void RevenueReportSelection(){
        String[] options = {"Daily Revenue Report", "Monthly Revenue Report", "Yearly Revenue Report"};
        int selection = HelperFunctions.getUserInput("REVENUE REPORT OPTIONS", options);
        if(selection == 1){
            System.out.println("Enter date (dd/mm/yyyy format) :");
            String inputDate = scanner.next();
            LocalDate formattedDate = LocalDate.parse(inputDate, MacDonaldsApp.dateFormatter);
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
            HelperFunctions.forStupid();
        }
    }

    public void RestaurantInformation(){
        String[] options = {"Memberships", "Restaurant Details"};
        int selection = HelperFunctions.getUserInput("INFO OPTIONS", options);
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
            HelperFunctions.forStupid();
        }
    }
}
