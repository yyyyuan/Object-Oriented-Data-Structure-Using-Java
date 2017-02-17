package stack;

/**
 * A {@link LLNode} is a container that has two properties. It can store some
 * data and it has a reference to a {@link LLNode}
 * 
 * @param <T>
 */
public class LLNode<T> {

	private T data;
	private LLNode<T> next;

	/**
	 * Creates a {@link LLNode} with the specified data and doesn't
	 * reference another {@link LLNode}
	 * @param data the data to store
	 * @throws NullPointerException if {@code data} is {@code null}
	 */
	public LLNode(T data) {
		if (data == null)
			throw new NullPointerException();
		this.data = data;
		next = null;
	}

	/**
	 * Returns the data stored in this {@link LLNode}.
	 * @return the data stored in this {@link LLNode}.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data stored in this {@link LLNode}.
	 * @param data the data to store
	 * @throws NullPointerException if {@code data} is {@code null}
	 */
	public void setData(T data) {
		if (data == null)
			throw new NullPointerException();
		this.data = data;
	}

	/**
	 * Returns the {@link LLNode} that this one references. If this method returns
	 * {@code null}, it means that it does not have a reference to another
	 * {@link LLNode}.
	 * 
	 * @return the {@link LLNode} that this one references or {@code null} if it
	 *         does not reference another {@link LLNode}
	 */
	public LLNode<T> getNext() {
		return next;
	}

	/**
	 * Sets the {@link LLNode} that this one is referencing. If {@code next} is
	 * {@code null}, it means this {@link LLNode} does not point at anything.
	 * 
	 * @param next
	 *            the {@link LLNode} to reference
	 */
	public void setNext(LLNode<T> next) {
		this.next = next;
	}

}
