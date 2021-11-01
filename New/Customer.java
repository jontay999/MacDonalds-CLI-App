package MacDonalds.New;

public class Customer extends Person {
    Order order;
    // Membership membership;

    Customer(){
        //
    }

    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name = n;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    
}
