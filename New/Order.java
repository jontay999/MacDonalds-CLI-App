package MacDonalds.New;

import java.time.LocalDateTime;

public class Order implements OrderManager {
    Customer customer;
    Staff staff;
    LocalDateTime dateTime;
    int tableId;

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTableId() {
        return this.tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public void addItem(Set item) {
        // TODO Auto-generated method stub
        
    }

    public void addItem(Alacarte item) {
        // TODO Auto-generated method stub
        
    }

    public void removeItem() {
        // TODO Auto-generated method stub
        
    }

    public void viewOrder() {
        // TODO Auto-generated method stub
        
    }

    public void printOrderInvoice() {
        // TODO Auto-generated method stub
        
    }
    
}
