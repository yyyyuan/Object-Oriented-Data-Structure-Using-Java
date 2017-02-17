//----------------------------------------------------------------------
// ArrayListStack.java        by Dale/Joyce/Weems              Chapter 3
//
// Implements UnboundedStackInterface using an ArrayList to 
// hold the stack elements.
//----------------------------------------------------------------------

package ch03.stacks;

import java.util.*;

public class ArrayListStack<T> implements UnboundedStackInterface<T>
{
  protected ArrayList<T> stack;     // ArrayList that holds stack elements

  public ArrayListStack() 
  {
    stack = new ArrayList<T>();      
  }

  public void push(T element)   
  // Places element at the top of this stack.
  {
    stack.add(element);
  }

  public void pop()               
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {
    if (!isEmpty())
    {
      stack.remove(stack.size() - 1);
    }
    else 
      throw new StackUnderflowException("Pop attempted on an empty stack.");
  }

  public T top()             
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element from this stack.
  {
    T topOfStack = null;
    if (!isEmpty())
      topOfStack = stack.get(stack.size() - 1);
    else 
      throw new StackUnderflowException("Top attempted on an empty stack.");    
    return topOfStack;
  }

  public boolean isEmpty()         
  // Returns true if this stack is empty, otherwise returns false.
  {
    if (stack.size() == 0)
      return true;
    else 
      return false;
  }
}