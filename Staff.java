package MacDonalds;

public class Staff {
    private String name;
    private String gender;
    private int staffId;
    private String jobTitle;

    public Staff (String n,  String g, int  id, String title){
        name = n;
        gender = g;
        staffId = id;
        jobTitle = title;
    }

    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getStaffId() { return staffId; }
    public String getJobTitle() { return jobTitle; }

    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setStaffId(int staffId) { this.staffId = staffId; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
}
