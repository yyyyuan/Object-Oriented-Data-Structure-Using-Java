package graphs;

import java.util.List;

/**
 * An interface representing a simple graph.
 * 
 * A simple graph consists of a set of vertices (of type T) and a set of edges.
 * 
 * An edge exists between two vertices u and v if and only if u and v are
 * adjacent in the graph. In a simple graph, the edges are unweighted (they
 * exist, or do not, but have no associated value) and are undirected (if u is
 * adjacent to v, then v is adjacent to u, and vice versa).
 */
public interface SimpleGraph<T extends Comparable<T>> {
	/**
	 * Adds the vertex to the set of vertices in the graph.
	 * 
	 * Does nothing if the vertex is already in the set of vertices.
	 * 
	 * @param vertex
	 */
	void addVertex(T vertex);

	/**
	 * @param vertex
	 * @return true iff the vertex is in the set of vertices in the graph
	 */
	boolean hasVertex(T vertex);

	/**
	 * Adds the undirected edge between vertex1 and vertex2 to the set of edges
	 * in the graph.
	 * 
	 * Does nothing if the edge is already in the set of vertices.
	 * 
	 * @param vertex1
	 * @param vertex2
	 */
	void addEdge(T vertex1, T vertex2);

	/**
	 * @param vertex1
	 * @param vertex2
	 * @return true iff an edge between vertex1 and vertex2 belongs to the set
	 *         of edges in the graph
	 */
	boolean hasEdge(T vertex1, T vertex2);

	/**
	 * 
	 * @return a list of the vertices in the set of vertices in this graph
	 */
	List<T> listVertices();

	/**
	 * @param vertex
	 * @return a list of the vertices which are adjacent to vertex
	 */
	List<T> listNeighbors(T vertex);
}