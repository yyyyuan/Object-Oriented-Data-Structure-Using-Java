package evaluator.arith;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.IllegalPostfixExpressionException;
import evaluator.PostfixEvaluator;

public class PublicArithPostfixEvaluatorTest {

	private PostfixEvaluator<Integer> evaluator;

	@Before
	public void setup(){
		evaluator = new ArithPostfixEvaluator();
	}

	@Test (timeout = 5000)
	public void testEvaluateSimple() throws Exception {
		Integer result = evaluator.evaluate("1");
		assertEquals(new Integer(1), result);
	}

	@Test (timeout = 5000)
	public void testEvaluatePlus() throws Exception {
		Integer result = evaluator.evaluate("1 2 +");
		assertEquals(new Integer(3), result);

		result = evaluator.evaluate("1 2 3 + +");
		assertEquals(new Integer(6), result);

		result = evaluator.evaluate("10000 1000 100 10 1 + + + +");
		assertEquals(new Integer(11111), result);
	}

	@Test (timeout = 5000)
	public void testEvaluateSub() throws Exception {
		Integer result = evaluator.evaluate("1 2 -");
		assertEquals(new Integer(-1), result);

		result = evaluator.evaluate("1 2 3 - -");
		assertEquals(new Integer(2), result);

		result = evaluator.evaluate("1000 100 10 1 - - -");
		assertEquals(new Integer(909), result);
	}

	@Test (timeout = 5000)
	public void testEvaluateMult() throws Exception {
		Integer result = evaluator.evaluate("1 2 *");
		assertEquals(new Integer(2), result);

		result = evaluator.evaluate("1 2 3 * *");
		assertEquals(new Integer(6), result);

		result = evaluator.evaluate("1 2 3 4 * * *");
		assertEquals(new Integer(24), result);
	}

	@Test (timeout = 5000)
	public void testEvaluateNegate() throws Exception {
		Integer result = evaluator.evaluate("1 !");
		assertEquals(new Integer(-1), result);

		result = evaluator.evaluate("2 !");
		assertEquals(new Integer(-2), result);

		result = evaluator.evaluate("-15 !");
		assertEquals(new Integer(15), result);
	}

	@Test (timeout = 5000, expected = IllegalPostfixExpressionException.class)
	public void testInvalidExpression() throws Exception {
		evaluator.evaluate("1 2");
	}


}
