package MacDonalds.New;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderSelection {
    Restaurant MacDonalds = MacDonaldsApp.MacDonalds;
    Scanner scanner = MacDonaldsApp.scanner;

    OrderSelection(){
        String[] options = {"New Order","Edit Order","View Order","Close Order","Back"};
        int selection = HelperFunctions.getUserInput("ORDER OPTIONS", options);
        if(selection==1) newOrder();
        else if(selection==2) editOrder();
        else if(selection==3) viewOrder();
        else if(selection==4) closeOrder();
        else if(selection==5) return;
        else HelperFunctions.forStupid();
    }

    public void newOrder(){
        Table table = getTableSelection();
        if(table == null){
            System.out.println("There are no occupied tables to take orders from now!");
            return;
        }
        Customer customer = table.getOccupyingCustomer();
        Order order = new Order(customer,MacDonalds.getAllStaff().get(2),table);
        Menu menu = getMenuSelection();
        String [] options = {"Alacarte","Set","Done"};
        while(true){
            int selection = HelperFunctions.getUserInput("SELECT ITEM TYPE", options);
            if(selection==1)order.addItem(getAlacarteItemInput(menu));
            else if(selection==2)order.addItem(getSetItemInput(menu));
            else  if(selection==3) break;
        }
        customer.setOrder(order);
        MacDonalds.addOrder(order);
    }

    public void editOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = customer.getOrder();
        order.viewOrder();
        String [] options = {"Alacarte","Set","Done"};
        int selection = HelperFunctions.getUserInput("SELECT ITEM TYPE TO REMOVE", options);
        System.out.print("Enter index of item to remove: ");
        int toRemove = scanner.nextInt();
        if(selection==1){
            Alacarte toRemoveItem = order.getAlacarteList().get(toRemove-1);
            order.removeItem(toRemoveItem);
        }
        else if(selection==2){
            Set toRemoveSetItem = order.getSetList().get(toRemove-1);
            order.removeItem(toRemoveSetItem);
        }
    }

    public void viewOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = customer.getOrder();
        order.viewOrder();
    }

    public void closeOrder(){
        Table table = getTableSelection();
        Customer customer = table.getOccupyingCustomer();
        Order order = customer.getOrder();
        order.printOrderInvoice();
        table.setOccupyingCustomer(null);
    }

    public Table getTableSelection(){
        ArrayList<Table> tables = MacDonalds.getOccupiedTables();
        String [] options = new String[tables.size()];
        int i=0;
        if(tables.size()==0)return null;
        for(Table table:tables){
            options[i]="Table "+table.getTableNumber();
            i++;
        }
        int selection = HelperFunctions.getUserInput("SELECT TABLE", options);
        return tables.get(selection-1);
    }

    public Menu getMenuSelection(){
        ArrayList<Menu> menus = MacDonalds.getAllMenus();
        String [] options = new String[menus.size()];
        int i=0;
        for(Menu menu:menus){
            options[i]=menu.getName();
            i++;
        }
        int selection = HelperFunctions.getUserInput("SELECT MENU", options);
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
        int selection = HelperFunctions.getUserInput("SELECT ITEM", options);
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
        int selection = HelperFunctions.getUserInput("SELECT ITEM", options);
        return items.get(selection-1);
    }
}
