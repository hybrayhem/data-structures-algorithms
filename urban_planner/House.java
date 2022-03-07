package urban_planner;

import java.util.Objects;

public class House extends Building {
    /** Number of rooms in house */
    private int room;
    /** Owner's name */
    private String owner;
    private String color;

    public House() {
        super();
        room = 0;
        owner = "Anonymous";
        color = "None";
    }

    public House(int position, int length, int height, int room, String owner, String color) {
        super(position, length, height);
        this.room = room;
        this.owner = owner;
        this.color = color;
    }

    public int getRoom() {
        return this.room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof House)) {
            return false;
        }
        House house = (House) o;
        return super.equals(house) && (room == house.room && owner.equals(house.owner) && color.equals(house.color));
    }

    @Override
    public int hashCode() {
        return (31 * super.hashCode() + Objects.hash(room, owner, color));
    }

    @Override
    public String toString() {
        return super.toString() +
                "room=" + getRoom() + ", " +
                "owner=" + getOwner() + ", " +
                "color=" + getColor() +
                " }";
    }

}
