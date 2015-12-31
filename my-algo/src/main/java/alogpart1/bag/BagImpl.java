package alogpart1.bag;

import java.util.Iterator;

public class BagImpl<T> implements Bag<T>{

	Node<T> first = null;
	int N = 0;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void add(T item) {
		Node<T> node = new Node<T>(item, first);
		first = node;
		N++;
	}
	
	public int size() {
		return N;
	}
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
            Node<T> current = first;
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T item = current.getItem();
				current = current.getNext();
				return item;
			}

			@Override
			public void remove() {
             throw new UnsupportedOperationException("Remove operation is not supported by this Bag implementation.");				
			}
		};
		return iterator;
	}
	
	private class Node<T> {
		T item = null;
		Node<T> next = null;
		public Node(T item) {
			this.item = item;
		}
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
		public T getItem() {
			return item;
		}
		public void setItem(T item) {
			this.item = item;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
}
