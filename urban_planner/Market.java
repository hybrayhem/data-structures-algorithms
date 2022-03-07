package urban_planner;

import java.util.Objects;

public class Market extends Building {
    private String openingTime;
    private String closingTime;
    private String owner;

    public Market() {
        super();
        openingTime = "None";
        closingTime = "None";
        owner = "Anonymous";
    }

    public Market(int position, int length, int height, String openingTime, String closingTime, String owner) {
        super(position, length, height);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.owner = owner;
    }

    public String getOpeningTime() {
        return this.openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return this.closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Market openingTime(String openingTime) {
        setOpeningTime(openingTime);
        return this;
    }

    public Market closingTime(String closingTime) {
        setClosingTime(closingTime);
        return this;
    }

    public Market owner(String owner) {
        setOwner(owner);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Market)) {
            return false;
        }
        Market market = (Market) o;
        return super.equals(market) && (openingTime.equals(market.openingTime) && closingTime.equals(market.closingTime)
                && owner.equals(market.owner));
    }

    @Override
    public int hashCode() {
        return (31 * super.hashCode() + Objects.hash(openingTime, closingTime, owner));
    }

    @Override
    public String toString() {
        return super.toString() +
                "openingTime=" + getOpeningTime() + ", " +
                "closingTime=" + getClosingTime() + ", " +
                "owner=" + getOwner() +
                " }";
    }

}
