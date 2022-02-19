package com.lrn.prc2018.sort;

import java.util.Arrays;

import com.lrn.prc2018.util.SortUtils;

public class MergeSort<T extends Comparable<T>> {
	/**
	 * merge sort can sort big files and big datasets.
	 */
	
	SortUtils<T> sortUtils = new SortUtils<>();
	
	/*bottom up merger sort (no recursion)*/
	public void buSort(T[] array, T[] auxArray) {
		int arrayLength = array.length;
		/*generate size 1,2,4,8,16..*/
		for(int subArraySize = 1; subArraySize < arrayLength; subArraySize = subArraySize * 2) {
			/*for sub arrays of subArraySize call merge method
			 *  ex. if size is 2 then two arrays [0][1], [2][3] should be merged 
			 *  so for size 2 increment counter by low + (size of 2 arrays = 2 * sub array size)
			 *  stop at array length - sub array size
			 * */
			for(int low = 0; low < (arrayLength - subArraySize); low = low + (2*subArraySize)) {
				/*
				 * two sub arrays 
				 * 1). low , mid = low + size -1
				 * 2). minimum of low + 2*size -1 or array length -1
				 *  
				 */
				int mid = low + subArraySize -1;
				int high = Math.min(low + 2*subArraySize -1, arrayLength -1 );
				System.out.println(subArraySize+","+low+","+mid+","+high);
				mergeArray(array, auxArray, low, mid,high);
			}
		}
	}
	
	/*Merger sort*/
	public void sortArray(T[] array, T[] auxArray,int low, int high) {
		/**
		 * recursion : base case / exit case
		 */
		if(high <= low) {
			return;
		}
		int mid = low + (high - low)/2;
		/**
		 * recursion : recursive case
		 */
		sortArray(array, auxArray, low, mid);
        sortArray(array, auxArray, mid+1, high);
        mergeArray(array, auxArray,low, mid, high);
	}
	
	
	public void mergeArray(T[] mainArray, T[] auxArray, int low, int mid, int high) {
		/*works only for sorted sub arrays. so low to mid and mid to high two subarrays must be sorted.*/
		assert sortUtils.isSorted(mainArray, low, mid) : "left half not sorted";
		assert sortUtils.isSorted(mainArray, mid+1, high) : "right half not sorted";
		/*take two counter variables*/
		int leftHalfPointer = low;
		int rightHalfPointer = mid+1;
		/*copy data to aux array*/
		for(int cnt=low; cnt<=high; cnt++) {
			auxArray[cnt] = mainArray[cnt];
		}
		/*start from low and stop at high*/
		for(int cnt=low; cnt<=high; cnt++) {
			/*if left pointer reached to end (mid) the append only right side of the elements*/
			if(leftHalfPointer > mid) {
				mainArray[cnt] = auxArray[rightHalfPointer++];
			}/*if right pointer reached to end (high) then append only left side of the elements*/
			else if(rightHalfPointer > high) {
				mainArray[cnt] = auxArray[leftHalfPointer++];
			} /*if element at LEFT HALF if smaller then element at  RIGHT HALF then append element from left side*/ 
			else if(sortUtils.isLess(auxArray[leftHalfPointer], auxArray[rightHalfPointer])) {
				mainArray[cnt] = auxArray[leftHalfPointer++];
			} /*if element at RIGHT HALF smaller then element at LEFT HALF then append element from right side */
			else {
				mainArray[cnt] = auxArray[rightHalfPointer++];
			}
		}
		
	}

}
