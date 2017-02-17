//----------------------------------------------------------------------------
// DLLNode.java              by Dale/Joyce/Weems                     Chapter 7
//
// Implements <T> nodes for a doubly linked list.
//----------------------------------------------------------------------------

package structures;

public class DLLNode<T> {
	private DLLNode<T> back;
	private DLLNode<T> forward;
	private T info;

	public DLLNode(T info) {
		this.info = info;
		this.back = null;
		this.forward = null;
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

	public void setBack(DLLNode<T> back)
	// Sets back link of this DLLNode.
	{
		this.back = back;
	}

	public DLLNode<T> getBack()
	// Returns back link of this DLLNode.
	{
		return back;
	}

	public void setForward(DLLNode<T> forward)
	// Sets forward link of this DLLNode;
	{
		this.forward = forward;
	}

	public DLLNode<T> getForward()
	// Returns forward link of this DLLNode.
	{
		return forward;
	}
}
