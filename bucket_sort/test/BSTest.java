package test;

import alg.BucketSort;

public class BSTest extends SortTest {

	protected void sort(Integer[] array) {
		BucketSort.bucketSort(array);
	}

}
