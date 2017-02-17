package parser;

import language.Operand;
import language.Operator;

/**
 * A {@link PostfixParser} is used to parse postfix expressions made up of operands and operators.
 * @author jcollard
 *
 * @param <T> - the type of data held in an operand
 */
public interface PostfixParser<T> extends Iterable<Token<T>> {

	/**
	 * A {@link PostfixParser} can produce different types.
	 * @author jcollard
	 *
	 */
	public static enum Type {
	
		/**
		 * Indicates that the value being parsed is an {@link Operand}
		 */
		OPERAND,
		
		/**
		 * Indicates that the value being parsed is an {@link Operator} 
		 */
		OPERATOR;
	}
}
