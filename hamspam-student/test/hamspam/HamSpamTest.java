package hamspam;

import static org.junit.Assert.*;

import org.junit.Test;

public class HamSpamTest {
	private final HamSpam hamspamThreeFour = new HamSpam(3, 4);
	private final HamSpam hamspamTwoFive = new HamSpam(2, 5);

	@Test
	public void testNotHamOrSpamGetValue() {
		assertEquals("getValue returns incorrect value", "2",
				hamspamThreeFour.getValue(2));
	}

	@Test
	public void testNotHamOrSpamGetValueAlt() {
		assertEquals("getValue returns incorrect value", "3",
				hamspamTwoFive.getValue(3));
	}

	@Test
	public void testHamOrSpamGetValue() {
		assertEquals("getValue returns incorrect value", "ham",
				hamspamThreeFour.getValue(3));
		assertEquals("getValue returns incorrect value", "spam",
				hamspamThreeFour.getValue(4));
	}

	@Test
	public void testHamOrSpamMultipleGetValue() {
		assertEquals("getValue returns incorrect value", "ham",
				hamspamThreeFour.getValue(9));
		assertEquals("getValue returns incorrect value", "spam",
				hamspamThreeFour.getValue(8));
	}

	@Test
	public void testHamAndSpamGetValue() {
		assertEquals("getValue returns incorrect value",
				"hamspam", hamspamThreeFour.getValue(12));
	}

	@Test
	public void testGetValuesSimple() {
		assertArrayEquals("getValues returns incorrect values", new String[] {
				"1", "2", "ham", "spam" }, hamspamThreeFour.getValues(1, 4));
	}

	@Test
	public void testGetValuesOffset() {
		assertArrayEquals("getValues returns incorrect values", new String[] {
				"2", "ham", "spam", "5", "ham" },
				hamspamThreeFour.getValues(2, 6));
	}
}