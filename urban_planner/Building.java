package urban_planner;

import java.util.Objects;

public abstract class Building {
    /** Start position of building in street */
    private int position;
    private int length;
    private int height;

    protected Building() {
        position = 0;
        length = 0;
        height = 0;
    }

    protected Building(int position, int length, int height) {
        this.position = position;
        this.length = length;
        this.height = height;
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
        this.length = length;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
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
        return "{" +
                " position=" + getPosition() + ", " +
                " length=" + getLength() + ", " +
                " height=" + getHeight() +
                "}";
    }


    // TODO: generate 2d view matrix for print
}
