package structures;

import comparators.IntegerComparator;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {

	public StudentArrayHeap<Integer, V> maxqueue;

	
	public MaxQueue() {
		maxqueue = new StudentArrayHeap<Integer, V> (new IntegerComparator());
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		// TODO Auto-generated method stub
		if (priority == null || value == null) {
			throw new NullPointerException("The input is empty!");
		}
		
		maxqueue.add(priority, value);
		
		
		return this;
	}

	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The queue is empty!");
		}
		
		V data;
		
		data = maxqueue.remove();
		
		return data;
	}

	@Override
	public V peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The queue is empty!");
		}
		V data;
		
		data = maxqueue.peek();
		
		return data;
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO Auto-generated method stub
		
		return maxqueue.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO Auto-generated method stub
		return maxqueue.comparator;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return maxqueue.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return maxqueue.isEmpty();
	}
}
