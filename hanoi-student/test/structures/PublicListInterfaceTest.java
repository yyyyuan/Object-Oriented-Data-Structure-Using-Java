package structures;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import structures.ListInterface;

public class PublicListInterfaceTest {

	private ListInterface<Integer> impl;

	@Before
	public void setup() {
		impl = new ListImplementation<Integer>();
	}

	@Test(timeout = 500)
	public void testList0() {
		assertTrue("Newly constructed list should be empty", impl.isEmpty());
	}

	@Test(timeout = 500)
	public void testList1() {
		assertTrue("Newly constructed list should be empty", impl.isEmpty());
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
	}

	@Test(timeout = 500)
	public void testList2() {
		assertTrue("Newly constructed list should be empty", impl.isEmpty());
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertSame("Appending the list should return itself.", impl,
				impl.append(5));

	}

	@Test(timeout = 500)
	public void testList3() {
		assertTrue("Newly constructed list should be empty", impl.isEmpty());
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertEquals("Appending the list should return itself.", impl,
				impl.append(5));
		assertEquals("Size should now be 1.", 1, impl.size());

	}

	@Test(timeout = 500)
	public void testList4() {
		assertTrue("Newly constructed list should be empty", impl.isEmpty());
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertEquals("Appending the list should return itself.", impl,
				impl.append(5));
		assertEquals("Size should now be 1.", 1, impl.size());
		impl.append(6).append(7).append(8);
		assertEquals("Size should now be 4.", 4, impl.size());
	}

	@Test(timeout = 500)
	public void testList5() {
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertEquals("Appending the list should return itself.", impl,
				impl.append(5));
		assertEquals("Size should now be 1.", 1, impl.size());
		impl.append(6).append(7).append(8);
		assertEquals("Size should now be 4.", 4, impl.size());
		assertEquals("First element should be 5.", new Integer(5), impl.get(0));
	}

	@Test(timeout = 500)
	public void testList6() {
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertEquals("Appending the list should return itself.", impl,
				impl.append(5));
		assertEquals("Size should now be 1.", 1, impl.size());
		impl.append(6).append(7).append(8);
		assertEquals("Size should now be 4.", 4, impl.size());
		assertEquals("First element should be 5.", new Integer(5), impl.get(0));
		assertEquals("Second element should be 6.", new Integer(6), impl.get(1));
	}

	@Test(timeout = 500)
	public void testList7() {
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertEquals("Appending the list should return itself.", impl,
				impl.append(5));
		assertEquals("Size should now be 1.", 1, impl.size());
		impl.append(6).append(7).append(8);
		assertEquals("Size should now be 4.", 4, impl.size());
		assertEquals("First element should be 5.", new Integer(5), impl.get(0));
		assertEquals("Second element should be 6.", new Integer(6), impl.get(1));
		assertEquals("Third element should be 7.", new Integer(7), impl.get(2));
	}

	@Test(timeout = 500)
	public void testList8() {
		assertEquals("Newly constructed list should have size 0", 0,
				impl.size());
		assertEquals("Appending the list should return itself.", impl,
				impl.append(5));
		assertEquals("Size should now be 1.", 1, impl.size());
		impl.append(6).append(7).append(8);
		assertEquals("Size should now be 4.", 4, impl.size());
		assertEquals("First element should be 5.", new Integer(5), impl.get(0));
		assertEquals("Second element should be 6.", new Integer(6), impl.get(1));
		assertEquals("Third element should be 7.", new Integer(7), impl.get(2));
		assertEquals("Fourth element should be 8.", new Integer(8), impl.get(3));
	}

	@Test(timeout = 500)
	public void testList9() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
	}

	@Test(timeout = 500)
	public void testList10() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("First returned by iterator should be 5.", new Integer(5),
				iterator.next());
	}

	@Test(timeout = 500)
	public void testList11() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("First returned by iterator should be 5.", new Integer(5),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
	}

	@Test(timeout = 500)
	public void testList12() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("First returned by iterator should be 5.", new Integer(5),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Second returned by iterator should be 6.",
				new Integer(6), iterator.next());
	}

	@Test(timeout = 500)
	public void testList13() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("First returned by iterator should be 5.", new Integer(5),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Second returned by iterator should be 6.",
				new Integer(6), iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
	}

	@Test(timeout = 500)
	public void testList14() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("First returned by iterator should be 5.", new Integer(5),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Second returned by iterator should be 6.",
				new Integer(6), iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Third returned by iterator should be 7.", new Integer(7),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Fourth returned by iterator should be 8.",
				new Integer(8), iterator.next());
		assertFalse("Iterator should not have next element", iterator.hasNext());
	}

	@Test(timeout = 500, expected = NoSuchElementException.class)
	public void testList15() {
		impl.append(5).append(6).append(7).append(8);
		Iterator<Integer> iterator = impl.iterator();
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("First returned by iterator should be 5.", new Integer(5),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Second returned by iterator should be 6.",
				new Integer(6), iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Third returned by iterator should be 7.", new Integer(7),
				iterator.next());
		assertTrue("Iterator should have next element", iterator.hasNext());
		assertEquals("Fourth returned by iterator should be 8.",
				new Integer(8), iterator.next());
		assertFalse("Iterator should not have next element", iterator.hasNext());
		iterator.next();
	}

	@Test(timeout = 500)
	public void testListUnbounded() {
		for (int i = 0; i < 500000; i++) {
			assertEquals(i, impl.size());
			impl.append(i);
		}
	}

	@Test(timeout = 500, expected = NullPointerException.class)
	public void testNullPointer() {
		impl.append(null);
	}

	@Test(timeout = 500, expected = NoSuchElementException.class)
	public void testOutOfBounds1() {
		impl.append(5).append(6).append(7).append(8).get(4);
	}

	@Test(timeout = 500, expected = NoSuchElementException.class)
	public void testOutOfBounds2() {
		impl.append(5).append(6).append(7).append(8).get(-1);
	}
}
