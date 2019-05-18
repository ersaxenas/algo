package algo.trie;

import java.util.Arrays;

public class RwayTrie {
    final static int R = 256;	
	private Node root = new Node();
	
	
	public void put(String str, String val) {
		root = put(str,val,0,root);
	}
    
	private Node put(String str, String val, int d, Node x) {
		if(x==null) {x = new Node();}
		if(d==str.length()) {x.val = val; return x;}
		int pos = str.charAt(d);
		x.node[pos] = put(str,val,d+1,x.node[pos]); 
		return x;
	}
	
	public Object get(String str) {
      int d=0;
      Node x = root;
      int pos =0;
      Object val = null;
      if(x == null) {
    	  return null;
      }
      while(d < str.length()) {
    	  pos = str.charAt(d);
    	  if(x.node[pos] != null) {
    		  x = x.node[pos];
    		  val = x.val;
    		  d++;
    	  }
    	  else {
    		  return null;
    	  }
      }
	 return val;	
	}
	
	public Object getKey(String str) {
		Node x = getKey(str, 0, root);
		if(x == null) {
			return null;
		}
		return x.val;
	}
	
	private Node getKey(String str, int d, Node x) {
		if(x==null) return null;
		if(d == str.length()) {
			return x;
		}
		int pos = str.charAt(d);
		return getKey(str,d+1,x.node[pos]);		
	}
	
	public void deleteKey(String str) {
		 delKey(str, 0, root);
	}
	
	private Node delKey(String str, int d, Node x) {
		if(x==null) return null;
		if(d == str.length()) {
			x.val = null;
			return x;
		}
		char pos = str.charAt(d);
		delKey(str,d+1,x.node[pos]);
   
		if((x.node[pos] != null) && isArrayEmpty(x.node[pos].node) && x.val != null) {
			x.node[pos]  = null;
		}
		return x;
	}
    
	private boolean isArrayEmpty(Node[] arr) {
		for(Node node : arr) {
			if(node != null) {
				return false;
			}
		}
		return true;
	}
    
	
	
	private class Node {
		private Object val;
		Node node[] = new Node[R];
		public Object getVal() {
			return val;
		}
		public void setVal(Object val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
		
	}
}
