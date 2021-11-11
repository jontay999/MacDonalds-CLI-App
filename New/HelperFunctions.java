package MacDonalds.New;

import java.util.Scanner;

public class HelperFunctions {
    static Scanner scanner = MacDonaldsApp.scanner;

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
            scanner.nextLine();
            if(selection<=count){
                return selection;
            }
            else{
                System.out.println("Invalid selection! Please try again.");
            }
        }
    }

    public static void forStupid(){
        System.out.println("Please don't stupid, make valid options pls...");
    }
}
