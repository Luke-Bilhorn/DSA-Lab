package alg;


import adt.Graph;
import adt.Stack;
import impl.ListStack;

/**
 * DepthFirstTraversal
 * 
 * Class to provide an iterator giving access to the vertices
 * of a graph in depth first order from a given starting
 * vertex.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 18, 2015
 */
public class DepthFirstTraversal implements Traversal {

    /**
     * Timestamps for when each vertex was discovered.
     */
    protected int[] discoveryTimes;
    
    
    /**
     * Retrieve the discovery times of each vertex from the most recent
     * traversal done by this object.
     */
    public int[] discoveryTimes() { return discoveryTimes; }


    /**
     * Execute a given operation on each vertex of the graph
     * reachable able from start in a specific ordering
     * @param g The graph on whose vertices to operate
     * @param start The vertex from which to start
     * @param op The encapsulated operation to perform
     */
    public int[] traverse(Graph g, int start, PerformOnVertex op) {
        int[] parents = new int[g.numVertices()];
        discoveryTimes = new int[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++)
            parents[i] = discoveryTimes[i] = -1;
        parents[start] = start;
        int time = 0;
         // ADD CODE HERE
        return parents;
    }
}
