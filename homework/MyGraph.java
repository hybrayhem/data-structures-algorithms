package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Graph.DynamicGraph;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;

public class MyGraph implements DynamicGraph {
    // Data Fields
    /**
     * Number of vertices
     */
    private int numV;
    /**
     * Flag to indicate whether this is a directed graph
     */
    private boolean directed;
    /**
     * An array of Lists to contain the edges that originate with each vertex
     */
    private List<Edge>[] edges;

    private List<Vertex> vertices;

    // Constructor
    /**
     * Construct a graph with the specified number of vertices and directionality
     * 
     * @param numV     The number of vertices
     * @param directed The directionality flag
     */
    @SuppressWarnings("unchecked")
    public MyGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;

        vertices = new ArrayList<Vertex>();
        edges = new List[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }
    }

    
    /** 
     * @return int
     */
    // Methods
    @Override
    public int getNumV() {
        return numV;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

    
    /** 
     * @param edge
     */
    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest()].add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    
    /** 
     * @param source
     * @param dest
     * @return boolean
     */
    @Override
    public boolean isEdge(int source, int dest) {
        return edges[source].contains(new Edge(source, dest));
    }

    
    /** 
     * @param source
     * @param dest
     * @return Edge
     */
    @Override
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, 1.0);
        for (Edge edge : edges[source]) {
            if (edge.equals(target))
                return edge; // Desired edge found; return it
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }

    
    /** 
     * @param source
     * @param dest
     * @return boolean
     */
    public boolean edgeContains(int source, int dest) {
        Edge target = new Edge(source, dest, 1.0);
        for (Edge edge : edges[source]) {
            if (edge.equals(target))
                return true; // Desired edge found; return it
        }
        // Assert: All edges for source checked.
        return false; // Desired edge not found.
    }

    
    /** 
     * @param source
     * @return Iterator<Edge>
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int end = edges.length;
        for (int i = 0; i < end; i++) {
            sb.append("Node " + i + "-->\n");
            for (Edge e : edges[i]) {
                sb.append("\tnode: " + e.getDest() + ", weight: " + e.getWeight() + "\n");
            }
        }
        return sb.toString();
    }

    
    /** 
     * @param label
     * @param weight
     */
    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    @Override
    public void newVertex(String label, double weight) {
        Vertex vertex = new Vertex(label, weight);
        vertices.add(vertex);
    }

    
    /** 
     * @param new_vertex
     */
    @Override
    public void addVertex(Vertex new_vertex) {
        vertices.add(new_vertex);
    }

    
    /** 
     * @param vertexID
     */
    @Override
    public void removeVertex(int vertexID) {
        for (Vertex v : vertices) {
            if (v.getID() == vertexID)
                vertices.remove(v);
        }
    }

    
    /** 
     * @param label
     */
    @Override
    public void removeVertex(String label) {
        for (Vertex v : vertices) {
            if (v.getLabel() == label)
                vertices.remove(v);
        }
    }

    
    /** 
     * @param vertexID1
     * @param vertexID2
     * @param weight
     */
    @Override
    public void addEdge(int vertexID1, int vertexID2, double weight) {
        Edge edge = new Edge(vertexID1, vertexID2);
        edges[vertexID1].add(edge);
    }

    
    /** 
     * @param vertexID1
     * @param vertexID2
     */
    @Override
    public void removeEdge(int vertexID1, int vertexID2) {
        for (Edge e : edges[vertexID1]) {
            if (e.getDest() == vertexID2)
                edges[vertexID1].remove(e);
        }
    }

    
    /** 
     * @param key
     * @param filter
     * @return Graph
     */
    @Override
    public Graph filterVertices(String key, String filter) {
        MyGraph graph = new MyGraph(numV, directed);
        for (Vertex v : vertices) {
            if (v.getValue(key) == filter) {
                graph.addVertex(v);
            }
        }

        return graph;
    }

    @Override
    public void exportMatrix() {
        System.out.print("   ");
        for (int i = 0; i < numV; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");

        for (int i = 0; i < numV; i++) {
        System.out.print(i + "- ");
            for (int j = 0; j < numV; j++) {
                if(edgeContains(i, j)){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println("");
        }

        System.out.println("");

    }

    @Override
    public void printGraph() {
        int end = edges.length;
        for (int i = 0; i < end; i++) {
            System.out.print("Node " + i + " --> ");
            for (Edge e : edges[i]) {
                System.out.print(e.getDest() + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}