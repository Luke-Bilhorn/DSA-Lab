package alg;


import adt.Graph;
import adt.Queue;
import impl.ListQueue;

/**
 * BreadthFirstTraversal
 * 
 * Class to provide an iterator giving access to the vertices
 * of a graph in breadth first order from a given starting
 * vertex.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 18, 2015
 */
public class BreadthFirstTraversal implements Traversal {

    
    /**
     * The distances from the starting point for each vertex 
     * from the most recent traversal done by this object; 
     * -1 for each vertex unreachable from the starting point 
     * of that traversal.
     */
    private int[] distances;
    
    

    /**
     * Retrieve the distances from the starting point for each vertex 
     * from the most recent traversal done by this object.
     */
    public int[] distances() { return distances; }

    /**
     * Execute a given operation on each vertex of the graph
     * reachable able from start in a specific ordering
     * @param g The graph on whose vertices to operate
     * @param start The vertex from which to start
     * @param op The encapsulated operation to perform
     */
    public int[] traverse(Graph g, int start, PerformOnVertex op) {
        int[] parents = new int[g.numVertices()];
        distances = new int[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++)
            parents[i] = distances[i] = -1;
        distances[start] = 0;
        parents[start] = start;
        
         // ADD CODE HERE        
        return parents;
        
    }

}
