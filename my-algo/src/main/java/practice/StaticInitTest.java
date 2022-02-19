package practice;

public class StaticInitTest {

	static {
		System.out.println("I am inside static initializer block....");
		init();
		
	}
	
	public static void init() {
		System.out.println("I am inside init method...");
		//throw new RuntimeException("INIT exception.");
	}
	
	public static void load() {
		System.out.println("class loaded successfully...");
	}
}
