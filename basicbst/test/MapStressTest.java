package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.junit.Test;

import adt.Map;


public abstract class MapStressTest extends MapTest {
    protected Map<Integer, Integer> testMapInt;
    
    protected abstract void resetInteger();
    
    @Test
    public void putDuplicate() {
        reset();
        testMap.put("a", "a");
        testMap.put("a", "a");
        testMap.put("a", "a");
        testMap.put("a", "a");
        testMap.put("a", "a");
    }

    @Test
    public void putLots() {
        resetInteger();
        for (int i = 0; i < 200; i++) {
            testMapInt.put(i, null);

        }

    }

    @Test
    public void putLotsRandom() {
        resetInteger();
        for (int i = 0; i < 200; i++) {
            testMapInt.put(rand.nextInt(), 42);
        }
    }
    
    @Test
    public void putGetLotsRepeats() {
        resetInteger();

        HashMap<Integer, Integer> correctMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<Integer> vals = new ArrayList<Integer>();
        Random rand = new Random();
        int size = 200; // rand.nextInt(20);
        for (int i = 0; i < size; i++) {
            Integer a = rand.nextInt(20);
            Integer b = rand.nextInt(20);
            keys.add(a);
            vals.add(b);

            correctMap.put(keys.get(i), vals.get(i));
            testMapInt.put(keys.get(i), vals.get(i));
        }

        for (int i = 0; i < size; i++) {
            Integer testVal = testMapInt.get(keys.get(i));
            Integer correctVal = correctMap.get(keys.get(i));
            assert(testVal != null);
            assert testVal.equals(correctVal);
        }

    }
    
    @Test
    public void putGetLots() {
        resetInteger();

        HashMap<Integer, Integer> correctMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<Integer> vals = new ArrayList<Integer>();
        Random rand = new Random();
        int size = rand.nextInt(2000);
        for (int i = 0; i < size; i++) {
            Integer a = rand.nextInt();
            Integer b = rand.nextInt();
            keys.add(a);
            vals.add(b);

            correctMap.put(keys.get(i), vals.get(i));
            testMapInt.put(keys.get(i), vals.get(i));
        }

        for (int i = 0; i < size; i++) {
            Integer testVal = testMapInt.get(keys.get(i));
            Integer correctVal = correctMap.get(keys.get(i));
            assert testVal != null;
            assert testVal.equals(correctVal);
        }

    }



    /* The following test the cases of traditional RB trees,
      * but all maps should be able to pass them */

    private void checkABCD() {
        assertEquals("A", testMap.get("A"));
        assertEquals("B", testMap.get("B"));
        assertEquals("C", testMap.get("C"));
        assertEquals("D", testMap.get("D"));
    }

    @Test
    public void TRBLLRU() {
        reset();
        testMap.put("C", "C");
        testMap.put("B", "B");
        testMap.put("D", "D");
        testMap.put("A", "A");
        checkABCD();
    }

    @Test
    public void TRBLL() {
        reset();
        testMap.put("C", "C");
        testMap.put("B", "B");
        testMap.put("A", "A");
        testMap.put("D", "D");
        checkABCD();
    }

    @Test
    public void TRBLR() {
        reset();
        testMap.put("C", "C");
        testMap.put("A", "A");
        testMap.put("B", "B");
        testMap.put("D", "D");
        checkABCD();
    }

    @Test
    public void TRBRRRU() {
        reset();
        testMap.put("B", "B");
        testMap.put("A", "A");
        testMap.put("C", "C");
        testMap.put("D", "D");
        checkABCD();
    }

    @Test
    public void TRBRR() {
        reset();
        testMap.put("A", "A");
        testMap.put("B", "B");
        testMap.put("C", "C");
        testMap.put("D", "D");
        checkABCD();
    }

    @Test
    public void TRBRL() {
        reset();
        testMap.put("A", "A");
        testMap.put("C", "C");
        testMap.put("B", "B");
        testMap.put("D", "D");
        checkABCD();
    }

    // demonstrate a bug in my code July 8, 2015
    @Test
    public void AVLTrick() {
        reset();
        testMap.put("B", "B");
        testMap.put("E", "E");
        testMap.put("F", "F");
        testMap.put("D", "D");
        testMap.put("A", "A");
        testMap.put("C", "C");
        checkA2F();
    }

    private void checkA2F() {
        checkABCD();
        assertEquals("E", testMap.get("E"));
        assertEquals("F", testMap.get("F"));
    }




}
