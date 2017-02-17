package stack;

/**
 * A {@link StackUnderflowException} is thrown at runtime when an operation that would
 * return or manipulate the top most element of a stack that is empty is called.
 * @author jcollard
 *
 */
public class StackUnderflowException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackUnderflowException() {
		super();
	}

	public StackUnderflowException(String message) {
		super(message);
	}
}