package MacDonalds.New;

import java.time.LocalTime;

public class InitRestaurant {
    LocalTime openingTime = LocalTime.parse("09:00");
    LocalTime closingTime = LocalTime.parse("18:00");
    Restaurant MacDonalds = new Restaurant("REP-Donalds", "Banyanyan Hall", openingTime, closingTime);

    InitRestaurant(){
        //add tables, 5 tables each of 2,4,6,8 capacities
        for(int i = 0;i<20;i++){
            int capacity = ((i/5)+1)*2;
            MacDonalds.addTable(capacity);
        }
        MacDonalds.addTable(10);

        String[] memberships = {"Bronze", "Silver", "Gold"};
        for (int i = 1;i<=memberships.length;i++){
            Membership newMembership = new Membership(memberships[i-1], i*0.05);
            MacDonalds.addMembership(newMembership);
        }

        //add staff
        String[] names = new String[]{"Cady", "Grace", "Rihanna", "Taylor", "Dhruval", "Riley", "Marcus", "Pitbull"};
        for(int i = 0;i<names.length;i++){
            Gender gender = i > 4 ? Gender.MALE : Gender.FEMALE;
            JobTitle role = i > 6 ? JobTitle.MANAGER : JobTitle.EMPLOYEE;
            MacDonalds.addStaff(names[i], role, gender);
        }

        //add menu
        MacDonalds.addMenu(new InitMenu().getMenu(0));
    }

    public Restaurant getRestaurant(){
        return this.MacDonalds;
    }
}
