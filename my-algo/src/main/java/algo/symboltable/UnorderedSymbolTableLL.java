package algo.symboltable;

public class UnorderedSymbolTableLL<K extends Comparable<K>, V> {
	
    private Node first;
    private Node last;
	
    public void put(K key, V val) {
      Node node = new Node();
      node.setKey(key);
      node.setVal(val);
      
     if(last != null) {
    	 last.setNext(node);
    	 last = node;
     }
     else {
    	 last = node;
     }
     if(first == null) {
    	 first = node;
     }
    }
    
    public void remove(K key) {
    	 Node node = first;
         while(node != null) {
       	  int cmp = key.compareTo(node.getKey());
       	  if(cmp == 0) {
       		  
       	  }
       	  node = node.getNext();
         }
    }
    
    public V get(K key) {
     Node node = first;
          while(node != null) {
        	  int cmp = key.compareTo(node.getKey());
        	  if(cmp == 0) {
        		  return node.getVal();
        	  }
        	  node = node.getNext();
          }
          return null;
    }
	
    public boolean contains(K key) {
    	return get(key) != null;
    }
    
    public boolean isEmpty() {
    	return first == null;
    }
	
    public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}

	private class Node {
    	private Node next;
    	K key;
    	V val;
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
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
		
	}
}
