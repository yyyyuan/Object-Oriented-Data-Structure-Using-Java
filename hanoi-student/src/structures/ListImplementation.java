package structures;


import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and
 * provides useful operations.
 * 
 * @author jcollard
 * 
 */
public class ListImplementation<T> implements ListInterface<T> {
	
	protected Node<T> start;
	protected Node<T> end;
	protected int count;
	
	protected ListImplementation<T> stack;

	
	public ListImplementation() {
		end = null;
		start = null;
		count = 0;
	}
	


	/**
	 * Returns the number of nodes in this list.
	 */
	@Override
	public int size() {
		
        return count;
	}

	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Appends {@code elem} to the end of this {@code ListImplementation} and
	 * returns itself for convenience.
	 */
	@Override
	public ListImplementation<T> append(T elem) throws NullPointerException {
		if (elem != null) {
			if (this.count == 0) {
				Node<T> newNode = new Node<T> (elem, null);
				newNode.setNext(this.end);
				this.end = newNode;
				this.start = newNode;
			}
			else {
				Node<T> newNode = new Node<T> (elem, null);	
				this.end.setNext(newNode);
				this.end = newNode;
			}

			this.count++;
			return this;
		} else {
			throw new NullPointerException("The input element is null!");
		}
	}

	/**
	 * Gets the {@code n}th element from this list.
	 */
	@Override
	public T get(int n) throws NoSuchElementException {
		if (n < size() && n >= 0) {
			Node<T> mark = this.start;
			T data;
			for (int i = 0; i < n; i++) {
				mark = mark.getNext();
			}
			data = mark.getData();
			return data;
		}
		else {
			throw new NoSuchElementException("The input n is too large!");
		}
	}

	/**
	 * Returns an iterator over this list. The iterator does not support the
	 * {@code remove()} method.
	 */
	@Override
	public Iterator<T> iterator() {
		
		Iterator<T> iterator = new Iterator<T>();
		Node<T> mark = this.start;
		
		while (mark != null) {
			if (iterator.count == 0) {
				Node<T> newNode = new Node<T> (mark.getData(), null);
				iterator.top = newNode;
				iterator.next = newNode;
				mark = mark.getNext();
				iterator.count++;
			}
			else {
				iterator.add(mark.getData());
				mark = mark.getNext();
				iterator.count++;
			}
		}
		return iterator;
	}
}

