package MacDonalds.New;


enum Gender {MALE, FEMALE}
enum JobTitle {EMPLOYEE, MANAGER}

/**
 Represents a Staff working at the Restaurant
 @author Jonathan Tay
 @version 1.0
 @since 2021-11-09
  * */

public class Staff extends Person {
    /**
     * Gender of the Staff
     * */
    private Gender gender;

    /**
     * Job Title of the Staff
     * */
    private JobTitle jobTitle;

    /**
     * Create the Staff working in the Restaurant
     * @param name Name of the Staff
     * @param gender Gender of the Staff
     * @param jobTitle Job Title of the Staff
     * */
    Staff(String name, Gender gender, JobTitle jobTitle){
        this.name=name;
        this.gender=gender;
        this.jobTitle=jobTitle;
    }

    /**
     * Return the Gender of the Staff
     * */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Return the Job Title of the Staff
     * */
    public JobTitle getJobTitle() {
        return this.jobTitle;
    }

    /**
     * Print Staff Details
     * */
    public void printStaffInfo(){
        System.out.println("Name: "+ getName() + " | Gender: " + getGender() + " | Job Title: " + getJobTitle());
    }
    
}
