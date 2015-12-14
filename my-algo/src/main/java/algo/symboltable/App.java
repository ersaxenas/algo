package algo.symboltable;


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
	
	
	public static void main(String[] args) {
		App obj = new App();
		obj.testUSymbolTable();
	}

}
