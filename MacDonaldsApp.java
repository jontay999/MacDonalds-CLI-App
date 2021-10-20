import java.time.LocalDate;

public class MacDonaldsApp {

    public static void main(String[] args){
        System.out.println("Hello! Welcome to MacDonalds");
        Menu menu = new Menu("Lunch");
        LocalDate now = LocalDate.now();
        MenuItem item1 = new MenuItem(5.00, 5.00, now, now, "burger", "this is a burger", 12345, Category.MAIN_COURSE);
        MenuItem item2 = new MenuItem(5.00, 3.00, now, now, "fries", "this is a fries", 12345, Category.SIDES);
        MenuItem item3 = new MenuItem(5.00, 1.00, now, now, "coke", "this is a drink", 12345, Category.DRINK);
        MenuItem item4 = new MenuItem(5.00, 1.50, now, now, "vegetarian burger", "this is a drink", 12345, Category.MAIN_COURSE);
        MenuItem item5 = new MenuItem(5.00, 2.70, now, now, "McChicken", "this is a drink", 12345, Category.SIDES);
        MenuItem item6 = new MenuItem(5.00, 1.00, now, now, "McDouble Spicy", "this is a drink", 12345, Category.SIDES);
        PromotionalSet promo1 = new PromotionalSet("McVeggie Meal", 5.00, 5.00, now, now, 123456);
        promo1.addMenuItem(item1);
        promo1.addMenuItem(item2);
        menu.addItem(item1);
        menu.addItem(item2);
        menu.addItem(item3);
        menu.addItem(item4);
        menu.addItem(item5);
        menu.addItem(item6);
        menu.addItem(item6);
        menu.addItem(item6);
        menu.addItem(item6);
        menu.addItem(item6);
        menu.addItem(promo1);
        menu.addItem(promo1);
        menu.addItem(promo1);
        menu.addItem(promo1);
        menu.addItem(promo1);
        // menu.addItem(item6);
        menu.printMenu();
        }
    }

