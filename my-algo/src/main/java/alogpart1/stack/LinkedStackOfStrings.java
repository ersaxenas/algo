package alogpart1.stack;

import java.util.Random;

public class LinkedStackOfStrings {
	
	public class Node {
		private String item;
		private Node next;
		
		public Node(final String item, final Node node) {
			this.item = item;
			this.next = node;
		}
		
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	private Node first;
	
	public void push(final String item) {
		Node oldfirst = first;  
		first = new Node(item, oldfirst);
	}

	public String pop() {
		if(first == null) {
			return null;
		}
		String item = first.getItem();
		Node next = first.next;
		first.next = null;
		first = next;
		return item;
	}

	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}

	
	public static void main(String[] args) {
		Random random = new Random();
		LinkedStackOfStrings linkedStack = new LinkedStackOfStrings();
		int item = 0;
		for(int cnt=0;cnt<10;cnt++) {
			item = random.nextInt(50);
			System.out.print(" Push :"+ item);
			linkedStack.push(""+item);
		}
		System.out.println("");
		for(int cnt=0;cnt<5;cnt++) {
			System.out.print(" Pop  :"+ linkedStack.pop());
		}
		System.out.println("");
		for(int cnt=0;cnt<5;cnt++) {
			item = random.nextInt(50);
			System.out.print(" Push :"+ item);
			linkedStack.push(""+item);
		}
		System.out.println("");
		for(int cnt=0;cnt<10;cnt++) {
			System.out.print(" Pop  :"+ linkedStack.pop());
		}
	}
	
}
