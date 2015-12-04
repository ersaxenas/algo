package algo.sorting;

import edu.princeton.cs.algs4.StdRandom;
import algo.sorting.utils.SortUtils;

public class QuickSort {
	
	/*Function partitions array*/
	public static <T extends Comparable<T>> int partition(T[] arr, int lowBound, int highBound) {
		int  i = lowBound, j = highBound+1;
		while(true) {
			while(SortUtils.less(arr[++i], arr[lowBound])) {
				if(i == highBound ) break;
			}
			
			while(SortUtils.less(arr[lowBound], arr[--j])) {
				if(j == lowBound) break;
			}
			if(i>=j) {
				break;
			}
			SortUtils.exch(arr, i, j);
		}
		SortUtils.exch(arr, lowBound, j);
		return j;
	}
	
	/*Function to sort array*/
	private static <T extends Comparable<T>> T[] sort(T[] arr, int low, int high) {
		if(high <= low) {return arr;}
		int ptn = partition(arr, low, high);
		sort(arr,low, ptn-1);
		sort(arr,ptn+1, high);
		return arr;
	}
	/**/
	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		StdRandom.shuffle(arr);
		sort(arr, 0, arr.length -1);
		return arr;
	}

}
