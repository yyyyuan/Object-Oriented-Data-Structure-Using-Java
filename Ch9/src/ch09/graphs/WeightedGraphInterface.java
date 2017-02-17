//----------------------------------------------------------------------------
// WeightedGraphInterface.java       by Dale/Joyce/Weems             Chapter 9
//
// Interface for a class that implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------

package ch09.graphs;

import ch05.queues.*;

public interface WeightedGraphInterface<T>
{
  boolean isEmpty();
  // Returns true if this graph is empty; otherwise, returns false.

  boolean isFull();
  // Returns true if this graph is full; otherwise, returns false.
  
  void addVertex(T vertex);
  // Preconditions:   This graph is not full.
  //                  Vertex is not already in this graph.
  //                  Vertex is not null.
  //
  // Adds vertex to this graph.

  boolean hasVertex(T vertex);
  // Returns true if this graph contains vertex; otherwise, returns false.

  void addEdge(T fromVertex, T toVertex, int weight);
  // Adds an edge with the specified weight from fromVertex to toVertex.

  int weightIs(T fromVertex, T toVertex);
  // If edge from fromVertex to toVertex exists, returns the weight of edge;
  // otherwise, returns a special “null-edge” value.

  UnboundedQueueInterface<T> getToVertices(T vertex);
  // Returns a queue of the vertices that are adjacent from vertex.

  void clearMarks();
  // Sets marks for all vertices to false.

  void markVertex(T vertex);
  // Sets mark for vertex to true.

  boolean isMarked(T vertex);
  // Returns true if vertex is marked; otherwise, returns false.
  
  T getUnmarked();
  // Returns an unmarked vertex if any exist; otherwise, returns null.
  
}
