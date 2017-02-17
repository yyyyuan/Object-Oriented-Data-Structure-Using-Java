//-------------------------------------------------------------------------
// RefSortedList.java         by Dale/Joyce/Weems                 Chapter 6
//
// Implements the ListInterface using a linked list. It is kept in increasing
// order as defined by the compareTo method of the added elements. Only 
// Comparable elements may be added to a list.
//
// Null elements are not permitted on a list.
//
// One constructor is provided, one that creates an empty list.
//----------------------------------------------------------------------------

package ch06.lists;

import support.LLNode;

public class RefSortedList<T extends Comparable<T>> 
             extends RefUnsortedList<T> 
             implements ListInterface<T>
             
{
  public RefSortedList() 
  {
    super();
  }

  public void add(T element)
  // Adds element to this list.
  {
    LLNode<T> prevLoc;        // trailing reference
    LLNode<T> location;       // traveling reference
    T listElement;            // current list element being compared      

    // Set up search for insertion point.
    location = list;
    prevLoc = null;

    // Find insertion point.
    while (location != null)
    {
      listElement = location.getInfo();
      if (listElement.compareTo(element) < 0)  // list element < add element
      {
         prevLoc = location;
         location = location.getLink();
      }
      else
        break;
    }

    // Prepare node for insertion.
    LLNode<T> newNode = new LLNode<T>(element);

    // Insert node into list.
    if (prevLoc == null)         
    {
      // Insert as first node.
      newNode.setLink(list);
      list = newNode;
    }
    else
    {
      // Insert elsewhere.
      newNode.setLink(location);
      prevLoc.setLink(newNode);
    }
    numElements++;
  }
}
