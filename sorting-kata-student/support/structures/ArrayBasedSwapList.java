package structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ArrayBasedSwapList<T> implements SwapList<T> {
	private final ArrayList<T> arrayList;
	private int swaps = 0;
	private int comparisons = 0;

	public ArrayBasedSwapList(T[] array) {
		arrayList = new ArrayList<T>(Arrays.asList(array));
	}

	public ArrayBasedSwapList(Collection<T> coll) {
		arrayList = new ArrayList<T>(coll);
	}

	@Override
	public int compare(int index1, int index2, Comparator<T> comparator) {
		comparisons++;
		return comparator.compare(arrayList.get(index1), arrayList.get(index2));
	}

	@Override
	public void swap(int index1, int index2) {
		swaps++;
		T temp = arrayList.get(index1);
		arrayList.set(index1, arrayList.get(index2));
		arrayList.set(index2, temp);
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	@Override
	public boolean isSorted(Comparator<T> comparator) {
		for (int i = 0; i < arrayList.size() - 1; i++) {
			if (comparator.compare(arrayList.get(i), arrayList.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	public int getSwaps() {
		return swaps;
	}

	public int getComparisons() {
		return comparisons;
	}
	
	@Override
	public String toString() {
		return arrayList.toString();
	}
}
