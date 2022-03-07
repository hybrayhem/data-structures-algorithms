package urban_planner;

import java.util.Objects;

public abstract class Building {
    /** Start position of building in street */
    private int position;
    private int length;
    private int height;
    private int[][] viewMatrix;

    protected Building() {
        position = 0;
        length = 0;
        height = 0;
        updateViewMatrix();
    }

    protected Building(int position, int length, int height) {
        this.position = position;
        this.length = length;
        this.height = height;
        updateViewMatrix();
    }

    public int getPosition() {
        return this.position;
    }

    // TODO: error handling in setters
    public void setPosition(int position) {
        this.position = position;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        int oldLength = this.length;
        this.length = length;

        if (length != oldLength)
            updateViewMatrix();
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        int oldHeight = this.height;
        this.height = height;

        if (height != oldHeight)
            updateViewMatrix();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Building)) {
            return false;
        }
        Building building = (Building) o;
        return position == building.position && length == building.length && height == building.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, length, height);
    }

    @Override
    public String toString() {
        return "{ " +
                " position=" + getPosition() + ", " +
                " length=" + getLength() + ", " +
                " height=" + getHeight() + ", ";
    }

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
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < length; i++) {
                System.out.print(viewMatrix[j][i]);
            }
            System.out.print("\n");
        }
    }
}
