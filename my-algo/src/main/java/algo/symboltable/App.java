package algo.symboltable;

import java.util.Iterator;

import util.AlgoUtils;


public class App {
	
	public void testUSymbolTable() {
	    Integer arr[] = {2,4,6,9,11,14,17,18,20,24,26,29,33,35,38};
	    UnorderedSymbolTableLL<Integer, String> ust = new UnorderedSymbolTableLL<Integer, String>();
	    for( int a : arr) {
	    	ust.put(a, String.valueOf(a));
	    }
	    ust.remove(2);
	    ust.put(2,"2");
	    ust.get(6);
	    ust.get(7);
	    ust.get(20);
	    ust.remove(22);
	    ust.isEmpty();
	    
	    
	}
	
	public void testBinarySearchTree() {
	    Integer arr[] = {22,56,34,9,76,43,27,18,94,56,75,83,88,29,3};
	    BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
	    for( int a : arr) {
	    	bst.put(a, String.valueOf(a));
	    }
	    	System.out.println("Get Value :"+94+":"+bst.getValue(94));
	    	System.out.println("Get Value :"+18+":"+bst.getValue(18));
	    	System.out.println("Get Value :"+20+":"+bst.getValue(20));
	    	System.out.println("Get Value :"+83+":"+bst.getValue(83));
	    	System.out.println("Get Value :"+29+":"+bst.getValue(29));
	    	System.out.println("Get Value :"+39+":"+bst.getValue(39));
	    	System.out.println("Get Value :"+89+":"+bst.getValue(89));
	    	System.out.println("Get Rank : "+18+":"+bst.rank(18));
	    	System.out.println("Get Rank : "+22+":"+bst.rank(22));
	    	bst.delete(76);
            System.out.println(bst.iterator());	
            bst.delMin();
            System.out.println(bst.iterator());	
            bst.delMax();
            System.out.println(bst.iterator());
            System.out.println(bst.getMin());
	}
	
	public void testRedBlackBinarySearchTree() {
	    Integer arr[] = AlgoUtils.getIntArray(9999999);
	    RedBlackBST<Integer, String> bst = new RedBlackBST<Integer, String>();
	    for( int a : arr) {
	    	bst.put(a, String.valueOf(a));
	    }
	    	System.out.println("Get Value :"+94+":"+bst.getValue(94));
	    	System.out.println("Get Value :"+18+":"+bst.getValue(18));
	    	System.out.println("Get Value :"+20+":"+bst.getValue(20));
	    	System.out.println("Get Value :"+83+":"+bst.getValue(83));
	    	System.out.println("Get Value :"+29+":"+bst.getValue(29));
	    	System.out.println("Get Value :"+39+":"+bst.getValue(39));
	    	System.out.println("Get Value :"+89+":"+bst.getValue(89));
	    	System.out.println("Get Rank : "+18+":"+bst.rank(18));
	    	System.out.println("Get Rank : "+22+":"+bst.rank(22));
            System.out.println(bst.iterator());
            System.out.println(bst.getMin());
	}
	
	
	public static void main(String[] args) {
		App obj = new App();
		obj.testRedBlackBinarySearchTree();
	}

}
