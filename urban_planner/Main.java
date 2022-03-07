package urban_planner;

import java.util.Scanner;

import urban_planner.House;
import urban_planner.Office;
import urban_planner.Market;
import urban_planner.Playground;

class Main {
    public static int buildingNumber(Building[] street) {
        int num = 0;
        for (int i = 0; street[i] != null; i++) {
            num++;
        }
        return num;
    }

    public static Building[] add(Building[] street, Building building) {
        int size = buildingNumber(street);
        Building[] tempStreet = new Building[size + 2];
        for (int i = 0; i < size; i++) {
            tempStreet[i] = street[i];
        }
        tempStreet[size] = building; // add new element
        tempStreet[size + 1] = null; // null value as end indicator

        return tempStreet;
    }

    public static void delete(Building[] street, int index) {
        int size = buildingNumber(street);
        if(index > size - 1)
            throw new IndexOutOfBoundsException("Index not exists in street.");
        
        for (int i = index; i < size; i++) {
            street[i] = street[i+1];
        }
    }
    
    public static void listBuildings(Building[] street){
        for (int i = 0; i < buildingNumber(street); i++) {
            System.out.println(street[i].toString());
        }
    }
    //print street
    // get_selection
    // streetview matrix max position max heiht lazim
    // silhouette matrix
    // print matrix

    public static void main(String[] args) {
        System.out.println("/* -------------------------------------------------------------------------- */\n" +
                "/*                           Class Initialize Tests                           */\n" +
                "/* -------------------------------------------------------------------------- */\n");

        System.out.println("/* ---------------------------- House initialize ---------------------------- */");
        House house1 = new House(0, 3, 6, 4, "Halil", "Yellow");
        House house2 = new House();
        try {
            house2 = house1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException: can't copy house.");
        }
        System.out.println(
                "Compare houses: " + house1.toString() + " vs " + house2.toString() + " = " + house1.equals(house2));

        System.out.println("Modify house2 with setters. (created with clone from house1)");
        house2.setHeight(12);
        house2.setOwner("Mehmet");

        System.out.println(
                "Compare houses: " + house1.toString() + " vs " + house2.toString() + " = " + house1.equals(house2));

        /* ---------------------------- Office initialize --------------------------- */
        System.out.println("\n\n/* ---------------------------- Office initialize ---------------------------- */");
        Office office1 = new Office(15, 10, 20, "Robotics", "Ibrahim");
        Office office2 = new Office();
        try {
            office2 = office1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException: can't copy office.");
        }
        System.out.println(
                "Compare offices: " + office1.toString() + " vs " + office2.toString() + " = "
                        + office1.equals(office2));

        System.out.println("Modify office2 with setters. (created with clone from office1)");
        office2.setJobType("Web Development");
        office2.setOwner("Ilhan");

        System.out.println(
                "Compare offices: " + office1.toString() + " vs " + office2.toString() + " = "
                        + office1.equals(office2));

        /* ---------------------------- Market initialize --------------------------- */
        System.out.println("\n\n/* ---------------------------- Market initialize ---------------------------- */");
        Market market1 = new Market(40, 10, 2, "9:00", "22:00", "Halil");
        Market market2 = new Market();
        try {
            market2 = market1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException: can't copy market.");
        }
        System.out.println(
                "Compare markets: " + market1.toString() + " vs " + market2.toString() + " = "
                        + market1.equals(market2));

        System.out.println("Modify market2 with setters. (created with clone from market1)");
        market2.setHeight(3);
        market2.setOwner("Ayse");

        System.out.println(
                "Compare markets: " + market1.toString() + " vs " + market2.toString() + " = "
                        + market1.equals(market2));

        /* -------------------------- Playground initialize ------------------------- */
        System.out.println("\n\n/* ---------------------------- Playground initialize ---------------------------- */");
        Playground playground1 = new Playground(35, 10, 1);
        Playground playground2 = new Playground();
        try {
            playground2 = playground1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException: can't copy playground.");
        }
        System.out.println(
                "Compare Playgrounds: " + playground1.toString() + " vs " + playground2.toString() + " = "
                        + playground1.equals(playground2));

        System.out.println(
                "Modify Playground2 (created with clone from Playground1) with setters. (created with clone from Playground1)");
        playground2.setLength(15);

        System.out.println(
                "Compare Playgrounds: " + playground1.toString() + " vs " + playground2.toString() + " = "
                        + playground1.equals(playground2));
        System.out.println("\n\n");

        /* -------------------------------------------------------------------------- */
        /*                         Street Test with Auto input                        */
        /* -------------------------------------------------------------------------- */
        Building[] street = { null };

        
        /* ------------------------------- Initialize ------------------------------- */
        street = add(street, house1);
        street = add(street, house2);
        System.out.println("Total number of buildings(after adding two house): " + buildingNumber(street));
        listBuildings(street);
        
        try {
            delete(street, 0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        System.out.println("Total number of buildings(delete first house): " + buildingNumber(street));
        listBuildings(street);


        /* -------------------------------- Edit mode ------------------------------- */
        /* -------------------------------- View Mode ------------------------------- */

        /* -------------------------------------------------------------------------- */
        /*                          Street Test with User input                       */
        /* -------------------------------------------------------------------------- */

    }
}
