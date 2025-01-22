package test;

import org.junit.Test;
import static org.junit.Assert.*;


public abstract class SortTest {
    public static boolean isSorted(Integer[] array) {
        boolean inOrderSoFar = true;
        for (int i = 1; inOrderSoFar && i < array.length; i++)
            inOrderSoFar &= array[i] >= array[i-1];
        return inOrderSoFar;
    }

    public static boolean allThere(Integer[] orig, Integer[] sorted) {
        assert orig.length == sorted.length;
        boolean[] taken = new boolean[orig.length];
        boolean allFound = true;
        for (int i = 0; allFound && i < orig.length; i++) {
            boolean found = false;
            for (int j = 0; !found && j < sorted.length; j++)
                 found = taken[j] = !taken[j] && orig[i].equals(sorted[j]);
            allFound &= found;
        }
        return allFound;
    }

    
    private static String displayArray(Integer[] array) {
        String toReturn = "[";
        for (Integer x : array)
            toReturn += x + ", ";
        toReturn = toReturn.substring(0, toReturn.length() - 1);
        toReturn += "]";
        return toReturn;
    }
    
    protected abstract void sort(Integer[] array);
    
    protected void setUpAndSort(int[] array) {
        Integer[] original = new Integer[array.length];
        Integer[] subject = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
            original[i] = subject[i] = array[i];
        sort(subject);
        assertTrue("Not sorted: \n" + displayArray(subject), isSorted(subject));
        assertTrue("Not all there:\n" + displayArray(original) + "\n" + 
                displayArray(subject), allThere(original, subject));
    }
    
    @Test
    public void empty() {
        setUpAndSort(new int[0]);
    }
    
    @Test
    public void sizeOne() {
        setUpAndSort(new int[] {5});
    }

    @Test
    public void smallSorted() {
        setUpAndSort(new int[]{1, 2, 3, 4, 5, 6, 7} );
    }
    @Test
    public void medSizeSmallRange() {
        setUpAndSort(new int[] {3, 3, 3, 0, 0, 4, 3, 1, 0, 1, 4, 2, 2, 3, 3, 4, 3, 0, 1, 4});
    }

    @Test
    public void medSizeBigRange() {
        setUpAndSort(new int[] {13, 4, 12, 10, 15, 6, 11, 2, 7, 10, 3, 5, 17, 18, 0, 1, 1, 10, 6, 17});
    }

    @Test
    public void bigSizesmallRange() {
        setUpAndSort(new int[] {3, 2, 0, 4, 2, 2, 1, 3, 2, 4, 2, 2, 4, 1, 0, 3, 2, 2, 1, 0, 4, 2, 0, 3, 0, 2, 1, 3, 0, 3, 4, 2, 3, 4, 2, 3, 4, 0, 2, 1, 0, 2, 0, 2, 0, 2, 1, 2, 1, 1, 1, 4, 1, 4, 4, 4, 1, 1, 1, 4, 1, 2, 0, 1, 1, 1, 1, 3, 3, 3, 2, 0, 1, 1, 0, 3, 3, 4, 3, 1, 0, 3, 0, 0, 4, 1, 3, 1, 0, 3, 0, 2, 1, 4, 4, 0, 1, 4, 0, 3});
    }
    @Test
    public void revserSorted() {
        setUpAndSort(new int[] {10,9,8,7,6,5,4});
    }
    @Test
    public void allSame() {
        setUpAndSort(new int[] {8,8,8,8,8,8,8,8,8,8,8,8});
    }
    @Test
    public void through100() {
        setUpAndSort(new int[]{87, 50, 21, 47, 62, 79, 23, 51, 18, 15, 46, 76, 23, 52, 44, 93, 9, 62, 54, 50, 33, 93, 7, 10, 17, 32, 35, 21, 5, 6});
    }

    @Test
    public void through1000() {
        setUpAndSort(new int[]{495, 202, 516, 429, 401, 536, 421, 315, 321, 442, 105, 67, 149, 625, 621, 368, 400, 686, 222, 60, 198, 180, 944, 8, 399, 575, 890, 133, 885, 677});
    }
    
    @Test
    public void through32() {
        setUpAndSort(new int[]{28, 10, 1, 0, 29, 24, 10, 26, 20, 16, 21, 22, 9, 3, 11, 8, 27, 19, 23, 0, 3, 18, 11, 24, 19, 23, 1, 1, 15, 6});
    }

    @Test
    public void through256() {
        setUpAndSort(new int[] {137, 113, 215, 197, 52, 142, 198, 188, 9, 95, 198, 30, 128, 13, 49, 161, 163, 39, 239, 83, 234, 109, 226, 116, 79, 102, 15, 28, 197, 176});
    }
    
    @Test
    public void trough2401() {
        setUpAndSort(new int[] {360, 149, 2037, 1082, 1264, 1398, 2389, 1253, 158, 1661, 2301, 1707, 2307, 2208, 1222, 168, 28, 2196, 220, 888, 332, 2365, 1792, 777, 497, 150, 4, 1056, 2212, 473});
    }
    
 
    
}
