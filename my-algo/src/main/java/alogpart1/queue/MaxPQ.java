package alogpart1.queue;

import java.util.Arrays;

import algo.sorting.utils.SortUtils;

public class MaxPQ <T extends Comparable<T>>{
	
	private T arr[] = null;
	private int top=0;
	
	public MaxPQ(int size) {
		arr = (T[]) new Comparable[size];
	}
	
	public void insert(final T key) {
		System.out.println("Insert:"+key);
		if(top <=arr.length -1) {
			arr[++top] = key;
		}
		swim(top);
	}
	
	public void swim(int k) {
		while(k > 1 && SortUtils.less(arr[k/2], arr[k])) {
			SortUtils.exch(arr, k/2, k);
			k=k/2;
		}
		System.out.println("Swim:"+Arrays.asList(arr));
	}
	
	public void sink(int k) {
		int j = 0;
		while( 2*k <= top ) {
			j = 2*k;
			if(j < top &&SortUtils.less(arr[j],arr[j+1])) {
				j++;
			}
			if(SortUtils.less(arr[k],arr[j])) {
				SortUtils.exch(arr, k, j);
			}
			else {
				break;
			}
			k = j;
		}
		System.out.println("Sink"+Arrays.asList(arr));
	}
	
	public T delMax() {
		T max = arr[1];
		SortUtils.exch(arr, top--, 1);
	    arr[top+1] = null;
	    sink(1);
	    System.out.println("DelMax:"+Arrays.asList(arr));
	    return max;
	}
	

}
