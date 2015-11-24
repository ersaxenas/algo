package alogpart1.queue;


public class ResizingArrayQueueOfStrings {

	private String stack[];
	private int first = 0;
	private int last = 0;

	public ResizingArrayQueueOfStrings(final int size) {
           stack = new String[size];
	}
	
	public boolean isEmpty() {
		if(first == last) {
			if(stack[first] == null) {
				return true;
			}
		}
		return false;
	}

	private void resize(int capacity) {
		int newCnt=0;
        String nStack[] = new String[capacity];
	    for(int cnt=first; cnt < last; cnt++, newCnt++) {
	    	nStack[newCnt] = stack[cnt];
	    }
	    first =0;
	    last=newCnt;
	    stack = nStack;
	}
	
	public void enqueue(final String item) {
		int currentStackLen = stack.length;
		if (first==0 && last == currentStackLen) {
			System.out.println("---- Increasing size of stack ----:"+currentStackLen*2);
			resize(currentStackLen*2);
		} 
		else if((last == stack.length)) {
				resize(stack.length);
		}
			stack[last++] = item;
	}

	public String dequeue() {
		String item = null;
		if (first == last) {
			if(stack[first] != null) {
				item = stack[first];
				stack[first] = null;
			}
			else {
				System.out.println("---- Queue is empty ----:");
				return null;
			}
		} else {
			item = stack[first];
			stack[first++] = null;
		}
		if((last-first) <= (stack.length/4)) {
			System.out.println("---- Decreasing size of stack ----:"+stack.length/2);
			resize(stack.length/2);
		}
		return item;
	}
}
