package hanoi;

import structures.ListImplementation;
import structures.ListInterface;

/**
 * A {@link RecursiveHanoiSolver} implements the {@link HanoiSolver} taking
 * advantage of recursion.
 * 
 * @author jcollard
 *
 */
public class RecursiveHanoiSolver {

	/**
	 * Moves {@code n} rings from {@code fromPeg} to the {@code toPeg}.
	 * 
	 * @param n
	 *            the number of rings to move
	 * @param fromPeg
	 *            the peg to move them from
	 * @param auxPeg
	 *            a peg that we may utilize when needed to accomplish the task
	 * @param toPeg
	 *            the peg to move them to
	 */
	
	ArrayBasedHanoiBoard board;
	
	private void solverHelper(int n, int fromPeg, int auxPeg, int toPeg,
			ListInterface<HanoiMove> moves) throws IllegalHanoiMoveException {
		if (n > 0) {
			solverHelper(n - 1, fromPeg, toPeg, auxPeg, moves);
			
			HanoiMove move = new HanoiMove(fromPeg, toPeg);
			board.doMove(move);
			moves.append(move);
			
			solverHelper(n - 1, auxPeg, fromPeg, toPeg, moves);
			
		}
	}

	public HanoiSolution solve(int n) throws IllegalHanoiMoveException {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		
		board = new ArrayBasedHanoiBoard(n);
		
		// Initialize moves to a new list to get rid of any previous
		// solution stored there
		ListInterface<HanoiMove> moves = new ListImplementation<HanoiMove>();
		// We want to move n rings from peg 0 to peg 2.
		solverHelper(n, 0, 1, 2, moves);
		// Return a new solution with n as the number of rings
		// and moves as the solution
		return new HanoiSolution(n, moves);
	}
}
