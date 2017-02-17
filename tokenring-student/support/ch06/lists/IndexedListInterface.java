//----------------------------------------------------------------------
// IndexedListInterface.java    by Dale/Joyce/Weems            Chapter 6
//
// Extends the ListInterface with methods specific to indexed lists.
//----------------------------------------------------------------------

package ch06.lists;

public interface IndexedListInterface<T> extends ListInterface<T>
{
  void add(int index, T element);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index > size().
  // Otherwise, adds element to this list at position index; all current 
  // elements at that position or higher have 1 added to their index.
  
  T set(int index, T element);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, replaces element on this list at position index and
  // returns the replaced element.
    
  T get(int index);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, returns the element on this list at position index.
  
  int indexOf(T element);
  // If this list contains an element e such that e.equals(element), 
  // then returns the index of the first such element.
  // Otherwise, returns -1.
  
  T remove(int index);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, removes element on this list at position index and
  // returns the removed element; all current elements at positions
  // higher than that position have 1 subtracted from their index.
}
