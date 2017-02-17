package ch07.circular;

//----------------------------------------------------------------------
// CRefUnsortedList.java      by Dale/Joyce/Weems              Chapter 7
//
// Implements the ListInterface using references 
// (a circular linked list).
//
// Null elements are not permitted on a list.
//
// One constructor is provided, one that creates an empty list.
//----------------------------------------------------------------------

import support.LLNode;
import ch06.lists.*;

public class CRefUnsortedList<T> implements ListInterface<T>  
{

  protected int numElements;          // Number of elements on this list
  protected LLNode<T> currentPos;     // Current position for iteration

  // set by find method
  protected boolean found;         // true if element found, else false
  protected LLNode<T> location;    // node containing element, if found
  protected LLNode<T> previous;    // node preceding location

  protected LLNode<T> list;        // the last node on the list

  public CRefUnsortedList() 
  {
    numElements = 0;
    list = null;
    currentPos = null;
  }

  public void add(T element)
  // Adds element to this list.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    if (list == null)
    {
      // add element to an empty list
      list = newNode;
      newNode.setLink(list);
    }
    else
    {
      // add element to a non-empty list
      newNode.setLink(list.getLink());
      list.setLink(newNode);
      list = newNode;
    }
    numElements++;
  }

  protected void find(T target)
  // Searches list for an occurrence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If unsuccessful, sets 
  // found to false.
  {
    location = list;
    found = false;

    if (list != null)
      do
      {
        // move search to the next node
        previous = location;
        location = location.getLink();
      
        // check for a match
        if (location.getInfo().equals(target))
          found = true;
      }
      while ((location != list) && !found); 
  }

  public int size()
  // Returns the number of elements on this list. 
  {
    return numElements;
  }

  public boolean contains (T element)
  // Returns true if this list contains an element e such that 
  // e.equals(element), otherwise returns false.
  {
    find(element);
    return found;
  }

  public boolean remove (T element)
  // Removes an element e from this list such that e.equals(element)
  // and returns true; if no such element exists, returns false.
  {
    find(element);
    if (found)
    {
      if (list == list.getLink())      // if single-element list    
        list = null;              
      else
        if (previous.getLink() == list)  // if removing last node
          list = previous;        
        previous.setLink(location.getLink());  // remove node 
      numElements--;
    }
    return found;
  }

  public T get(T element)
  // Returns an element e from this list such that e.equals(element);
  // if no such element exists returns null.
  {
    find(element);    
    if (found)
      return location.getInfo();
    else
      return null;
  }
  
  public String toString()
  // Returns a nicely formatted string that represents this list.
  {
    String listString = "List:\n";
    if (list != null)
    {
      LLNode<T> prevNode = list;
      do
      {
        listString = listString + "  " + prevNode.getLink().getInfo() + "\n";
        prevNode = prevNode.getLink();
      }
      while (prevNode != list);
    } 
    return listString;
  }  

  public void reset()
  // Initializes current position for an iteration through this list,
  // to the first element on this list.
  {
    if (list != null)
      currentPos = list.getLink();
  }

  public T getNext()
  // Preconditions: the list is not empty
  //                the list has been reset
  //                the list has not been modified since most recent reset
  //
  // Returns the element at the current position on this list.
  // If the current position is the last element then it advances the value 
  // of the current position to the first element, otherwise it advances
  // the value of the current position to the next element.
  {
    T next = currentPos.getInfo();
    currentPos = currentPos.getLink();
    return next;
  }
}

