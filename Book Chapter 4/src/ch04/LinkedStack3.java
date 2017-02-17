package ch04;

//----------------------------------------------------------------------
// LinkedStack3.java         by Dale/Joyce/Weems               Chapter 4
//
// Extends LinkedStack with a non-recursive printReversed method.
//----------------------------------------------------------------------

import ch03.stacks.*;
import support.LLNode;

public class LinkedStack3<T> extends LinkedStack<T> 
{
  public void printReversed()
  {
    UnboundedStackInterface<T> stack = new LinkedStack<T>();
    LLNode<T> listNode;
	 
    listNode = top;
 
    while (listNode != null)   // Put references onto the stack
    {
      stack.push(listNode.getInfo());
      listNode = listNode.getLink();
    }
 
    // Retrieve references in reverse order and print elements
    while (!stack.isEmpty())
    {
      System.out.println(" " + stack.top());
      stack.pop();
    }
  }
}
