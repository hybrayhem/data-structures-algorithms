package urban_planner;

import java.util.Objects;

public abstract class Building implements Cloneable {
    /** Start position of building in street */
    private int position;
    private int length;
    private int height;
    protected int[][] viewMatrix;

    protected Building() {
        position = 0;
        length = 0;
        height = 0;
        // updateViewMatrix();
    }

    protected Building(int position, int length, int height) {
        this.position = position;
        this.length = length + 1;
        this.height = height + 1;
        updateViewMatrix();
    }

    
    /** 
     * @return int
     */
    public int getPosition() {
        return this.position;
    }

    
    /** 
     * @param position
     */
    // TODO: error handling in setters
    public void setPosition(int position) {
        this.position = position;
    }

    
    /** 
     * @return int
     */
    public int getLength() {
        return this.length;
    }

    
    /** 
     * @param length
     */
    public void setLength(int length) {
        int oldLength = this.length;
        this.length = length + 1;

        if (length != oldLength)
            updateViewMatrix();
    }

    
    /** 
     * @return int
     */
    public int getHeight() {
        return this.height;
    }

    
    /** 
     * @param height
     */
    public void setHeight(int height) {
        int oldHeight = this.height;
        this.height = height + 1;

        if (height != oldHeight)
            updateViewMatrix();
    }


    
    /** 
     * @param o
     * @return String
     */
    /**
     * Abstract method overriden in subclasses
     * @return value of focus field, differs by instance type
     */
    public abstract String focus();

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Building)) {
            return false;
        }
        Building building = (Building) o;
        // deep compare
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < length; i++) {
                if (building.viewMatrix[j][i] != this.viewMatrix[j][i])
                    return false;
            }
        }
        return position == building.position && length == building.length && height == building.height;
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(position, length, height);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{ " +
                " position=" + getPosition() + ", " +
                " length=" + (getLength() - 1) + ", " +
                " height=" + (getHeight() - 1) + ", ";
    }

    
    /** 
     * @return int[][]
     */
    public int[][] getViewMatrix() {
        return this.viewMatrix;
    }

    /**
     * Creates/updates the presentation of building, will be used in print street
     * 
     * Corner: 0
     * Borders: 1
     * Spaces: 2
     */
    public int[][] updateViewMatrix() {
        viewMatrix = new int[height][length];

        // fill with 0
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < length; i++) {
                viewMatrix[j][i] = 2;
            }
        }

        // set top and bottom border
        for (int i = 1; i < length - 1; i++) {
            viewMatrix[0][i] = 1;
            viewMatrix[height - 1][i] = 1;
        }

        // set right and left border
        for (int i = 1; i < height - 1; i++) {
            viewMatrix[i][0] = 1;
            viewMatrix[i][length - 1] = 1;
        }

        // set corners
        viewMatrix[0][0] = 0;
        viewMatrix[0][length - 1] = 0;
        viewMatrix[height - 1][0] = 0;
        viewMatrix[height - 1][length - 1] = 0;
        return this.viewMatrix;
    }

    /** print for debug updateViewMatrix function */
    public void printViewMatrix() {
        System.out.println("\n");
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < length; i++) {
                System.out.print(viewMatrix[j][i]);
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}
