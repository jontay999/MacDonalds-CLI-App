package MacDonalds.New;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSelection {
    Restaurant MacDonalds = MacDonaldsApp.MacDonalds;
    Scanner scanner = MacDonaldsApp.scanner;

    MenuSelection(){
        String[] options = {"Choose Menu","Create Menu","Back"};
        int selection = HelperFunctions.getUserInput("MENU OPTIONS", options);
        if(selection==1)pickMenu();
        else if(selection==2)createNewMenu();
        else if(selection==3)return;
    }

    public void pickMenu(){
        ArrayList<Menu> menuList = MacDonalds.getAllMenus();
        String[] options=new String[menuList.size()];
        int count=0;
        for(Menu menu:menuList){
            options[count]=menu.getName();
            count++;
        }
        int chosenMenuNum = HelperFunctions.getUserInput("AVAILABLE MENUS", options);
        Menu chosenMenu = menuList.get(chosenMenuNum-1);
        String chosenMenuName = chosenMenu.getName();

        String[] options2 = {"Display Menu","Edit Menu","Add Item"};
        int selection2 = HelperFunctions.getUserInput(chosenMenuName.toUpperCase()+" OPTIONS", options2);
        if(selection2==1)chosenMenu.printMenu();
        if(selection2==2)editMenu(chosenMenu);
        if(selection2==3)addToMenu(chosenMenu);
    }

    public void createNewMenu(){
        System.out.println("Enter a name: ");
        String name = scanner.nextLine();
        Menu menu = new Menu(name);
        MacDonalds.addMenu(menu);
        String [] options = {"Alacarte","Set","Done"};
        while(true){
            int selection = HelperFunctions.getUserInput("SELECT TYPE OF ITEM TO ADD", options);
            if(selection==1){
                Alacarte item = createItem();
                menu.addItem(item);
            }
            else if(selection==2){
                Set item2 = createSet();
                menu.addItem(item2);
            }
            else if(selection==3)break;
        }
    }

    public Alacarte createItem(){
        System.out.println("Enter item name: ");
        String name=scanner.nextLine();
        System.out.println("Enter item description: ");
        String description=scanner.nextLine();
        System.out.println("Enter item price: ");
        float price=(float)scanner.nextDouble();
        String [] cats = {"Main Course", "Drinks", "Dessert", "Sides"};
        int selection = HelperFunctions.getUserInput("Select item category", cats);
        Category category= MacDonaldsApp.allCategories[selection-1];
        Alacarte item = new Alacarte(name,description,price,category);
        return item;
    }

    public Set createSet(){
        System.out.println("Enter Set name: ");
        String name=scanner.nextLine();
        Set newSet = new Set(name,name);
        String [] options = {"Add Item","Done"};
        while(true){
            int selection = HelperFunctions.getUserInput("OPTIONS", options);
            if(selection==1){
                Alacarte item = createItem();
                newSet.addAlacarteItem(item);
            }
            else if(selection==2)break;
        }
        return newSet;
    }

    public void addToMenu(Menu menu){
        String [] options = {"Alacarte","Set","Promo Alacarte","Promo Set"};
        int selection = HelperFunctions.getUserInput("SELECT TYPE TO ADD", options);
        if(selection==1)menu.addItem(createItem());
        if(selection==2)menu.addItem(createSet());
        if(selection==3){
            Alacarte newPromoItem = createItem();
            System.out.print("Enter a discounted price: ");
            float discount = (float)scanner.nextDouble();
            Alacarte a = new PromoAlacarte(newPromoItem.getName(),newPromoItem.getDescription(),newPromoItem.getPrice(),discount,newPromoItem.getCategory());
            a.setPrice(discount);
            a.setName(a.getName()+" *PROMO*");
            menu.addItem(a);
        }
        if(selection==4){
            Set newPromoItem = createSet();
            System.out.println("Enter a discounted price:");
            float discount = (float)scanner.nextDouble();
            Set a = new PromoSet(newPromoItem.getName(),newPromoItem.getDescription(),discount);
            ArrayList<Alacarte> items = newPromoItem.getAlacarteItems();
            for(Alacarte x:items){
                a.addAlacarteItem(x);
            }
            a.setPrice(discount);
            a.setName(a.getName()+" *PROMO*");
            menu.addItem(a);
        }
    }

    public void editMenu(Menu menu){
        String [] options = {"Alacarte","Set"};
        int selection = HelperFunctions.getUserInput("TYPE OF ITEM TO EDIT", options);
        if(selection==1)editItem(menu,OrderSelection.getAlacarteItemInput(menu));
        else if(selection==2)editItem(menu,OrderSelection.getSetItemInput(menu));
    }

    public void editItem(Menu menu,Alacarte item){
        String [] options = {"Name","Price","Remove Item"};
        int selection = HelperFunctions.getUserInput("FIELD TO EDIT", options);
        if(selection==1){
            System.out.println("Enter new name:");
            String name = scanner.nextLine();
            item.setName(name);
        }
        else if(selection==2){
            System.out.println("Enter new price:");
            float price = (float)scanner.nextDouble();
            item.setPrice(price);
        }
        else if(selection==3)menu.removeItem(item);
    }

    public void editItem(Menu menu,Set item){
        String [] options = {"Name","Remove Item"};
        int selection = HelperFunctions.getUserInput("FIELD TO EDIT", options);
        if(selection==1){
            System.out.println("Enter new name:");
            String name = scanner.nextLine();
            item.setName(name);
        }
        else if(selection==2)menu.removeItem(item);
    }
}
