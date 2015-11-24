package algo.sorting;

import static algo.sorting.utils.SortUtils.exch;
import static algo.sorting.utils.SortUtils.less;

import java.util.Arrays;

public class ShellSort {
	/*Insertion Sort*/
    public static <T extends Comparable<T>> T[] sort(T[] arr) {
    	
    	int step = 0;
    	while(step < (arr.length/3)) {
    		step = 3*step + 1;
    	}
        while (step >=1) {
        	
        	for(int i=step; i<arr.length; i++) {
        		for(int j=i; j>=step; j=j-step){
        			System.err.print("Step:"+step+",i:"+i+",j:"+j);
        			System.err.print("- e1:"+arr[j-step]+", e2:"+arr[j]+"\n");
        			if(less(arr[j],arr[j-step])) {
        				exch(arr, j, j-step);
        				System.err.println(Arrays.asList(arr));
        			}
        			else {
        				break;
        			}
        			
        		}
        		
        	}
        	step = step/3;
        }
    	
    	return arr;
    }

}
