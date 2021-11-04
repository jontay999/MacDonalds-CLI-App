//package MacDonalds;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Set;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.LocalDate;
//
////import org.json.simple.JSONArray;
////import org.json.simple.JSONObject;
////import org.json.simple.parser.JSONParser;
////import org.json.simple.parser.ParseException;
//
//public class MacDonaldsAppOld {
//    static ArrayList<Menu> menuList=new ArrayList<Menu>();
////    public static void main(String[] args){
////        initMenuData();
////        System.out.println("Hello! Welcome to MacDonalds");
////        String[]options={"Menu","Quit"};
////        int selection=0;
////        while(selection!=options.length){
////            selection = getUserInput("OPTIONS", options);
////            if(selection==1)MenuSelection();
////        }
////    }
//
//    public static void initMenuData(){
//        JSONParser parser = new JSONParser();
//        try{
//            Object obj = parser.parse(new FileReader("MacDonalds/data.json"));
//            JSONObject jsonObject = (JSONObject)obj;
//            Set<?> menuNames = jsonObject.keySet();
//            for(Object name:menuNames){
//                Menu tempMenu = new Menu(name.toString());
//                JSONArray array = (JSONArray)jsonObject.get(name);
//                for(Object x:array){
//                    LocalDate now = LocalDate.now();
//                    double price = Double.parseDouble(((JSONObject)x).get("price").toString().substring(2));
//                    String itemName = ((JSONObject)x).get("name").toString().strip();
//                    String description = ((JSONObject)x).get("description").toString().strip();
//                    MenuItem tempItem = new MenuItem(price, price, now, now, itemName, description, 123, Category.MAIN_COURSE);
//                    tempMenu.addItem(tempItem);
//                }
//                menuList.add(tempMenu);
//            }
//        }
//        catch(FileNotFoundException e){e.printStackTrace();}
//        catch(IOException e){e.printStackTrace();}
//        catch(ParseException e){e.printStackTrace();}
//        catch(Exception e){e.printStackTrace();}
//    }
//
//    public static void MenuSelection(){
//        String[] options = {"Choose Menu","Create Menu"};
//        int selection = getUserInput("MENU OPTIONS", options);
//        if(selection==1)pickMenu();
//        else if(selection==2)System.out.println("CREATE NEW MENU");
//    }
//
//    public static void pickMenu(){
//        String[] options=new String[menuList.size()];
//        int count=0;
//        for(Menu menu:menuList){
//            options[count]=menu.getName();
//            count++;
//        }
//        int chosenMenuNum = getUserInput("AVAILABLE MENUS", options);
//        Menu chosenMenu = menuList.get(chosenMenuNum-1);
//        String chosenMenuName = chosenMenu.getName();
//
//        String[] options2 = {"Display Menu","Edit Menu"};
//        int selection2 = getUserInput(chosenMenuName.toUpperCase()+" OPTIONS", options2);
//        if(selection2==1)chosenMenu.printMenu();
//    }
//
//    public static int getUserInput(String title, String []options){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\n"+title);
//        int count=0;
//        for(String opt:options){
//            count++;
//            System.out.println(count+"."+opt);
//        }
//        while(true){
//            System.out.print("\nEnter your selection: ");
//            int selection = scanner.nextInt();
//            if(selection<=count){
//                return selection;
//            }
//            else{
//                System.out.println("Invalid selection! Please try again.");
//            }
//        }
//    }
//    }
//
