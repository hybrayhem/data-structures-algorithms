package urban_planner;

import java.util.Scanner;

import urban_planner.StreetArray;
import urban_planner.StreetArrayList;
import urban_planner.StreetLinkedList;
import urban_planner.House;
import urban_planner.Office;
import urban_planner.Market;
import urban_planner.Playground;

class Main {
    
    /** 
     * @param msg
     * @param lower
     * @param upper
     * @return int
     */
    // secure input function that gets the int selection for menu with a
    // bullet-proof
    // error handling
    public static int get_selection(String msg, int lower, int upper) {
        boolean flag = false;
        int selection = 0;

        Scanner scanner = new Scanner(System.in);
        while (!flag) {
            if (!msg.isEmpty())
                System.out.printf("%s", msg);
            selection = scanner.nextInt();
            // System.out.println(scanner.next()); // remove unnecessary characters
            if (selection < lower || selection > upper) {
                System.out.printf("Invalid!\n");
                continue;
            }
            flag = true;
        }
        scanner.close();
        return selection;
    }


    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        // buildings = [[2,7,10],[3,4,15],[5,7,12],[15,5,10],[19,5,8]]
        System.out.println("/* -------------------------------------------------------------------------- */\n" +
                "/*                           Class Initialize Tests                           */\n" +
                "/* -------------------------------------------------------------------------- */\n");

        System.out.println("/* ---------------------------- House initialize ---------------------------- */");
        House house1 = new House(2, 6, 10, 4, "Halil", "Yellow");
        House house2 = new House();
        try {
            house2 = house1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException: can't copy house.");
        }
        System.out.println(
                "Compare houses: " + house1.toString() + " vs " + house2.toString() + " = " + house1.equals(house2));

        System.out.println("Modify house2 with setters. (created with clone from house1)");
        house2.setPosition(3);
        house2.setLength(3);
        house2.setHeight(15);
        house2.setOwner("Mehmet");

        System.out.println(
                "Compare houses: " + house1.toString() + " vs " + house2.toString() + " = " + house1.equals(house2));

        /* ---------------------------- Office initialize --------------------------- */
        System.out.println("\n\n/* ---------------------------- Office initialize ---------------------------- */");
        Office office1 = new Office(5, 7, 12, "Robotics", "Ibrahim");
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
        office2.setPosition(15);
        office2.setLength(5);
        office2.setHeight(10);
        office2.setJobType("Web Development");
        office2.setJobType("Web Development");
        office2.setOwner("Ilhan");

        System.out.println(
                "Compare offices: " + office1.toString() + " vs " + office2.toString() + " = "
                        + office1.equals(office2));

        /* ---------------------------- Market initialize --------------------------- */
        System.out.println("\n\n/* ---------------------------- Market initialize ---------------------------- */");
        Market market1 = new Market(19, 5, 8, "9:00", "22:00", "Halil");
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
        office2.setPosition(23);
        office2.setLength(6);
        office2.setHeight(18);
        market2.setOwner("Ayse");

        System.out.println(
                "Compare markets: " + market1.toString() + " vs " + market2.toString() + " = "
                        + market1.equals(market2));

        /* -------------------------- Playground initialize ------------------------- */
        System.out.println("\n\n/* ---------------------------- Playground initialize ---------------------------- */");
        Playground playground1 = new Playground(14, 3, 0);
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
        playground2.setPosition(32);
        playground2.setLength(5);
        playground2.setHeight(0);

        System.out.println(
                "Compare Playgrounds: " + playground1.toString() + " vs " + playground2.toString() + " = "
                        + playground1.equals(playground2));
        System.out.println("\n\n");

        /* -------------------------------------------------------------------------- */
        /* Street Test with Auto input */
        /* -------------------------------------------------------------------------- */
        // StreetArray street = new StreetArray();
        // StreetArrayList street = new StreetArrayList();
        StreetLinkedList street = new StreetLinkedList();

        System.out.println("/* ---------------------------- Initialize Street ---------------------------- */");
        street.add(house1);
        
        street.add(house2);
        System.out.println("Total number of buildings(after adding two house): " + street.buildingNumber());
        street.listBuildings();

        try {
            street.delete(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        System.out.println("Total number of buildings(delete first house): " + street.buildingNumber());
        street.listBuildings();

        System.out.println("\n\n/* -------------------------------- Edit mode ------------------------------- */");
        street.add(house1);
        street.add(office1);
        street.add(office2);
        street.add(market1);
        street.add(market2);
        street.add(playground1);
        street.add(playground2);
        System.out.println("Total number of buildings(add 7 more building): " + street.buildingNumber());

        System.out.println("\nStreet View\n");
        street.printViewMatrix(street.streetViewMatrix());
        
        try {
            street.delete(0);
            street.delete(4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        System.out.println("\nTotal number of buildings(delete house1 and office2): " + street.buildingNumber());
        System.out.println("\nStreet View\n");
        street.printViewMatrix(street.streetViewMatrix());
        
        System.out.println("\n\n/* -------------------------------- View mode ------------------------------- */");
        System.out.println("\nSilhouette View\n");
        street.printViewMatrix(street.silhouetteViewMatrix());

        System.out.println(
                "\nTotal remaining length of lands on the street: " + street.emptyLand(street.silhouetteViewMatrix()));
        System.out.println("\n\nList of buildings:");
        street.listBuildings();
        System.out.println("Number of playgrounds: " + street.playgroundNumber());

        int totalLen = street.maxStreetLength();
        int withoutPlaygroundLen = street.totalWithoutPlayground();
        System.out.println("Ratio of length of playgrounds: " + (totalLen - withoutPlaygroundLen) + " / " + totalLen);

        System.out.println("Total length of markets, houses or offices: " + withoutPlaygroundLen);

        /* ------------------------------- Focus Mode ------------------------------- */
        System.out.println("\n\n/* ---------------------------- Focus Mode ---------------------------- */");
        street.listBuildings();
        int selection = get_selection("Select a building to focus:", 1, street.buildingNumber());
        System.out.println("Focused: " + street.getBuilding(selection - 1).focus());

        /* -------------------------------------------------------------------------- */
        /* Street Test with User input */
        /* -------------------------------------------------------------------------- */

    }
}
