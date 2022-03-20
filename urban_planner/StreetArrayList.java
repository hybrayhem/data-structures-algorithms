package urban_planner;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StreetArrayList {
    private List<Building> buildings;
    private static int initialCapacity = 10;

    public StreetArrayList() {
        buildings = new ArrayList<>(initialCapacity);
    }

    
    /** 
     * @param index
     * @return Building
     */
    public Building getBuilding(int index) {
        if (index >= 0 && index < buildings.size()) {
            return buildings.get(index);
        }
        return null;
    }

    
    /** 
     * @return int
     */
    public int buildingNumber() {
        return buildings.size();
    }

    
    /** 
     * @param building
     */
    public void add(Building building) {
        buildings.add(building);
    }

    
    /** 
     * @param index
     */
    public void delete(int index) {
        buildings.remove(index);
    }

    public void listBuildings() {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println((i + 1) + ". " + buildings.get(i).toString());
        }
    }

    
    /** 
     * @return int
     */
    public int maxStreetHeigth() {
        int res = 0;
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getHeight() > res)
                res = buildings.get(i).getHeight();
        }
        return res;
    }

    
    /** 
     * @return int
     */
    public int maxStreetLength() {
        int res = 0;
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getPosition() + buildings.get(i).getLength() > res)
                res = buildings.get(i).getPosition() + buildings.get(i).getLength();
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
        for (int i = 0; i < buildings.size(); i++) {
            for (int j = 0; j < buildings.get(i).getHeight(); j++) {
                for (int k = 0; k < buildings.get(i).getLength(); k++) {
                    int currentVal = streetView[j + maxStreetHeigth() - buildings.get(i).getHeight()][k
                            + buildings.get(i).getPosition()];
                    int newVal = buildings.get(i).viewMatrix[j][k];
                    if (currentVal == 2 || currentVal == 3)
                        streetView[j + maxStreetHeigth() - buildings.get(i).getHeight()][k
                                + buildings.get(i).getPosition()] = newVal;
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
        for (int i = 0; i < buildings.size(); i++) {
            for (int j = 0; j < buildings.get(i).getHeight(); j++) {
                for (int k = 0; k < buildings.get(i).getLength(); k++) {
                    streetView[j + maxStreetHeigth() - buildings.get(i).getHeight()][k
                            + buildings.get(i).getPosition()] = buildings.get(i).viewMatrix[j][k];
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
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i) instanceof Playground)
                res++;
        }
        return res;
    }

    
    /** 
     * @return int
     */
    public int totalWithoutPlayground() {
        StreetArrayList tempStreet = new StreetArrayList();
        for (int i = 0; i < buildings.size(); i++) {
            if (!(buildings.get(i) instanceof Playground))
                tempStreet.add(buildings.get(i));
        }

        return maxStreetLength() - tempStreet.emptyLand(tempStreet.silhouetteViewMatrix());
    }
}
