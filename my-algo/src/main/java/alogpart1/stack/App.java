package alogpart1.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	
	public static void main(String[] args) {
		BufferedReader reader  = null;
		String line = null;
		String data[] = null;
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);
		//ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings(5);
          try {
			reader = new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("/stack_string.txt")));
			while((line=reader.readLine()) != null)  {
				 data = line.split("\\s+");
				 for(String split : data) {
					 if(split != null && split.equals("-")) {
						 System.out.println(stack.pop());
					 }
					 else {
						 stack.push(split);
					 }
				 }
			}
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}

}
