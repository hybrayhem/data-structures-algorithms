package urban_planner;

import java.util.Arrays;
import java.util.Scanner;

import urban_planner.House;
import urban_planner.Office;
import urban_planner.Market;
import urban_planner.Playground;

class Main {
    public static void main(String[] args) {
        System.out.println("/* -------------------------------------------------------------------------- */\n" +
                "/*                              Initialize tests                              */\n" +
                "/* -------------------------------------------------------------------------- */\n");

        System.out.println("/* ---------------------------- House initialize ---------------------------- */");
        House house1 = new House(0, 3, 6, 4, "Halil", "Yellow");
        House house2 = new House(0, 3, 6, 4, "Halil", "Yellow"); // TODO: change with clone
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
        Office office2 = new Office(15, 10, 20, "Robotics", "Ibrahim"); // TODO: change with clone
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
        Market market2 = new Market(40, 10, 2, "9:00", "22:00", "Halil"); // TODO: change with clone
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
        Playground playground2 = new Playground(35, 10, 1); // TODO: change with clone
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


        office1.printViewMatrix();

    }
}
