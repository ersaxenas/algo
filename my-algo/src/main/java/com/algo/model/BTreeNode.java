package com.algo.model;

import algo.symboltable.BinarySearchTree.Node;

public class BTreeNode<K extends Comparable<K>, V> {
	private K key;
	private V val;
	private BTreeNode<K, V> leftNode;
	private BTreeNode<K, V> rightNode;
	private int count;

	public BTreeNode(K key, V val, int count) {
		this.key = key;
		this.val = val;
		this.count = count;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getVal() {
		return val;
	}

	public void setVal(V val) {
		this.val = val;
	}

	public BTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BTreeNode [{key=" + key + ", val=" + val +", count= "+count+ "} leftNode->" + ((leftNode == null ) ? " empty " : leftNode.getKey()) + ", rightNode->" + ((rightNode == null ) ? " empty " : rightNode.getKey())+"]";
	}

}
