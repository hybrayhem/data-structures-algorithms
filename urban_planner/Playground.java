package urban_planner;

public class Playground extends Building {

    public Playground() {
        super();
    }

    public Playground(int position, int length, int height) {
        super(position, length, height);
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Playground)) {
            return false;
        }
        Playground playground = (Playground) o;
        return super.equals(playground);
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return 31 * super.hashCode();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " }";
    }

    /**
     * Returns a deep copy of this {@code Playground} instance.
     *
     * @return a clone of this {@code Playground} instance
     */
    @Override
    protected Playground clone() throws CloneNotSupportedException {
        Playground copy = (Playground) super.clone();
        return copy;
    }

    @Override
    public String focus() {
        return "Playground don't have a focus.";
    }

}
