package algo.search;


public class App {
	
	public void testBinarySearch() {
	    Integer arr[] = {2,4,6,9,11,14,17,18,20,24,26,29,33,35,38};
	    BinarySearch<Integer> benS = new BinarySearch<Integer>();
	    System.out.println(benS.search(arr, 39));
	}
	
	
	public static void main(String[] args) {
		App obj = new App();
		obj.testBinarySearch();
	}

}
