package structures;

/**
 * A {@link ListInterface} is a container that supports insertion, removal, and
 * searching.
 * 
 * @author jcollard
 * 
 * @param <T>
 */
public interface ListInterface<T> extends Iterable<T> {

	/**
	 * Returns the number of elements in this {@link ListInterface}. This method
	 * runs in O(1) time.
	 * 
	 * @return the number of elements in this {@link ListInterface}
	 */
	public int size();

	/**
	 * Adds an element to the front of this {@link ListInterface}. This method
	 * runs in O(1) time. For convenience, this method returns the
	 * {@link ListInterface} that was modified.
	 * 
	 * @param elem
	 *            the element to add
	 * @throws NullPointerException
	 *             if {@code elem} is {@code null}
	 * @return The modified {@link ListInterface}
	 */
	public ListInterface<T> insertFirst(T elem);

	/**
	 * Adds an element to the end of this {@link ListInterface}. This method
	 * runs in O(size) time. For convenience, this method returns the
	 * {@link ListInterface} that was modified.
	 * 
	 * @param elem
	 *            the element to add
	 * @throws NullPointerException
	 *             if {@code elem} is {@code null}
	 * @return the modified {@link ListInterface}
	 */
	public ListInterface<T> insertLast(T elem);

	/**
	 * Adds an element at the specified index such that a subsequent call to
	 * {@link ListInterface#get(int)} at {@code index} will return the inserted
	 * value. This method runs in O(index) time. For convenience, this method
	 * returns the {@link ListInterface} that was modified.
	 * 
	 * @param index
	 *            the index to add the element at
	 * @param elem
	 *            the element to add
	 * @throws NullPointerException
	 *             if {@code elem} is {@code null}
	 * @throws IndexOutOfBoundsException
	 *             if {@code index} is less than 0 or greater than
	 *             {@link ListInterface#size()}
	 * @return The modified {@link ListInterface}
	 */
	public ListInterface<T> insertAt(int index, T elem);

	/**
	 * Removes the first element from this {@link ListInterface} and returns it.
	 * This method runs in O(1) time.
	 * 
	 * @throws IllegalStateException
	 *             if the {@link ListInterface} is empty.
	 * @return the removed element
	 */
	public T removeFirst();

	/**
	 * <p>
	 * Removes the last element from this {@link ListInterface} and returns it.
	 * This method runs in O(size) time.
	 *</p>
	 * 
	 * @throws IllegalStateException
	 *             if the {@link ListInterface} is empty.
	 * @return the removed element
	 */
	public T removeLast();

	/**
	 * Removes the ith element in this {@link ListInterface} and returns it.
	 * This method runs in O(i) time.
	 * 
	 * @param i
	 *            the index of the element to remove
	 * @throws IndexOutOfBoundsException
	 *             if {@code i} is less than 0 or {@code i} is greater than or
	 *             equal to {@link ListInterface#size()}
	 * @return The removed element
	 */
	public T removeAt(int i);

	/**
	 * Returns the first element in this {@link ListInterface}. This method runs
	 * in O(1) time.
	 * 
	 * @throws IllegalStateException
	 *             if the {@link ListInterface} is empty.
	 * @return the first element in this {@link ListInterface}.
	 */
	public T getFirst();

	/**
	 * Returns the last element in this {@link ListInterface}. This method runs
	 * in O(size) time.
	 * 
	 * @throws IllegalStateException
	 *             if the {@link ListInterface} is empty.
	 * @return the last element in this {@link ListInterface}.
	 */
	public T getLast();

	/**
	 * Returns the ith element in this {@link ListInterface}. This method runs
	 * in O(i) time.
	 * 
	 * @param i
	 *            the index to lookup
	 * @throws IndexOutOfBoundsException
	 *             if {@code i} is less than 0 or {@code i} is greater than or
	 *             equal to {@link ListInterface#size()}
	 * @return the ith element in this {@link ListInterface}.
	 */
	public T get(int i);

	/**
	 * Removes {@code elem} from this {@link ListInterface} if it exists. If
	 * multiple instances of {@code elem} exist in this {@link ListInterface}
	 * the one associated with the smallest index is removed. This method runs
	 * in O(size) time.
	 * 
	 * @param elem
	 *            the element to remove
	 * @throws NullPointerException
	 *             if {@code elem} is {@code null}
	 * @return {@code true} if this {@link ListInterface} was altered and
	 *         {@code false} otherwise.
	 */
	public boolean remove(T elem);

	/**
	 * Returns the smallest index which contains {@code elem}. If there is no
	 * instance of {@code elem} in this {@link ListInterface} then -1 is
	 * returned. This method runs in O(size) time.
	 * 
	 * @param elem
	 *            the element to search for
	 * @throws NullPointerException
	 *             if {@code elem} is {@code null}
	 * @return the smallest index which contains {@code elem} or -1 if
	 *         {@code elem} is not in this {@link ListInterface}
	 */
	public int indexOf(T elem);

	/**
	 * Returns {@code true} if this {@link ListInterface} contains no elements
	 * and {@code false} otherwise. This method runs in O(1) time.
	 * 
	 * @return {@code true} if this {@link ListInterface} contains no elements
	 *         and {@code false} otherwise.
	 */
	public boolean isEmpty();

}
