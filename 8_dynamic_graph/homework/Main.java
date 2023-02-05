package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import Graph.BreadthFirstSearch;
import Graph.DepthFirstSearch;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;

class Main {
    /**
     * Dijkstra's Shortest Path algorithm
     * pre: graph to be searched is a weighted directed graph with only positive
     * weights
     * pred and dist are arrays of size V
     * 
     * @param graph The weighted graph to be searched
     * @param start The start vertex
     * @param pred  Output array to contain the predecessors in the shortest path
     * @param dist  Output array to contain the distance in the shortest path
     */
    public static void dijkstrasAlgorithm(Graph graph, int start, int[] pred, double[] dist) {
        int numV = graph.getNumV();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
        // Initialize V - S
        for (int i = 0; i < numV; i++) {
            if (i != start)
                vMinusS.add(i);
        }
        // Initialize pred and dist
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        // Main loop
        while (vMinusS.size() != 0) {
            // Find the value u in V - S with the smallest dist[u]
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS
            vMinusS.remove(u);
            // Update the distances
            Iterator<Edge> edgeIter = graph.edgeIterator(u);
            while (edgeIter.hasNext()) {
                Edge edge = edgeIter.next();
                int v = edge.getDest();
                if (vMinusS.contains(new Integer(v))) {
                    double weight = edge.getWeight();
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                        System.out.println("u:" + u);
                    }
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");

        // ----------------------------------- Q1 ----------------------------------- //
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        MyGraph graph = new MyGraph(6, true);

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addEdge(v0.getID(), v1.getID(), 1.0);
        graph.addEdge(v0.getID(), v3.getID(), 1.0);
        graph.addEdge(v1.getID(), v4.getID(), 1.0);
        graph.addEdge(v2.getID(), v4.getID(), 1.0);
        graph.addEdge(v2.getID(), v5.getID(), 1.0);
        graph.addEdge(v3.getID(), v1.getID(), 1.0);
        graph.addEdge(v4.getID(), v3.getID(), 1.0);
        graph.addEdge(v5.getID(), v5.getID(), 1.0);
        
        try {
            System.out.println("graph.toString");
            System.out.println(graph.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("exportMatrix");
            graph.exportMatrix();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("printGraph");
            graph.printGraph();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("BreadthFirstSearch");
            BreadthFirstSearch bSearch = new BreadthFirstSearch();
            bSearch.test(graph);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("DepthFirstSearch");
            DepthFirstSearch dSearch = new DepthFirstSearch(graph);
            dSearch.test(graph);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("dijkstrasAlgorithm");
            int[] pred = new int[100];
            double[] dist = new double[100];
            System.out.println("Predecessors: " + pred.toString());
            System.out.println("Distance: " + dist.toString());

            dijkstrasAlgorithm(graph, 0, pred, dist);
            System.out.println("Predecessors: " + pred.toString());
            System.out.println("Distance: " + dist.toString());
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // try {
        // Graph g = AbstractGraph.createGraph(false, "Matrix");
        // System.out.println(g.toString());
        // } catch(Exception e){
        // e.printStackTrace();
        // }

        // // Perform a depth-first search

        // // Perform a depth-first search

    }
}
