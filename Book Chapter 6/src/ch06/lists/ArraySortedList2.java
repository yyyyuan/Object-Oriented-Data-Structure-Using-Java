//----------------------------------------------------------------------------
// ArraySortedList2.java          by Dale/Joyce/Weems                Chapter 6
//
// Implements the ListInterface using an array. It is kept in increasing order
// as defined by the compareTo method of the added elements. Only Comparable 
// elements may be added to a list.
//
// Null elements are not permitted on a list.
//
// Two constructors are provided: one that creates a list of a default
// original capacity, and one that allows the calling program to specify the 
// original capacity.
//----------------------------------------------------------------------------

package ch06.lists;

public class ArraySortedList2<T> extends ArrayUnsortedList<T>
                                 implements ListInterface<T>  
{
  public ArraySortedList2() 
  {
    super();
  }

  public ArraySortedList2(int origCap) 
  {
    super(origCap);
  }

  protected void find(T target)
  // Searches list for an occurrence of an element e such that
  // target.equals(e). If successful, sets instance variables
  // found to true and location to the array index of e. If
  // not successful, sets found to false.
  {
    int first = 0;
    int last = numElements - 1;
    int compareResult;
    Comparable targetElement = (Comparable) target;
    
    found = false;

    while (first <= last) 
    {
      location = (first + last) / 2;
      compareResult = targetElement.compareTo(list[location]);
      if (compareResult == 0)
      {
        found = true;
        break;
      }
      else if (compareResult < 0)  
      // target element is less than element at location
        last = location - 1;
      else   // target element is greater than element at location
        first = location + 1;
    }
  }

  public void add(T element)
  // Precondition:  element is Comparable.
  //  
  // Adds element to this list.
  {
    T listElement;      
    int location = 0;
 
    if (numElements == list.length)
      enlarge();

    while (location < numElements)
    {
      listElement = (T)list[location];
      if (((Comparable)listElement).compareTo(element) < 0)  // list element < add element
        location++;
      else
        break;   // list element >= add element
    }
    
    for (int index = numElements; index > location; index--)
      list[index] = list[index - 1];

    list[location] = element;
    numElements++;
  }

  public boolean remove (T element)
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
}
