package hanoi;

/**
 * A {@link HanoiRing} is an element of the Tower of Hanoi puzzle. Rings can
 * only be placed on top of rings whose size is greater than their own.
 * 
 * @author jcollard
 *
 */
public class HanoiRing {

	private final int size;

	/**
	 * Creates a {@link HanoiRing} of the specified size.
	 * 
	 * @param size
	 */
	public HanoiRing(int size) {
		this.size = size;
	}

	/**
	 * Returns the size of this ring.
	 * 
	 * @return the size of this ring.
	 */
	public int getSize() {
		return size;
	}
}
