package MacDonalds.New;

/**
 * All Possible Categories that a food item can fall under
 * */
enum Category{MAIN_COURSE, DRINKS, DESSERT, SIDES};

/**
 Represents a MenuControl Interface for printing menus
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public interface MenuControl {
    /**
     * Print the Menu by Category
     * @param category Category of Menu to be printed
     * */
    void printMenu(Category category);

    /**
     * Print the full Menu
     * */
    void printMenu();
    int getMaxAlacarteLength();
    int getMaxSetLength();

}
