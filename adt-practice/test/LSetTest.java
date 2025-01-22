package test;

import impl.LinkedSet;

public class LSetTest extends SetTest {

    protected void reset() {
        testSet = new LinkedSet<String>();
    }

	@Override
	protected void resetInt() {
		testSetInt = new LinkedSet<Integer>();
	}

 
}
