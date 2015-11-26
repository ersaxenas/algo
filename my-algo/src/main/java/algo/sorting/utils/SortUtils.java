package algo.sorting.utils;

public class SortUtils {
	
	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	public static <T> void exch(T[] arr, int i, int j) {
		T swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
		for(int cnt=1; cnt<arr.length; cnt++) {
			if(less(arr[cnt],arr[cnt-1])) {
			   return false;	
			}
		}
		return true;
	}

}
