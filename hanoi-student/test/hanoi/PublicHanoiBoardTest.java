package hanoi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PublicHanoiBoardTest {

	private HanoiBoard impl;

	@Before
	public void setup() {
		impl = new ArrayBasedHanoiBoard(5);
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testSetupException() {
		impl = new ArrayBasedHanoiBoard(-1);
	}

	@Test(timeout = 5000)
	public void testSetupAndIsLegalMove() {
		impl = new ArrayBasedHanoiBoard(5);

		HanoiMove move = new HanoiMove(0, 1);
		assertTrue(impl.isLegalMove(move));

		move = new HanoiMove(0, 2);
		assertTrue(impl.isLegalMove(move));

		move = new HanoiMove(0, 0);
		assertFalse("You can't move a ring on top of itself.",
				impl.isLegalMove(move));

		move = new HanoiMove(1, 0);
		assertFalse("You cannot move from a ring that contains no rings.",
				impl.isLegalMove(move));

		move = new HanoiMove(2, 0);
		assertFalse("You cannot move from a ring that contains no rings.",
				impl.isLegalMove(move));

	}

	@Test(timeout = 5000)
	public void testSetupIsLegalMoveAndDoMove() {
		impl = new ArrayBasedHanoiBoard(5);

		HanoiMove move = new HanoiMove(0, 1);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(0, 1);
		assertFalse("Ring is too large.", impl.isLegalMove(move));

		move = new HanoiMove(0, 2);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(1, 2);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(0, 2);
		assertFalse("Ring is too large.", impl.isLegalMove(move));

		move = new HanoiMove(0, 1);
		impl.doMove(move);

		move = new HanoiMove(0, 2);
		assertFalse("Ring is too large.", impl.isLegalMove(move));

		move = new HanoiMove(0, 1);
		assertFalse("Ring is too large.", impl.isLegalMove(move));

		move = new HanoiMove(2, 1);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(2, 0);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(1, 0);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(1, 2);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(0, 1);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(0, 2);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(1, 2);
		assertTrue(impl.isLegalMove(move));
		impl.doMove(move);

		move = new HanoiMove(0, 2);
		assertFalse("Ring is too large.", impl.isLegalMove(move));

	}

	@Test(timeout = 5000, expected = NullPointerException.class)
	public void testIsLegalMoveException() {
		impl.isLegalMove(null);
	}

	@Test(timeout = 5000, expected = IllegalHanoiMoveException.class)
	public void testDoIllegalMove1() {
		impl = new ArrayBasedHanoiBoard(0);
		HanoiMove move = new HanoiMove(0, 1);
		impl.doMove(move);
	}

	@Test(timeout = 5000, expected = IllegalHanoiMoveException.class)
	public void testDoIllegalMove2() {
		impl = new ArrayBasedHanoiBoard(2);
		HanoiMove move = new HanoiMove(0, 1);
		impl.doMove(move);
		move = new HanoiMove(0, 1);
		impl.doMove(move);
	}

	@Test(timeout = 5000, expected = NullPointerException.class)
    public void testDoIllegalMove3() {
		impl = new ArrayBasedHanoiBoard(0);
		impl.doMove(null);
	}

	@Test(timeout = 5000)
	public void testSetupDoMoveAndIsSolved() {
		impl = new ArrayBasedHanoiBoard(0);
		assertTrue(impl.isSolved());

		impl = new ArrayBasedHanoiBoard(1);
		assertFalse(impl.isSolved());
		impl.doMove(new HanoiMove(0, 2));
		assertTrue(impl.isSolved());

		impl = new ArrayBasedHanoiBoard(2);
		impl.doMove(new HanoiMove(0, 1));
		assertFalse(impl.isSolved());
		impl.doMove(new HanoiMove(0, 2));
		assertFalse(impl.isSolved());
		impl.doMove(new HanoiMove(1, 2));
		assertTrue(impl.isSolved());

	}
}
