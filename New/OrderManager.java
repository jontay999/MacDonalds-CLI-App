package MacDonalds.New;

/**
 Represents an interface for managing Orders
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public interface OrderManager {
    /**
     * Add a Set Item into the Order
     * */
    void addItem(Set item);

    /**
     * Add an AlaCarte Item into Order
     * */
    void addItem(Alacarte item);

    /**
     * Remove either a Set or Ala Carte Item from order
     * */
    void removeItem(int index, boolean isSet);

    /**
     * Print a Summary of the Order and its Items
     * */
    void viewOrder();

    /**
     * Print the Order Invoice including the price
     * */
    void printOrderInvoice();
}
