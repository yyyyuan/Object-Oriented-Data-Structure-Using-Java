package hanoi;

/**
 * A {@link HanoiBoard} is a representation of the Tower of Hanoi puzzle.
 * 
 * @author jcollard
 * 
 */
public interface HanoiBoard {

	/**
	 * Performs the specified {@link HanoiMove} on this {@link HanoiBoard}.
	 * 
	 * @param move
	 *            the move to perform.
	 * @throws IllegalHanoiMoveException
	 *             if {@code move} is not a legal move.
	 */
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException;

	/**
	 * Returns {@code true} if the puzzle has been solved and {@code false}
	 * otherwise.
	 * 
	 * @return {@code true} if the puzzle has been solved and {@code false}
	 *         otherwise.
	 */
	public boolean isSolved();

	/**
	 * Returns {@code true} if the specified move can be performed on this
	 * {@link HanoiBoard} and {@code false} otherwise.
	 * 
	 * @param move
	 *            the move to check
	 * @return {@code true} if the specified move can be performed on this
	 *         {@link HanoiBoard} and {@code false} otherwise.
	 * @throws NullPointerException
	 *             if {@code move} is {@code null}
	 */
	public boolean isLegalMove(HanoiMove move);

}
