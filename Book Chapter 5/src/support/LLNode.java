//----------------------------------------------------------------------------
// LLNode.java            by Dale/Joyce/Weems                  Chapter 3
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------

package support;

public class LLNode<T>
{
  private LLNode<T> link;
  private T info;
  
  public LLNode(T info)
  {
    this.info = info;
    link = null;
  }
 
  public void setInfo(T info)
  // Sets info of this LLNode.
  {
    this.info = info;
  }

  public T getInfo()
  // Returns info of this LLONode.
  {
    return info;
  }
 
  public void setLink(LLNode<T> link)
  // Sets link of this LLNode.
  {
    this.link = link;
  }

  public LLNode<T> getLink()
  // Returns link of this LLNode.
  {
    return link;
  }
}
 
 