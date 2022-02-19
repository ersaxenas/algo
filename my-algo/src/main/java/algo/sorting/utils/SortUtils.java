package algo.sorting.utils;

public class SortUtils {
	
	public static <T extends Comparable<T>> boolean less(Comparable<T> aux, Comparable<T> aux2) {
		return aux.compareTo((T) aux2) < 0;
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
	public static <T extends Comparable<T>> boolean isSorted(T[] arr, int start, int end) {
		int upperBound = (end>=arr.length) ? arr.length : end;
		int lowerBound = (start <= 0) ? 1 : start+1;
		for(int cnt=lowerBound; cnt<upperBound; cnt++) {
			if(less(arr[cnt],arr[cnt-1])) {
				System.out.println("asserting failed");
				System.out.println(start+":"+arr[cnt]);
				System.out.println(end+":"+arr[end]);
			   return false;	
			}
		}
		return true;
	}

}
