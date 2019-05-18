package algo.sorting;


import java.util.Arrays;

import util.AlgoUtils;
import algo.sorting.utils.SortUtils;

public class App {
	
	public void testSelectionSort(int size) {
		Integer[] arr = AlgoUtils.getIntArray(size);
		System.out.println("Selection sort: Initial array:"+Arrays.asList(arr));
		arr = SelectionSort.sort(arr);
		System.out.println("array:"+Arrays.asList(arr));
	}
	
	public void testInsertionSort(int size) {
		Integer[] arr = AlgoUtils.getIntArray(size);
		System.out.println("Insertion sort :Initial array:"+Arrays.asList(arr));
		arr = InsertionSort.sort(arr);
		System.out.println("array:"+Arrays.asList(arr));
	}
	
	public void testShellSort(int size) {
		Integer[] arr = AlgoUtils.getIntArray(size);
		System.out.println("Shell Sort : Initial array:");
		System.out.println(Arrays.asList(arr));
		arr = ShellSort.sort(arr);
		if(SortUtils.isSorted(arr)) {
			System.out.println("Sorted");
		}
		System.out.println("array:");
		System.out.println(Arrays.asList(arr));
	}
	
	
	public void testShuffle(int size) {
		Integer[] arr = new Integer[size];
		for(int cnt=0; cnt<arr.length; cnt++) {
			arr[cnt] = cnt;
		}
		System.out.println("Shuffling: Initial array:"+Arrays.asList(arr));
		arr = Shuffler.shuffle(arr);
		System.out.println("Shuffled array:"+Arrays.asList(arr));
	}
	
	public void testMergeSort(int size) {
		Integer[] arr = AlgoUtils.getIntArray(size);
		System.out.println("Merge Sort : Initial array:");
		System.out.println(Arrays.asList(arr));
		 MergeSort.sort(arr);
		if(SortUtils.isSorted(arr)) {
			System.out.println("Sorted");
		}
		System.out.println("array:");
		System.out.println(Arrays.asList(arr));
	}
	
	public void testQuickSort(int size) {
		Integer[] arr = AlgoUtils.getIntArray(size);
		System.out.println("Quick Sort : Initial array:");
		System.out.println(Arrays.asList(arr));
		 QuickSort.sort(arr);
		if(SortUtils.isSorted(arr)) {
			System.out.println("Sorted");
		}
		System.out.println("array:");
		System.out.println(Arrays.asList(arr));
	}
	
	public void testSelectionItem(int size) {
		Integer[] arr = {4,6,2,7,1,4,0,3,5,9,8};
		System.out.println("Selection Item : Initial array:");
		System.out.println(Arrays.asList(arr));
        System.out.println(SelectionBasedOnQuickSort.find(arr, 11));
	}
	
	public void test3WayQuickSort(int size) {
		Integer[] arr = AlgoUtils.getIntArray(size);
		System.out.println("3WayQuick Sort : Initial array:");
		System.out.println(Arrays.asList(arr));
		 QuickSort.sortDup(arr);
		if(SortUtils.isSorted(arr)) {
			System.out.println("Sorted");
		}
		System.out.println("array:");
		System.out.println(Arrays.asList(arr));
	}
	
	public void testHeapSort(int size) {
		Integer[] arr = {4,3,5,6,7,8,9,33,55,66,22,10};
		System.out.println("Heap Sort : Initial array:");
		System.out.println(Arrays.asList(arr));
		HeapSort hs = new HeapSort<Integer>();
		hs.sort(arr);
		if(SortUtils.isSorted(arr)) {
			System.out.println("Sorted");
		}
		else {
			System.out.println("NOT Sorted");
		}
		System.out.println("array:");
		System.out.println(Arrays.asList(arr));
	}
	
	public static void main(String args[]) {
		App app = new App();
		app.testHeapSort(10);
	}

}
