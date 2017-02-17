package Exercise04;

public class DLList<T> {

	protected DNode<T> head;
	protected DNode<T> tail;
	
	public DLList() {
		head = null;
		tail = null;
	}
	
	public void addAfter(T element, DNode<T> insertAfter) { 
		if (element == null) {
			throw new NullPointerException("The element is empty!");
		}
		else {
			
			DNode<T> insertBefore;
			
			if (insertAfter == null) { // add at start of list
				insertBefore = head; 
			}
			else {
				insertBefore = (DNode<T>) insertAfter.getNext();
			}
			
			DNode<T> newNode = new DNode<T>(element, insertBefore, insertAfter);
			if (newNode.getNext() == null) {
				tail = newNode; 
			} else {
				newNode.getNext().setPrev(newNode);
			}
			
			if (newNode.getPrev() == null) {
				head = newNode; 
			}
			else {
				newNode.getPrev().setNext(newNode);
			}
		}
	}
	
	
	//Question 2, due to the fact that this is a remove helper, I think it's simple
	public void removeNode(DNode<T> nodeToRemove) {
		
		nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
		nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
		
		
		//Make the removed node garbage
		nodeToRemove.setNext(null);
		nodeToRemove.setPrev(null);
		
	}
		
	
	//Question3
	public void moveInto(DLList<T> other, DNode<T> insertAfter) {
		
		while (other.head != null) {
			addAfter(other.head.getInfo(), insertAfter);
			other.head = other.head.getNext();
			insertAfter = insertAfter.getNext();
			
			//Make the node before garbage
			other.head.getPrev().setNext(null);
			other.head.setPrev(null);
		}
	}
	
}
