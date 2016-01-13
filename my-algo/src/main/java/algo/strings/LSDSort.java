package algo.strings;

import java.util.Arrays;

public class LSDSort {
	
	public void sort(String str[], int W) {
		int R = 256;
		int N = str.length;
		String aux[] = new String[N];
		Integer count[] = new Integer[R+1]; 
		for(int sd=W; sd >= 0; sd-- ) {
			Arrays.fill(count, 0);
			/*
			 * steps:
			 * 1) Frequency: count[arr[i]+1] = count[arr[i]+1] + 1 OR count[arr[i]+1]++ where i is 0 .. arr.len
			 * 2) Cumulates : count[r+1] = count[r+1] + count[r] OR count[r+1] += count[r] where r is 0 .. aux.len
			 * 3). Fill AUX arr with key based on range
			 * int key = arr[i] where i is 0 ... arr.len
			 * int start = count[key];
			 * aux[start] = key;
			 * count[start] = start +1;
			 * 4) copy content of aux to arr
			 */
			for(int cnt=0; cnt<N; cnt++) {
				count[str[cnt].charAt(sd)+1]++;
			}
			for(int cnt=0; cnt<R; cnt++) {
				count[cnt+1] = count[cnt+1] + count[cnt];
			}
			for(int cnt=0; cnt<N; cnt++) {
				/*String key = str[cnt];
				int start = count[key.charAt(sd)];
			    aux[start] = key;
			    count[start] = start +1;*/
				String key = str[cnt];
			    aux[count[key.charAt(sd)]++] = key;
			}
			for(int cnt=0; cnt<N; cnt++) {
				str[cnt] = aux[cnt];
			}
		}
		
		
	}

}
