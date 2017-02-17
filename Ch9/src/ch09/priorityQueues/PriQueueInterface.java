//----------------------------------------------------------------------------
// PriQueueInterface.java          by Dale/Joyce/Weems               Chapter 9
//
// Interface for a class that implements a priority queue of Comparable objects.
//----------------------------------------------------------------------------

package ch09.priorityQueues;

public interface PriQueueInterface<T extends Comparable<T>>
{
  boolean isEmpty();
  // Returns true if this priority queue is empty; otherwise, returns false.

  boolean isFull();
  // Returns true if this priority queue is full; otherwise, returns false.

  void enqueue(T element); 
  // Precondition: element is Comparable
  //
  // Throws PriQOverflowException if this priority queue is full;
  // otherwise, adds element to this priority queue.

  T dequeue();
  // Throws PriQUnderflowException if this priority queue is empty;
  // otherwise, removes element with highest priority from this 
  // priority queue and returns it.
}
