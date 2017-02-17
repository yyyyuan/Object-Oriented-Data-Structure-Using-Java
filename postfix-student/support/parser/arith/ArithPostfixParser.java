package parser.arith;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import language.Operand;
import language.Operator;
import language.arith.DivOperator;
import language.arith.MultOperator;
import language.arith.NegateOperator;
import language.arith.PlusOperator;
import language.arith.SubOperator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser;
import parser.Token;

/**
 * <p>
 * An {@code ArithPostfixParser} is a postfix parser for arithmetic
 * expressions.
 * </p>
 * <p>
 * You shouldn't worry about how this class is implemented but you should be
 * aware of its usage.
 * </p>
 * 
 * @author jcollard
 * 
 */
public class ArithPostfixParser implements PostfixParser<Integer> {

	private static interface OperatorConstructor {
		public Operator<Integer> construct();
	}

	private static final Map<String, OperatorConstructor> operators;

	private static boolean isParseable(String expr) {
		Scanner s = new Scanner(expr);
		while (s.hasNext()) {
			// If we find an integer, we are good.
			if (s.hasNextInt()) {
				s.nextInt();
				continue;
			}
			String token = s.next();
			// If we find a string that is not an operator
			// return false
			if (!operators.containsKey(token)) {
				s.close();
				return false;
			}
		}
		s.close();
		// If we make it to the end of the expression we are good
		return true;
	}

	static {
		operators = new HashMap<String, ArithPostfixParser.OperatorConstructor>();

		operators.put("+", new OperatorConstructor() {

			@Override
			public Operator<Integer> construct() {
				return new PlusOperator();
			}
		});

		operators.put("*", new OperatorConstructor() {

			@Override
			public Operator<Integer> construct() {
				return new MultOperator();
			}
		});

		operators.put("-", new OperatorConstructor() {

			@Override
			public Operator<Integer> construct() {
				return new SubOperator();
			}
		});

		operators.put("/", new OperatorConstructor() {

			@Override
			public Operator<Integer> construct() {
				return new DivOperator();
			}
		});

		operators.put("!", new OperatorConstructor() {

			@Override
			public Operator<Integer> construct() {
				return new NegateOperator();
			}
		});
	}

	private final String expr;

	/**
	 * Creates an {@link ArithPostfixParser} over {@code expr}.
	 * 
	 * @param expr
	 *            the arithmetic expression to parse
	 * @throws NullPointerException if expr is null
	 * @throws IllegalPostfixExpressionException if expr is not a valid arithmetic
	 *         expression.
	 */
	public ArithPostfixParser(String expr) throws IllegalPostfixExpressionException {
		if (expr == null)
			throw new NullPointerException("The expression must be non-null.");
		if (!isParseable(expr))
			throw new IllegalPostfixExpressionException("The string \"" + expr
					+ "\" is not a valid ArithPostfix expression.");
		this.expr = expr;
	}

	@Override
	public Iterator<Token<Integer>> iterator() {
		return new TokenIterator(expr);
	}

	private class TokenIterator implements Iterator<Token<Integer>> {
		String expr;
		Scanner scanner;
		
		public TokenIterator(String expr) {
			this.expr = expr;
			this.scanner = new Scanner(this.expr);
		}

		@Override
		public boolean hasNext() {
			return scanner.hasNext();
		}
		
		@Override
		public Token<Integer> next() {
			if (hasNext()) {
				// If the token is an int, generate an integer operand
				if (scanner.hasNextInt()) {
					int token = scanner.nextInt();
					Operand<Integer> nextOperand = new Operand<Integer>(token);
					return new Token<Integer>(Type.OPERAND, nextOperand);
				} else {
					// Otherwise return the associated operator
					String token = scanner.next();
					Operator<Integer>nextOperator = operators.get(token).construct();
					return new Token<Integer>(Type.OPERATOR, nextOperator);
				}
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
