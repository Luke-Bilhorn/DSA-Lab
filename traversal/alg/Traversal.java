package alg;

import adt.Graph;

/**
 * Traversal
 * 
 * Interface to define a class that, given a graph, will
 * provide an iterator giving access to the vertices of
 * the graph in a specific order, such as depth-first or
 * breadth-first.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 18, 2015
 */
public interface Traversal {

    /**
     * Execute a given operation on each vertex of the graph
     * reachable able from start in a specific ordering
     * @param g The graph on whose vertices to operate
     * @param start The vertex from which to start
     * @param op The encapsulated operation to perform
     * @return The parents of each vertex in the traversal tree
     */
    int[] traverse(Graph g, int start, PerformOnVertex op);
    
}
