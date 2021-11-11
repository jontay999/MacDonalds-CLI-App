package MacDonalds.New;

import java.util.ArrayList;
import java.util.Scanner;

public class SeatCustomerSelection {
    Restaurant MacDonalds=MacDonaldsApp.MacDonalds;
    static Scanner scanner = MacDonaldsApp.scanner;

    SeatCustomerSelection(){
        Table assignedTable;
        Customer currCustomer = createCustomerIfNotExist(MacDonalds);
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

    public static Customer createCustomerIfNotExist(Restaurant MacDonalds){
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
}
