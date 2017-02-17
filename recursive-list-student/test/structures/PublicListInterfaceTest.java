package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PublicListInterfaceTest {

	private ListInterface<String> list;
	private ListInterface<String> q;
	
	private ListInterface<Integer> what;

	@Before
	public void setup(){
          list = new RecursiveList<String>();
          q = new RecursiveList<String>();
          what = new RecursiveList<Integer>();

	}

	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertAt(0,"hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
		assertEquals("First element should .equals \"foo\".", "foo", list.get(0));
		assertEquals("hello",list.removeAt(2));
		assertEquals(2, list.size());
		assertFalse("It should return false", list.remove("hello"));
		assertEquals(2, list.size());
		assertEquals("foo", list.removeFirst());
	}
	
	@Test (timeout = 500)
	public void testRemoveAt() {
		assertFalse(list.remove("Hello"));
		assertTrue(list.isEmpty());
		assertEquals(0,list.size());
		list.insertAt(0,"world");
		assertFalse(list.remove("Hello"));
		assertEquals("world", list.getLast());
		list.insertAt(0,"hello");
		assertFalse(list.remove("Hello"));
		list.insertAt(0,"sun");
		assertFalse(list.remove("Hello"));
		list.insertAt(0,"flower");
		assertEquals(4,list.size());
		assertFalse(list.isEmpty());
		
		assertEquals("world", list.removeAt(3));
		assertTrue("Remove that element", list.remove("hello"));
		assertFalse("Remove that element", list.remove("hellos"));
		assertEquals(2, list.size());
		list.removeFirst();
		list.removeFirst();
	}
	
	@Test (timeout = 500)
	public void testRemoveFirst() {
		list.insertLast("world");
		list.insertLast("hello");
		list.insertLast("sun");
		list.insertLast("flower");		
		assertEquals("hello", list.get(1));
		assertEquals("sun",list.get(2));
		assertEquals("world", list.get(0));
		list.insertAt(2, "wow");
		list.insertAt(5, "wow");
		assertEquals(2, list.indexOf("wow"));
		assertEquals(-1, list.indexOf("wowo"));

	}
	
	@Test
	public void testEmpty() {
		

		q = list.insertAt(0, "world");
		assertEquals(0, q.indexOf("world"));
		
		assertEquals(-1, list.indexOf("hello"));
		list.insertAt(0,"hello");
		list.insertAt(0,"sun");
		list.insertAt(0,"flower");
		
		assertEquals(3, list.indexOf("world"));
		assertEquals(2, list.indexOf("hello"));
		assertEquals(1, list.indexOf("sun"));
		assertEquals(0, list.indexOf("flower"));
		assertEquals(-1, list.indexOf("wworld"));


		assertEquals("world", list.getLast());
		assertEquals("world", list.get(3));
		assertEquals("world", list.removeLast());
		assertEquals("hello", list.removeLast());
		assertEquals("sun", list.removeLast());
		assertEquals(true, list.remove("flower"));
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

	}
	
	@Test
	public void testInsert() {
		list.insertFirst("world");
		list.insertAt(1,"foo");
		list.insertAt(2,"sun");
		list.insertFirst("hello");
		
		assertEquals(0, list.indexOf("hello"));
		assertEquals("sun", list.get(3));
		assertEquals("sun", list.get(3));
		assertEquals("hello", list.getFirst());
		assertTrue(list.remove("hello"));
		assertFalse(list.remove("whocares"));
		
		assertTrue(list.remove("sun"));
		assertEquals("foo", list.getLast());
		assertEquals(2, list.size());

		
	}
	
	@Test
	public void test() {
		list.insertFirst("hello");
		list.insertLast("oww");
		list.insertAt(1, "lalal");
		list.insertLast("duo");
		list.insertAt(4, "flower");
		
		list.removeAt(2);
		list.removeFirst();
		
		assertEquals(2, list.indexOf("flower"));
		assertEquals(0, list.indexOf("lalal"));
	}
	
	@Test
	public void testEmptyList() {
		
		String a = new String ("hello");
		String b = new String ("hello");

		assertEquals(0, list.size());
		list.insertFirst("Hello");
		assertTrue(list.remove("Hello"));
		
		list.insertFirst("wow");
		list.removeLast();
		
		list.insertLast("sun");
		list.removeFirst();
		
		assertFalse(list.remove("hello"));
		assertEquals(-1, list.indexOf("flower"));

	}
	
	@Test
	public void testGarbage() {
		Integer b = new Integer(5);
		Integer c = 5;
		
		what.insertFirst(b);
		assertTrue(what.remove(5));

		
		
	}
}
