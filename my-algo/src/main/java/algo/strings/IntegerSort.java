package algo.strings;

import java.util.Arrays;

public class IntegerSort {
  
	public Integer[] sort(Integer arr[], int range) {
		Integer R = range;
		Integer N = arr.length;
		Integer aux[] = new Integer[N];
		Integer count[] = new Integer[R+1];
		Arrays.fill(count, 0);
		
		/*
		 * steps:
		 * 1) Frequency: count[arr[i]+1] = count[arr[i]+1] + 1 OR count[arr[i]+1]++ where i is 0 .. arr.len
		 * 2) Cumulates : count[r+1] = count[r+1] + count[r] OR count[r+1] += count[r] where r is 0 .. aux.len
		 * 3) Fill AUX arr with key based on range
		 * int key = arr[i] where i is 0 ... arr.len
		 * int start = count[key];
		 * aux[start] = key;
		 * count[start] = start +1;
		 * 4) copy content of aux to arr
		 */
		
		
		/*find frequency*/
		for(int cnt=0; cnt<N; cnt++) {
			count[arr[cnt]+1]++;
		}                   
		System.out.println("freq                       :"+Arrays.asList(count));
		/*calculate cumulate*/
		for(int cnt=0; cnt<R; cnt++) {
			count[cnt+1] = count[cnt+1] + count[cnt];
		}                   
		System.out.println("cumulates                  :"+Arrays.asList(count));
		/*fill aux array by iterating over arr and placing int based on calculated cumulates range*/
		for(int cnt=0; cnt<N; cnt++) {
			int key = arr[cnt];
			aux[count[key]] = key;
			count[key] = count[key] + 1;
			System.out.println("cumulates                  :"+Arrays.asList(count));
		}                   
		System.out.println("Aux array                  :"+Arrays.asList(aux));
		/*copy aux to original array*/
		for(int cnt=0; cnt<N; cnt++) {
			arr[cnt] = aux[cnt];
		}
		return arr;
	}
	
	
	
}
