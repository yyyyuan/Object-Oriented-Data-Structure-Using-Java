package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PublicDoublyCircularLinkedListTest {

	private DoublyCicularLinkedList<Integer> list;
	
	@Before
	public void setUp() {
		list = new DoublyCircularLinkedListImplementation<Integer>();
	}
	
	@Test (timeout = 100)
	public void testAdd() {
		try {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
		} catch (Exception e) {
			String m = "problem adding to your list: ";
			fail(m + e.getMessage());
		}
	}
	
	@Test (timeout = 100)
	public void testRemove() {
		try {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
			for (int i = 0; i < 1000; i++) {
				list.remove(i);
			}
		} catch (Exception e) {
			String m = "problem removing from your list: ";
			fail(m + e.getMessage());
		}
	}
	
	@Test (timeout = 100)
	public void testSize() {
		assertEquals(0, list.size());
		
		try {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
				assertEquals(i, list.size()-1);
			}			
			for (int i = 0; i < 1000; i++) {
				assertEquals(1000-i, list.size());
				list.remove(i);				
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (timeout = 500)
	public void testContains() {
		try {
			assertFalse(list.contains(4));
			
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}			
			for (int i = 0; i < 1000; i++) {
				assertTrue(list.contains(i));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}	
	
	@Test (timeout = 500)
	public void testGet() {
		try {
			assertNull(list.get(4));			
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}			
			for (int i = 0; i < 1000; i++) {
				assertNotNull(list.get(i));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}	
	
	@Test (timeout = 500)
	public void testIterateForward() {
		try {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
			list.reset();
			for (int i = 0; i < 1000; i++) {
				int info = list.getNext();
				assertEquals(i, info);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test (timeout = 500)
	public void testIterateBackward() {
		try {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
			}
			list.reset();
			for (int i = 999; i >= 0; i--) {
				int info = list.getPrevious();
				assertEquals(i, info);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}	

}
