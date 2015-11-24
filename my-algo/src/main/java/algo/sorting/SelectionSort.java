package algo.sorting;
import static algo.sorting.utils.SortUtils.exch;
import static algo.sorting.utils.SortUtils.less;;
public class SelectionSort  {
	/*Selection sort implementation*/
	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		for(int i=0; i<arr.length; i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				/*if current element is smaller then current min.*/
				if(less(arr[j],arr[min])) {
					min = j;
				}
			}
			/*swap element at i with min*/
			exch(arr, i, min);
		}
		return arr;
	}

}
