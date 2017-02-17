package hanoi;

import structures.LinkedStack;
import structures.StackInterface;
import structures.Node;

/**
 * A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a
 * {@link LinkedStack}
 * 
 * @author jcollard
 *
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	protected Node<HanoiRing> top;
	protected int size;
	
	public StackBasedHanoiPeg() {
		top = null;
		size = 0;
	}
	
	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if (size == 0) {
			Node<HanoiRing> newNode = new Node<HanoiRing> (ring, null);
			newNode.setNext(top);
			top = newNode;
			this.size++;
		}
		else {
			if (ring.getSize() >= this.getTopRing().getSize()) {
				throw new IllegalHanoiMoveException("The added ring is larger than the top");
			}
			else {
				if (ring == null)
					throw new NullPointerException("the added ring is empty");
				else {
					Node<HanoiRing> newNode = new Node<HanoiRing> (ring, null);
					newNode.setNext(top);
					top = newNode;
					this.size++;
				}
			}
		}
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if (this.top == null) {
			throw new IllegalHanoiMoveException("There doesn't exist any element");
		}
		else {
			Node<HanoiRing> oldTop = top;
			top = top.getNext();
			this.size--;
			
			return oldTop.getData();
		}
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if (top == null) {
			throw new IllegalHanoiMoveException("There doesn't exist any element");
		}
		else {
			return top.getData();
		}
	}
	
	public int size() {
		return size;
	}

	@Override
	public boolean hasRings() {
        return top != null;
	}
}
