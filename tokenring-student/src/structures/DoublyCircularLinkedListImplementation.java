package structures;

public class DoublyCircularLinkedListImplementation<T extends Comparable<T>> implements
		DoublyCicularLinkedList<T> {
	
	protected int numElements;
	protected DLLNode<T> currentPos;
	
	//set by find method
	protected boolean found;
	protected DLLNode<T> location;
	
	protected DLLNode<T> list; //The first node in the list
	
	public DoublyCircularLinkedListImplementation() {
            // TODO
		numElements = 0;
		list = null;
		currentPos = null;
		
	}
	
	@Override
	public int size() {
            // TODO
            return numElements;
	}

	@Override
	public void add(T element) {
            // TODO
		DLLNode<T> newNode = new DLLNode<T> (element);

		if (list == null) {
			list = newNode;
			newNode.setForward(list);
			newNode.setBack(list);
			
			numElements++;
			
		}
		else {
			
			DLLNode<T> current;
			
			current = list;
			while (element.compareTo(current.getInfo()) < 0) {
					current = current.getForward();
				}
			
			newNode.setBack(current.getBack());
			newNode.setForward(current);
			current.getBack().setForward(newNode);
			current.setBack(newNode);
			
			numElements++;			
		}
			
	}

	protected void find(T target) {
		location = list;
		found = false;
		
		if (list != null) {
			do {
				if (location.getInfo().equals(target)) {
					found = true;
				}
				else {
					location = location.getForward();
				}
				
			} while ((location != list) && !found);
		}
	}
	
	@Override
	public boolean remove(T element) {
            // TODO
		find(element);
		
		if (found) {
			if (location == list) {
				list = list.getForward();
			}
			
			location.getBack().setForward(location.getForward());
			location.getForward().setBack(location.getBack());
			location.setForward(null);
			location.setBack(null);
			
			numElements--;
		}
		
        return found;
	}

	
	@Override
	public boolean contains(T element) {
            // TODO
		
		find(element);
		
        return found;
	}

	@Override
	public T get(T element) {
            // TODO
		find(element);
		
		if (found) {
            return location.getInfo();
		}
		else {
			return null;
		}
		
	}

	@Override
	public void reset() {
            // TODO
		currentPos = list;
	}

	@Override
	public T getNext() {
            // TODO
		if (currentPos == null) {
			return null;
		}
		else {
			T data;
			data = currentPos.getInfo();
			currentPos = currentPos.getForward();
			
	        return data;
		}

	}

	@Override
	public T getPrevious() {
            // TODO
		T data;
		data = currentPos.getBack().getInfo();
		currentPos = currentPos.getBack();
            return data;
	}

}
