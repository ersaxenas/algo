package algo.symboltable;
 
public class UnorderedSymbolTableLL<K extends Comparable<K>, V> {
	
    private Node first;
    private Node last;
	
    public void put(K key, V val) {
      System.out.println("Insert :("+key+","+val+")");
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
     
     print();
    }
    
    public boolean remove(K key) {
    	if(isEmpty()) {
    		return false;
    	}
    	 Node node = first;
    	 Node previous = null;
         while(node != null) {
       	  int cmp = key.compareTo(node.getKey());
       	  if(cmp == 0) {
       		  if(previous == null) {
       			  /*first node*/
       			  first = first.getNext();
       			  node.setNext(null);
       			  node = null;
       		  }
       		  else {
       			 previous.setNext(node.getNext());
       			 node.setNext(null);
      			 node = null;
       		  }
       		System.out.println("removed :("+key+")");
            print();
       		  return true;
       	  }
       	  previous = node;
       	  node = node.getNext();
         }
         System.out.println("Key :("+key+") not found");
         return false;
    }
    
    public V get(K key) {
    	if(isEmpty()) {
    		return null;
    	}
     Node node = first;
          while(node != null) {
        	  int cmp = key.compareTo(node.getKey());
        	  if(cmp == 0) {
        		  System.out.println("Key "+key+" found");
        		  return node.getVal();
        	  }
        	  node = node.getNext();
          }
          System.out.println("Key "+key+" not found");
          return null;
    }
    
    public void print() {
    	Node node = first;
    	System.out.println("\n");
    	while(node != null) {
    		System.out.print("("+node.getKey()+","+node.getVal()+")->");
    		node = node.getNext();
    	}
    	System.out.println("\n");
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
		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + "]";
		}
		
	}
}
