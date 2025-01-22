package impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import adt.Map;

/**
 * IterativeBSTMap
 * 
 * Class to implement an ordered map using a linked BST
 * with operations implemented recursively.
 * 
 * @author Thomas VanDrunen
 */
public class RecursiveBSTMap<K extends Comparable<K>, V> implements Map<K,V> { 

    /**
     * An interface defining what messages nodes respond to.
     * This parallels the Map interface.
     */
    private static interface Node<KK extends Comparable<KK>,VV> extends Iterable<KK>{
        Node<KK,VV> put(KK key, VV val);
        VV get(KK key);
        boolean containsKey(KK key);
    }

    /**
     * A class for non-null, "real" nodes in the tree.
     */
    private class RealNode implements Node<K,V> {
        K key;
        V value;
        Node<K,V> left, right;
        public RealNode(K key, V value, Node<K,V> left, Node<K,V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public boolean containsKey(K key) {
             throw new UnsupportedOperationException();
        }
        public V get(K key) {
             throw new UnsupportedOperationException();
        }
       public Node<K, V> put(K key, V val) {
             throw new UnsupportedOperationException();
        }
 
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                Iterator<K> lit = left.iterator();
                boolean mine = true;
                Iterator<K> rit = right.iterator();
                public boolean hasNext() {
                    return lit.hasNext() || mine || rit.hasNext();
                }
                public K next() {
                    if (! hasNext()) throw new NoSuchElementException();
                    if (lit.hasNext()) return lit.next();
                    else if (mine) {
                        mine = false;
                        return key;
                    }
                    else {
                        assert rit.hasNext();
                        return rit.next();
                    }
                }

            };
        }
    }

    /**
     * The (singleton) dummy node standing in for a null value
     * in the tree.
     */
    private Node<K,V> nully = new Node<K,V>() {
        public Node<K, V> put(K key, V val) {
            return new RealNode(key, val, this, this);
        }

        public V get(K key) { return null; }

 
        public boolean containsKey(K key) {
            return false;
        }

        public Iterator<K> iterator() {
            return new Iterator<K> () {
                public boolean hasNext() {
                    return false;
                }
                public K next() {
                    throw new NoSuchElementException();
                }
            };
        }
    };

 
    /**
     * The root of the binary search tree. 
     * root == null iff the tree (and, conceptually, the map) is empty
     */
    private Node<K,V> root;

    /**
     * Constructor for an empty map. The root is set to the
     * dummy node.
     */
    public RecursiveBSTMap() {
        root = nully;
    }

    /**
     * Add an association to the map.
     * @param key The key to this association
     * @param val The value to which this key is associated
     */
    public void put(K key, V val) { root = root.put(key, val); }

    /**
     * Get the value for a key.
     * @param key The key whose value we're retrieving.
     * @return The value associated with this key, null if none exists
     */
    public V get(K key) { return root.get(key); }

    /**
     * Test if this map contains an association for this key.
     * @param key The key to test.
     * @return true if there is an association for this key, false otherwise
     */
    public boolean containsKey(K key) { return root.containsKey(key); }

    /**
     * Remove the association for this key, if it exists.
     * @param key The key to remove
     */
    public void remove(K key) { throw new UnsupportedOperationException(); }


    public Iterator<K> iterator() {
        return root.iterator();
    }


}
