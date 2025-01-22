package test;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.Graph;
import alg.BreadthFirstTraversal;
import alg.PerformOnVertex;

public abstract class BreadthFirstTraversalTest {

    protected Graph testGraph;
    
    protected abstract void reset(String filename);

    @Test
    public void smallInternal() {
        reset("small.graph");
        final boolean[] hits = new boolean[testGraph.numVertices()];
        BreadthFirstTraversal testTrav = new BreadthFirstTraversal();

        PerformOnVertex pov = new PerformOnVertex() {
            public void perform(int vertex) {
                hits[vertex] = true;
            }
        };
        
        int[] parents = testTrav.traverse(testGraph, 1, pov);
        boolean noneMissed = true;
        for (boolean hit : hits)
            noneMissed &= hit;
        assertTrue(noneMissed);
        
        int[] distances = testTrav.distances();
        assertEquals(distances[0], 1);
        assertEquals(parents[0], 1);
        assertEquals(distances[1], 0);
        assertEquals(parents[1], 1);
        assertEquals(distances[2], 1);
        assertEquals(parents[2], 1);
        assertEquals(distances[3], 1);
        assertEquals(parents[3], 1);
        assertEquals(distances[4], 2);
        assertEquals(parents[4], 0);
        assertEquals(distances[5], 2);
        assertEquals(parents[5], 3);
        
    }
}
