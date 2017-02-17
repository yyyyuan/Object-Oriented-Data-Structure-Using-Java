package algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PublicRecursiveMathTest {

	private RecursiveMath impl;

	@Before
	public void setup() {
		impl = new RecursiveMath();
		if (impl == null)
			fail("Could not allocate a RecursiveMath object.");
	}

	@Test(timeout = 5000)
	public void testIsEven() {
		assertTrue(impl.isEven(4));
		assertFalse(impl.isEven(1));
		assertTrue(impl.isEven(12));
		assertTrue(impl.isEven(-42));
		assertFalse(impl.isEven(-13));
	}

	@Test(timeout = 5000)
	public void testIsOdd() {
		assertFalse(impl.isOdd(4));
		assertTrue(impl.isOdd(1));
		assertFalse(impl.isOdd(12));
		assertFalse(impl.isOdd(-42));
		assertTrue(impl.isOdd(-13));
	}

	@Test(timeout = 5000)
	public void testSumN() {
		assertEquals(0, impl.sumN(0));
		assertEquals(1, impl.sumN(1));
		assertEquals(3, impl.sumN(2));
		assertEquals(6, impl.sumN(3));
		assertEquals(10, impl.sumN(4));
		assertEquals(15, impl.sumN(5));
		assertEquals(21, impl.sumN(6));
		assertEquals(5050, impl.sumN(100));
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testSumNException() {
		impl.sumN(-1);
	}

	@Test(timeout = 5000)
	public void testFactorial() {
		assertEquals(1, impl.factorial(1));
		assertEquals(2, impl.factorial(2));
		assertEquals(6, impl.factorial(3));
		assertEquals(24, impl.factorial(4));
		assertEquals(3628800, impl.factorial(10));
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
  public void testFactorialException() {
		impl.factorial(-1);
	}

	@Test(timeout = 5000)
	public void testBiPower() {
		assertEquals(1, impl.biPower(0));
		assertEquals(2, impl.biPower(1));
		assertEquals(4, impl.biPower(2));
		assertEquals(0x1 << 20, impl.biPower(20));
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
  public void testBiPowerException() {
		impl.biPower(-5);
	}

}
