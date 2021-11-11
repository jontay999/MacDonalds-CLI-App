package MacDonalds.New;

/**
 Represents a Person
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public abstract class Person {
    String name;
    int id;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
}

