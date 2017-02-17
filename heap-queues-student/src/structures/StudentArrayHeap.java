package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) {
		// TODO Auto-generated method stub
		if (index < 0) {
			throw new IndexOutOfBoundsException("The index is less than 0!");
		}
		
		return (index * 2) + 1;
	}

	@Override
	protected int getRightChildOf(int index) {
		// TODO Auto-generated method stub
		if (index < 0) {
			throw new IndexOutOfBoundsException("The index is less than 0!");
		}
		
		return (index * 2) + 2;
	}

	@Override
	protected int getParentOf(int index) {
		// TODO Auto-generated method stub
		if (index < 1) {
			throw new IndexOutOfBoundsException("The parent doesn't exist!");
		}
		
		return (index - 1) / 2;
	}

	@Override
	protected void bubbleUp(int index) {
		// TODO Auto-generated method stub
		int hole = heap.size() - 1;
		while ((hole > 0) 
				&& 
			(comparator.compare(heap.get(hole).getPriority(), heap.get(getParentOf(hole)).getPriority()) > 0)) {
		      // move hole's parent down and then move hole up
			swap(hole, getParentOf(hole));
			hole = getParentOf(hole);
		}		
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO Auto-generated method stub
		int hole = index;
		int newhole;
		
		newhole = newHole(hole);
		while (newhole != hole) {
			swap(hole, newhole);
			hole = newhole;
			newhole = newHole(hole);
		}
		
	}
	
	private int newHole(int hole) {
		int left = getLeftChildOf(hole);
		int right = getRightChildOf(hole);
		int lastIndex = heap.size() - 1;
		
		if (left > lastIndex) 
		    // hole has no children
			return hole;
		else
		if (left == lastIndex) 
		      // hole has left child only
			if (comparator.compare(heap.get(hole).getPriority(), heap.get(left).getPriority()) < 0)
		        // element < left child
				return left;
			else
		        // element >= left child
				return hole;
		else
		    // hole has two children 
		    if (comparator.compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0)
		      // left child < right child
		      if (comparator.compare(heap.get(right).getPriority(), heap.get(hole).getPriority()) <= 0)
		        // right child <= element
		        return hole;
		      else
		        // element < right child
		        return right;
		    else
		    // left child >= right child
		    if (comparator.compare(heap.get(left).getPriority(), heap.get(hole).getPriority()) <= 0)
		      // left child <= element
		      return hole;
		    else
		      // element < left child
		      return left;
	}
	
}

