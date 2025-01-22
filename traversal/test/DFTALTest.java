package test;

import impl.UnWeightedGraphFactory;

public class DFTALTest extends DepthFirstTraversalIterativeTest {

    protected void reset(String filename) {
        testGraph = UnWeightedGraphFactory.directedALGraphFromFile(filename);
    }

}
