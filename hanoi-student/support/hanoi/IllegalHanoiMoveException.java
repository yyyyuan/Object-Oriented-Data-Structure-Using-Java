package hanoi;

/**
 * An {@link IllegalHanoiMoveException} is thrown when an invalid move is made
 * in the Tower of Hanoi puzzle.
 * 
 * @author jcollard
 *
 */
public class IllegalHanoiMoveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalHanoiMoveException(String message) {
		super(message);
	}

}
