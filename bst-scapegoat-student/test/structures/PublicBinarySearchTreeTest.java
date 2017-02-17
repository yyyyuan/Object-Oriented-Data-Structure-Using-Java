package structures;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.Timeout;

public class PublicBinarySearchTreeTest {

	private BSTInterface<Integer> emptyTree;
	private BSTInterface<String> oneNodeTree;
	private static final String FOO = "foo";

	@Rule
    public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);
	
	@Before
	public void before() {
		emptyTree = new BinarySearchTree<Integer>();
		oneNodeTree = new BinarySearchTree<String>();
		oneNodeTree.add(FOO);
	}
	
	@Test
	public void testEmpty() {
		assertTrue(emptyTree.isEmpty());
	}

	@Test
	public void testNotEmpty() {
		assertFalse(oneNodeTree.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, emptyTree.size());
		assertEquals(1, oneNodeTree.size());
	}
	
	@Test
	public void testContains() {
		assertTrue(oneNodeTree.contains(FOO));
	}
	
	@Test
	public void testContains1() {
		emptyTree.add(3);
		emptyTree.add(2);
		emptyTree.add(1);
		emptyTree.add(4);
		
		assertTrue(emptyTree.contains(3));
		assertTrue(emptyTree.contains(2));
		assertTrue(emptyTree.contains(1));
		assertTrue(emptyTree.contains(4));
		assertFalse(emptyTree.contains(5));


	}
	
	@Test
    public void testRemove() {
		assertFalse(emptyTree.remove(0));
	}
	
	@Test
	public void testGet() {
		assertEquals(FOO, oneNodeTree.get(FOO));
	}
	
	@Test
	public void testAdd() {
		emptyTree.add(1);
		assertFalse(emptyTree.isEmpty());
		assertEquals(1, emptyTree.size());
	}
	
	@Test
	public void testGetMinimum() {
		assertEquals(null, emptyTree.getMinimum());
		
		emptyTree.add(3);
		emptyTree.add(2);
		emptyTree.add(1);
		emptyTree.add(4);
		
		assertEquals(1, (int) emptyTree.getMinimum());
	}

	@Test
	public void testGetMaximum() {
		assertEquals(FOO, oneNodeTree.getMaximum());
		
		emptyTree.add(3);
		emptyTree.add(2);
		emptyTree.add(1);
		emptyTree.add(4);
		
		assertEquals(4, (int) emptyTree.getMaximum());
	}

	@Test
	public void testHeight() {
		assertEquals(-1, emptyTree.height());
		assertEquals(0, oneNodeTree.height());
		
		emptyTree.add(3);
		emptyTree.add(2);
		emptyTree.add(1);
		emptyTree.add(4);
		assertEquals(2, emptyTree.height());


	}
	
	@Test
	public void testPreorderIterator() {
		Iterator<String> i = oneNodeTree.preorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
	}

	@Test
	public void testInorderIterator() {
		Iterator<String> i = oneNodeTree.inorderIterator();
		while (i.hasNext()) {
			assertEquals(FOO, i.next());			
		}
	}
	
	@Test
	public <T> void testInorder1() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		emptyTree.add(4);
		
		assertEquals(4, emptyTree.size());
		
		Iterator<Integer> test = emptyTree.inorderIterator();
		

		int[] y = new int[4];
		
			
		for (int index = 0; index < 4; index++) {
			y[index] = (int) test.next();
		} 
		
		emptyTree.add(y[3]);
		
		assertEquals(4, y[3]);
	}

	@Test
	public void testPostorderIterator() {
		Iterator<Integer> i = emptyTree.postorderIterator();
		assertFalse(i.hasNext());
	}
	
	@Test
	public void testEquals() {
		BSTInterface<String> tree = new BinarySearchTree<String>();
		BSTInterface<String> subtree = new BinarySearchTree<String>();

		assertTrue(subtree.equals(tree));

		
		assertFalse(oneNodeTree.equals(tree));
		tree.add(new String("foo"));
		assertTrue(oneNodeTree.equals(tree));
	}
	
	@Test
	public void testEquals1() {
		BSTInterface<Integer> tree = new BinarySearchTree<Integer>();
		
		emptyTree.add(5);
		emptyTree.add(3);
		emptyTree.add(6);
		
		tree.add(3);
		tree.add(5);
		tree.add(6);
		
		assertFalse(emptyTree.equals(tree));


	}
	
	@Test
	public void testSameValues() {
		BSTInterface<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.add(1);
		emptyTree.add(2);
		
		tree.add(2);
		tree.add(1);
		
		assertTrue(emptyTree.sameValues(tree));
	}
	
	@Test
	public void testSameValues1() {
		BSTInterface<Integer> tree = new BinarySearchTree<Integer>();
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		emptyTree.add(4);

		

		
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);

		
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.remove(2);
		tree.remove(2);
		
		assertTrue(emptyTree.sameValues(tree));
		
		emptyTree.add(5);
		emptyTree.add(6);
		emptyTree.add(7);
		emptyTree.add(4);
		
		tree.add(4);
		tree.add(7);
		tree.add(6);
		tree.add(5);
		
		emptyTree.balance();
		assertTrue(emptyTree.sameValues(tree));
		
		
		emptyTree.remove(7);
		tree.remove(7);

		assertTrue(emptyTree.sameValues(tree));




	}
	
	@Test 
	public void testIsBalanced() {
		// disabled due to late change of isBalanced() specification
		// assertTrue(emptyTree.isBalanced());
		emptyTree.add(1);
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(2);
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(3);
		assertFalse(emptyTree.isBalanced());
	}
	
	@Test 
	public void testBalance() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		assertFalse(emptyTree.isBalanced());
		emptyTree.balance();
		assertTrue(emptyTree.isBalanced());
		
		assertEquals(2, (int) emptyTree.getRoot().getData());
	}
	
	@Test
	public void testBalance1() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		emptyTree.add(4);
		emptyTree.add(5);
		assertFalse(emptyTree.isBalanced());
		emptyTree.balance();
		assertTrue(emptyTree.isBalanced());
		emptyTree.add(6);
		emptyTree.add(7);
		emptyTree.add(8);
		emptyTree.add(9);

		assertFalse(emptyTree.isBalanced());
		emptyTree.balance();
		assertTrue(emptyTree.isBalanced());
	}
	
	@Test
	public void testBalance2() {
		emptyTree.add(1);
		emptyTree.add(2);
		emptyTree.add(3);
		emptyTree.add(4);
		emptyTree.add(5);
		emptyTree.add(6);
		emptyTree.add(7);
		emptyTree.add(8);
		emptyTree.add(9);

		assertFalse(emptyTree.isBalanced());
		emptyTree.balance();
		assertTrue(emptyTree.isBalanced());

	}
}
