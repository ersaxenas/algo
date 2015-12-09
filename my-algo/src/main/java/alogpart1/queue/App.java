package alogpart1.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	
	public void testLinkedQueueOfStrings() {
		BufferedReader reader  = null;
		String line = null;
		String data[] = null;
		LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
          try {
			reader = new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("/stack_string.txt")));
			while((line=reader.readLine()) != null)  {
				 data = line.split("\\s+");
				 for(String split : data) {
					 if(split != null && split.equals("-")) {
						 System.out.println(queue.dequeue());
					 }
					 else {
						 queue.enqueue(split);
					 }
				 }
			}
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}
	
	public void testResizingArrayQueueOfStrings() {
		BufferedReader reader  = null;
		String line = null;
		String data[] = null;
		ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(10);
          try {
			reader = new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("/stack_string.txt")));
			while((line=reader.readLine()) != null)  {
				 data = line.split("\\s+");
				 for(String split : data) {
					 if(split != null && split.equals("-")) {
						 System.out.println(queue.dequeue());
					 }
					 else {
						 queue.enqueue(split);
					 }
				 }
			}
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}
	
	public void testUnorderedMaxPQ(int trackItems) {
		
	}
	
	public static void main(String[] args) {
		
	}

}
