package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	
	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	
	@Override
	public SwapList<T> sort() {
                // TODO

		int first = 0;
		int last = list.size() - 1;
		
		quickSort(first, last);
		
		return list;
	}
	
	private void quickSort(int first, int last) {
		if (first < last) {
			int splitPoint;
			
			splitPoint = split(first, last);
			// values[first] to values[splitPoint - 1] <= splitVal
			// values[splitPoint] = splitVal
			// values[splitPoint + 1] to values[last] > splitVal
			
			quickSort(first, splitPoint - 1);
			quickSort(splitPoint + 1, last);
		}
	}


	private int split(int first, int last) {
		int splitVal = (first + last) / 2;
		int saveF = last;
		int swapIndex = first;
		
		list.swap(splitVal, last);
		splitVal = last;
		last--;
		
		while (first <= last)
			if (list.compare(first, splitVal, comparator) > 0) {
				first++;
			}
			else {
				list.swap(first, swapIndex);
				first++;
				swapIndex++;
			}
			
		
		list.swap(saveF, swapIndex);
		return swapIndex;
	}
	
}
