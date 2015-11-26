package algo.sorting;

import java.util.Random;

import algo.sorting.utils.SortUtils;

public class Shuffler {

	/*Shuffle an array*/
	public static <T> T[] shuffle(T[] arr) {
		Random random = new Random();
		for(int cnt=0; cnt<arr.length; cnt++) {
			SortUtils.exch(arr, cnt, random.nextInt(cnt+1));
		}
		return arr;
	}
}
