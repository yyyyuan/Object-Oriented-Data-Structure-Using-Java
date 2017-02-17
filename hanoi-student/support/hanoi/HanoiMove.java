package hanoi;

/**
 * A {@link HanoiMove} represents a move in the Tower of Hanoi puzzle.
 * 
 * @author jcollard
 * 
 */
public class HanoiMove {

	private final int fromPeg, toPeg;

	/**
	 * Constructs a {@link HanoiMove} specifiying the starting {@link HanoiPeg},
	 * and the destination {@link HanoiPeg}
	 * 
	 * @param fromPeg
	 *            the starting peg
	 * @param toPeg
	 *            the destination peg
	 * @throws IllegalHanoiMoveException
	 */
	public HanoiMove(int fromPeg, int toPeg) throws IllegalHanoiMoveException {
		if (fromPeg < 0 || fromPeg > 2 || toPeg < 0 || toPeg > 2)
			throw new IllegalHanoiMoveException(
					"The specified move is not possible.");
		this.fromPeg = fromPeg;
		this.toPeg = toPeg;
	}

	/**
	 * Returns the index of the peg where the rings will be moved from
	 * 
	 * @return the index of the peg where the rings will be moved from
	 */
	public int getFromPeg() {
		return fromPeg;
	}

	/**
	 * Returns the index of the peg where the rings will be moved to
	 * 
	 * @return the index of the peg where the rings will be moved to
	 */
	public int getToPeg() {
		return toPeg;
	}

}
