package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import adt.Graph;
import alg.DepthFirstTraversal;
import alg.DepthFirstTraversalRecursive;
import alg.PerformOnVertex;
import alg.Traversal;

public abstract class DepthFirstTraversalTest {

    protected Graph testGraph;

    public DepthFirstTraversalTest() {
        super();
    }

    protected abstract void reset(String filename);
    
    protected abstract void check(Traversal testTrav, int start, int[] parents);

    @Test
    public void smallInternal() {
        reset("small.graph");
        final boolean[] hits = new boolean[testGraph.numVertices()];
        Traversal testTrav = getTraversal();

        PerformOnVertex pov = new PerformOnVertex() {
            public void perform(int vertex) {
                hits[vertex] = true;
            }
        };
        
        int start = 1;
        int[] parents = testTrav.traverse(testGraph, start, pov);
        boolean noneMissed = true;
        for (boolean hit : hits)
            noneMissed &= hit;
        assertTrue(noneMissed);
        
        check(testTrav, start, parents);
    }

    protected abstract Traversal getTraversal();
}