package test;

import static org.junit.Assert.assertTrue;

import alg.DepthFirstTraversal;
import alg.DepthFirstTraversalRecursive;
import alg.Traversal;

public abstract class DepthFirstTraversalRecursiveTest extends DepthFirstTraversalTest {


    
    protected void check(Traversal testTrav, int start, int[] parents) {
        DepthFirstTraversalRecursive testTravR = (DepthFirstTraversalRecursive) testTrav;
        int[] discoveryTimes = testTravR.discoveryTimes();
        int[] finishedTimes = testTravR.finishingTimes();
        //int[] parents = testTrav.parents();
        for (int i = 0; i < testGraph.numVertices(); i++) {
            if (i != start) {
                int j = parents[i];
                assertTrue(testGraph.adjacent(j, i));
                assertTrue(discoveryTimes[j] < discoveryTimes[i]);
                assertTrue(discoveryTimes[i] < finishedTimes[i]);
                assertTrue(finishedTimes[i] < finishedTimes[j]);
            }
        }        // TODO Auto-generated method stub

    }

    
    protected Traversal getTraversal() {
        return new DepthFirstTraversalRecursive();
    }

}
