package alg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Bucket.java
 * 
 * Class to implement a bucket such as could be used in bucket sort,
 * using a linked list.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College (IL)
 * Jan 30, 2024
 */
public class Bucket implements Iterable<Integer> {

    /**
     * Class representing nodes in this linked list
     */
    private class Node {
        int datum;
        Node next;
        Node(int datum, Node next) {
            this.datum = datum;
            this.next = next;
        }
    }

    /**
     * The first node in the list if any
     */
    private Node head;
    
    /**
     * The number of items in the bucket, or nodes in the list
     */
    private int size;

    // Class Invariant: The items in nodes are in sorted order
    
    /**
     * Constructor for an initially empty bucket
     */
    public Bucket() {
        head = null;
        size = 0;
    }

    /**
     * Insert a given item into sorted position in this bucket
     * @param item The item to add
     */
    public void insertSorted(int item) {
        if (head == null || item < head.datum) {
            // Special case: this item goes first
        }
        else {
            // Find the place where this item goes
        }
    }
    
    /**
     * Dump the contents of this bucket into a given array, beginning
     * at a given position.
     * @param toFill The array into which to dump these items
     * @param start The position at which to begin the dump
     * @return The next position after the filled range
     */
    public int fillArray(Integer[] toFill, int start) {
        // Make sure there is room enough in this array
        assert start + size <= toFill.length;
        // Add code here
        return -1;  // delete this line
    }

    /**
     * Provide an iterator over this bucket
     */
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node current = head;
            public boolean hasNext() { return current != null; }
            public Integer next() {
                if (! hasNext()) throw new NoSuchElementException();
                int toReturn = current.datum;
                current = current.next;
                return toReturn;
            }
            
        };
    }
}
