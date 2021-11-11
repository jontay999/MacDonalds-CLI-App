package MacDonalds.New;

/**
 Represents an interface for managing Orders
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public interface OrderManager {
    /**
     * Print a Summary of the Order and its Items
     * */
    void viewOrder();

    /**
     * Print the Order Invoice including the price
     * */
    void printOrderInvoice();
}
