package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class PublicMaxQueueTest {

  MaxQueue<String> queue;
	
  @Before
  public void setup() {
    queue = new MaxQueue<String>();
  }

  @Test (timeout = 100)
  public void testQueue() {
    queue.enqueue(100, "Highest priority");
    queue.enqueue(50, "High priority");
    queue.enqueue(25, "Medium priority");
    queue.enqueue(0, "Low priority");
    assertEquals("Highest priority", queue.dequeue());
    assertEquals("High priority", queue.dequeue());
    assertEquals("Medium priority", queue.dequeue());
    assertEquals("Low priority", queue.dequeue());
  }
  
  @Test
  public void testSize() {
	queue.enqueue(100, "Highest priority");
	queue.enqueue(50, "High priority");
	queue.enqueue(25, "Medium priority");
	queue.enqueue(0, "Low priority");	
	
	queue.dequeue();
	queue.dequeue();
	
	assertEquals(2, queue.size());
  }

  @Test
  public void testIterator() {
	  Iterator<Entry<Integer, String>> test;
	  
	queue.enqueue(100, "Highest priority");
	queue.enqueue(50, "High priority");
	queue.enqueue(25, "Medium priority");
	queue.enqueue(0, "Low priority");	  
	
	test = queue.iterator();
	
	test.next();
	test.next();
	test.next();
	assertTrue(test.hasNext());
	test.next();
	assertFalse(test.hasNext());
		
		
  }
  
}
