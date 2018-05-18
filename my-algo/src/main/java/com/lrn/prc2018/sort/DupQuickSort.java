package com.lrn.prc2018.sort;

import com.lrn.prc2018.util.SortUtils;

public class DupQuickSort<T extends Comparable<T>> {
	SortUtils<T> sortUtils = new SortUtils<>();

	public void sortArray(T[] array, int low, int high) {
		/**
		 * recursion base case:
		 * high <= low the exit
		 */
		if(high <= low) {
			return;
		}
		
		int forwardPointer = low;
		int lessThenPointer = low; 
		T partitioningEelement = array[low];
		int greaterThenPointer = high;
		/*loop till forwardPointer >= greaterThenPointer
		 * if( forwardPointer element < lessThenPointer) then exchange both and increment both
		 * if( forwardPointer element > lessThenPointer) then exchange forward pointing element
		 * with greater then pointing element and decrement greaterThenPointer -- ONLY
		 * if( forwardPointer element == lessThenPointer element) then increment ++ forward pointing element ONLY
		 * <--LT--><--EQ--><--GT-->
		 * */
		while(forwardPointer <= greaterThenPointer) {
			int comp = array[forwardPointer].compareTo(partitioningEelement);
			if(comp < 0 ) {
				sortUtils.exch(array, forwardPointer, lessThenPointer);
				forwardPointer ++;
				lessThenPointer ++;
			} else if(comp > 0) {
				sortUtils.exch(array, forwardPointer, greaterThenPointer);
				greaterThenPointer--;
			} else {
				forwardPointer++;
			}
		}
		/**
		 * recursion : recursive case
		 */
		/*sort LT sub array - [low, lessThenPointer-1]*/
		sortArray(array, low, lessThenPointer-1);
		/*sort GT sub array - [greaterThenPointer+1, high]*/
		sortArray(array, greaterThenPointer+1, high);
	}
	
	
	
}
