package test;
import impl.UnWeightedGraphFactory;

public class DFTRAMTest extends DepthFirstTraversalIterativeTest{

    protected void reset(String filename) {
        testGraph = UnWeightedGraphFactory.directedAMGraphFromFile(filename);
    }
}
