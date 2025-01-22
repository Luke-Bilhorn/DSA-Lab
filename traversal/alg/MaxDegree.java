package alg;

import adt.Graph;

public class MaxDegree {

    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.numVertices(); v++) {
            int deg = 0;
            for (Integer u : g.adjacents(v)) deg++;
            if (deg > max) max = deg;
        }
        return max;
    }
    
}
