package com.lrn.prc2018.sort;

import com.lrn.prc2018.util.SortUtils;

public class InsertionSort<T extends Comparable<T>> {

	SortUtils<T> sortUtils = new SortUtils<>();
	
	public void sortArray(T[] intArray) {
		/*start with second element in the array
		 * move in forward direction ++
		 * break look if reached at the end of element
		 * */
		for(int cnt1=1; cnt1<intArray.length; cnt1++) {
			/*traverse in the reverse direction and sort elements of left side array
			 * elements ---- cnt1/current pointer ---- rest of the elments
			 * <---left side array--->    ^   <---right side of the array --->
			 * sort left side array
			 * */
			for(int cnt2=cnt1; cnt2>0; cnt2--) {
				/*compare if elements at current index with index -1*/
				if(sortUtils.isLess(intArray[cnt2], intArray[cnt2-1])) {
					/*if element at index - 1 is less then element at index then swap*/
					sortUtils.exch(intArray, cnt2, cnt2-1);
				} else {
					break; /*IMP : since left of the loop always is kept sorted just need to swap once*/
				}
			}
		}
	}
	
}
