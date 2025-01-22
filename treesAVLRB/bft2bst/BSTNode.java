package bft2bst;

/**
 * BSTNode.java
 * 
 * Class to model a simplified binary search tree represented
 * by the root of that (sub)-tree. Actually, nothing in the
 * code forces it to be a BST; that is merely its purpose
 * in context.
 * 
 * @author Thomas VanDrunen
 * Algorithmic Commonplaces
 * Feb 28, 2020
 */
public class BSTNode {

    public final int key;
    public final BSTNode left, right;

    public BSTNode(int key, BSTNode left, BSTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return "(" + key + "," + (left == null? "*":left.toString()) + "," + (right == null? "*":right.toString()) + ")";
    }
    
    public static boolean treeEq(BSTNode a, BSTNode b) {
        if (a == null && b == null) return true;
        else if (a == null || b == null) return false;
        else return treeEq(a.left, b.left) && a.key == b.key && treeEq(a.right, b.right);
    }
}
