//----------------------------------------------------------------------------
// DLLNode.java              by Dale/Joyce/Weems                     Chapter 7
//
// Implements <T> nodes for a doubly linked list.
//----------------------------------------------------------------------------

package support;

public class DLLNode<T> extends LLNode<T> 
{
  private DLLNode<T> back;
  
  public DLLNode(T info)
  {
    super(info);
    back = null;
  }
 
  public void setBack(DLLNode<T> back)
  // Sets back link of this DLLNode.
  {
    this.back = back;
  }

  public DLLNode getBack()
  // Returns back link of this DLLNode.
  {
    return back;
  }
}
 
 