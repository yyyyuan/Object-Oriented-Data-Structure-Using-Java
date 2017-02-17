package hanoi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class PublicHanoiPegTest {

	private HanoiPeg impl;

	@Before
	public void setup() {
		impl = new StackBasedHanoiPeg();
	}

	@Test(timeout = 5000)
	public void testPeg() {
		assertFalse("Peg should be empty.", impl.hasRings());

		HanoiRing fiveRing = new HanoiRing(5);
		impl.addRing(fiveRing);
		assertTrue("Peg should not be empty.", impl.hasRings());
		assertEquals("The top element we just put on top.", fiveRing,
				impl.getTopRing());

		HanoiRing fourRing = new HanoiRing(4);
		impl.addRing(fourRing);
		assertEquals("The top element should be fourRing", fourRing,
				impl.getTopRing());

		HanoiRing top = impl.remove();
		assertEquals("The removed element should be fourRing", fourRing, top);
		assertEquals("The top element should be fiveRing", fiveRing,
				impl.getTopRing());
		assertTrue("The peg should not be empty.", impl.hasRings());

		top = impl.remove();
		assertEquals("The removed element should be fiveRing", fiveRing, top);
		assertFalse("The peg should be empty.", impl.hasRings());
	}

	@Test(timeout = 5000, expected = IllegalHanoiMoveException.class)
	public void testIllegalRemove() {
		impl.remove();
	}

	@Test(timeout = 5000, expected = IllegalHanoiMoveException.class)
	public void testIllegalAdd() {
		impl.addRing(new HanoiRing(5));
		impl.addRing(new HanoiRing(6));
	}

	@Test(timeout = 5000, expected = IllegalHanoiMoveException.class)
	public void testIllegalAdd2() {
		impl.addRing(new HanoiRing(5));
		impl.addRing(new HanoiRing(5));
	}

}
