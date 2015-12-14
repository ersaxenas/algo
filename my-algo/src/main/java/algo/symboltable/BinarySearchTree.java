package algo.symboltable;

public class BinarySearchTree<K extends Comparable<K>, V> {
	
	private Node root;
	
	public void put(K key, V val) {
		root = put(root, key, val);
	}
	
	private Node put(Node root,K key, V val) {
		Node x = root;
        if(x == null) {
        	Node node = new Node(key,val);
        	return node;
        }
		int cmp = key.compareTo(x.getKey());
		if(cmp < 0) {
			x = put(x.getLeftNode(), key, val);
		}
		else if (cmp > 0) {
			x = put(x.getRightNode(), key, val);
		}
		else {
			x.setVal(val);
		}
		return x;
	}
	
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
	
	public void delete(K key) {
		
	}
	
	public Iterable<K> iterator() {
		
		return null;
	}
	
	
	
	
	
	
	
	
   public class Node {
	   private K key;
	   private V val;
	   private Node leftNode;
	   private Node rightNode;
  
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
   }

}
