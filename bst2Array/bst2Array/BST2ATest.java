package bst2Array;

import static org.junit.Assert.*;

import org.junit.Test;

public class BST2ATest {

    
    public void runTest(BSTNode root, int[] testArray) {
        int[] result = BST2Array.bst2Array(root);
        assertEquals(testArray.length, result.length);
        for (int i = 0; i < testArray.length; i++)
            assertEquals(testArray[i], result[i]);
    }
    
    @Test
    public void testEmpty() {
        runTest(null, new int[0]);
    }
    
    @Test
    public void testLeaf() {
        runTest(new BSTNode(5, null, null), new int[]{5});
    }
    
    @Test
    public void testLopLeft() {
        runTest(new BSTNode(5, new BSTNode(4, null, null), null), new int[]{4, 5});
    }
    @Test
    public void testLopRight() {
        runTest(new BSTNode(5, null, new BSTNode(6, null, null)), new int[]{5, 6});
    }
    @Test
    public void testSmall() {
        runTest(new BSTNode(4,new BSTNode(2,new BSTNode(1, null, null),new BSTNode(3, null, null)),
                new BSTNode(6, new BSTNode(5, null, null), new BSTNode(7, null, null))),
                new int[]{1,2,3,4,5,6,7});
    }
    private static int[] medium = new int[] {2,9,14,17,18,22,29,31,34,35,37,48,51,56,74,88, 89, 90, 93};
    @Test
    public void testMediumA() {
        runTest(new BSTNode(22, new BSTNode(9, new BSTNode(2, null, null), 
                new BSTNode(17, new BSTNode(14, null, null), new BSTNode(18, null, null))),
                new BSTNode(56, new BSTNode(29, null, new BSTNode(31, null, 
                        new BSTNode(48, new BSTNode(35, new BSTNode(34, null, null),
                                new BSTNode(37, null, null)), new BSTNode(51, null, null)))),
                        new BSTNode(89, new BSTNode(88, new BSTNode(74, null, null), null),
                                new BSTNode(93, new BSTNode(90, null, null), null)))),
                medium);
    }
    @Test
    public void testMediumB() {
        runTest(new BSTNode(74, new BSTNode(29, new BSTNode(22, new BSTNode(17,
                new BSTNode(9, new BSTNode(2, null, null), new BSTNode(14, null, null)),
                new BSTNode(18, null, null)), null), 
                new BSTNode(51, new BSTNode(34, new BSTNode(31, null, null),
                        new BSTNode(37, new BSTNode(35, null, null), 
                                new BSTNode(48, null, null))), new BSTNode(56, null, null))),
                new BSTNode(90, new BSTNode(88, null, new BSTNode(89, null, null)),
                        new BSTNode(93, null, null))) ,medium);
       
    }

}
