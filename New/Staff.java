package MacDonalds.New;

enum Gender {MALE, FEMALE};
enum JobTitle {EMPLOYEE, MANAGER}

public class Staff extends Person {
    private Gender gender;
    private JobTitle jobTitle;

    Staff(String name, Gender gender, JobTitle jobTitle){
        this.name=name;
        this.gender=gender;
        this.jobTitle=jobTitle;
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

    public void printStaffInfo(){
        System.out.println("Name: "+ getName() + " | Gender: " + getGender() + " | Job Title: " + getJobTitle());
    }
    
}
