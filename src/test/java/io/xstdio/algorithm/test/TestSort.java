package io.xstdio.algorithm.test;

import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

public class TestSort {

	/*
     * In bubble sort we need n-1 iteration to sort n elements
     * at end of first iteration larget number is sorted and subsequently numbers smaller
     * than that.
     */
    public static void bubble_sort(int[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));
      
        // Outer loop - need n-1 iteration to sort n elements
        for(int i=0; i<unsorted.length -1; i++){
          
            //Inner loop to perform comparision and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<unsorted.length -i; j++){
              
                //If current number is greater than swap those two
                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
        }
    }

	@Test
	public void sort() {
		int[] test = { 5, 3, 2, 1};
		int[] unsorted = {32, 39,21, 45, 23, 3};
//		bubble_sort(unsorted);
		bubble_sort(test);

	}
	
	
}