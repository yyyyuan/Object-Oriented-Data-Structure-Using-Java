//---------------------------------------------------------------------------
// GlassQueue.java            by Dale/Joyce/Weems                   Chapter 5
//
// Extends ArrayUnbndQueue with operations to determine the size of the queue
// and to access the front and rear queue elements without removing them.
//---------------------------------------------------------------------------

package ch05.queues;

public class GlassQueue<T> extends ArrayUnbndQueue<T>
{

  public GlassQueue() 
  {
    super();
  }

  public GlassQueue(int origCap) 
  {
    super(origCap);
  }

  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }
  
  public T peekFront()
  // Returns the object at the front of this queue.
  // If the queue is empty, returns null.
  {
    return queue[front];
  }
  
  public T peekRear()
  // Returns the object at the rear of this queue.
  // If the queue is empty, returns null.
  {
    return queue[rear];
  }
}