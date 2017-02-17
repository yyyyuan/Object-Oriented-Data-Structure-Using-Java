package structures;

public interface StackInterface<T> {
	/**
	 * Pushes an element onto the stack.
	 *
	 * @param element
	 *            the element to be pushed
	 * @throws NullPointerException
	 *             if {@code element} is null.
	 */
	void push(T element);

	/**
	 * Removes the top element from the stack and returns it.
	 *
	 * @return the element removed from the top of the stack
	 * @throws NoSuchElementException
	 *             if the stack is empty
	 */
	T pop();

	/**
	 * Examines the stack and returns the top element without removing it from
	 * the stack.
	 *
	 * @return the top element on the stack
	 * @throws NoSuchElementException
	 *             if the stack is empty
	 */
	T peek();

	/**
	 * Returns true if the stack is empty, false otherwise.
	 *
	 * @return true if the stack is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the size of the stack, the number of elements that the stack
	 * currently contains.
	 *
	 * @return the number of elements the stack currently contains
	 */
	int getSize();
}
