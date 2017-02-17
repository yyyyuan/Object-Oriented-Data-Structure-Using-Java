package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBasedGraph<T extends Comparable<T>> implements SimpleGraph<T> {
	private T vertices[];
	private boolean edges[][];
	private int size;

	public ArrayBasedGraph(int maxVertices) {
		vertices = (T[]) new Comparable[maxVertices];
		edges = new boolean[maxVertices][maxVertices];
		size = 0;
	}

	@Override
	public void addVertex(T vertex) {
		vertices[size] = vertex;
		size += 1;
	}

	@Override
	public boolean hasVertex(T vertex) {
		boolean found = false;
		for (int i = 0; i < size; i += 1) {
			if (vertex.equals(vertices[i]))
				found = true;
			else
				found = false;
		}
		return found;
	}

	private int indexOf(T vertex) {
		for (int i = 0; i < size; i += 1) {
			if (vertex.equals(vertices[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void addEdge(T vertex1, T vertex2) {
		if (hasVertex(vertex1) && hasVertex(vertex2)) {
			edges[indexOf(vertex1)][indexOf(vertex2)] = true;
		}
	}

	@Override
	public boolean hasEdge(T vertex1, T vertex2) {
		return edges[indexOf(vertex1)][indexOf(vertex2)];
	}

	@Override
	public List<T> listVertices() {
		return Arrays.asList(vertices);
	}

	@Override
	public List<T> listNeighbors(T vertex) {
		ArrayList<T> neighbors = new ArrayList<T>();
		if (hasVertex(vertex)) {
			boolean[] isNeighborIndex = edges[indexOf(vertex)];
			for (int i = 0; i < size; i += 1) {
				if (isNeighborIndex[i]) {
					neighbors.add(vertices[i]);
				}
			}
		}
		return neighbors;
	}
}
