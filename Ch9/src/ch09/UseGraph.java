package ch09;

//----------------------------------------------------------------------------
// UseGraph.java             by Dale/Joyce/Weems                     Chapter 9
//
// Examples of uses of the Graph ADT.
//----------------------------------------------------------------------------

import ch05.queues.*;
import ch03.stacks.*;
import ch09.priorityQueues.*;
import ch09.graphs.*;
import support.Flight;

public class UseGraph
{
private static void shortestPaths(WeightedGraphInterface<String> graph,
                                  String startVertex  )

// Writes the shortest distance from startVertex to every 
// other reachable vertex in graph.
{
  Flight flight;
  Flight saveFlight;         // for saving on priority queue
  int minDistance;
  int newDistance;

  PriQueueInterface<Flight> pq = new Heap<Flight>(20);   // Assume at most 20 vertices
  String vertex;
  UnboundedQueueInterface<String> vertexQueue = new LinkedUnbndQueue<String>();
  
  graph.clearMarks();
  saveFlight = new Flight(startVertex, startVertex, 0);
  pq.enqueue(saveFlight);

  System.out.println("Last Vertex   Destination   Distance");
  System.out.println("------------------------------------");
 
  do
  {
    flight = pq.dequeue();
    if (!graph.isMarked(flight.getToVertex()))
    {
      graph.markVertex(flight.getToVertex());
      System.out.println(flight);
      flight.setFromVertex(flight.getToVertex());
      minDistance = flight.getDistance();
      vertexQueue = graph.getToVertices(flight.getFromVertex());
      while (!vertexQueue.isEmpty())
      {
        vertex = vertexQueue.dequeue();
        if (!graph.isMarked(vertex))
        {
          newDistance = minDistance 
                        + graph.weightIs(flight.getFromVertex(), vertex);
          saveFlight = new Flight(flight.getFromVertex(), vertex, newDistance);
          pq.enqueue(saveFlight);
        }
      }
    }
  } while (!pq.isEmpty());
  System.out.println();
  System.out.println("The unreachable vertices are:");
  vertex = graph.getUnmarked();
  while (vertex != null)
  {
    System.out.println(vertex);
    graph.markVertex(vertex);
    vertex = graph.getUnmarked();
  }
  System.out.println();
}

private static boolean isPath(WeightedGraphInterface<String> graph,
                              String startVertex, 
                              String endVertex    )

// Returns true if a path exists on graph, from startVertex to endVertex; 
// otherwise returns false. Uses depth-first search algorithm.

{
  UnboundedStackInterface<String> stack = new LinkedStack<String>();
  UnboundedQueueInterface<String> vertexQueue = new LinkedUnbndQueue<String>();
 
  boolean found = false;
  String vertex;
  String item;
 
  graph.clearMarks();
  stack.push(startVertex);
  do
  {
    vertex = stack.top();
    stack.pop();
    if (vertex == endVertex)
       found = true;
    else
    {
      if (!graph.isMarked(vertex))
      {
        graph.markVertex(vertex);
        vertexQueue = graph.getToVertices(vertex);
 
        while (!vertexQueue.isEmpty())
        {
          item = vertexQueue.dequeue();
          if (!graph.isMarked(item))
            stack.push(item);
        }
      }
    }
  } while (!stack.isEmpty() && !found);
  
  return found;
}

private static boolean isPath2(WeightedGraphInterface<String> graph,
                               String startVertex, 
                               String endVertex    )

// Returns true if a path exists on graph, from startVertex to endVertex; 
// otherwise returns false. Uses breadth-first search algorithm.

{
  UnboundedQueueInterface<String> queue = new LinkedUnbndQueue<String>();
  UnboundedQueueInterface<String> vertexQueue = new LinkedUnbndQueue<String>();
 
  boolean found = false;
  String vertex;
  String item;

  graph.clearMarks();
  queue.enqueue(startVertex);
  do
  {
    vertex = queue.dequeue();
    if (vertex == endVertex)
       found = true;
    else
    {
      if (!graph.isMarked(vertex))
      {
        graph.markVertex(vertex);
        vertexQueue = graph.getToVertices(vertex);
 
        while (!vertexQueue.isEmpty())
        {
          item = vertexQueue.dequeue();
          if (!graph.isMarked(item))
            queue.enqueue(item);
        }
      }
    }
  } while (!queue.isEmpty() && !found);
  
  return found;
}


  public static void main(String[] args) 
  {
    WeightedGraphInterface<String> graph = new WeightedGraph<String>();
    String s0 = new String("Atlanta   ");
    String s1 = new String("Austin    ");
    String s2 = new String("Chicago   ");
    String s3 = new String("Dallas    ");
    String s4 = new String("Denver    ");
    String s5 = new String("Houston   ");
    String s6 = new String("Washington");

    graph.addVertex(s0);
    graph.addVertex(s1);
    graph.addVertex(s2);
    graph.addVertex(s3);
    graph.addVertex(s4);
    graph.addVertex(s5);
    graph.addVertex(s6);

    graph.addEdge(s0, s5, 800);
    graph.addEdge(s0, s6, 600);
    graph.addEdge(s1, s3, 200);
    graph.addEdge(s1, s5, 160);
    graph.addEdge(s2, s4, 1000);
    graph.addEdge(s3, s1, 200);
    graph.addEdge(s3, s2, 900);
    graph.addEdge(s3, s4, 780);
    graph.addEdge(s4, s0, 1400);
    graph.addEdge(s4, s2, 1000);
    graph.addEdge(s5, s0, 800);
    graph.addEdge(s6, s0, 600);
    graph.addEdge(s6, s3, 1300);

    boolean result;

    System.out.println("depth first ...");
    result = isPath(graph, s1, s2);
    System.out.println("s1 s2 " + result);
    result = isPath(graph, s1, s6);
    System.out.println("s1 s6 " + result);
    result = isPath(graph, s6, s5);
    System.out.println("s6 s5 " + result);
    result = isPath(graph, s6, s3);
    System.out.println("s6 s3 " + result);
    result = isPath(graph, s6, s1);
    System.out.println("s6 s1 " + result);
    
    System.out.println();
    System.out.println("breadth first ...");
    result = isPath2(graph, s1, s2);
    System.out.println("s1 s2 " + result);
    result = isPath2(graph, s1, s6);
    System.out.println("s1 s6 " + result);
    result = isPath2(graph, s6, s5);
    System.out.println("s6 s5 " + result);
    result = isPath2(graph, s6, s3);
    System.out.println("s6 s3 " + result);
    result = isPath2(graph, s6, s1);
    System.out.println("s6 s1 " + result);
    System.out.println();
    shortestPaths(graph, s6);
	 
    System.out.println();
    System.out.println();
    shortestPaths(graph, s4);


    System.out.println();
    System.out.println();
	 
    System.out.println("a new graph without Wash - Dallas leg");
    System.out.println();

    graph = new WeightedGraph<String>();
    s0 = new String("Atlanta   ");
    s1 = new String("Austin    ");
    s2 = new String("Chicago   ");
    s3 = new String("Dallas    ");
    s4 = new String("Denver    ");
    s5 = new String("Houston   ");
    s6 = new String("Washington");

    graph.addVertex(s0);
    graph.addVertex(s1);
    graph.addVertex(s2);
    graph.addVertex(s3);
    graph.addVertex(s4);
    graph.addVertex(s5);
    graph.addVertex(s6);

    graph.addEdge(s0, s5, 800);
    graph.addEdge(s0, s6, 600);
    graph.addEdge(s1, s3, 200);
    graph.addEdge(s1, s5, 160);
    graph.addEdge(s2, s4, 1000);
    graph.addEdge(s3, s1, 200);
    graph.addEdge(s3, s2, 900);
    graph.addEdge(s3, s4, 780);
    graph.addEdge(s4, s0, 1400);
    graph.addEdge(s4, s2, 1000);
    graph.addEdge(s5, s0, 800);
    graph.addEdge(s6, s0, 600);
//    graph.addEdge(s6, s3, 1300);

    System.out.println("depth first ...");
    result = isPath(graph, s1, s2);
    System.out.println("s1 s2 " + result);
    result = isPath(graph, s1, s6);
    System.out.println("s1 s6 " + result);
    result = isPath(graph, s6, s5);
    System.out.println("s6 s5 " + result);
    result = isPath(graph, s6, s3);
    System.out.println("s6 s3 " + result);
    result = isPath(graph, s6, s1);
    System.out.println("s6 s1 " + result);
    
    System.out.println();
    System.out.println("breadth first ...");
    result = isPath2(graph, s1, s2);
    System.out.println("s1 s2 " + result);
    result = isPath2(graph, s1, s6);
    System.out.println("s1 s6 " + result);
    result = isPath2(graph, s6, s5);
    System.out.println("s6 s5 " + result);
    result = isPath2(graph, s6, s3);
    System.out.println("s6 s3 " + result);
    result = isPath2(graph, s6, s1);
    System.out.println("s6 s1 " + result);
    System.out.println();
    shortestPaths(graph, s6);
	 
    System.out.println();
    System.out.println();
    shortestPaths(graph, s4);


  } 
} 