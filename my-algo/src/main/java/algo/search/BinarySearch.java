package algo.search;

public class BinarySearch<T extends Comparable<T>> {

	public int search(T[] arr, T key) {
		int low = 0, high = arr.length -1;
		int mid = 0, cmp =0;
		while(low <= high) {
			mid = low + ((high - low) /2);
			cmp = key.compareTo(arr[mid]);
			if(cmp < 0) {
				high = mid-1;
			}
			else if(cmp > 0) {
				low = mid+1;
			}
			else {
				return mid;
			}
		}
		return low;
	}
	
}
