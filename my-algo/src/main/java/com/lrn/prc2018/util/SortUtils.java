package com.lrn.prc2018.util;

public class  SortUtils<T extends Comparable<T>> {
	
	public boolean isLess(Comparable<T> elem1, Comparable<T> elem2) {
		return elem1.compareTo((T) elem2) < 0;
	}
	
	public void exch(T[] arr, int elem1, int elem2) {
		T temp = arr[elem1];
		arr[elem1] = arr[elem2];
		arr[elem2] = temp;
	}
	
	public boolean isSorted(T[] arr, int start, int end) {
		if(start == end) {
			return true;
		}
		int upperBound = (end>=arr.length)? arr.length-1: end;
		int lowerBound = (start<=1)? 1 : start+1;
		for(int cnt=lowerBound; cnt<upperBound;cnt++) {
			if(isLess(arr[cnt], arr[cnt-1])) {
				System.out.println("asserting failed");
				System.out.println(start+":"+arr[cnt]);
				System.out.println(end+":"+arr[end]);
			   return false;	
			}
		}
		return true;
	}
	public boolean isSorted(T[] arr) {
		return isSorted(arr, 0, arr.length-1);
	}

}
