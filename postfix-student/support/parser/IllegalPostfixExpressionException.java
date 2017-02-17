package parser;

/**
 * A {@link IllegalPostfixExpressionException} is thrown at when an invalid
 * PostfixExpression is encountered.
 * @author jcollard
 *
 */
public class IllegalPostfixExpressionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalPostfixExpressionException() {
		super();
	}

	public IllegalPostfixExpressionException(String message) {
		super(message);
	}
}
