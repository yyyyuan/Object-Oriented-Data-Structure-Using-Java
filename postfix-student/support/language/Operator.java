package language;

/**
 * An {@link Operator} is capable of performing an operation on some number
 * of {@link Operand}s.
 * @author jcollard
 *
 * @param <T> the type of data stored in {@link Operand}s.
 */
public interface Operator<T> {

	/**
	 * Returns the number of {@link Operand}s that this {@link Operator}
	 * needs to perform its operation.
	 * @return the number of {@link Operand}s that this {@link Operator}
	 * needs to perform its operation. 
	 */
	public int getNumberOfArguments();
	
	/**
	 * Performs this operation on values supplied via the {@link Operator#setOperand(int, Operand)} method and returns
	 * the resulting {@link Operand}.
	 * @return the result of applying this {@link Operator} to its {@link Operand}s
	 * @throws IllegalStateException if the required {@link Operand}s were not set. 
	 */
	public Operand<T> performOperation();
	
	/**
	 * <p>Sets the specified {@link Operand}.</p>
	 * <p><b>Note</b>: {@link Operand}s positions are indexed by 0 so the first {@link Operand} should be set with 0, the
	 * second with 1, third with 2, etc...</p>
	 * @param i the position of the operand
	 * @param operand the {@link Operand} to set.
	 * @throws IllegalStateException if the position was previously set.
	 * @throws NullPointerException if the operand provided is null.
	 */
	public void setOperand(int position, Operand<T> operand);
	
}
