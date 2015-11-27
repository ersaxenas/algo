package algo.sorting;

import algo.sorting.utils.SortUtils;

public class MergeSort {
	/**
	 * Function sorts array using merge sort algorithm.
	 * @param arr - Array containing data.
	 * @param aux - Auxiliary array.
	 * @param low - lower boundary / start 
	 * @param mid - Middle boundary / Mid
	 * @param high - Upper boundary / high
	 * @return Sorted array arr[].
	 */
	private static <T extends Comparable<T>> T[] merge(T[] arr, T[] aux, int low, int mid, int high) {
		assert(SortUtils.isSorted(arr, low, mid)); /*Check if array1 is sorted*/
		assert(SortUtils.isSorted(aux, mid+1, high)); /*Check if array2 is sorted*/
		/*copy in to auxiliary array.*/
		for(int cnt=0; cnt<arr.length; cnt++) {
			aux[cnt] = arr[cnt];
		}
		/*Start of array1*/
		int arr1Cnt = low;
		/*Start of array2*/
		int arr2Cnt = mid+1;
		for(int cnt=0; cnt<high; cnt++) {
			
			if(arr1Cnt>mid) {/*if array1 counter has reached mid, then take rest of the elements from array2 only*/
				arr[cnt] = aux[arr2Cnt++]; 
			}
			else if(arr2Cnt>high) {/*if array2 counter has reached end, then take rest of the elements from array1 only*/
				arr[cnt] = aux[arr1Cnt++]; 
			}
			else if(SortUtils.less(aux[arr1Cnt], aux[arr2Cnt])) {/*if array1 element is smaller then array2 element, then take array1 element*/
				arr[cnt] = aux[arr1Cnt++];
			}
			else {/*if array2 element is smaller then array1 element, then take array2 element*/
				arr[cnt] = aux[arr2Cnt++];
			}
		}
		assert(SortUtils.isSorted(arr)); /*Check if whole array is sorted.*/
		return arr;
	}
	/**
	 * Function divides in to 2 then sorts and then merges the two array. 
	 * @param arr
	 * @param aux
	 * @param low
	 * @param high
	 */
	private static <T extends Comparable<T>> void sort(T[] arr, T[] aux, int low, int high) {
		if(low >= high) {
			return;
		}
        int mid = low + ((high -low)/2);		
		sort(arr, aux, low, mid);
		sort(arr,aux,mid+1, high);
		merge(arr,aux,low,mid,high);
	}
	
	public static <T extends Comparable<T>> void sort(T[] arr) {
		Comparable aux[] = new Comparable[arr.length];
		sort(arr, aux, 0, arr.length-1);
	}
	

}
