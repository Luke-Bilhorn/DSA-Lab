package test;

import alg.BucketSort;

public class BSRTest extends SortTest {

    protected void sort(Integer[] array) {
        BucketSort.bucketSortR(array);
    }

}
