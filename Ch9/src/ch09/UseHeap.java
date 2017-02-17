package ch09;

//----------------------------------------------------------------------------
// UseHeap.java              by Dale/Joyce/Weems                     Chapter 9
//
// Example of a simple use of the Heap.
//----------------------------------------------------------------------------

import ch09.priorityQueues.*;

public class UseHeap
{
  public static void main(String[] args)
  { 
    PriQueueInterface<String> h = new Heap<String>(10);
    h.enqueue("J");
    h.enqueue("A");
    h.enqueue("M");
    h.enqueue("B");
    h.enqueue("L");
    h.enqueue("E");
    
    System.out.println(h);
    
    System.out.println(h.dequeue() + "\n");
    
    System.out.println(h);
  }
}