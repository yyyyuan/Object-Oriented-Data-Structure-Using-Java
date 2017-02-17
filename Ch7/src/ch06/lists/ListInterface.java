//----------------------------------------------------------------------------
// ListInterface.java            by Dale/Joyce/Weems                 Chapter 6
//
// The lists are unbounded and allow duplicate elements, but do not allow 
// null elements. As a general precondition, null elements are not passed as 
// arguments to any of the methods.
//
// The list has a special property called the current position - the position 
// of the next element to be accessed by getNext during an iteration through 
// the list. Only reset and getNext affect the current position.
//----------------------------------------------------------------------------

package ch06.lists;

public interface ListInterface<T>
{
  int size();
  // Returns the number of elements on this list.

  void add(T element);
  // Adds element to this list.

  boolean remove (T element);
  // Removes an element e from this list such that e.equals(element)
  // and returns true; if no such element exists, returns false. 
  
  boolean contains (T element);
  // Returns true if this list contains an element e such that 
  // e.equals(element); otherwise, returns false.
    
  T get(T element);
  // Returns an element e from this list such that e.equals(element);
  // if no such element exists, returns null.
  
  String toString();
  // Returns a nicely formatted string that represents this list.
  
  void reset();
  // Initializes current position for an iteration through this list,
  // to the first element on this list.

  T getNext();
  // Preconditions: The list is not empty
  //                The list has been reset
  //                The list has not been modified since the most recent reset
  //
  // Returns the element at the current position on this list.
  // If the current position is the last element, then it advances the value 
  // of the current position to the first element; otherwise, it advances
  // the value of the current position to the next element.
}
