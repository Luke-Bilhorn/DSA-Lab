package bft2bst;

import static org.junit.Assert.*;
import static bft2bst.BSTNode.treeEq;


import org.junit.Test;

public class TestBFT2BST {

    private void compare(BSTNode t, Integer[] a) {
        //System.out.println(BFT2BST.bft2BST(a));
        assertTrue(treeEq(t, BFT2BST.bft2BST(a)));
    }
    
    @Test
    public void testTrivial() {
        compare(null, new Integer[] {});
    }

    @Test
    public void testOne() {
        compare(new BSTNode(5,null, null), new Integer[] {5});
    }
    
    @Test
    public void testTwoLeft() {
        compare(new BSTNode(5,new BSTNode(2, null, null), null), new Integer[] {5,2});
    }
    @Test
    public void testTwoRight() {
        compare(new BSTNode(5,null, new BSTNode(2, null, null)), new Integer[] {5,null, 2});
    }
    @Test
    public void testBigCompact() {
        compare(new BSTNode(25, new BSTNode(12, new BSTNode(8, new BSTNode(5, null, null),
                new BSTNode(11, null, null)), new BSTNode(20, new BSTNode(18, null, null), 
                        new BSTNode(23, null, null))),
                new BSTNode(45, new BSTNode(30, new BSTNode(28, null, null), 
                        new BSTNode(31, null, null)), new BSTNode(50, new BSTNode(47, null, null),
                                new BSTNode(57, null, null)))),
                new Integer[] {25, 12,45,8,20,30,50,5,11,18,23,28,31,47,57});
    }
    @Test
    public void testBigSparse() {
        compare(new BSTNode(25, new BSTNode(12, new BSTNode(8, new BSTNode(5, null, null),
                null), new BSTNode(20, null, 
                        new BSTNode(23, null, null))),
                new BSTNode(45, null,  new BSTNode(50, new BSTNode(47, null, null),
                                new BSTNode(57, null, null)))),
                new Integer[] {25, 12,45,8,20,null,50,5,null,null,23,null,null,47,57});
    }
    
}
