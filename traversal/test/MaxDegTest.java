package test;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.Graph;
import alg.MaxDegree;
import impl.AdjListGraph.ALGBuilder;

public class MaxDegTest {

    @Test
    public void testSmall() {
        ALGBuilder builder = new impl.AdjListGraph.ALGBuilder(3);
        builder.connect(0,1);
        builder.connect(1,0);
        builder.connect(2,1);
        builder.connect(1,2);
        Graph testGraph = builder.getGraph();
        assertEquals(2, MaxDegree.maxDegree(testGraph));
    }

    @Test
    public void testMedium() {
        ALGBuilder builder = new impl.AdjListGraph.ALGBuilder(6);
        builder.connect(0,1);
        builder.connect(1,0);
        builder.connect(0,2);
        builder.connect(2,0);
        builder.connect(0,3);
        builder.connect(3,0);
        builder.connect(1,2);
        builder.connect(2,1);
        builder.connect(1,5);
        builder.connect(5,1);
        builder.connect(2,3);
        builder.connect(3,2);
        builder.connect(2,5);
        builder.connect(5,2);
        builder.connect(2,4);
        builder.connect(4,2);
        builder.connect(3,4);
        builder.connect(4,3);
        builder.connect(4,5);
        builder.connect(5,4);
        Graph testGraph = builder.getGraph();
        assertEquals(5, MaxDegree.maxDegree(testGraph));
       
    }
    
}
