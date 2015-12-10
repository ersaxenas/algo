package util;

import java.util.Random;

public class AlgoUtils {
	
	public static Integer[] getIntArray(int size) {
		Integer[] arr = new Integer[size];
		Random random = new Random();
		for(int cnt=0; cnt<arr.length; cnt++) {
			arr[cnt] = random.nextInt(size);
		}
		return arr;
	}
}
