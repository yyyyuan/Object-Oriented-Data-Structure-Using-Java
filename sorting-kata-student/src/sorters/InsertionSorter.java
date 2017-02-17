package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
                // TODO
		for (int count = 1; count < list.size(); count++) {
			insertElement(0, count);
		}
		
		return list;
	}
	
	private void insertElement(int startIndex, int endIndex) {
		boolean finished = false;
		int current = endIndex;
		boolean moreToSearch = true;
		
		while (moreToSearch && ! finished) {
			if (list.compare(current, current - 1, comparator) < 0) {
				list.swap(current, current - 1);
				current--;
				moreToSearch = (current != startIndex);
			}
			else {
				finished = true;
			}
		}
	}

}
