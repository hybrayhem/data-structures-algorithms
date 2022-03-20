package urban_planner;

import java.util.Objects;

public class Office extends Building {
    private String jobType;
    private String owner;

    public Office() {
        super();
        jobType = "None";
        owner = "Anonymous";
    }

    public Office(int position, int length, int height, String jobType, String owner) {
        super(position, length, height);
        this.jobType = jobType;
        this.owner = owner;
    }

    
    /** 
     * @return String
     */
    public String getJobType() {
        return this.jobType;
    }

    
    /** 
     * @param jobType
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
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
     * @return String
     */
    @Override
    public String focus() {
        return this.jobType;
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Office)) {
            return false;
        }
        Office office = (Office) o;
        return super.equals(office) && (jobType.equals(office.jobType) && owner.equals(office.owner));
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return (31 * super.hashCode() + Objects.hash(jobType, owner));
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
                "jobType=" + getJobType() + ", " +
                "owner=" + getOwner() + ", " +
                " }";
    }

    /**
     * Returns a deep copy of this {@code Office} instance.
     *
     * @return a clone of this {@code Office} instance
     */
    @Override
    protected Office clone() throws CloneNotSupportedException {
        Office copy = (Office) super.clone();
        copy.jobType = this.jobType;
        copy.owner = this.owner;
        return copy;
    }

}
