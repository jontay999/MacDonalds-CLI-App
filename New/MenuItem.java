package MacDonalds.New;

/**
 Represents a MenuControl Interface for printing menus
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public abstract class MenuItem {
    /**
     * name of MenuItem
     * */
    private String name;

    /**
     * description of MenuItem
     * */
    private String description;

    /**
     * the price of the MenuItem
     * */
    private float price;

    /**
     * Returns the Name of the MenuItem
     * */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the MenuItem
     * @param name name of MenuItem
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the MenuItem
     * */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description of the MenuItem
     * @param description description of MenuItem
     * */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the MenuItem
     * */
    public float getPrice() {
        return this.price;
    }

    /**
     * Set the price of the MenuItem
     * @param price price of MenuItem
     * */
    public void setPrice(float price) {
        this.price = price;
    }

}
