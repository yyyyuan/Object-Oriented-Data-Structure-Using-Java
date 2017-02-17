package hanoi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import structures.ListInterface;

public class PublicHanoiSolverTest {

	private RecursiveHanoiSolver impl;
	private HanoiPeg[] peg;

	@Before
	public void setup() {
		impl = new RecursiveHanoiSolver();
		peg = new HanoiPeg[3];
		peg[0] = new StackBasedHanoiPeg();
		peg[1] = new StackBasedHanoiPeg();
		peg[2] = new StackBasedHanoiPeg();
		if(peg[0] == peg[1] || peg[1] == peg[2] || peg[0] == peg[2])
			fail("The StackBasedHanoiPeg should return a new copy of HanoiPeg each time it is called.");
	}

	@Test(timeout = 5000)
	public void testGetNumberOfRings() {
		HanoiSolution solution = impl.solve(0);
		assertEquals(0, solution.getNumberOfRings());

		solution = impl.solve(1);
		assertEquals(1, solution.getNumberOfRings());

		solution = impl.solve(2);
		assertEquals(2, solution.getNumberOfRings());

		solution = impl.solve(3);
		assertEquals(3, solution.getNumberOfRings());

		solution = impl.solve(10);
		assertEquals(10, solution.getNumberOfRings());
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testException() {
		impl.solve(-5);
	}

	private boolean isSolution(ListInterface<HanoiMove> moves) {
		for (HanoiMove move : moves) {
			int from = move.getFromPeg();
			int to = move.getToPeg();
			HanoiRing ring = peg[from].remove();
			peg[to].addRing(ring);
		}
		return !(peg[0].hasRings()) && !(peg[1].hasRings());
	}

	@Test(timeout = 5000)
	public void testSolveSize0() {
		// This test assumes your HanoiPeg implementation is correct.
		HanoiSolution solution = impl.solve(0);
		ListInterface<HanoiMove> moves = solution.getMoves();
		assertTrue(isSolution(moves));
	}

	@Test(timeout = 5000)
	public void testSolveSize1() {
		// This test assumes your HanoiPeg implementation is correct.
		peg[0].addRing(new HanoiRing(1));
		HanoiSolution solution = impl.solve(1);
		ListInterface<HanoiMove> moves = solution.getMoves();
		assertTrue(isSolution(moves));
	}

	@Test(timeout = 5000)
	public void testSolveSize2() {
		// This test assumes your HanoiPeg implementation is correct.
		peg[0].addRing(new HanoiRing(2));
		peg[0].addRing(new HanoiRing(1));
		HanoiSolution solution = impl.solve(2);
		ListInterface<HanoiMove> moves = solution.getMoves();
		assertTrue(isSolution(moves));
	}

	@Test(timeout = 5000)
	public void testSolveSize3() {
		// This test assumes your HanoiPeg implementation is correct.
		peg[0].addRing(new HanoiRing(3));
		peg[0].addRing(new HanoiRing(2));
		peg[0].addRing(new HanoiRing(1));
		HanoiSolution solution = impl.solve(3);
		ListInterface<HanoiMove> moves = solution.getMoves();
		assertTrue(isSolution(moves));
	}

	@Test(timeout = 5000)
	public void testSolveSize4() {
		// This test assumes your HanoiPeg implementation is correct.
		peg[0].addRing(new HanoiRing(4));
		peg[0].addRing(new HanoiRing(3));
		peg[0].addRing(new HanoiRing(2));
		peg[0].addRing(new HanoiRing(1));
		HanoiSolution solution = impl.solve(4);
		ListInterface<HanoiMove> moves = solution.getMoves();
		assertTrue(isSolution(moves));
	}

	@Test(timeout = 5000)
	public void testSolveSize15() {
		// This test assumes your HanoiPeg implementation is correct.
		peg[0].addRing(new HanoiRing(15));
		peg[0].addRing(new HanoiRing(14));
		peg[0].addRing(new HanoiRing(13));
		peg[0].addRing(new HanoiRing(12));
		peg[0].addRing(new HanoiRing(11));
		peg[0].addRing(new HanoiRing(10));
		peg[0].addRing(new HanoiRing(9));
		peg[0].addRing(new HanoiRing(8));
		peg[0].addRing(new HanoiRing(7));
		peg[0].addRing(new HanoiRing(6));
		peg[0].addRing(new HanoiRing(5));
		peg[0].addRing(new HanoiRing(4));
		peg[0].addRing(new HanoiRing(3));
		peg[0].addRing(new HanoiRing(2));
		peg[0].addRing(new HanoiRing(1));
		HanoiSolution solution = impl.solve(15);
		ListInterface<HanoiMove> moves = solution.getMoves();
		assertTrue(isSolution(moves));
	}

}
