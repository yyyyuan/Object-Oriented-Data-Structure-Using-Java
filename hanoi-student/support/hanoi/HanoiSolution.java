package hanoi;

import structures.ListInterface;

/**
 * A {@link HanoiSolution} represents a solution to the Tower of Hanoi puzzle.
 * 
 * @author jcollard
 *
 */
public class HanoiSolution {

	private int numberOfRings;
	private ListInterface<HanoiMove> moves;

	/**
	 * Creates a {@link HanoiSolution} backed by the specified inputs
	 * 
	 * @param numberOfRings
	 * @param moves
	 */
	public HanoiSolution(int numberOfRings, ListInterface<HanoiMove> moves) {
		if (numberOfRings < 0 || moves == null) {
			throw new IllegalArgumentException();
		}
		this.numberOfRings = numberOfRings;
		this.moves = moves;
	}

	/**
	 * Returns the number of rings that this solution solves for
	 * 
	 * @return the number of rings that this solution solves for
	 */
	public int getNumberOfRings() {
		return numberOfRings;
	}

	/**
	 * Returns a {@link ListInterface} of {@link HanoiMove}s that solves the
	 * Tower of Hanoi puzzle.
	 * 
	 * @return a {@link ListInterface} of {@link HanoiMove}s that solves the
	 *         Tower of Hanoi puzzle.
	 */
	public ListInterface<HanoiMove> getMoves() {
		return moves;
	}
}
