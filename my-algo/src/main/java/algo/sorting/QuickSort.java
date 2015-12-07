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
	/*Default quick sort*/
	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		StdRandom.shuffle(arr);
		sort(arr, 0, arr.length -1);
		return arr;
	}
	/*Quick sort for arrays containing duplicates */
	public static <T extends Comparable<T>> T[] sortDup(T[] arr) {
        int low =0, high = arr.length -1;		
        sortDup(arr, low, high);
		return arr;
	}
	
	/*Quick sort for arrays containing duplicates */
	private static <T extends Comparable<T>> void sortDup(T[] arr, int low , int high) {
       if(high <= low) {
    	   return;
       }
	   T v = arr[low];
	   int lt = low, gt = high, i = low;
	   
	   while(i <= gt) {
		   
		   int cmp = arr[i].compareTo(v);
		   if(cmp < 0) { /*a[i] < v then exchange and increment lt and i*/ 
			   SortUtils.exch(arr, lt++, i++);
		   }
		   else if ( cmp > 0) {/*a[i] > v then exchange and decrement gt only*/ 
			   SortUtils.exch(arr, i, gt--);
		   }
		   else { /* a[i] == v then increment i only*/
			   i++;
		   }
	   }
	  sortDup(arr, low, lt-1);
	  sortDup(arr, gt+1, high);	
        
	}
	
	

}
