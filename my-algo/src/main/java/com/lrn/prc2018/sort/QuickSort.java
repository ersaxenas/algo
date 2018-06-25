package com.lrn.prc2018.sort;

import com.lrn.prc2018.util.SortUtils;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort<T extends Comparable<T>> {

	SortUtils<T> sortUtils = new SortUtils<>();

	public void sortArray(final T[] array, final int low, final int high) {
		StdRandom.shuffle(array); /*improves quicksort's performance*/
		/*recursively sort array*/
		sort(array, low, high);
	}

	public void sort(final T[] array, final int low, final int high) {
		/*recursively call sort method for right and left arrays
		 * ----left side ---- partition element ----- right side ----
		 * break if crossing arrays bounds
		 * if(upper bound is less then equal to lower bound)
		 * */
		/**
		 * recursion : base case / exit condition
		 * */
		if(high <= low) {
			return;
		}
		/**
		 * recursion: recursive case
		 */
		int partition = partition(array, low, high);
		/*sort left side of the array*/
		sort(array, low, partition -1);
		/*sort right side of the array*/
		sort(array, partition +1, high);
	}


	public Integer partition(final T[] array, final int low, final int high) {
		/*all the elements less then partition element are on the left side of leftSidePointer
		 * it starts at (low or 0) location
		 * It moves in the forward direction ++ and stops if it crosses array length (high).
		 * */
		int leftSidePointer = low;
		/*all the elements greater then partition element are on the right side of rightSidePointer
		 * it starts at (high or array length) + 1 location.
		 * It moves in the backward/reverse direction -- and stops if it crosses array first element (low).
		 * */
		int rightSidePointer = high + 1;
		/*this look runs till leftSidePointer crosses right side pointer
		 * break if leftSidePointer > rightSidePointer
		 * */
		while(true) {
			/* : forward direction loop
			 * increment ++ leftSide pointer and check if element is less then low
			 * if (less and leftSidePointer is not greater then high ) then continue
			 * else stop
			 * 		: if(leftSidePointer is greater then or equal to high then break)
			 * */
			while(sortUtils.isLess(array[++leftSidePointer], array[low])) {
				if(leftSidePointer == high) {
					break;
				}
			}
			/* : backward loop
			 * decrement -- rightSidePointer and check if element is greater then low
			 * if(greater and rightSidePointer is not less then equal to low) then continue
			 * else stop
			 * 		: if (rightSidePointer is greater then or equal to high then break)
			 */
			while(sortUtils.isLess(array[low], array[--rightSidePointer])) {
				if(rightSidePointer == low) {
					break;
				}
			}

			if(leftSidePointer >= rightSidePointer) {
				break; /*break infinite main loop*/
			}
			/* exchange elements at leftSidePointer and rightSidePointer
			 * */
			sortUtils.exch(array, leftSidePointer, rightSidePointer);
		}
		/*
		 * exchange partition element / first element with rightSidePointer
		 * when rightSidePointer crosses leftSidePointer it starts to point to last element less then
		 * partition element. Exchanging partition element with rightSidePointer will bring it in correct place.
		 */
		sortUtils.exch(array, low, rightSidePointer);
		/*return partition element*/
		return rightSidePointer;
	}




}
