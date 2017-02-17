package evaluator;

import parser.IllegalPostfixExpressionException;

/**
 * A {@code PostfixEvaluator} evaluates postfix expressions.
 * @author jcollard
 *
 * @param <T> the type of result to be evaluated
 */
public interface PostfixEvaluator<T> {

	/**
	 * Evaluates the postfix expression and returns a value
	 * @param expr the expression to be evaluate
	 * @return the value of evaluating expr
	 * @throws IllegalPostfixExpressionException if the expression is not a valid postfix expression
	 */
	public T evaluate(String expr) throws IllegalPostfixExpressionException;
	
}
