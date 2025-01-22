package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import alg.DepthFirstTraversal;
import alg.DepthFirstTraversalRecursive;
import alg.PerformOnVertex;
import alg.Traversal;

public abstract class DepthFirstTraversalIterativeTest extends DepthFirstTraversalTest {


    protected void check(Traversal testTrav, int start, int[] parents) {
        DepthFirstTraversal testTravI = (DepthFirstTraversal) testTrav;
        int[] discoveryTimes = testTravI.discoveryTimes();
        //int[] finishedTimes = testTrav.finishedTimes();
        //int[] parents = testTrav.parents();
        for (int i = 0; i < testGraph.numVertices(); i++) {
            if (i != start) {
                int j = parents[i];
                assertTrue(testGraph.adjacent(j, i));
                assertTrue(discoveryTimes[j] < discoveryTimes[i]);
                //assertTrue(discoveryTimes[i] < finishedTimes[i]);
                //assertTrue(finishedTimes[i] < finishedTimes[j]);
            }
        }
    }

    protected Traversal getTraversal() {
        return new DepthFirstTraversal();
    }
    
 
}
