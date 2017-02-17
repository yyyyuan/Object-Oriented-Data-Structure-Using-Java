package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * @param <T>
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {


	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */

	StackBasedHanoiPeg peg0 = new StackBasedHanoiPeg();
	StackBasedHanoiPeg peg1 = new StackBasedHanoiPeg();
	StackBasedHanoiPeg peg2 = new StackBasedHanoiPeg();
	int numberOfRings;
	
	public ArrayBasedHanoiBoard(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("The argument is illegal");
		}
		else {
			HanoiRing node;

			for (int i = n; i > 0; i--) {
				int y = i;
				node = new HanoiRing(y);
				peg0.addRing(node);
			}
			numberOfRings = n;
		}
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (isLegalMove(move)) {
			int from = move.getFromPeg();
			int to = move.getToPeg();
			HanoiRing element;
			
			if (from == 0) {
				element = peg0.remove();
			}
			else if (from == 1) {
				element = peg1.remove();
			}
			else {
				element = peg2.remove();
			}
			
			if (to == 0) {
				peg0.addRing(element);
			}
			else if (to == 1) {
				peg1.addRing(element);
			}
			else {
				peg2.addRing(element);
			}
		}
		else {
			throw new IllegalHanoiMoveException("That's an illegal move");
		}

	}

	@Override
	public boolean isSolved() {
            return peg2.size() == numberOfRings;
	}

	/**
	 * <p>
	 * A {@link HanoiMove} is not legal if either is true:
	 * 
	 * <ul>
	 * <li>The from peg has no rings</li>
	 * <li>The to peg has rings AND the ring to be moved has a size larger than
	 * the topmost ring on the to peg.</li>
	 * </ul>
	 * 
	 * Otherwise, the move is legal.
	 * </p>
	 */
	@Override
	public boolean isLegalMove(HanoiMove move) {
		if (move == null) {
			throw new NullPointerException("move is empty");
		}
		else {
			StackBasedHanoiPeg pegFrom = new StackBasedHanoiPeg();
			StackBasedHanoiPeg pegTo = new StackBasedHanoiPeg();
			if (move.getFromPeg() == 0) {
				pegFrom = peg0;
			}
			else if (move.getFromPeg() == 1) {
				pegFrom = peg1;
			}
			else {
				pegFrom = peg2;
			}
			
			if (move.getToPeg() == 0) {
				pegTo = peg0;
			}
			else if (move.getToPeg() == 1) {
				pegTo = peg1;
			}
			else {
				pegTo = peg2;
			}
	        
			if (pegFrom.size() == 0) {
				return false;
			}
			else if (pegTo.size() != 0 && pegFrom.getTopRing().getSize() > pegTo.getTopRing().getSize()) {
				return false;
			}
			else if (move.getFromPeg() == move.getToPeg()) {
				return false;
			}
			else {
				return true;
			}
		}
	}
}
