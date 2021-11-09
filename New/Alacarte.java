package MacDonalds.New;

public class Alacarte extends MenuItem {
    private Category category;
    Alacarte(String name,String description,float price, Category category){
        setName(name);
        setDescription(description);
        setPrice(price);
        this.category=category;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
