package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	
	protected LLNode<T> top;
	
	public LinkedStack()
	  {
	    top = null;
	  }


	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
    // TODO
	T result;
		
	if (!isEmpty()) {
		result = top.getData();
		top = top.getNext();
		return result;
	}
	else
        throw new StackUnderflowException("Top attempted on an empty stack.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
    // TODO
	    if (!isEmpty())
	        return top.getData();
	      else
	        throw new StackUnderflowException("Top attempted on an empty stack.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
    // TODO
	    if (top == null) 
	        return true;
	      else
	        return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
    // TODO
		int count = 0;
		LLNode<T> chase = top;
		
		while (chase != null) {
			chase = chase.getNext();
			count++;
		}
		
		return count;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
    // TODO
	    LLNode<T> newNode = new LLNode<T> (elem);
	    newNode.setNext(top);
	    top = newNode;
	}

}
