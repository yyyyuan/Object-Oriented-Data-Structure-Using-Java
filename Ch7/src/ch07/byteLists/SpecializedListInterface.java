//----------------------------------------------------------------------------
// SpecializedListInterface.java     by Dale/Joyce/Weems             Chapter 7
// 
// Interface for a class that implements a list of bytes.
// There can be duplicate elements on the list.
// The list has two special properties called the current forward position
// and the current backward position -- the positions of the next element
// to be accessed by getNextElement and by getPriorElement during an iteration
// through the list. Only resetForward and getNextElement affect the current
// forward position. Only resetBackward and getPriorElement affect the current
// backward position. 
//----------------------------------------------------------------------------
 
package ch07.byteLists;
 
public interface SpecializedListInterface
{
  void resetForward();
  // Initializes current forward position for this list to the first
  // byte on the list.

  byte getNextElement ();
  // Preconditions: The list is not empty
  //                The list has been resetForward
  //                The list has not been modified since the most recent reset
  //
  // Returns the value of the byte at the current forward position on 
  // this list. If the current forward position is the last element, then 
  // it advances the value of the current forward position to the first element; 
  // otherwise, it advances the value of the current forward position to the 
  // next element.

  void resetBackward();
  // Initializes current backward position for this list to the last
  // byte on the list.
 
  byte getPriorElement ();
  // Preconditions: The list is not empty
  //                The list has been resetBackward
  //                The list has not been modified since the most recent reset
  //
  // Returns the value of the byte at the current backward position on 
  // this list. If the current backward position is the first element, then 
  // it advances the value of the current backward position to the last element; 
  // otherwise, it advances the value of the current backward position to the 
  // previous element.
  
  int size();
  // Returns the number of elements on this list.

  void addFront (byte element);
  // Adds the value of element to the front of this list.

  void addEnd (byte element);
  // Adds the value of element to the end of this list.
}
