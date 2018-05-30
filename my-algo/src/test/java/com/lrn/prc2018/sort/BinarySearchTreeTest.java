package com.lrn.prc2018.sort;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lrn.prc2018.tree.BinarySearchTree;

public class BinarySearchTreeTest {
	
	private static BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

	@BeforeClass
	public static void setup() {
		binarySearchTree.put(10, "key-10").put(9, "key-09").put(7, "key-07").put(13, "key-13").put(17, "key-17")
		.put(3, "key-03").put(5, "key-05");
	}
	
	@Test
	public void testGet() {
		assertTrue("key-13".equals(binarySearchTree.get(13).orElse("none")));
	}

	@Test
	public void testPut() {
		binarySearchTree.put(27, "key-27");
		assertTrue("key-27".equals(binarySearchTree.get(27).orElse("none")));
	}
	
	@Test
	public void testSize() {
		assertTrue(7 == binarySearchTree.size());
	}
	@Test
	public void testRank() {
		assertTrue(5 == binarySearchTree.rank(13));
	}
	@Test
	public void testGetKeys() {
		Iterable<Integer> keys = binarySearchTree.getKeys();
		assertTrue(keys != null);
        System.out.println(keys);
	}

}
