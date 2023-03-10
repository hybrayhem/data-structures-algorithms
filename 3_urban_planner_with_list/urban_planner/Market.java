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

    
    /** 
     * @return String
     */
    public String getOpeningTime() {
        return this.openingTime;
    }

    
    /** 
     * @param openingTime
     */
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    
    /** 
     * @return String
     */
    public String getClosingTime() {
        return this.closingTime;
    }

    
    /** 
     * @param closingTime
     */
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    
    /** 
     * @return String
     */
    public String getOwner() {
        return this.owner;
    }

    
    /** 
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    
    /** 
     * @param openingTime
     * @return Market
     */
    public Market openingTime(String openingTime) {
        setOpeningTime(openingTime);
        return this;
    }

    
    /** 
     * @param closingTime
     * @return Market
     */
    public Market closingTime(String closingTime) {
        setClosingTime(closingTime);
        return this;
    }

    
    /** 
     * @param owner
     * @return Market
     */
    public Market owner(String owner) {
        setOwner(owner);
        return this;
    }

    
    /** 
     * @return String
     */
    @Override
    public String focus() {
        return this.closingTime;
    }

    
    /** 
     * @param o
     * @return boolean
     */
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

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return (31 * super.hashCode() + Objects.hash(openingTime, closingTime, owner));
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
                "openingTime=" + getOpeningTime() + ", " +
                "closingTime=" + getClosingTime() + ", " +
                "owner=" + getOwner() +
                " }";
    }

    /**
     * Returns a deep copy of this {@code Market} instance.
     *
     * @return a clone of this {@code Market} instance
     */
    @Override
    protected Market clone() throws CloneNotSupportedException {
        Market copy = (Market) super.clone();
        copy.openingTime = this.openingTime;
        copy.closingTime = this.closingTime;
        copy.owner = this.owner;
        return copy;
    }

}
