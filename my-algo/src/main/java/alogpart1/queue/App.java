package alogpart1.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import util.AlgoUtils;

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
		Integer[] arr = AlgoUtils.getIntArray(20);
		System.out.println("UnorderedMaxPQ sort :Initial array:"+Arrays.asList(arr));
		UnorderedMaxPQ<Integer> unorderedMaxPQ = new UnorderedMaxPQ<Integer>(20);
		int cnt = 1;
		for(int item : arr) {
			unorderedMaxPQ.insertItem(item);
			if(cnt >= trackItems) {
				System.out.println("Max: "+unorderedMaxPQ.delMax()); 
				cnt = 1;
			}
			else {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {
		App obj = new App();
		obj.testUnorderedMaxPQ(4);
	}

}
