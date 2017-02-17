package graphs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayBasedGraphTest {

	private SimpleGraph<Integer> graph;

	@Before
	public void before() {
		graph = new ArrayBasedGraph<Integer>(10);
	}

	@Test
	public void testAddToNewGraph() {
		assertFalse(graph.hasVertex(100));
		graph.addVertex(100);
		assertTrue(graph.hasVertex(100));
	}

	@Test
	public void testVertexListSize() {
		for (int i = 0; i < 5; i++) {
			graph.addVertex(i);
		}
		assertEquals(5, graph.listVertices().size());
	}
	
	@Test
	public void testAddvertex() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);
		graph.addVertex(10);

	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testAddvertexOutOfBounds() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);
		graph.addVertex(10);
		
		graph.addVertex(11);
	}
	
	@Test
	public void testAddDuplicateElements1() {
		graph.addVertex(1);
		graph.addVertex(1);
		
		assertEquals((Integer) 1, graph.listVertices().get(0));
		assertNotEquals((Integer) 1, graph.listVertices().get(0));

	}
	
	@Test
	public void testAddvertexDoingNothingWhenElementAlreaadyExists() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);
		graph.addVertex(10);

		graph.addVertex(2);
	}
	
	@Test
	public void testAddvertexNotOutOfBounds() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);

		graph.addVertex(2);
	}
	
	@Test
	public void testHasVertex() {
		assertFalse(graph.hasVertex(1));
		graph.addVertex(1);
		assertTrue(graph.hasVertex(1));
		
		assertFalse(graph.hasVertex(2));
		graph.addVertex(2);
		assertTrue(graph.hasVertex(2));
	}
	
	@Test
	public void testHasVertexTestingDoubleElements() {
		assertFalse(graph.hasVertex(1));
		graph.addVertex(1);
		assertTrue(graph.hasVertex(1));
		
		assertFalse(graph.hasVertex(2));
		graph.addVertex(2);
		assertTrue(graph.hasVertex(1));
		assertTrue(graph.hasVertex(2));
	}
	
	@Test
	public void testAddEdge() {
		graph.addVertex(1);
		graph.addVertex(2);
		
		graph.addEdge(1, 2);
			
	}
	
	@Test
	public void testAddEdgeAddingDuplicateEdges() {
		graph.addVertex(1);
		graph.addVertex(2);
		
		graph.addEdge(1, 2);
			
		graph.addEdge(1, 2);

	}
	
	@Test
	public void testHasEdge() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		assertFalse(graph.hasEdge(1, 2));
		graph.addEdge(1,2);
		assertTrue(graph.hasEdge(1, 2));
	}
	

	
	@Test
	public void testHasEdgeForMoreElements() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		assertFalse(graph.hasEdge(1, 2));
		graph.addEdge(1,2);
		graph.addEdge(2, 3);
		assertTrue(graph.hasEdge(1, 2));
		assertTrue(graph.hasEdge(2, 3));


	}
	
	@Test
	public void testListVerticesSize() {
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(100);
		graph.addVertex(20);
		graph.addVertex(27);
		graph.addVertex(12);
		
		assertEquals(7, graph.listVertices().size());

	}
	
	@Test
	public void testListVerticesContents() {
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(100);
		graph.addVertex(20);
		graph.addVertex(27);
		graph.addVertex(12);
		
		assertTrue(graph.listVertices().contains(100));
		assertTrue(graph.listVertices().contains(0));
		assertTrue(graph.listVertices().contains(1));
		assertTrue(graph.listVertices().contains(2));
		assertTrue(graph.listVertices().contains(20));
		assertTrue(graph.listVertices().contains(27));
		assertTrue(graph.listVertices().contains(12));

		assertEquals(((Integer) 100), graph.listVertices().get(3));
		assertEquals(((Integer) 20), graph.listVertices().get(4));
		assertEquals(((Integer) 27), graph.listVertices().get(5));

	}
	
	@Test
	public void testIfListNeighborsWorks() {
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);

		assertFalse(graph.listNeighbors(0).contains(1));
		assertFalse(graph.listNeighbors(0).contains(2));
		
	}
	
	@Test
	public void testListNeighborsContents() {
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);

		graph.addEdge(1, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		
		assertTrue(graph.listNeighbors(0).contains(1));
		assertTrue(graph.listNeighbors(0).contains(2));

		
	}
	
	@Test
	public void testVertexListSize1() {
		assertFalse(graph.hasVertex(100));
		graph.addVertex(100);
		assertTrue(graph.hasVertex(100));
		
		assertEquals(1, graph.listVertices().size());
	}
}
