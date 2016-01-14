package algo.trie;

public class TernaryTrie {
	
	Node root = new Node();
	
	public void put(String str, String val) {
		root = put(str,0,root,val);
	}
	
    private Node put(String str, int d, Node x, String val) {
    	if(x==null) {
    		x = new Node();
    		x.key = str.charAt(d);
    	}
    	char currChar = str.charAt(d);
    	if(currChar < x.key) {
    	/*go left*/
    		x.left = put(str, d, x.left, val);
    	}
    	else if(currChar > x.key) {
    	/*go right*/
    		x.right = put(str, d, x.right, val);
    	}
    	else if(d < str.length() -1) {
    		x.mid = put(str, d+1, x.mid, val);
    	} else {
    		x.val = val;
    	}
    	return x;
    }
	
    public Object getVal(String str) {
    	return getVal(str,0,root);
    }
    
    private Object getVal(String str, int d, Node x) {
    	Object val = null;
    	if(x==null) {
    		return null;
    	}
    	char currChar = str.charAt(d);
    	if(currChar < x.key) {
        	/*go left*/
        		val = getVal(str, d, x.left);
        	}
        	else if(currChar > x.key) {
        	/*go right*/
        		val = getVal(str, d, x.right);
        	}
        	else if(d < str.length() -1) {
        		val = getVal(str, d+1, x.mid);
        	} else {
        		val = x.val;
        	}
    	return val;
    }
    
    
    
	
	private class Node {
		private char key;
		private Object val;
		private Node left,mid,right;
		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + "]";
		}
	}
}
