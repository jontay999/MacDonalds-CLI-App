package MacDonalds.New;

enum Gender {MALE, FEMALE};
enum JobTitle {EMPLOYEE, MANAGER}

public class Staff extends Person {
    Gender gender;
    JobTitle jobTitle;

    Staff(String name, Gender gender, JobTitle jobTitle){
        //dhruval can continue here
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

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public JobTitle getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    
}
