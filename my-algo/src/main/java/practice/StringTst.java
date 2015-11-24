package practice;

import java.util.Arrays;

public class StringTst {

	public void splitTest() {
		String strintst = "This,class,allows,communication,via,SSL";
		
		String parts[] = strintst.split(",");
		for(String part : parts) {
			System.out.println(part);
		}
		
		System.out.println(Arrays.toString(parts));
		String str = "sss.ddd";
		System.out.println(str.substring(0, str.indexOf(".")));
		
		Integer a1 = 10, a2=5;
		System.out.println("compare:"+a1.compareTo(a2));
		
	}
	
	public static void main(String args[]) {
		StringTst obj = new StringTst();
		obj.splitTest();
	}
	
	
	
}
