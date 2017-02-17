package structures;

import java.util.NoSuchElementException;

public class Iterator<T> implements java.util.Iterator<T> {
	
	public Node<T> top;
	private Node<T> next;
	int count;
	
	public Iterator() {
		top = null;
		next = null;
		count = 0;
	}
	
	public Node<T> getTop() {
		return this.top;
	}

	public void add(T element) {
		Node<T> newNode = new Node<T> (element, null);
		top.setNext(newNode);
		top = newNode;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (this.next == null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public T next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (next != null) {
			T data;
			data = next.getData();
			next = next.getNext();
			return data;
		}
		else {
			throw new NoSuchElementException("There is no next element");
		}
	}
}
