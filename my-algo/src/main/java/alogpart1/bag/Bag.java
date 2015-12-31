package alogpart1.bag;

public interface Bag<T> extends Iterable<T>{
	public boolean isEmpty();
	public void add(T item);
	public int size();
}
