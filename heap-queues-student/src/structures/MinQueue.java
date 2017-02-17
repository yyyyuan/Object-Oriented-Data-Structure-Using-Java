package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {

	public StudentArrayHeap<Integer, V> minqueue;
	
	public MinQueue() {
		minqueue = new StudentArrayHeap<Integer, V>(new ReverseIntegerComparator());
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		// TODO Auto-generated method stub
		if (priority == null || value == null) {
			throw new NullPointerException("The input is empty!");
		}
		
		minqueue.add(priority, value);
		
		
		return this;
	}

	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The queue is empty!");
		}
		
		V data;
		
		data = minqueue.remove();
		
		return data;
	}

	@Override
	public V peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("The queue is empty!");
		}
		V data;
		
		data = minqueue.peek();
		
		return data;
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO Auto-generated method stub
		return minqueue.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO Auto-generated method stub
		return minqueue.comparator;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return minqueue.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return minqueue.isEmpty();
	}
}

