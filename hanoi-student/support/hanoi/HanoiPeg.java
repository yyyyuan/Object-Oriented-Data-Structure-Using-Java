package hanoi;

/**
 * A {@link HanoiPeg} is an element in the Tower of Hanoi puzzle that holds
 * {@link HanoiRing}s on it.
 * 
 * @author jcollard
 * 
 */
public interface HanoiPeg {

	/**
	 * Adds the specified {@link HanoiRing} to the top of this {@link HanoiPeg}.
	 * 
	 * @param ring
	 *            the ring to put at the top of the {@link HanoiPeg}
	 * @throws IllegalHanoiMoveException
	 *             if the {@link HanoiRing} being added to the top is not
	 *             smaller than the topmost {@link HanoiRing} on this
	 *             {@link HanoiPeg}.
	 * @throws NullPointerException
	 *             if {@code ring} is {@code null}
	 */
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException;

	/**
	 * Removes the topmost {@link HanoiRing} from this {@link HanoiPeg} and
	 * returns it.
	 * 
	 * @return the {@link HanoiRing} that was removed.
	 * @throws IllegalHanoiMoveException
	 *             if this {@link HanoiPeg} does not contain any
	 *             {@link HanoiRing}s
	 */
	public HanoiRing remove() throws IllegalHanoiMoveException;

	/**
	 * Returns the topmost {@link HanoiRing} from this {@link HanoiPeg}
	 * 
	 * @return the topmost {@link HanoiRing} from this {@link HanoiPeg}
	 * @throws IllegalHanoiMoveException
	 *             if this {@link HanoiPeg} does not contain any
	 *             {@link HanoiRing}s
	 */
	public HanoiRing getTopRing() throws IllegalHanoiMoveException;

	/**
	 * Returns {@code true} if this {@link HanoiPeg} has one or more
	 * {@link HanoiRing}s on it and {@code false} otherwise.
	 * 
	 * @return {@code true} if this {@link HanoiPeg} has one or more
	 *         {@link HanoiRing}s on it and {@code false} otherwise.
	 */
	public boolean hasRings();
}
