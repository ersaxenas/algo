package com.lrn.prc2018.sort;


import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.lrn.prc2018.util.AlgoUtils;
import com.lrn.prc2018.util.SortUtils;

class SelectionSortTest {
	SelectionSort<Integer> selectionSort = new SelectionSort<>();
    SortUtils<Integer> sortUtils = new SortUtils<>();
	@Before
	void setUp() throws Exception {
	}

	@Test
	void testSortArray() {
		Integer[] intArray = AlgoUtils.getIntArray(5);
		System.out.println(Arrays.asList(intArray));
		selectionSort.sortArray(intArray);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}

}
