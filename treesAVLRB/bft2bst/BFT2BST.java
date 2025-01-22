package bft2bst;

/**
 * BFT2BST
 * 
 * Placeholder for static function to convert a BST
 * that is represented in an array in breadth-first
 * traversal order into a linked BST
 * 
 * @author Thomas VanDrunen
 * CSCI 345
 * Mar 20, 2024
 */
public class BFT2BST {

    /**
     * Convert a BST from an array in breadth-first
     * traversal order to a BST built from BSTNodes.
     * @param bftArray The array of (Integer) keys laid out like
     * a binary heap (BFT order), with null values for missing 
     * branches.
     * @return An equivalent BST as a linked structure
     */
    public static BSTNode bft2BST(Integer[] bftArray) {
        throw new UnsupportedOperationException();
    }

    
 
    private static int left(int i) { return 2*i + 1; }
    private static int right(int i) { return 2*i + 2; }
    
}
