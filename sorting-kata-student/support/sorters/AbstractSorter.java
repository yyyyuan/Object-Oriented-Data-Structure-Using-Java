package sorters;

import java.util.Comparator;

import structures.SwapList;

/**
 * An abstraction over the idea of a sorter. Concrete subclasses should sort the
 * list into ascending (smallest-first) order, using the provided Comparator.
 * 
 * @author liberato
 *
 * @param <T>
 */
public abstract class AbstractSorter<T> {
	/**
	 * the list to be sorted
	 */
	protected final SwapList<T> list;
	
	/**
	 * the comparator to be used
	 */
	protected final Comparator<T> comparator;

	/**
	 * Constructs a new sorter, using the given list and comparator.
	 * @param list the list to be sorted
	 * @param comparator the comparator to use when sorting
	 * @throw IllegalStateException if the list has already been manipulated by a sorter
	 */
	public AbstractSorter(SwapList<T> list, Comparator<T> comparator) {
		if ((list == null) || (comparator == null)) {
			throw new NullPointerException();
		}
		if (list.getComparisons() > 0 || list.getSwaps() > 0) {
			throw new IllegalStateException();
		}
		
		this.list = list;
		this.comparator = comparator;
	}

	/**
	 * Sorts the associated list in-place, and returns a reference to it. 
	 * 
	 * @return a reference to the sorted list.
	 */
	public abstract SwapList<T> sort();
}