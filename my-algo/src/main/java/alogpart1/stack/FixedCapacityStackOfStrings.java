package alogpart1.stack;

public class FixedCapacityStackOfStrings {

	private String stack[];
	private int n = 0;

	public FixedCapacityStackOfStrings(final int size) {
           stack = new String[size];
	}
	
	public boolean isEmpty() {
		return n == 0;
	}

	public void push(final String item) {
		if (n >= stack.length) {
			System.out.println("Stack is full.");
		} else {
			stack[n++] = item;
		}
	}

	public String pop() {
		String item = "";
		if (isEmpty() ) {
				System.out.println("Stack is empty.");
		} else {
			item = stack[--n];
			stack[n] = null;
		}
		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
