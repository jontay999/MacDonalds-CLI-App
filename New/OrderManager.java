package MacDonalds.New;

public interface OrderManager {
    public void addItem(Set item);
    public void addItem(Alacarte item);
    public void removeItem();
    public void viewOrder();
    public void printOrderInvoice();
}
