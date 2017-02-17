//----------------------------------------------------------------------------
// BoundedQueueInterface.java        by Dale/Joyce/Weems             Chapter 5
//
// Interface for a class that implements a queue of T with a bound
// on the size of the queue. A queue is a "first in, first out" structure.
//----------------------------------------------------------------------------

package ch05.queues;

public interface BoundedQueueInterface<T> extends QueueInterface<T>

{
  void enqueue(T element) throws QueueOverflowException;
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.

  boolean isFull();
  // Returns true if this queue is full; otherwise, returns false.
}
