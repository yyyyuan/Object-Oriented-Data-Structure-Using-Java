package Exercise04;

public class DNode<T> {

	private DNode<T> next;
	private DNode<T> prev;
	private T info;
	
	public DNode(T info, DNode<T> next, DNode<T> back) {
		this.info = info;
		this.next = next;
		this.prev = back;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setNext(DNode<T> next) {
		this.next = next;
	}
  	
	public DNode<T> getNext() {
		return next;
	}
	
	public void setPrev(DNode<T> back) {
		this.prev = back;
	}
	
	public DNode<T> getPrev() {
		return prev;
	}
}
