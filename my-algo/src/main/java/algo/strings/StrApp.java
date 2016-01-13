package algo.strings;

import java.util.Arrays;

import algo.sorting.utils.SortUtils;

public class StrApp {
	public void testIntegerSort(int size) {
		Integer[] arr = {7,7,2,2,7,7,3,3,9,1,3,3,5,5};
		System.out.println("Integer sort :Initial array:"+Arrays.asList(arr));
		IntegerSort sort = new IntegerSort();
		sort.sort(arr,10);
		if(SortUtils.isSorted(arr)) {
			System.out.println("Sorted");
		}
		else {
			System.out.println("NOT Sorted");
		}
		System.out.println("array:"+Arrays.asList(arr));
	}
	public void lsdSort() {
		String arr[] =  {"aad","aac","zzz","aab","aaa"};
		LSDSort sort = new LSDSort();
		sort.sort(arr, 2);
		System.out.println(Arrays.toString(arr));
	}
	
	public void msdSort() {
		String arr[] =  {"aads","ac","zzzdd","asab","aa"};
		MSD sort = new MSD();
		sort.sortStrings(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[]) {
		StrApp app = new StrApp();
		app.msdSort();
	}
}
