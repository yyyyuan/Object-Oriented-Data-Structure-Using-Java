//----------------------------------------------------------------------------
// SList.java                by Dale/Joyce/Weems                     Chapter 6
//
// Defines constructs for an unbounded array-based list of objects that do
// not depend on whether the list is sorted or indexed.
//
// Our intention is for this class to be extended by other classes that furnish
// the remaining methods needed to support a list, for example a method that
// allows objects to be added to the list.
//
// Null elements are not permitted on a list.
// The list is Serializable.
//
// Two constructors are provided: one that creates a list of a default
// original capacity, and one that allows the calling program to specify the 
// original capacity.
//---------------------------------------------------------------------------

package ch06.serLists;

import java.io.*;

public class SList implements Serializable
{
  protected final int DEFCAP = 100; // default capacity
  protected int origCap;            // original capacity
  protected Serializable[] list;    // array to hold this list’s elements
  protected int numElements = 0;    // number of elements in this list
  protected int currentPos;         // current position for iteration

  // set by find method
  protected boolean found;  // true if element found, otherwise false
  protected int location;   // indicates location of element if found

  public SList() 
  {
    list = new Serializable[DEFCAP];
    origCap = DEFCAP;
  }

  public SList(int origCap) 
  {
    list = new Serializable[origCap];
    this.origCap = origCap;
  }

  protected void enlarge()
  // Increments the capacity of the list by an amount 
  // equal to the original capacity.
  // Used by subclasses that provide an add method.
  {
    // create the larger array
    Serializable[] larger = new Serializable[list.length + origCap];
    
    // copy the contents from the smaller array into the larger array
    for (int i = 0; i < numElements; i++)
    {
      larger[i] = list[i];
    }
    
    // reassign list reference
    list = larger;
  }

  protected void find(Object target)
  // Searches list for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true and location to the array index of e. If
  // not successful, sets found to false.
  {
    boolean moreToSearch;
    location = 0;
    found = false;
    moreToSearch = (location < numElements);

    while (moreToSearch && !found) 
    {
      if (list[location].equals(target))  
        found = true;
      else
      {
        location++;
        moreToSearch = (location < numElements);
      }
    }
  }

  public int size()
  // Returns the number of elements on this list. 
  {
    return numElements;
  }

  public boolean contains (Object element)
  // Returns true if this list contains an element e such that 
  // e.equals(element), otherwise, returns false.
  {
    find(element);
	 return found;
  }

  public boolean remove (Object element)
  // Removes an element e from this list such that e.equals(element)
  // and returns true; if no such element exists, returns false.
  {
    find(element);    
    if (found)
    {
      for (int i = location; i <= numElements - 2; i++)
        list[i] = list[i+1];
      list[numElements - 1] = null;
      numElements--;  
    }
    return found;
  }

  public Object get(Object element)
  // Returns an element e from this list such that e.equals(element);
  // if no such element exists, returns null.
  {
    find(element);    
    if (found)
      return list[location];
    else
      return null;
  }
  
  public String toString()
  // Returns a nicely formatted string that represents this list.
  {
    String listString = "List:\n";
    for (int i = 0; i < numElements; i++)
      listString = listString + "  " + list[i] + "\n";
    return listString;
  }

  public void reset()
  // Initializes current position for an iteration through this list,
  // to the first element on this list.
  {
    currentPos  = 0;
  }

  public Object getNext()
  // Preconditions: The list is not empty
  //                The list has been reset
  //                The list has not been modified since the most recent reset
  //
  // Returns the element at the current position on this list.
  // If the current position is the last element, then it advances the value 
  // of the current position to the first element; otherwise, it advances
  // the value of the current position to the next element.
  {
    Object next = list[currentPos];
    if (currentPos == (numElements - 1))
      currentPos = 0;
    else
      currentPos++;
    return next;
  }
}