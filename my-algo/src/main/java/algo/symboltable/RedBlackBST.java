package algo.symboltable;

import java.util.ArrayDeque;
import java.util.Queue;

public class RedBlackBST<K extends Comparable<K>, V> {
	private Node root;
	private boolean RED = true;
	private boolean BLACK = false;

	public void put(K key, V val) {
		//System.out.println("Inserting :(" + key + "," + val + ")");
		root = put(root, key, val);
	}

	private Node put(Node root, K key, V val) {
		Node x = root;
		if (x == null) {
			Node node = new Node(key, val);
			node.count = 1;
			return node;
		}
		int cmp = key.compareTo(x.getKey());
		if (cmp < 0) {
			x.setLeftNode(put(x.getLeftNode(), key, val));
		} else if (cmp > 0) {
			x.setRightNode(put(x.getRightNode(), key, val));
		} else {
			x.setVal(val);
		}
		
		if(isRed(x.rightNode) && !isRed(x.leftNode)) {
			x = rotateLeft(x);
		}
		if(isRed(x.leftNode) && isRed(x.leftNode.leftNode)) {
			x = rotateRight(x);
		}
		if(isRed(x.leftNode) && isRed(x.rightNode)) {
			flipTheColor(x);
		}
		x.setCount(1 + size(x.getLeftNode()) + size(x.getRightNode()));
		return x;
	}

	public V getValue(K key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.getKey());
			if (cmp < 0) {
				x = x.getLeftNode();
			} else if (cmp > 0) {
				x = x.getRightNode();
			} else {
				return x.getVal();
			}
		}
		return null;
	}

	public void delete(K key) {
		//root = delete(root, key);
	}

	private Node delete(Node x, K key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.leftNode = delete(x.leftNode, key);
		} else if (cmp > 0) {
			x.rightNode = delete(x.rightNode, key);
		} else {
			if (x.leftNode == null) {
				return x.rightNode;
			}
			if (x.rightNode == null) {
				return x.leftNode;
			}

			Node t = x;
			x = min(t.rightNode);
			x.rightNode = delMin(t.rightNode);
			x.leftNode = t.leftNode;
			x.count = 1 + size(x.leftNode) + size(x.rightNode);
		}
		return x;
	}

	public void delMin() {
		root = delMin(root);
	}

	private Node delMin(Node x) {
		if (x.leftNode == null) {
			return x.rightNode;
		}
		x.leftNode = delMin(x.leftNode);
		x.count = 1 + size(x.leftNode) + size(x.rightNode);
		return x;
	}

	public V getMin() {
		return min(root).getVal();
	}

	private Node min(Node x) {
		if (x.leftNode == null) {
			return x;
		}
		return min(x.leftNode);
	}

	public void delMax() {
		//root = delMax(root);
	}

	private Node delMax(Node x) {
		if (x.rightNode == null) {
			return x.leftNode;
		}
		x.rightNode = delMax(x.rightNode);
		x.count = 1 + size(x.leftNode) + size(x.rightNode);
		return x;
	}

	public Iterable<K> iterator() {
		Queue<K> queue = new ArrayDeque<K>();
		inorder(root, queue);
		return queue;
	}

	private void inorder(Node x, Queue<K> queue) {
		if (x == null) {
			return;
		}
		inorder(x.leftNode, queue);
		queue.add(x.key);
		inorder(x.rightNode, queue);
	}

	public V floor(K key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		}
		return x.getVal();
	}

	private Node floor(Node root, K key) {
		Node x = root;
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.getKey());
		if (cmp == 0) {
			return x;
		} else if (cmp < 0) {
			return floor(x.getLeftNode(), key);
		}

		Node t = floor(x.getRightNode(), key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		}
		return x.getCount();
	}

	public int rank(K key) {
		return rank(key, root);
	}
	/*RED BLACK FUNCTIONS*/
	
	private Node rotateLeft(Node h) {
		/*if right child is RED : isRed(h)*/
		Node x = h.rightNode;
		h.rightNode = x.leftNode;
		x.leftNode = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rotateRight(Node h) {
		/*if left child is red - isRed(h.left)*/
		Node x = h.leftNode;
		h.leftNode = x.rightNode;
		x.rightNode = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node flipTheColor(Node h) {
		/*if nodes color is not red and both the children are red*/
		/* !isRed(h) && isRed(h.leftChild) && isRed(h.rightChild)*/
		h.color = RED;
		h.leftNode.color = BLACK;
		h.rightNode.color = BLACK;
		return h;
	}

	private int rank(K key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.getKey());
		if (cmp < 0) {
			return rank(key, x.getLeftNode());
		} else if (cmp > 0) {
			return (1 + size(x.getLeftNode()) + rank(key, x.getRightNode()));
		} else {
			return size(x.leftNode);
		}
	}
	
	private boolean isRed(Node x) {
		if(x == null) {
			return false;
		}
		return x.color == RED;
	}
	

	public class Node {
		private K key;
		private V val;
		private Node leftNode;
		private Node rightNode;
		private boolean color;
		private int count;

		public Node() {
		}

		public Node(K key, V val) {
			this.key = key;
			this.val = val;
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

		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + "]";
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public boolean isColor() {
			return color;
		}

		public void setColor(boolean color) {
			this.color = color;
		}
	}
}
