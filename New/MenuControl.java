package MacDonalds.New;

enum Category{MAIN_COURSE, DRINKS, DESSERT, SIDES};

public interface MenuControl {
    void printMenu(Category category);
    void printMenu();
    int getMaxAlacarteLength();
    int getMaxSetLength();

}
