package structures;

public class RecursiveList<T> implements ListInterface<T> {

	protected int numElements;      // number of elements in this list
	protected Node<T> currentPos;
	
	protected int index;
	
	  
	protected boolean found;        // true if element found, else false
	protected Node<T> location;   // node containing element, if found	  
	protected Node<T> previous;   // node preceeding location  
	protected Node<T> list;       // first node on the list
	
	public RecursiveList()
	  {
	    numElements = 0;
	    list = null;
	    location = null;
	  }
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> iterator = new Iterator<T> ();
		iterator.top = list;
		
		return iterator;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException("The element is empty!");
		}
		else {
			Node<T> newNode = new Node<T>(elem, null);
			newNode.setNext(list);
			list = newNode;
			numElements++;
			
			return this;
		}
	}

	private void insertLastHelper () {
		if (location == null) {

		}
		else {
			previous = location;
			location = location.getNext();
			
			insertLastHelper();
		}
	}
	
	@Override
	public ListInterface<T> insertLast(T elem) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException("The element is empty!");
		}
		else {
			Node<T> newNode = new Node<T> (elem, null);

			if (isEmpty()) {
				list = newNode;
				numElements++;
			}
			else {
				
				location = list;
				insertLastHelper();
				
				previous.setNext(newNode);
				numElements++;
			}

			return this;
		}
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		// TODO Auto-generated method stub
		location = list;
		
		if (elem == null) {
			throw new NullPointerException("The element is empty!");
		}
		else if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("The index is out of bound.");
		}
		else {

			Node<T> newNode = new Node<T> (elem, null);
			
			
				if (index == 0) {
					newNode.setNext(list);
					list = newNode;
					numElements++;
				}
				else {
					location = list;
					
					insertAtHelper(index, elem);
					
					newNode.setNext(location);
					previous.setNext(newNode);

					numElements++;
				}
			
			return this;
		}
	}

	private void insertAtHelper(int index, T elem) {
		if (index == 0) {
			
		}
		else {
			index--;
			previous = location;
			location = location.getNext();
			
			insertAtHelper(index, elem);
		}
	}
	
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The list is empty!");
		}
 		else {
			
			T data;
			data = list.getData();
			list = list.getNext();
			numElements--;
			
			return data;
			
		}

	}
	
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The list is empty!");
		}
		else { 
			if (size() == 1) {
			T data;
			data = list.getData();
			list = null;
			numElements--;
			
			return data;
			}
		else {
			T data;
			location = list;
			
			removeAtHelper(size()-1);
			
			data = location.getData();
			previous.setNext(null);
			
			numElements--;
			
			return data;
			}
		}

	}

	private void removeAtHelper(int i) {
		if (i == 0) {
		}
		else {
			previous = location;
			location = location.getNext();
			i--;
			
			removeAtHelper(i);
		}
	}
	
	@Override
	public T removeAt(int i) {
		// TODO Auto-generated method stub
		
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException("The input is out of bound!");
		}
		else if (isEmpty()) {
			throw new IllegalStateException("The list is empty!");
		}
		else {
			T data;

			if (i == 0) {
				data = list.getData();
				list = list.getNext();
				numElements--;
				
			}
			else {
				
				location = list;
				
				removeAtHelper(i);
				
				data = location.getData();
				previous.setNext(location.getNext());
				numElements--;
			}

				
			return data;
		}
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The list is empty!");
		}
		else {
			
			T data;
			
			data = list.getData();
			
			return data;
		}
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The list is empty!");
		}
		else {
			T data;
			location = list;
			
			insertLastHelper();
			
			data = previous.getData();
			
			return data;
		}

	}

	private void getHelper(int i) {
		if (i == 0) {
			
		}
		else {
			location = location.getNext();
			i--;
			
			getHelper(i);
		}
	}
	
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException("The input i is illegal");
		}
		else if (isEmpty()) {
			throw new IllegalStateException("The list is empty!");
		}
		else {
			
			location = list;
			T data;
			
			getHelper(i);
			
			data = location.getData();
			
			return data;
		}
	}
	
	private void recFind(T target) {
		if (location == null) {
			found = false;
		}
		else {
			
			if (location.getData().equals(target)) {
			found = true;
			}
			
			else {
			previous = location;
			location = location.getNext();
			
			recFind(target);
			}
		}
	}
	
	private void find(T target) {
		location = list;
		found = false;
		
		recFind(target);
		
	}

	@Override
	public boolean remove(T elem) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException("The element is empty!");
		}
		else {
				find(elem);
				
				if (found) {
					if (list == location) {
						list = list.getNext();
					}
					else {
						previous.setNext(location.getNext());
					}
					
					numElements--;
				
				}
		
		return found;

		}	
	}

	private void indexOfHelper(T element) {
		if (location == null) {
			index = -1;
		}
		else {
			if (location.getData() == element) {
			}
			else {
				location = location.getNext();
				index++;
				
				indexOfHelper(element);
			}
		}
	}
	
	@Override
	public int indexOf(T elem) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException("The element is empty!");
		}
		else {
			if (isEmpty()) {
				index = -1;
				return index;
			}
			else {
				
				location = list;
				index = 0;
				
				indexOfHelper(elem);
				
				return index;
			}
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (list == null);
	}
	
	public Node<T> getLocation() {
		return location;
	}

}
