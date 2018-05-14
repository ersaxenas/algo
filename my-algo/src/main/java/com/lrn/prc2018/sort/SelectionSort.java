package com.lrn.prc2018.sort;

import com.lrn.prc2018.util.SortUtils;

public class SelectionSort<T extends Comparable<T>> {
	SortUtils<T> sortUtils = new SortUtils<>();
	
	public T[] sortArray(T[] array) {
		/*Iterate over elements
		 * move in forward direction ++
		 * stop when reached at the end of array
		 * */
		for(int cnt1=0; cnt1<array.length; cnt1++) {
			/*assume minimum element is at current index -> cnt1*/
			int minElem = cnt1;
			/*start with next element in the 2nd for loop and find smallest element
			 * <-----left  ^  right------->
			 * find element smaller then current element at position cnt1 in the right side of the array
			 * */
			for(int cnt2=cnt1+1; cnt2<array.length; cnt2++) {
				if(sortUtils.isLess(array[cnt2], array[minElem])) {
					minElem = cnt2;
				}
			}
			/*swap element at index of loop 1 with smallest element and move to next index and repeat*/
			sortUtils.exch(array, cnt1, minElem);
		}
		return array;
	}

}
