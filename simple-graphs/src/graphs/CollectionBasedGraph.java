package graphs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionBasedGraph<T extends Comparable<T>> implements
		SimpleGraph<T> {
	private Set<T> vertices;
	private Map<T, Set<T>> adjacencyMap;

	public CollectionBasedGraph() {
		vertices = new TreeSet<T>();
		adjacencyMap = new Hashtable<T, Set<T>>();
	}

	@Override
	public void addVertex(T vertex) {
		vertices.add(vertex);
		if (!adjacencyMap.containsKey(vertex)) {
			adjacencyMap.put(vertex, new TreeSet<T>());
		}
	}

	@Override
	public boolean hasVertex(T vertex) {
		return vertices.contains(vertex);
	}

	@Override
	public void addEdge(T vertex1, T vertex2) {
		Set<T> adjacencySet = adjacencyMap.get(vertex1);
		adjacencySet.add(vertex2);
	}

	@Override
	public boolean hasEdge(T vertex1, T vertex2) {
		Set<T> adjacencySet = adjacencyMap.get(vertex1);
		return adjacencySet.contains(vertex2);
	}

	@Override
	public List<T> listVertices() {
		return new ArrayList<T>(vertices);
	}

	@Override
	public List<T> listNeighbors(T vertex) {
		Set<T> adjacencySet = adjacencyMap.get(vertex);
		return new ArrayList<T>(vertices);
	}

}
