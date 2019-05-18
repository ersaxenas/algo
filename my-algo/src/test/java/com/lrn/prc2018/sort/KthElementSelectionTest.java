package com.lrn.prc2018.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class KthElementSelectionTest {
	
	KthElementSelection<Integer> kthElementSelection = new KthElementSelection<>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelect() {
		Integer[] intArray = {5,2,9,0,1,7,3};
		System.out.println(Arrays.asList(intArray));
		assertTrue(1==kthElementSelection.select(intArray, 1));
		assertTrue(5==kthElementSelection.select(intArray, 4));
	}

}
