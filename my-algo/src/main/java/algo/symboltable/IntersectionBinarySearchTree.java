package algo.symboltable;

import java.util.ArrayDeque;
import java.util.Queue;

public class IntersectionBinarySearchTree<K extends Comparable<K>, V extends Comparable<V>> {
	
	private Node root;
	/**
	 * Function puts key, value pair in the Tree.
	 * It replaces existing value if key is already present else it adds the key. 
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) {
		System.out.println("Inserting :("+key+","+val+")" );
		root = put(root, key, val);
	}
	/**
	 * Function recursive lively adds a key and value to the tree.
	 * It also updates the size of the nodes visited.
	 * @param root
	 * @param key
	 * @param val
	 * @return root of the tree.
	 */
	private Node put(Node root,K key, V val) {
		Node x = root;
        if(x == null) {
        	Node node = new Node(key,val);
        	node.count = 1;
        	node.maxRight = val;
        	return node;
        }
		int cmp = key.compareTo(x.getKey());
		if(cmp < 0) {
			x.setLeftNode(put(x.getLeftNode(), key, val));
			if(x.leftNode != null) {
				if(x.maxRight.compareTo(x.leftNode.maxRight) < 0) {
					x.maxRight = x.leftNode.maxRight;
				}
			}
			
		}
		else if (cmp > 0) {
			x.setRightNode(put(x.getRightNode(), key, val));
			if(x.rightNode != null) {
				if(x.maxRight.compareTo(x.rightNode.maxRight) < 0) {
					x.maxRight = x.rightNode.maxRight;
				}
			}
			
		}
		else {
			x.setVal(val);
		}
		x.setCount(1+size(x.getLeftNode())+size(x.getRightNode()));
		return x;
	}
	
	/**
	 * Function searches in the tree for the key and returns the value if key is found
	 * in the tree.
	 * @param key
	 * @return Value of the key or null.
	 */
	public V getValue(K key) {
		Node x = root;
		while(x != null) {
		   int cmp = key.compareTo(x.getKey());
		   if(cmp < 0) {
			x = x.getLeftNode();   
		   }
		   else if(cmp > 0) {
		    x = x.getRightNode();
		   }
		   else {
			   return x.getVal();
		   }
		}
		return null;
	}
	
	/**
	 * Function checks if key is present in the tree or not.
	 * If key is found then it returns true else false.
	 * @param key
	 * @return True/False.
	 */
	public boolean contains(K key){
		return (getValue(key) != null);
	}
	/**
	 * Function deletes a key from the tree.
	 * @param key
	 */
	public void delete(K key) {
		root = delete(root, key);
	}
	/**
	 * Function iterates through the three and deletes the key.
	 * It also recalculates the size of the nodes visited. 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node delete(Node x, K key) {
		if(x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp<0) {
			x.leftNode  = delete(x.leftNode, key);
			if(x.maxRight.compareTo(x.leftNode.maxRight) < 0) {
				x.maxRight = x.leftNode.maxRight;
			}
		}
		else if(cmp>0) {
			x.rightNode = delete(x.rightNode, key);
			if(x.maxRight.compareTo(x.leftNode.maxRight) < 0) {
				x.maxRight = x.leftNode.maxRight;
			}
		}
		else {
			if(x.leftNode == null){
				return x.rightNode;
			}
			if(x.rightNode == null) {
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
	/**
	 * Function deletes minimum key from the tree.
	 */
	public void delMin() {
		root = delMin(root);
	}
	/**
	 * Function deletes minimum key fro the tree and returns the new root.
	 * @param x
	 * @return
	 */
	private Node delMin(Node x) {
		if(x.leftNode == null) {
			return x.rightNode;
		}
		x.leftNode = delMin(x.leftNode);
		x.count = 1 + size(x.leftNode) + size(x.rightNode);
		return x;
	}
	/**
	 * Function finds and returns the minimum key from the tree.
	 * @return
	 */
	public V getMin() {
		return min(root).getVal();
	}
	/**
	 * Function recursively finds minimum key from the tree.
	 * @param x
	 * @return
	 */
	private Node min(Node x) {
		if(x.leftNode == null) {
			return x;
		}
		return min(x.leftNode);
	}
	/**
	 * Function deletes maximum key from the tree.
	 */
	public void delMax() {
		root = delMax(root);
	}
	/**
	 * Function recursively finds maximum key from the tree and deletes it.
	 * @param x
	 * @return
	 */
	private Node delMax(Node x) {
		if(x.rightNode == null) {
			return x.leftNode;
		}
		x.rightNode = delMax(x.rightNode);
		x.count = 1 + size(x.leftNode) + size(x.rightNode);
		return x;
	}
	
	/**
	 * Function iterates through the tree, pull all the keys in a queue and returns the queue as iterator. 
	 * @return
	 */
	public Iterable<K> iterator() {
		Queue<K> queue = new ArrayDeque<K>();
		inorder(root, queue);
		return queue;
	}
	/**
	 * Function first iterates the left and then iterates the right nodes of the tree and keeps adding nodes to queue.
	 * 
	 * @param x
	 * @param queue
	 */
	private void inorder(Node x, Queue<K> queue) {
		if(x == null) {
			return;
		}
		inorder(x.leftNode,queue);
		queue.add(x.key);
		inorder(x.rightNode, queue);
	}
	
	public V floor(K key) {
		Node x = floor(root, key);
		if(x==null) {
			return null;
		}
		return x.getVal();
	}
	
	private Node floor(Node root, K key) {
		Node x = root;
		if(x==null) {return null;}
		int cmp = key.compareTo(x.getKey());
		if(cmp == 0) {
			return x;
		}
		else if(cmp < 0) {
		     return floor(x.getLeftNode(), key);
		}
		
		Node t = floor(x.getRightNode(),key);
		if(t != null) {
			return t;
		}
		else {
			return x;
		}
	}
	/**
	 * Function returns current size of the tree.
	 * @return
	 */
	public int size() {
		return size(root);
	}
	/**
	 * Function finds the current size of the tree.
	 * @param x
	 * @return
	 */
	private int size(Node x) {
		if(x == null) {
			return 0;
		}
		return x.getCount();
	}
	/**
	 * function finds the rank of a key in tree.
	 * @param key
	 * @return
	 */
	public int rank(K key) {
		return rank(key, root);
	}
	/**
	 * function finds rank of a give key from the node.
	 * @param key
	 * @param x
	 * @return
	 */
   private int rank(K key, Node x) {
		if(x == null) return 0;
		int cmp = key.compareTo(x.getKey());
		if(cmp<0) {
			return rank(key, x.getLeftNode());
		}
		else if(cmp>0) {
			return (1 + size(x.getLeftNode()) + rank(key, x.getRightNode())); 
		}
		else {
			return size(x.leftNode);
		}
	}

   /**
    * Function finds the number of keys within range key1 to key2.
    * @param key1
    * @param key2
    * @return
    */
   public int size(K key1, K key2) {
	   assert(key1 != null);
	   assert(key2 != null);
	   assert(key2.compareTo(key1) > 0);
	   int sz = 0;
	   if(contains(key2)) {
		   sz = rank(key2) - rank(key1) + 1;
	   }
	   else {
		   sz = rank(key2) - rank(key1);
	   }
	   return sz;
   }
   /**
    * Function finds keys in the given range.
    * @param key1
    * @param key2
    * @return
    */
   public Iterable<K> findKeyInRange(K key1, K key2) {
	   Queue<K> queue = new ArrayDeque<K>();
	   findKeyInRange(key1, key2, queue, root);	   
	   return queue;
   }
   /**
    * Function finds keys within provided range startig from the give node.
    * @param key1
    * @param key2
    * @param queue
    * @param x
    */
   private void findKeyInRange(K key1, K key2, Queue<K> queue, Node x) {
	   if(x==null) {return;};
	   int cmp1 = key1.compareTo(x.key);
	   if(cmp1 <= 0) {
		   findKeyInRange(key1, key2, queue, x.leftNode);
	   }
	   int cmp2 = key2.compareTo(x.key);
	   if(cmp2 >= 0) {
		   findKeyInRange(key1, key2, queue, x.rightNode);
	   }
	 
	   if((cmp1 <= 0) && (cmp2 >= 0)) {
		   queue.add(x.key);
	   }
	   
   }
   


public class Node {
	   private K key;
	   private V val;
	   private Node leftNode;
	   private Node rightNode;
       private int count;
       private V maxRight;
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

	public V getMaxRight() {
		return maxRight;
	}

	public void setMaxRight(V maxRight) {
		this.maxRight = maxRight;
	}
   }

}
