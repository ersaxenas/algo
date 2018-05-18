package com.lrn.prc2018.sort;

import edu.princeton.cs.algs4.StdRandom;

public class KthElementSelection<T extends Comparable<T>> {

	QuickSort<T> quickSort = new QuickSort<>();
	
	public T select(T[] array, int k) {
		StdRandom.shuffle(array);
		int low = 0,  high = array.length -1;
		/*divide and conquer
		 * partition array using quick sort 
		 * if K is less then partition index then search in the left side array
		 * if K is greater then partition index then search in the right side array
		 * else return element at partition index
		 * <---left side array---> Partition Index <----right side array---->
		 * low........................^^^^^^.............................high     
		 * */
		/*since we keep dividing look check for upper and lower bounds*/
         while(high > low) {
        	  int partitionIndex = quickSort.partition(array, low, high);
        	  if(k < partitionIndex) {
        		  /*search left side sub array*/
        		  high = partitionIndex -1;
        	  } else if(k > partitionIndex) {
        		  /*search right side sub array*/
        		  low = partitionIndex + 1;
        	  }
        	  else {
        		return array[k];  
        	  }
         }
		return array[k];
	}
	
}
