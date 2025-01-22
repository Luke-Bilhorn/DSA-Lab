package alg;

public class BucketSort {

    /**
     * Sort an array of integers using one level of bucket sort,
     * with insertion sort used as the subsort.
     * @param array The array to be sorted, assumed all nonnegative
     */
	public static void bucketSort(Integer[] array) {
	    int max = 0;
	    for (int x : array) if (x > max) max = x;
	    int tenPow = (int) Math.pow(10, Math.floor(Math.log10(max)));
	    Bucket[] buckets = new Bucket[10];
	    for (int i = 0; i < 10; i++) buckets[i] = new Bucket();
	    // Add code here
	}

	/**
	 * Sort an array of integers using bucket sort recursively
	 * all the way down. This method itself finds the largest power
	 * of ten and begins the recursive process
	 * @param array The array to sort, assumed all nonnegative
	 */
	public static void bucketSortR(Integer[] array) {
        int max = 0;
        for (int x : array) if (x > max) max = x;
        int tenPow = (int) Math.pow(10, Math.floor(Math.log10(max)));	    
	    bucketSortR(array, array.length, tenPow);
	}

	/**
	 * Do one level of bucket sort for a given array at a power of ten.
	 * PRECONDITION: The elements in the given array are all equal to each
	 * other in the digits greater than tenPow
	 * @param array The array to sort
	 * @param n The number of elements in the array (may be smaller than array.len)
	 * @param tenPow The least power of ten at which the elements in the array differ
	 */
	private static void bucketSortR(Integer[] array, int n, int tenPow) {
	    // The array of buckets; each bucket is of size n
	    Integer[][] buckets = new Integer[10][n];
	    // The number of elements in each bucket so far
	    int[] counts = new int[10];
	    // Toss the elements in the given array into buckets
	    for (int i = 0; i < n; i++) {
	        int x = array[i];            // The current item
	        int b = (x / tenPow) % 10;   // The bucket to which it should go

	        // Add code to put that item in the bucket
	    }
	    // Add code here to sort (recursively) the buckets and to reassemble into array
	}
}
