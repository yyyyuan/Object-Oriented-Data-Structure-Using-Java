package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {

	public Node<T> front;
	public Node<T> rear;
	protected int size;
	
	public Queue() {		
            // TODO 1
		front = null;
		rear = null;
		size = 0;
    }
	
	public Queue(Queue<T> other) {
            // TODO 2
		front = null;
		rear = null;
		size = 0;
		
		Node<T> index = other.front;
		Node<T> newNode;
		
		while (index != null) {
			newNode = new Node<T> (index.getData());
			
			if (rear == null) {
				front = newNode;
			}
			else {
				rear.setNext(newNode);
			}
			rear = newNode;
			index = index.getNext();
			
			size++;
		}
	}
	
	@Override
	public boolean isEmpty() {
            // TODO 3
            return (front == null);
	}

	@Override
	public int size() {
            // TODO 4
            return size;
	}

	@Override
	public void enqueue(T element) {
            // TODO 5
		Node<T> newNode = new Node<T> (element);
		if (rear == null)
			front = newNode;
		else
			rear.setNext(newNode);
		    rear = newNode;
		    
		size++;
	}

	@Override
	public T dequeue() throws NoSuchElementException {
            // TODO 6
            if (isEmpty()) {
            	throw new NoSuchElementException("The queue is empty!");
            }
            else {
            	T element;
            	element = front.getData();
            	front = front.getNext();
            	if (front == null) {
            		rear = null;
            	}
            	size--;
                return element;
            }
	}

	@Override
	public T peek() throws NoSuchElementException {
            // TODO 7
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty!");
		}
		else {
			T element;
			element = front.getData();
			return element;
		}
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
            // TODO 8
		Queue<T> reverseQueue = new Queue<T> ();
		LinkedStack<T> stack = new LinkedStack<T> ();
		Node<T> index = this.front;
		
		while (index != null) {
			stack.push(index.getData());
			index = index.getNext();
		}
		
		while (!stack.isEmpty()) {
			reverseQueue.enqueue(stack.pop());
		}
            return reverseQueue;
	}
}
