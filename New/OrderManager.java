package MacDonalds.New;

/**
 Represents an interface for managing Orders
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public interface OrderManager {
    void addItem(Set item);
    void addItem(Alacarte item);
    void removeItem(int index, boolean isSet);
    void viewOrder();
    void printOrderInvoice();
}
