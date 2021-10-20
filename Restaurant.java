package MacDonalds;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private Table[] allTables;
    private Staff[] allStaff;
    private Menu[] allMenus;
    private Reservation[] allReservations;
    private Order[] allOrders;
    private String description;
    private String location;
    private String name;
    private LocalTime closingTime;
    private LocalTime openingTime;

    Restaurant(String name,String description, String location, LocalTime openingTime, LocalTime closingTime){
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.description = description;
        this.location = location;
    }

    //for month
    private void generateRevenueReport(int year, int month){

    }

    //for daily
    private void generateRevenueReport(LocalDate selectedDate){
        Map<String, HashMap<String, Double>> alaCarteSales = new  HashMap<String, HashMap<String, Double>>();
        Map<String, HashMap<String, Double>> promoSales =  new  HashMap<String, HashMap<String, Double>>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        for(int i=0;i<allOrders.length;i++){
            if(allOrders[i].dateTime.toLocalDate().equals(selectedDate)){
                for(int j = 0;j<allOrders[i].allMenuItems.length;j++){
                    updateHashMap(allOrders[i].allMenuItems[j], alaCarteSales);
                }
                for(int j = 0;j<allOrders[i].allPromoSets.length;j++){
                    updateHashMap(allOrders[i].allPromoSets[j], promoSales);
                }
            }
        }

        System.out.println("Revenue Report for "+selectedDate.format(formatter));
        System.out.println("===============================");
        printRevenueReport(alaCarteSales, promoSales);
    }

    //for monthly
    private void generateRevenueReport(int year, int month){
        Map<String, HashMap<String, Double>> alaCarteSales = new  HashMap<String, HashMap<String, Double>>();
        Map<String, HashMap<String, Double>> promoSales =  new  HashMap<String, HashMap<String, Double>>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL yyyy");
        for(int i=0;i<allOrders.length;i++){
            if(allOrders[i].dateTime.getMonthValue() == month && allOrders[i].dateTime.getYear() == year){
                for(int j = 0;j<allOrders[i].allMenuItems.length;j++){
                    updateHashMap(allOrders[i].allMenuItems[j], alaCarteSales);
                }
                for(int j = 0;j<allOrders[i].allPromoSets.length;j++){
                    updateHashMap(allOrders[i].allPromoSets[j], promoSales);
                }
            }
        }

        System.out.printf("Revenue Report for %d/%d%n", month, year);
        System.out.println("===============================");
        printRevenueReport(alaCarteSales, promoSales);
    }


    private void printRevenueReport(Map<String, HashMap<String, Double>> alaCarteSales, Map<String, HashMap<String, Double>> promoSales){
        double alaCarteRevenue = 0;
        double promoRevenue = 0;
        System.out.println("Ala Carte Sales");
        alaCarteRevenue = printCategorySales(alaCarteSales);
        System.out.println("===============================");
        System.out.println("Promo Set Sales");
        promoRevenue = printCategorySales(promoSales);
        System.out.println("===============================");
        System.out.printf("Total Ala Carte Revenue: %.2f%n", alaCarteRevenue);
        System.out.printf("Total Promo Set Revenue: %.2f%n", promoRevenue);
        System.out.println("===============================");
        System.out.printf("Total Revenue : %.2f%n", alaCarteRevenue+promoRevenue);
    }



    private double printCategorySales(Map<String, HashMap<String, Double>> salesCategory){
        double totalSales = 0;
        System.out.println("-------------------------------");
        for (Map.Entry<String, HashMap<String, Double>> entry : salesCategory.entrySet()) {
            String category = entry.getKey();
            HashMap<String, Double> categoryMap = entry.getValue();
            System.out.println("  " + category + ":");
            for(Map.Entry<String, Double> item: categoryMap.entrySet()){
                System.out.printf("    %s: %.2f%n", item.getKey(), item.getValue());
                totalSales += item.getValue();
            }
        }
        return totalSales;
    }

    private void updateHashMap(MenuItem currItem,  HashMap<String, HashMap<String, Double>> salesCategory){
        String category = currItem.getCategory();
        String itemName = currItem.getName();
        double itemPrice = currItem.getPrice();

        //if category doesn't exist yet, create category
        if(!salesCategory.containsKey(category)){
            salesCategory.put(category, new HashMap<String, Double>());
        }

        //increment totalSales for item so far
        Map<String, Double> subCategory = salesCategory.get(category);
        double currTotal = subCategory.containsKey(itemName) ? subCategory.get(itemName) : 0;
        subCategory.put(itemName, currTotal+itemPrice);
    }

    public ArrayList<LocalTime> getAvailableTime(LocalDate reservationDate, int pax){
        ArrayList<LocalTime> availableTimes = generateAllPossibleTimes();
        for(int i = 0;i<allReservations.length;i++){
            LocalDateTime reservationDateTime = allReservations[i].reservationTime;
            if(reservationDateTime.toLocalDate().equals(reservationDate)){
                availableTimes.remove(reservationDateTime.toLocalTime());
            }
        }
        return availableTimes;
    }

    private ArrayList<LocalTime> generateAllPossibleTimes(){
        ArrayList<LocalTime> allPossibleTimes = new ArrayList<LocalTime>();
        LocalTime currTime = getOpeningTime();
        while(currTime.isBefore(getClosingTime())){
            allPossibleTimes.add(currTime);
            currTime.plusMinutes(30);
        }
        return allPossibleTimes;
    }

    public boolean isOpen(LocalTime checkingTime){
        return checkingTime.isBefore(getClosingTime()) && checkingTime.isAfter(getOpeningTime());
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
