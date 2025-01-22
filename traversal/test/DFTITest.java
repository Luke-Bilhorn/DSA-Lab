package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import adt.Graph;
import alg.DepthFirstIterator;
import impl.UnWeightedGraphFactory;

public class DFTITest {

    @Test
    public void smallTest() {
        Graph testGraph = UnWeightedGraphFactory.directedALGraphFromFile("small.graph");
        for (Iterator<Integer> git = new DepthFirstIterator(testGraph, 1); git.hasNext(); )
            System.out.println(git.next());
                
        Iterator<Integer> git = new DepthFirstIterator(testGraph, 1);
        int[] vOrder = new int[]{ 1, 2, 3, 5, 4, 0};
        for (int v : vOrder) {
            assertTrue(git.hasNext());
            assertEquals(v, git.next().intValue());
        }
        assertFalse(git.hasNext());
    }

}
