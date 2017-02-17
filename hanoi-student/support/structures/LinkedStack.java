package structures;

import java.util.NoSuchElementException;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 *
 * @param <T>
 *            the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

	private Node<T> top;
	private int size = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		Node<T> oldTop = top;
		top = top.getNext();
		size -= 1;
		return oldTop.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		top = new Node<T>(elem, top);
		size += 1;
	}

}
