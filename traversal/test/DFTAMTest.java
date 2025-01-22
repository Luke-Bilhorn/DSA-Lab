package test;

import impl.UnWeightedGraphFactory;

public class DFTAMTest extends DepthFirstTraversalIterativeTest {

    protected void reset(String filename) {
        testGraph = UnWeightedGraphFactory.directedAMGraphFromFile(filename);
    }

}
