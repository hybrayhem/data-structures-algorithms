package urban_planner;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StreetArray {
    private Building[] buildings = { null };
    int size = 0;

    public StreetArray() {
        // Intentionally left empty
    }

    
    /** 
     * @param index
     * @return Building
     */
    public Building getBuilding(int index){
        if(index > 0 && index < size){
            return buildings[index];
        }
        return null;
    }

    /**
     * @return int
     */
    public int buildingNumber() {
        int num = 0;
        for (int i = 0; buildings[i] != null; i++) {
            num++;
        }
        return num;
    }

    /**
     * @param building
     * @return Building[]
     */
    public void add(Building building) {
        // int size = buildingNumber();
        Building[] tempStreet = new Building[size + 2];
        for (int i = 0; i < size; i++) {
            tempStreet[i] = this.buildings[i];
        }
        tempStreet[size] = building; // add new element
        tempStreet[size + 1] = null; // null value as end indicator

        this.buildings = tempStreet;
        size++;
    }

    /**
     * @param index
     */
    public void delete(int index) {
        // int size = buildingNumber();
        if (index > size - 1)
            throw new IndexOutOfBoundsException("Index not exists in street.");

        for (int i = index; i < size; i++) {
            buildings[i] = buildings[i + 1];
        }
        size--;
    }

    public void listBuildings() {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + buildings[i].toString());
        }
    }

    /**
     * @return int
     */
    public int maxStreetHeigth() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (buildings[i].getHeight() > res)
                res = buildings[i].getHeight();
        }
        return res;
    }

    /**
     * @return int
     */
    public int maxStreetLength() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (buildings[i].getPosition() + buildings[i].getLength() > res)
                res = buildings[i].getPosition() + buildings[i].getLength();
        }
        return res;
    }

    /**
     * @return int[][]
     */
    public int[][] streetViewMatrix() {
        int[][] streetView = new int[maxStreetHeigth()][maxStreetLength()];
        for (int j = 0; j < maxStreetHeigth(); j++) {
            for (int i = 0; i < maxStreetLength(); i++) {
                streetView[j][i] = 3;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < buildings[i].getHeight(); j++) {
                for (int k = 0; k < buildings[i].getLength(); k++) {
                    int currentVal = streetView[j + maxStreetHeigth() - buildings[i].getHeight()][k
                            + buildings[i].getPosition()];
                    int newVal = buildings[i].viewMatrix[j][k];
                    if (currentVal == 2 || currentVal == 3)
                        streetView[j + maxStreetHeigth() - buildings[i].getHeight()][k
                                + buildings[i].getPosition()] = newVal;
                }
            }
        }

        return streetView;
    }

    /**
     * @return int[][]
     */
    public int[][] silhouetteViewMatrix() {
        int[][] streetView = new int[maxStreetHeigth()][maxStreetLength()];
        for (int j = 0; j < maxStreetHeigth(); j++) {
            for (int i = 0; i < maxStreetLength(); i++) {
                streetView[j][i] = 3;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < buildings[i].getHeight(); j++) {
                for (int k = 0; k < buildings[i].getLength(); k++) {
                    streetView[j + maxStreetHeigth() - buildings[i].getHeight()][k
                            + buildings[i].getPosition()] = buildings[i].viewMatrix[j][k];
                }
            }
        }

        return streetView;
    }

    /**
     * @param viewMatrix
     */
    public void printViewMatrix(int[][] viewMatrix) {
        try {
            PrintStream out = new PrintStream(System.out, true, "UTF-8");

            for (int j = 0; j < maxStreetHeigth(); j++) {
                System.out.printf("%-3d|", maxStreetHeigth() - j - 1); // height column
                for (int i = 0; i < maxStreetLength(); i++) {
                    if (viewMatrix[j][i] == 3 || viewMatrix[j][i] == 2) {
                        System.out.print("   ");
                    } else if (viewMatrix[j][i] == 0) {
                        out.print("\u22c4  "); // for corners
                    } else if (viewMatrix[j][i] == 1) {
                        out.print("\u2022  "); // for borders
                    }
                }
                System.out.print("\n");
            }
            // footer line
            System.out.print("    ");
            for (int i = 0; i < maxStreetLength(); i++) {
                System.out.printf("___", i);
            }
            // footer numbers
            System.out.print("\n    ");
            for (int i = 0; i < maxStreetLength(); i++) {
                System.out.printf("%-2d ", i);
            }

            System.out.print("\n");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param viewMatrix
     * @return int
     */
    public int emptyLand(int[][] viewMatrix) {
        int res = 0;
        for (int i = 0; i < maxStreetLength(); i++) {
            // count spaces on land
            if (viewMatrix[maxStreetHeigth() - 1][i] > 1)
                res++;
        }
        return res;
    }

    /**
     * @return int
     */
    public int playgroundNumber() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (buildings[i] instanceof Playground)
                res++;
        }
        return res;
    }

    /**
     * @return int
     */
    public int totalWithoutPlayground() {
        StreetArray tempStreet = new StreetArray();
        for (int i = 0; i < size; i++) {
            if (!(buildings[i] instanceof Playground))
                tempStreet.add(buildings[i]);
        }

        return maxStreetLength() - tempStreet.emptyLand(tempStreet.silhouetteViewMatrix());
    }
}
