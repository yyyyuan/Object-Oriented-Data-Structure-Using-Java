package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
        // TODO
		int index;
		int size = list.size();
		
		for (index = (size/2) - 1; index >= 0; index--) {
			reheapDown(index, size - 1);
		}
		
		for (index = size - 1; index >= 1; index--) {
			list.swap(0, index);
			reheapDown(0, index - 1);
		}
		
        return list;
	}
	
	private void reheapDown(int root, int endIndex) {
		int hole = root;
		int newhole;
		
		newhole = newHole(hole, endIndex);
		while (newhole != hole) {
			list.swap(hole, newhole);
			hole = newhole;
			newhole = newHole(hole, endIndex);
		}
		
	}
	
	
	private int newHole(int hole, int lastIndex) {
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		
		if (left > lastIndex) 
			return hole;
		else if (left == lastIndex) {
			if (list.compare(hole, left, comparator) < 0)
				return left;
			else
				return hole;
		}
		else if (list.compare(left, right, comparator) < 0) {
			if (list.compare(right, hole, comparator) <= 0)
				return hole;
			else
				return right;
		}
		else {
			if (list.compare(left, hole, comparator) <= 0)
				return hole;
			else 
				return left;
		}
	}

	  
	  
}
