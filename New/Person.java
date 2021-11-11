package MacDonalds.New;

/**
 Represents a Person
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public abstract class Person {
    /**
     * The name of the Person
     * */
    String name;

    /**
     * Get the name of the Person
     * */
    public String getName(){
        return this.name;
    }

    /**
     * Set the name of the Person
     * */
    public void setName(String name){
        this.name=name;
    }
}

