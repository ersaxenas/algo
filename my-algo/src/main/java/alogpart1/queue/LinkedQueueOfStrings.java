package alogpart1.queue;


public class LinkedQueueOfStrings {
	private Node first;
	private Node last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(final String item) {
		Node oldlast = last;  
		last = new Node(item, null);
		if(isEmpty()) {
			first = last;
			System.out.println("---- Queue is empty ----");
		}
		else {
		oldlast.setNext(last); 
		}
	}

	public String dequeue() {
		if(isEmpty()) {
			System.out.println("---- Queue is empty ----");
			return "";
		}
		String item = first.getItem();
		Node next = first.next;
		first.next = null;
		first = next;
		if(first == null) {
			last = null;
		}
		return item;
	}

	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	
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
}
