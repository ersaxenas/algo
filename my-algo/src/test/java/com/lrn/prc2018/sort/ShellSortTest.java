package com.lrn.prc2018.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.lrn.prc2018.util.AlgoUtils;
import com.lrn.prc2018.util.SortUtils;

public class ShellSortTest {

	ShellSort<Integer> shellSort = new ShellSort<>();
	SortUtils<Integer> sortUtils = new SortUtils<>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Integer[] intArray = AlgoUtils.getIntArray(100);
		System.out.println(Arrays.asList(intArray));
		shellSort.sortArray(intArray);
		System.out.println(Arrays.asList(intArray));
		assertTrue(sortUtils.isSorted(intArray));
	}

}
