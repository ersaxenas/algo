package alogpart1.stack;


public class ResizingArrayStackOfStrings {

	private String stack[];
	private int n = 0;

	public ResizingArrayStackOfStrings(final int size) {
           stack = new String[size];
	}
	
	public boolean isEmpty() {
		return n == 0;
	}

	private void resize(int capacity) {
        String nStack[] = new String[capacity];
	    for(int cnt=0; cnt < n; cnt++) {
	    	nStack[cnt] = stack[cnt];
	    }
	    stack = nStack;
	}
	
	public void push(final String item) {
		
		if (n == stack.length) {
			System.out.println("---- Increasing size of stack ----:"+n*2);
			resize(n*2);
		} 
			stack[n++] = item;
	}

	public String pop() {
		String item = null;
		if (n == 0 && (stack[n]) != null) {
			item = stack[0];
			stack[0] = null;
		} else {
			item = stack[--n];
			stack[n] = null;
		}
		if(n <= (stack.length/4)) {
			System.out.println("---- Decreasing size of stack ----:"+stack.length/2);
			resize(stack.length/2);
		}
		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
