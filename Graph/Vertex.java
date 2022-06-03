package Graph;

import java.util.HashMap;

public class Vertex {
    private static int instanceCounter = 0;
    // Data Fields
    private int id;
    private String label;
    private HashMap<String, String> values = new HashMap<>();
    private double weight;
    private static double UNWEIGHTED_VERTEX = 1.0;

    // Constructors
    public Vertex(String label, double weight) {
        this.id = instanceCounter++;
        this.label = label;
        this.weight = weight;
    }

    public Vertex(String label) {
        this(label, UNWEIGHTED_VERTEX);
    }

    
    /** 
     * @return int
     */
    // Methods
    public int getID() {
        return this.id;
    }

    
    /** 
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getLabel() {
        return this.label;
    }

    
    /** 
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    
    /** 
     * @return double
     */
    public double getWeight() {
        return this.weight;
    }

    
    /** 
     * @param key
     * @return String
     */
    public String getValue(String key) {
        return values.get(key);
    }

    
    /** 
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        this.values.put(key, value);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getID() + "'" +
                ", label='" + getLabel() + "'" +
                ", values='" + values.toString() + "'" +
                ", weight='" + getWeight() + "'" +
                "}";
    }

}
