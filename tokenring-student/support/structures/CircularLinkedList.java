package structures;

import ch06.lists.ListInterface;

public interface CircularLinkedList<T> extends ListInterface<T> {
	/**
	 * Returns the element at the current position on this list.
	 * If the current position is the first element, then it advances the value 
     * of the current position to the last element; otherwise, it advances
     * the value of the current position to the previous element.
     * 
	 * @return the info of type T
	 */
	T getPrevious();
}
