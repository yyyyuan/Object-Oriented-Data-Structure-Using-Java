package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Iterable;

/**
 * A {@link ListInterface} is an unbounded container supporting appending to the
 * end, retrieval at a specified index, and iteration over the entire list.
 * 
 * @author jcollard
 * 
 * @param <T>
 *            the type of element being stored
 */
public interface ListInterface<T> extends Iterable<T> {

	/**
	 * Returns the number of elements in this {@link ListInterface}. The running
	 * time of this method must be O(1).
	 * 
	 * @return the number of elements in this {@link ListInterface}
	 */
	public int size();

	/**
	 * Returns true if the list is empty, false otherwise
	 *
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Returns the element in position {@code n} in the list, where 0 is the
	 * head.
	 *
	 * @param n
	 *            the position of the element to be returned
	 * @return the element at position {@code n}
	 * @throws NoSuchElementException
	 *             if {@code n >= size()}
	 */
	public T get(int n) throws NoSuchElementException;

	/**
	 * Appends an element to the end of this {@link ListInterface}. For
	 * convenience, this method returns the appended {@link ListInterface}. The
	 * running time of this method must be O(1).
	 * 
	 * @param elem
	 *            the element to append
	 * @return the appended {@link ListInterface}.
	 * @throws {@code NullPointerException} if {@code elem} is {@code null}
	 */
	public ListInterface<T> append(T elem);

	/**
	 * Returns an iterator over this list. It starts at the head; thus a newly
	 * appended element will be the last element returned by the iterator. This
	 * iterator does not support the {@code remove()} method.
	 *
	 * @return an iterator over the list
	 */
	public Iterator<T> iterator();
}
