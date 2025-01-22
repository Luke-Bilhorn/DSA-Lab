package test;
import org.junit.Test;

import alg.Bucket;

import static org.junit.Assert.*;

import java.util.Iterator;

public class BucketFillArrayTest {

    @Test
    public void fillEmpty() {
        Bucket buck = new Bucket();
        Integer[] array = new Integer[10];
        assertEquals(0, buck.fillArray(array, 0));
        for (int i = 0; i < 10; i++)
            assertEquals(null, array[i]);
    }

    @Test
    public void fillFront() {
        Bucket buck = new Bucket();
        Integer[] array = new Integer[10];
        buck.insertSorted(3);
        buck.insertSorted(4);
        buck.insertSorted(5);
        buck.insertSorted(6);
        assertEquals(4, buck.fillArray(array, 0));
        for (int i = 0; i < 10; i++)
            if (i < 4)
                assertEquals(i + 3, (int) array[i]);
            else 
                assertEquals(null, array[i]);
                
    }
    @Test
    public void fillBack() {
        Bucket buck = new Bucket();
        Integer[] array = new Integer[10];
        buck.insertSorted(3);
        buck.insertSorted(4);
        buck.insertSorted(5);
        buck.insertSorted(6);
        assertEquals(10, buck.fillArray(array, 6));
        for (int i = 0; i < 10; i++)
            if (i > 5)
                assertEquals(i - 3, (int) array[i]);
            else 
                assertEquals(null, array[i]);
                
    }
    
    @Test
    public void fillAll() {
        Bucket buck = new Bucket();
        Integer[] array = new Integer[10];
        buck.insertSorted(3);
        buck.insertSorted(4);
        buck.insertSorted(5);
        buck.insertSorted(6);
        buck.insertSorted(7);
        buck.insertSorted(8);
        buck.insertSorted(9);
        buck.insertSorted(10);
        buck.insertSorted(11);
        buck.insertSorted(12);
        assertEquals(10, buck.fillArray(array, 0));
        for (int i = 0; i < 10; i++)
            assertEquals(i + 3, (int) array[i]);
                
    }
    
    
    
}
