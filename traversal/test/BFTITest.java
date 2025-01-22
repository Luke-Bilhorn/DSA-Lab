package test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Iterator;

import org.junit.Test;

import adt.Graph;
import alg.BreadthFirstIterator;
import alg.DepthFirstIterator;
import impl.UnWeightedGraphFactory;

public class BFTITest {

    @Test
    public void smallTest() {
        Graph testGraph = UnWeightedGraphFactory.directedALGraphFromFile("small.graph");
        for (Iterator<Integer> git = new BreadthFirstIterator(testGraph, 1); git.hasNext(); )
            System.out.println(git.next());
       Iterator<Integer> git = new BreadthFirstIterator(testGraph, 1);
        int[] vOrder = new int[]{ 1, 0, 3, 2, 4, 5};
        for (int v : vOrder) {
            assertTrue(git.hasNext());
            assertEquals(v, git.next().intValue());
        }
        assertFalse(git.hasNext());
    }

}
