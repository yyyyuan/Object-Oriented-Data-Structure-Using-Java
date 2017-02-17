package structures;

public class Node<T> {
	/**
	 * The data to which this node refers.
	 */
	private T data;

	/**
	 * The link to the next node in the chain.
	 */
	private Node<T> next;

	/**
	 * Creates a {@code Node} with the specified data and next links.
	 */
	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Returns the data from this node.
	 *
	 * @return the data from this node.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns the next link from this node.
	 *
	 * @return the next node in the chain -- might be null
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Changes the data to which this node points
	 * 
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Changes the next node to which this node points
	 * 
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
