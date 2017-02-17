//----------------------------------------------------------------------------
// BSTInterface.java            by Dale/Joyce/Weems                  Chapter 8
//
// Interface for a class that implements a binary search tree (BST).
//
// The trees are unbounded and allow duplicate elements, but do not allow null
// elements. As a general precondition, null elements are not passed as 
// arguments to any of the methods.
//
// The tree supports iteration through its elements in INORDER, PREORDER,
// and POSTORDER.
//----------------------------------------------------------------------------

package ch08.trees;

public interface BSTInterface<T extends Comparable<T>>
{
  // used to specify traversal order
  static final int INORDER = 1;
  static final int PREORDER = 2;
  static final int POSTORDER = 3;

  boolean isEmpty();
  // Returns true if this BST is empty; otherwise, returns false.
  
  int size();
  // Returns the number of elements in this BST.

  boolean contains (T element);
  // Returns true if this BST contains an element e such that 
  // e.compareTo(element) == 0; otherwise, returns false.
    
  boolean remove (T element);
  // Removes an element e from this BST such that e.compareTo(element) == 0
  // and returns true; if no such element exists, returns false. 
  
  T get(T element);
  // Returns an element e from this BST such that e.compareTo(element) == 0;
  // if no such element exists, returns null.

  void add (T element);
  // Adds element to this BST. The tree retains its BST property.
  
  int reset(int orderType);
  // Initializes current position for an iteration through this BST
  // in orderType order. Returns current number of nodes in the BST.

  T getNext (int orderType);
  // Preconditions: The BST is not empty
  //                The BST has been reset for orderType
  //                The BST has not been modified since the most recent reset
  //                The end of orderType iteration has not been reached
  //
  // Returns the element at the current position on this BST for orderType
  // and advances the value of the current position based on the orderType. 
}