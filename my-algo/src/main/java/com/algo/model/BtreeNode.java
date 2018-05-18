package com.algo.model;

import algo.symboltable.BinarySearchTree.Node;

public class BtreeNode<K extends Comparable<K>, V> {
	private K key;
	private V val;
	private Node leftNode;

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

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private Node rightNode;
	private int count;

	public BtreeNode() {
	}

	public BtreeNode(K key, V val) {
		this.key = key;
		this.val = val;
	}

}
