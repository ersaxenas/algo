package com.lrn.prc2018.sort;


import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.lrn.prc2018.util.AlgoUtils;
import com.lrn.prc2018.util.SortUtils;

class MergeSortTest {
	
	MergeSort<Integer> mergeSort = new MergeSort<>();
	SortUtils<Integer> sortUtils = new SortUtils<>();

	@Before
	void setUp() throws Exception {
	}
	@Test
	void testMergeArray() {
		Integer[] intArray = {22,34,35, 3,4};
		System.out.println(Arrays.asList(intArray));
		Integer[] auxArray = new Integer[intArray.length];
		mergeSort.mergeArray(intArray, auxArray,0,intArray.length/2,intArray.length-1);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}
	@Test
	void testBuSort() {
		Integer[] intArray = {22,34,35, 3,4,40};
		System.out.println(Arrays.asList(intArray));
		Integer[] auxArray = new Integer[intArray.length];
		mergeSort.buSort(intArray, auxArray);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}
	
	@Test
	void testSortArray() {
		Integer[] intArray = AlgoUtils.getIntArray(5);
		System.out.println(Arrays.asList(intArray));
		Integer[] auxArray = new Integer[intArray.length];
		mergeSort.sortArray(intArray, auxArray, 0, intArray.length-1);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}

}
