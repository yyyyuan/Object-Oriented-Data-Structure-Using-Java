package structures;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comparators.StringLengthComparator;

public class PublicArrayHeapTest {

  private AbstractArrayHeap<String, Integer> arrayHeap;

  @Before
  public void setup() {
    arrayHeap = new StudentArrayHeap<String, Integer>(new StringLengthComparator());
  }

  @Test(timeout = 100)
  public void testBubbleUp() {
    // The comparator being used prioritizes by the length of the string
    // passed in as a priority
		
    List<Entry<String, Integer>> view = arrayHeap.asList();
		
    arrayHeap.add(".", 1);
    assertEquals("Peek value should be 1.", new Integer(1),
                 arrayHeap.peek());
		
    /*
     *    Original State       Initial Add               After BubbleUp
     *    (".", 1)     =>         (".", 1)         =>    ("..", 2)            
     *                             /                       /
     *                         ("..", 2)               (".", 1)
     */
		
    arrayHeap.add("..", 2);
    assertEquals("Peek value should be 2.", new Integer(2), arrayHeap.peek());
    assertEquals("The second element in the array should be 1.", new Integer(1), view.get(1).getValue());

    /*
     *    Original State       Initial Add                   After BubbleUp
     *    ("..", 2)     =>      ("..", 2)                =>          ("...", 3)
     *     /                    /        \                           /       \
     *  (".", 1)             (".", 1)    ("...", 3)             (".", 1)     ("..", 2)
     */
		
    arrayHeap.add("...", 3);
    assertEquals("Peek value should be 3.", new Integer(3), arrayHeap.peek());
    assertEquals("The third element in the array should be 2.", new Integer(2), view.get(2).getValue());
		
    /*
     *    Original State             Initial Add                   After BubbleUp
     *    ("...", 3)          =>     ("...", 3)           =>        (".....", 4)
     *    /        \               /             \                  /           \
     * (".", 1)  ("..", 2)     (".", 1)       ("..", 2)        ("...", 3)      ("..", 2)
     *                        /                                 /
     *                     (".....", 4)                    (".", 1)
     */
		
    arrayHeap.add(".....", 4);
    assertEquals("Peek value should be 4.", new Integer(4), arrayHeap.peek());
    assertEquals("The fourth element in the array should be 1.", new Integer(1), view.get(3).getValue());
    assertEquals("The second element in the array should be 3.", new Integer(3), view.get(1).getValue());
		
    /*
     *    Original State           =>       Initial Add            =>      After BubbleUp
     *       (".....", 4)                   (".....", 4)                     (".....", 4)
     *      /           \                   /         \                       /        \
     *  ("...", 3)      ("..", 2)       ("...", 3)    ("..", 2)         ("....", 5)   ("..", 2)
     *    /                              /      \                       /        \
     * (".", 1)                    (".", 1)    ("....", 5)          (".", 1)    ("...", 3)
     */
		
    arrayHeap.add("....", 5);
    assertEquals("Peek value should be 4.", new Integer(4), arrayHeap.peek());
    assertEquals("The fifth element in the array should be 3.", new Integer(3), view.get(4).getValue());
    assertEquals("The second element in the array should be 5.", new Integer(5), view.get(1).getValue());
  }
	
  @Test (timeout = 100)
  public void testBubbleUpAndBubbleDown(){
    // The comparator being used prioritizes by the length of the string
    // passed in as a priority
				
    List<Entry<String, Integer>> view = arrayHeap.asList();
				
    arrayHeap.add(".", 1).add("..", 2).add("...", 3).add(".....", 4).add("....", 5);
				
    /*
     *    Starting State          =>   Initial removal        =>     After Bubble Down
     *    (".....", 4)                   ("...", 3)                  ("....", 5)
     *     /        \                    /        \                  /         \
     * ("....", 5)   ("..", 2)       ("....", 5)  ("..", 2)      ("...", 3)    ("..", 2)
     *   /        \                   /                           /
     *(".", 1)    ("...", 3)        (".", 1)                    (".", 1)
     */
    assertEquals("The highest priority is 4.", new Integer(4), arrayHeap.remove());
    assertEquals("The second Element should be 3", new Integer(3), view.get(1).getValue());
		
    /*
     *    Starting State          => Initial removal        => After Bubble Down
     *    ("....", 5)                  (".", 1)                      ("...", 3)
     *     /         \                  /     \                      /        \                 
     * ("...", 3)    ("..", 2)    ("...", 3)  ("..", 2)          (".", 1)     ("..", 2)
     *   /
     * (".", 1)
     */
    assertEquals("The highest priority is 5.", new Integer(5), arrayHeap.remove());
    assertEquals("The second element is 1.", new Integer(1), view.get(1).getValue());
		
    /*
     *    Starting State              => Initial removal     => After Bubble Down
     *    ("...", 3)                     ("..", 2)               ("..", 2)
     *     /        \                    /                       /
     * (".", 1)     ("..", 2)         (".", 1)                 (".", 1)
     *   
     */
    assertEquals("The highest priority is 3.", new Integer(3), arrayHeap.remove());
    assertEquals("The second element is 1.", new Integer(1), view.get(1).getValue());
		
    /*
     *    After Bubble Down          => Initial removal        => After Bubble Down
     *    ("..", 2)                      (".", 1)                    (".", 1)
     *     /
     * (".", 1)
     *   
     */
    assertEquals("The highest priority is 2.", new Integer(2), arrayHeap.remove());
    assertEquals("The last element is 1.", new Integer(1), view.get(0).getValue());
		
		
  }
	
  @Test (timeout = 100)  
  public void testIndiceFunctions(){
    assertEquals(1, arrayHeap.getLeftChildOf(0));
    assertEquals(2, arrayHeap.getRightChildOf(0));
    assertEquals(3, arrayHeap.getLeftChildOf(1));
    assertEquals(4, arrayHeap.getRightChildOf(1));
    assertEquals(5, arrayHeap.getLeftChildOf(2));
    assertEquals(6, arrayHeap.getRightChildOf(2));
    assertEquals(0, arrayHeap.getParentOf(1));
    assertEquals(0, arrayHeap.getParentOf(2));
    assertEquals(1, arrayHeap.getParentOf(3));
    assertEquals(1, arrayHeap.getParentOf(4));
    assertEquals(2, arrayHeap.getParentOf(5));
    assertEquals(2, arrayHeap.getParentOf(6));
  }
	
  @Test (timeout = 100, expected = IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException1(){
    arrayHeap.getLeftChildOf(-1);
  }
	
  @Test (timeout = 100, expected = IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException2(){
    arrayHeap.getRightChildOf(-1);
  }
	
  @Test (timeout = 100, expected = IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException3(){
    arrayHeap.getParentOf(0);
  }

}
