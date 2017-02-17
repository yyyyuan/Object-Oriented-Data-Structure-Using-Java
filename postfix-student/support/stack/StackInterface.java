package stack;

/**
 * A {@link Stack} represents a last-in-first-out (LIFO) stack of objects. 
 * @author jcollard
 * 
 * @param <T> the type of elements in the stack
 */
public interface StackInterface<T> {

	/**
	 * Removes the top most element on this stack. For convenience, the top most element is returned
	 * @return the top most element of this stack is returned
	 * @throws StackUnderflowException if the stack is empty.
	 */
	public T pop() throws StackUnderflowException;


	/**
	 * Returns the top most element of this stack.
	 * @return the top most element of this stack.
	 * @throws StackUnderflowException if the stack is empty
	 */
	public T top() throws StackUnderflowException;
	
	/**
	 * Pushes {@code elem} to the top of this stack.
	 */
	public void push(T elem);

	/**
	 * Returns {@code true} if the stack contains no elements and {@code false} otherwise.
	 * @return {@code true} if the stack contains no elements and {@code false} otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this stack.
	 * @return the number of elements in this stack.
	 */
	public int size();

	
}
