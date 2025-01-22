package test;
import impl.UnWeightedGraphFactory;

public class DFTRALTest extends DepthFirstTraversalRecursiveTest {

    protected void reset(String filename) {
        
        testGraph = UnWeightedGraphFactory.directedALGraphFromFile(filename);
    }

}
