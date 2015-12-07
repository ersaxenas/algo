package algo.sorting;

public class SelectionBasedOnQuickSort {
	
	public static <T extends Comparable<T>> T find(T[] arr, int item) {
		int mid = 0, low =0, high = arr.length-1;
		while(high > low) {
			mid = QuickSort.partition(arr, low, high);
			/**
			 *  low - - - - - - - mid - - - - - - high 
			 *               item<mid<item
			 */
			
			if(item < mid) {
				high = mid - 1;
			}
			else if(mid < item) {
				low = mid + 1;
			}
			else {
				return arr[item];
			}
		}
		
		return arr[item];
	}

}
