package MacDonalds.New;

/**
 Represents an Ala Carte Item
 Inherits from Menu Item class
 @author Dhruval Kothari
 @version 1.0
 @since 2021-11-09
  * */
public class Alacarte extends MenuItem {
    /**
     * The Category of the Ala Carte Item
     * */
    private Category category;

    /**
     * Creates an AlaCarte Item
     * @param name name of the Item
     * @param description description of the Item
     * @param price price of item
     * @param category Category of the Item
     * */
    Alacarte(String name,String description,float price, Category category){
        setName(name);
        setDescription(description);
        setPrice(price);
        this.category=category;
    }

    /**
     * Returns the category of this Ala Carte Item
     * */
    public Category getCategory() {
        return this.category;
    }


}
