package urban_planner;

import java.util.Scanner;

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
     * @param street
     * @return int
     */
    public static int buildingNumber(Building[] street) {
        int num = 0;
        for (int i = 0; street[i] != null; i++) {
            num++;
        }
        return num;
    }

    
    /** 
     * @param street
     * @param building
     * @return Building[]
     */
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

    
    /** 
     * @param street
     * @param index
     */
    public static void delete(Building[] street, int index) {
        int size = buildingNumber(street);
        if (index > size - 1)
            throw new IndexOutOfBoundsException("Index not exists in street.");

        for (int i = index; i < size; i++) {
            street[i] = street[i + 1];
        }
    }

    
    /** 
     * @param street
     */
    public static void listBuildings(Building[] street) {
        for (int i = 0; i < buildingNumber(street); i++) {
            System.out.println((i + 1) + ". " + street[i].toString());
        }
    }

    
    /** 
     * @param street
     * @return int
     */
    public static int maxStreetHeigth(Building[] street) {
        int res = 0;
        for (int i = 0; i < buildingNumber(street); i++) {
            if (street[i].getHeight() > res)
                res = street[i].getHeight();
        }
        return res;
    }

    
    /** 
     * @param street
     * @return int
     */
    public static int maxStreetLength(Building[] street) {
        int res = 0;
        for (int i = 0; i < buildingNumber(street); i++) {
            if (street[i].getPosition() + street[i].getLength() > res)
                res = street[i].getPosition() + street[i].getLength();
        }
        return res;
    }

    
    /** 
     * @param street
     * @return int[][]
     */
    public static int[][] streetViewMatrix(Building[] street) {
        int[][] streetView = new int[maxStreetHeigth(street)][maxStreetLength(street)];
        for (int j = 0; j < maxStreetHeigth(street); j++) {
            for (int i = 0; i < maxStreetLength(street); i++) {
                streetView[j][i] = 3;
            }
        }
        for (int i = 0; i < buildingNumber(street); i++) {
            for (int j = 0; j < street[i].getHeight(); j++) {
                for (int k = 0; k < street[i].getLength(); k++) {
                    int currentVal = streetView[j + maxStreetHeigth(street) - street[i].getHeight()][k
                            + street[i].getPosition()];
                    int newVal = street[i].viewMatrix[j][k];
                    if (currentVal == 2 || currentVal == 3)
                        streetView[j + maxStreetHeigth(street) - street[i].getHeight()][k
                                + street[i].getPosition()] = newVal;
                }
            }
        }

        return streetView;
    }

    
    /** 
     * @param street
     * @return int[][]
     */
    public static int[][] silhouetteViewMatrix(Building[] street) {
        int[][] streetView = new int[maxStreetHeigth(street)][maxStreetLength(street)];
        for (int j = 0; j < maxStreetHeigth(street); j++) {
            for (int i = 0; i < maxStreetLength(street); i++) {
                streetView[j][i] = 3;
            }
        }
        for (int i = 0; i < buildingNumber(street); i++) {
            for (int j = 0; j < street[i].getHeight(); j++) {
                for (int k = 0; k < street[i].getLength(); k++) {
                    streetView[j + maxStreetHeigth(street) - street[i].getHeight()][k
                            + street[i].getPosition()] = street[i].viewMatrix[j][k];
                }
            }
        }

        return streetView;
    }

    
    /** 
     * @param viewMatrix
     * @param street
     */
    public static void printViewMatrix(int[][] viewMatrix, Building[] street) {
        for (int j = 0; j < maxStreetHeigth(street); j++) {
            for (int i = 0; i < maxStreetLength(street); i++) {
                if (viewMatrix[j][i] == 3 || viewMatrix[j][i] == 2) {
                    System.out.print(" ");
                } else if (viewMatrix[j][i] == 0) {
                    System.out.print("*");
                } else if (viewMatrix[j][i] == 1) {
                    System.out.print("#");
                }
            }
            System.out.print("\n");
        }
    }

    
    /** 
     * @param viewMatrix
     * @param street
     * @return int
     */
    public static int emptyLand(int[][] viewMatrix, Building[] street) {
        int res = 0;
        for (int i = 0; i < maxStreetLength(street); i++) {
            // count spaces on land
            if (viewMatrix[maxStreetHeigth(street) - 1][i] > 1)
                res++;
        }
        return res;
    }

    
    /** 
     * @param street
     * @return int
     */
    public static int playgroundNumber(Building[] street) {
        int res = 0;
        for (int i = 0; i < buildingNumber(street); i++) {
            if (street[i] instanceof Playground)
                res++;
        }
        return res;
    }

    
    /** 
     * @param street
     * @return int
     */
    public static int totalWithoutPlayground(Building[] street) {
        Building[] tempStreet = { null };
        for (int i = 0; i < buildingNumber(street); i++) {
            if (!(street[i] instanceof Playground))
                tempStreet = add(tempStreet, street[i]);
        }

        return maxStreetLength(tempStreet) - emptyLand(silhouetteViewMatrix(tempStreet), tempStreet);
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("/* -------------------------------------------------------------------------- */\n" +
                "/*                           Class Initialize Tests                           */\n" +
                "/* -------------------------------------------------------------------------- */\n");

        System.out.println("/* ---------------------------- House initialize ---------------------------- */");
        House house1 = new House(0, 4, 6, 4, "Halil", "Yellow");
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
        house2.setPosition(6);
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
        office2.setPosition(20);
        office2.setHeight(30);
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
        market2.setPosition(45);
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
        playground2.setPosition(55);

        System.out.println(
                "Compare Playgrounds: " + playground1.toString() + " vs " + playground2.toString() + " = "
                        + playground1.equals(playground2));
        System.out.println("\n\n");

        /* -------------------------------------------------------------------------- */
        /* Street Test with Auto input */
        /* -------------------------------------------------------------------------- */
        Building[] street = { null };

        System.out.println("/* ---------------------------- Initialize Street ---------------------------- */");
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

        System.out.println("\n\n/* -------------------------------- Edit mode ------------------------------- */");
        street = add(street, house1);
        street = add(street, office1);
        street = add(street, office2);
        street = add(street, market1);
        street = add(street, market2);
        street = add(street, playground1);
        street = add(street, playground2);
        System.out.println("Total number of buildings(add 7 more building): " + buildingNumber(street));

        System.out.println("\nStreet View\n");
        printViewMatrix(streetViewMatrix(street), street);

        try {
            delete(street, 0);
            delete(street, 4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        System.out.println("\nTotal number of buildings(delete house1 and office2): " + buildingNumber(street));
        System.out.println("\nStreet View\n");
        printViewMatrix(streetViewMatrix(street), street);

        System.out.println("\n\n/* -------------------------------- View mode ------------------------------- */");
        System.out.println("\nSilhouette View\n");
        printViewMatrix(silhouetteViewMatrix(street), street);

        System.out.println(
                "\nTotal remaining length of lands on the street: " + emptyLand(silhouetteViewMatrix(street), street));
        System.out.println("\n\nList of buildings:");
        listBuildings(street);
        System.out.println("Number of playgrounds: " + playgroundNumber(street));
        System.out.println("Ratio of length of playgrounds: " + (maxStreetLength(street) - emptyLand(silhouetteViewMatrix(street), street) - totalWithoutPlayground(street)) + " / " + maxStreetLength(street));

        System.out.println("Total length of markets, houses or offices: " + totalWithoutPlayground(street));

        /* ------------------------------- Focus Mode ------------------------------- */

        /* -------------------------------------------------------------------------- */
        /* Street Test with User input */
        /* -------------------------------------------------------------------------- */

    }
}
