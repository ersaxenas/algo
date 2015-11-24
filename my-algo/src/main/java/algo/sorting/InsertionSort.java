package algo.sorting;
import static algo.sorting.utils.SortUtils.less;
import static algo.sorting.utils.SortUtils.exch;
public class InsertionSort {
	
	/*Insertion Sort*/
    public static <T extends Comparable<T>> T[] sort(T[] arr) {
    	
    	for(int i=0; i<arr.length; i++) {
    		for(int j=i; j>0; j--){
    			if(less(arr[j],arr[j-1])) {
    				exch(arr, j, j-1);
    			}
    			else {
    				break;
    			}
    		}
    	}
    	return arr;
    }
}
