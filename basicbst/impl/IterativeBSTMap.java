package impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import adt.Map;
import adt.Stack;

/**
 * IterativeBSTMap
 * 
 * Class to implement an ordered map using a linked BST
 * with operations implemented iteratively.
 * 
 * @author Thomas VanDrunen
 */
public class IterativeBSTMap<K extends Comparable<K>,V> implements Map<K,V>{ 

    /**
     * Class standing for nodes in the tree.
     */
    private class Node {
        K key;
        V value;
        Node left, right;
        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
                   
        }
    }
    
    /**
     * The root of the binary search tree. 
     * root == null iff the tree (and, conceptually, the map) is empty
     */
    public Node root;

    /**
     * Find the node, if any, that contains the given key. If the
     * give key is not in the tree, then return the node that 
     * would be the parent of a new node inserted for this key.
     * PRECONDITION: The tree is not empty, that is, root is not null.
     * @param key The key to search for.
     * @return The node containing the given key, if such a node exists;
     *   if there is no such node, then the node that would be the parent
     *   of a new node for the given key.
     */
    private Node findKey(K key) {
        assert root != null;
        throw new UnsupportedOperationException();
    }
    
    
    // ---- Public methods ----
    

    /**
     * Get the value for a key.
     * @param key The key whose value we're retrieving.
     * @return The value associated with this key, null if none exists
     */
   public V get(K key) {
        if (root == null) return null;
        else {
            Node place = findKey(key);
            if (place.key.equals(key)) return place.value;
            else return null;
        }
    }

   /**
    * Test if this map contains an association for this key.
    * @param key The key to test.
    * @return true if there is an association for this key, false otherwise
    */
    public boolean containsKey(K key) {
        return root != null && findKey(key).key.equals(key);
    }

    /**
     * Add an association to the map.
     * @param key The key to this association
     * @param val The value to which this key is associated
     */
    public void put(K key, V val) {
        // Case 1: The tree is empty, 
        // make a root with the given key
        if (root == null)
            root = new Node(key, val, null, null);
        else {
            Node placeOrParent = findKey(key);
            int compare = key.compareTo(placeOrParent.key);
            // Case 2: The given key comes before its parent,
            // insert new node to the left
            if (compare < 0) {
                assert placeOrParent.left == null;
                placeOrParent.left = new Node(key, val, null, null);
            }
            // Case 3: The given key is already present,
            // overwrite old value with given val
            else if (compare == 0) {
                assert placeOrParent.key.equals(key);
                placeOrParent.value = val;
            }
            // Case 4: The given key comes after its parent,
            // insert new node to the right
            else {
                assert compare > 0 && placeOrParent.right == null;
                placeOrParent.right = new Node(key, val, null, null);
            }
        }
    }

    
    /**
     * Return an iterator over the keys of this map
     */
    public Iterator<K> iterator() {
        final Stack<Node> st = new ListStack<Node>();
        for (Node current = root; current != null; current = current.left)
            st.push(current);
        return new Iterator<K> () {
            public boolean hasNext() {
                return ! st.isEmpty();
            }

            public K next() {
                if (! hasNext()) throw new NoSuchElementException();
                else {
                    Node toReturn = st.pop();
                    for (Node current = toReturn.right; 
                            current != null; current = current.left)
                        st.push(current);
                    return toReturn.key;
                }
                    
            }
            
        };
    }
 
    /**
     * Remove the association for this key, if it exists.
     * Actually, we're going to punt on this one.
     * @param key The key to remove
     */
    public void remove(K key) {
        throw new UnsupportedOperationException();
 
    }

}
