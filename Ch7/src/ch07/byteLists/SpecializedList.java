//----------------------------------------------------------------------------
// SpecializedList.java          by Dale/Joyce/Weems                 Chapter 7
// 
// Implements the specialized list ADT using a doubly linked list of nodes
//----------------------------------------------------------------------------
 
package ch07.byteLists;
 
public class SpecializedList implements SpecializedListInterface
{
  protected class SListNode
  // List nodes for the specialized list implementation
  {
    protected byte info;        // The info in a list node
    protected SListNode next;   // A link to the next node on the list
    protected SListNode back;   // A link to the previous node on the list
  }
 
  protected SListNode listFirst;      // Reference to the first node on list
  protected SListNode listLast;       // Reference to the last node on the list
  protected int numElements;          // Number of elements in the list
  protected SListNode currentFPos;    // Current forward position for iteration
  protected SListNode currentBPos;    // Current backward position for iteration
 
  public SpecializedList()
  // Creates an empty list object
  {
    numElements = 0;
    listFirst = null;
    listLast = null;
    currentFPos = null;
    currentBPos = null;
  }

  public int size()
  // Determines the number of elements on this list
  {
    return numElements;
  }

  public void resetForward()
  // Initializes current forward position for an iteration through this list
  {
    currentFPos = listFirst;
  }
 
  public byte getNextElement ()
  // Returns the value of the next element in list in forward iteration
  {
    byte nextElementInfo = currentFPos.info;
    if (currentFPos == listLast)
      currentFPos = listFirst;
    else
      currentFPos = currentFPos.next;
 
    return nextElementInfo;
  }
 
  public void resetBackward()
  // Initializes current backward position for an iteration through this list
  {
    currentBPos = listLast;
  }
 
  public byte getPriorElement ()
  // Returns the value of the next element in list in backward iteration
  {
    byte nextElementInfo = currentBPos.info;
    if (currentBPos == listFirst)
      currentBPos = listLast;
    else
      currentBPos = currentBPos.back;
 
    return nextElementInfo;
  }

  public void addFront (byte element)
  // Adds the value of element to the beginning of this list
  {
    SListNode newNode = new SListNode();   // Reference to node being added
    newNode.info = element;
    newNode.next = listFirst;
    newNode.back = null;
    if (listFirst == null)            // Adding into an empty list
    {
      listFirst = newNode;
      listLast = newNode;
    }
    else                             // Adding into a non-empty list
    {
      listFirst.back = newNode;
      listFirst = newNode;
    }
    numElements++;
  }

  public void addEnd (byte element)
  // Adds the value of element to the end of this list
  {
    SListNode newNode = new SListNode();   // Reference to node being added
    newNode.info = element;
    newNode.next = null;
    newNode.back = listLast;
    if (listFirst == null)            // Adding into an empty list
    {
      listFirst = newNode;
      listLast = newNode;
    }
    else                             // Adding into a non-empty list
    {
      listLast.next = newNode;
      listLast = newNode;
    }
    numElements++;
  }
}