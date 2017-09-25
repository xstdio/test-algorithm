package io.xstdio.algorithm.test;

import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class TestSort {

	/*
	 * In bubble sort we need n-1 iteration to sort n elements at end of first
	 * iteration larget number is sorted and subsequently numbers smaller than
	 * that.
	 */
	private void bubble_sort(int[] unsorted) {
		System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));

		// Outer loop - need n-1 iteration to sort n elements
		for (int i = 0; i < unsorted.length - 1; i++) {

			// Inner loop to perform comparision and swapping between adjacent
			// numbers
			// After each iteration one index from last is sorted
			for (int j = 1; j < unsorted.length - i; j++) {

				// If current number is greater than swap those two
				if (unsorted[j - 1] > unsorted[j]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[j - 1];
					unsorted[j - 1] = temp;
				}
			}
			System.out.printf("unsorted array after %d pass %s: %n", i + 1, Arrays.toString(unsorted));
		}
	}

	private void quick_sort(int[] unsorted, int lo, int hi) {
		
		if (lo < hi) {
			int p = quick_sort_partition(unsorted, lo, hi);
			System.out.println(lo+"|"+hi+"|"+p);
			quick_sort(unsorted, lo, p - 1);
			quick_sort(unsorted, p + 1, hi);
			
		}
	}

	private int quick_sort_partition(int[] unsorted, int lo, int hi) {
		int pivot = unsorted[hi];
		int i = lo - 1;
		for (int j = lo; j <= (hi - 1); j++) {
			if (unsorted[j] < pivot) {
				i = i + 1;
				// swap arr[i] and arr[j]
                int temp = unsorted[i];
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;
			}
		}
		// swap arr[i+1] and arr[high] (or pivot)
		System.out.println(i+"-"+Arrays.toString(unsorted));
        int temp = unsorted[i+1];
        unsorted[i+1] = unsorted[hi];
        unsorted[hi] = temp;
        System.out.println(pivot+"+"+Arrays.toString(unsorted));
		return i + 1;
	}

	@Test
	public void sort() {
		int[] test = { 5, 3, 2, 1, 6, 9, 4, 8, 7 };
		int[] unsorted = { 32, 39, 21, 45, 23, 3 };
		// bubble_sort(test);
		System.out.println("0*"+Arrays.toString(test));
		System.out.println("===");
		quick_sort(test, 0, test.length - 1);
		System.out.println("===");
		System.out.println("0*"+Arrays.toString(test));
	}

}