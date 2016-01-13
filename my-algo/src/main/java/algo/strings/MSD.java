package algo.strings;

import java.util.Arrays;

public class MSD {
	private final int R = 256;
	
	public void sortStrings(String[] arr) {
		String aux[] = new String[arr.length];
		sort(arr, aux, 0, arr.length -1, 0);
	}
	
	private void sort(String arr[], String aux[], int low, int hi, int d) {
		if(hi <= low) {
			return;
		}
		/*
		 * charAt return -1 if string contains less chars then other string.
		 * So string which have less chars should be places at the beginning of the aux array.
		 * ex: {"sd","werfr","lk","weafc"} sorting is being done on 3 char of the string.
		 * so for "sd" and "lk" charAt would return -1. These two string should be on the top of sorted result.
		 * count array : 0 2 .....
		 * here 1 means we have 2 short string and these string will be placed on the top of the sorted result.
		 */
		int[] count = new int[R+2];
		Arrays.fill(count, 0);
		
		for(int i=low; i <=hi; i++ ) {
            count[charAt(arr[i], d)+2]++;
		}
		for(int r=0; r<R+1; r++) {
			count[r+1] = count[r+1] + count[r];
		}
		for(int i=low; i<=hi; i++) {
			int key = charAt(arr[i],d) +1;
			aux[count[key]] = arr[i];
			count[key]++;
		}
		for(int i=low; i<=hi; i++) {
			arr[i] = aux[i-low];
		}
		
		for(int r=0;r<R;r++) {
			sort(arr,aux,low+count[r],low+count[r+1]-1,d+1);
		}
		
	}
	
	private int charAt(String str, int d){
		if(d<str.length()) {
			return str.charAt(d);
		}
		else {
			return -1;
		}
	}

}
