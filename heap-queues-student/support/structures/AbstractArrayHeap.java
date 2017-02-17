package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * An {@link AbstractArrayHeap} is an implementation of a heap that represents
 * the tree using an array. By doing this, we can easily maintain the complete
 * tree property required by a Heap.
 * 
 * @author jcollard
 * 
 * @param <P> - the type of the priority values
 * @param <V> - the type of the associated values
 * @see http://en.wikipedia.org/wiki/Heap_(data_structure)
 */
public abstract class AbstractArrayHeap<P, V> {

  /**
   * The array representation of our heap
   */
  protected final ArrayList<Entry<P, V>> heap;

  /**
   * The {@link Comparator} which determines priorities in this
   * {@link AbstractArrayHeap}.
   */
  protected final Comparator<P> comparator;

  /**
   * Creates an {@link AbstractArrayHeap} with the specified
   * {@link Comparator} for determining priority
   * 
   * @param comparator
   *            the {@link Comparator} to use to determine priority
   * @throws NullPointerException
   *             if {@code comparator} is {@code null}
   */
  protected AbstractArrayHeap(Comparator<P> comparator) {
    if (comparator == null) {
      throw new NullPointerException();
    }
    this.comparator = comparator;
    heap = new ArrayList<Entry<P, V>>();
  }

  /**
   * Adds the specified {@code value} to this {@link AbstractArrayHeap} with
   * the specified {@code priority}. For convenience, returns the modified
   * {@link AbstractArrayHeap}.
   * 
   * @param priority
   *            the priority for this entry
   * @param value
   *            the value for this entry
   * @return The modified {@link AbstractArrayHeap}
   * @throws NullPointerException
   *             if {@code priority} or {@code value} are {@code null}.
   */
  public final AbstractArrayHeap<P, V> add(P priority, V value) {
    if (priority == null || value == null) {
      throw new NullPointerException("priority and value must be non-null.");
    }
    Entry<P, V> entry = new Entry<P, V>(priority, value);
    heap.add(entry);
    bubbleUp(heap.size() - 1);
    return this;
  }

  /**
   * Returns the value that has the highest priority as determined by
   * {@link AbstractArrayHeap#getComparator()}.
   * 
   * @return the value that has the highest priority
   * @throws NoSuchElementException
   *             if this {@link AbstractArrayHeap} is empty
   */
  public final V peek() {
    if (heap.isEmpty()) {
      throw new NoSuchElementException("Cannot peek at an empty ArrayHeap.");
    }
    return heap.get(0).getValue();
  }

  /**
   * Removes the value that has the highest priority as determined by
   * {@link AbstractArrayHeap#getComparator()} from this
   * {@link AbstractArrayHeap}. For convenience, this method returns the
   * removed value.
   * 
   * @return the removed value
   */
  public final V remove() {
    if (heap.isEmpty()) {
      throw new IllegalStateException("Cannot remove from an empty ArrayHeap.");
    }
    swap(0, heap.size() - 1);
    V val = heap.remove(heap.size() - 1).getValue();

    if (!heap.isEmpty()) {
      bubbleDown(0);
    }
      
    return val;
  }

  /**
   * Returns the number of elements in this {@link AbstractArrayHeap}.
   * 
   * @return the number of elements in this {@link AbstractArrayHeap}.
   */
  public final int size() {
    return heap.size();
  }

  /**
   * Returns {@code true} if this {@link AbstractArrayHeap} has no elements in
   * it and {@code false} otherwise.
   * 
   * @return {@code true} if this {@link AbstractArrayHeap} has no elements in
   *         it and {@code false} otherwise.
   */
  public final boolean isEmpty() {
    return heap.isEmpty();
  }

  /**
   * Returns an immutable view of the underlying array structure of this
   * {@link AbstractArrayHeap}.
   * 
   * @return an immutable view of the underlying array structure of this
   *         {@link AbstractArrayHeap}.
   */
  public final List<Entry<P, V>> asList() {
    return Collections.unmodifiableList(heap);
  }

  /**
   * Returns the {@link Comparator} that is used to determine priority in this
   * {@link AbstractArrayHeap}.
   * 
   * @return the {@link Comparator} that is used to determine priority in this
   *         {@link AbstractArrayHeap}.
   */
  public final Comparator<P> getComparator() {
    return this.comparator;
  }

  /**
   * Given two indices, swaps the values of those two indices.
   * 
   * @param ix0
   *            the first index
   * @param ix1
   *            the second index
   * @throws IndexOutOfBoundsException
   *             if either index is less than 0 or greater than or equal to
   *             the size of this {@link AbstractArrayHeap}
   */
  protected final void swap(int ix0, int ix1) {
    if (ix0 < 0 || ix0 >= heap.size() || ix1 < 0 || ix1 >= heap.size())
      throw new IndexOutOfBoundsException();
    Entry<P, V> e0 = heap.get(ix0);
    Entry<P, V> e1 = heap.get(ix1);
    heap.set(ix0, e1);
    heap.set(ix1, e0);
  }

  /**
   * Given an index of some "node" returns the index to that "nodes" left
   * child.
   * 
   * @param index
   *            an index in this {@link AbstractArrayHeap}
   * @return the index of the specified "nodes" left child
   * @throws IndexOutOfBoundsException
   *             if {@code index} is less than 0
   */
  protected abstract int getLeftChildOf(int index);

  /**
   * Given an index of some "node" returns the index to that "nodes" right
   * child.
   * 
   * @param index
   *            a "nodes" index
   * @return the index of the specified "nodes" right child
   * @throws IndexOutOfBoundsException
   *             if {@code index} is less than 0
   */
  protected abstract int getRightChildOf(int index);

  /**
   * Given an index of some "node" returns the index to that "nodes" parent.
   * 
   * @param index
   *            a "nodes" index
   * @return the index of the specified "nodes" parent
   * @throws IndexOutOfBoundsException
   *             if {@code index} is less than 1
   */
  protected abstract int getParentOf(int index);

  /**
   * <p>
   * This results in the entry at the specified index "bubbling up" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time.
   * </p>
   * <p>
   * Note: When add is called, an Entry is placed at the end of the internal
   * array and then this method is called on that index.
   * </p>
   * 
   * @param index
   *            the index to bubble up
   */
  protected abstract void bubbleUp(int index);

  /**
   * <p>
   * This method results in the entry at the specified index "bubbling down"
   * to a location such that the property of the heap are maintained. This
   * method should run in O(log(size)) time.
   * </p>
   * <p>
   * Note: When remove is called, if there are elements remaining in this
   * {@link AbstractArrayHeap} the bottom most element of the heap is placed
   * at the 0th index and bubbleDown(0) is called.
   * </p>
   * 
   * @param index
   */
  protected abstract void bubbleDown(int index);
}
