package alogpart1.queue;

import java.util.Arrays;

import algo.sorting.utils.SortUtils;

public class UnorderedMaxPQ<T extends Comparable<T>> {

	private T arr[] = null;
	private int top = 0;
	
	public UnorderedMaxPQ(int size) {
		arr = (T[]) new Comparable[size];
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void insertItem(T item) {
		arr[top++] = item;
	}
	
	public T delMin() {
		System.out.println(Arrays.asList(arr));
		int max = 0;
		for(int i = 1; i<top; i++) {
			if(!SortUtils.less(arr[max],arr[i])) {
				max = i;
			}
		}
		SortUtils.exch(arr,max,top-1);
		return arr[--top];
	}
	
	public T delMax() {
		System.out.println(Arrays.asList(arr));
		int max = 0;
		for(int i = 1; i<top; i++) {
			if(SortUtils.less(arr[max],arr[i])) {
				max = i;
			}
		}
		SortUtils.exch(arr,max,top-1);
		return arr[--top];
	}
	
	public int getPQSize() {
		return top;
	}
	
}
