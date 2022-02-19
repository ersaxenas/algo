package com.lrn.prc2018.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.lrn.prc2018.util.AlgoUtils;
import com.lrn.prc2018.util.SortUtils;

public class DupQuickSortTest {
	
	SortUtils<Integer> sortUtils = new SortUtils<>();
	DupQuickSort<Integer> dupQuickSort = new DupQuickSort<>();

	@Test
	public void testSortArray() {
		Integer[] intArray = AlgoUtils.getIntArray(10);
		System.out.println(Arrays.asList(intArray));
		dupQuickSort.sortArray(intArray, 0, intArray.length-1);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}

}
