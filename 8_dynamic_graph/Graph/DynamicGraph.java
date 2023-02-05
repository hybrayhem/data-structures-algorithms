package Graph;

public interface DynamicGraph extends Graph {

	// Generate a new vertex by given parameters
	public void newVertex(String label, double weight);

	// Add the given vertex to the graph
	public void addVertex(Vertex new_vertex);

	// Add an edge between the given two vertices in the graph
	public void addEdge(int vertexID1, int vertexID2, double weight);

	// Remove  the  edge  between  the  given  two vertices
	public void removeEdge(int vertexID1, int vertexID2);

	// Remove  the  vertex  from  the  graph  with  respect  to  the given vertex id
	public void removeVertex(int vertexID);

	// Remove  the  vertices  that  have  the  given  label  from  the graph
	public void removeVertex(String label);

	// Filter  the  vertices  by  the  given  user-defined property and returns a subgraph of the graph
	public Graph filterVertices(String key, String filter);

	// Generate the adjacency matrix representation of the graph and returns the matrix
	public void exportMatrix();

	// Print the  graph in  adjacency  list  format  (You  should  use  the  format that can be imported by the method in AbstarctGraph in the book
	public void printGraph();
}
