package structures;

import java.util.Comparator;

/**
 * A list which supports the minimal operations necessary for most in-place
 * comparison-based sorts, along with two observers.
 * 
 * Notably, it does not (directly) allow access to specific elements, though
 * we've included a toString() method in ArrayBasedList for fans of caveman
 * debugging.
 * 
 * @author liberato
 *
 * @param <T>
 */
public interface SwapList<T> {
	/**
	 * Return the result of comparator.compare() on the two elements of the list
	 * at the given indices.
	 * 
	 * @param index1
	 * @param index2
	 * @param comparator
	 * @return the result of comparator.compare() on the values at the indices
	 */
	public int compare(int index1, int index2, Comparator<T> comparator);

	/**
	 * Swaps the values contained in the indices of the list.
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2);

	/**
	 * 
	 * @return the number of elements in the list
	 */
	public int size();

	/**
	 * 
	 * @param comparator
	 * @return true iff the list is sorted according to the given comparator
	 */
	public boolean isSorted(Comparator<T> comparator);

	/**
	 * 
	 * @return the number of times swap() has been called on this list
	 */
	public int getSwaps();

	/**
	 * 
	 * @return the number of times compare() has been called on this list
	 */
	public int getComparisons();
}
