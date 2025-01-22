package test;
import org.junit.Test;

import alg.Bucket;

import static org.junit.Assert.*;

import java.util.Iterator;

public class BucketInsertTest {

    @Test
    public void insertOnEmpty() {
        Bucket buck = new Bucket();
        buck.insertSorted(12);
        Iterator<Integer> it = buck.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.next() == 12);
        assertFalse(it.hasNext());
    }

    @Test
    public void insertTwoInOrder() {
        Bucket buck = new Bucket();
        buck.insertSorted(5);
        buck.insertSorted(18);
        Iterator<Integer> it = buck.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.next() == 5);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 18);
        assertFalse(it.hasNext());
    }
    @Test
    public void insertTwoOutOfOrder() {
        Bucket buck = new Bucket();
        buck.insertSorted(15);
        buck.insertSorted(8);
        Iterator<Integer> it = buck.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.next() == 8);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 15);
        assertFalse(it.hasNext());
    }

    @Test
    public void insertBunchOrdered() {
        Bucket buck = new Bucket();
        buck.insertSorted(5);
        buck.insertSorted(8);
        buck.insertSorted(15);
        buck.insertSorted(28);
        buck.insertSorted(151);
        buck.insertSorted(802);
        buck.insertSorted(915);
        buck.insertSorted(982);
        Iterator<Integer> it = buck.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.next() == 5);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 8);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 15);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 28);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 151);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 802);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 915);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 982);
        assertFalse(it.hasNext());

    }
    @Test
    public void insertBunchReversed() {
        Bucket buck = new Bucket();
        buck.insertSorted(982);
        buck.insertSorted(915);
        buck.insertSorted(802);
        buck.insertSorted(151);
        buck.insertSorted(28);
        buck.insertSorted(15);
        buck.insertSorted(8);
        buck.insertSorted(5);
        Iterator<Integer> it = buck.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.next() == 5);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 8);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 15);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 28);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 151);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 802);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 915);
        assertTrue(it.hasNext());
        assertTrue(it.next() == 982);
        assertFalse(it.hasNext());

    }
    @Test
    public void insertBunchAllSame() {
        Bucket buck = new Bucket();
        for (int i = 0; i < 25; i++)
            buck.insertSorted(12);
        Iterator<Integer> it = buck.iterator();
        for (int i = 0; i < 25; i++) {
            assertTrue(it.hasNext());
            assertTrue(it.next() == 12);
        }
        assertFalse(it.hasNext());

    }
}
