package com.lrn.prc2018.sort;


import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.lrn.prc2018.util.SortUtils;

class QuickSortTest {
	
	SortUtils<Integer> sortUtils = new SortUtils<>();
	QuickSort<Integer> quickSort = new QuickSort<>();

	@Before
	void setUp() throws Exception {
	}

	@Test
	void testSortArray() {
		Integer[] intArray = {22,34,35, 3,4,40};
		System.out.println(Arrays.asList(intArray));
		quickSort.sort(intArray, 0, intArray.length-1);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}

}
