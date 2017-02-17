//----------------------------------------------------------------------------
// UnboundedQueueInterface.java       by Dale/Joyce/Weems            Chapter 5
//
// Interface for a class that implements a queue of T with no bound
// on the size of the queue. A queue is a "first in, first out" structure.
//----------------------------------------------------------------------------

package ch05.queues;

public interface UnboundedQueueInterface<T> extends QueueInterface<T>

{
  void enqueue(T element);
  // Adds element to the rear of this queue.
}
