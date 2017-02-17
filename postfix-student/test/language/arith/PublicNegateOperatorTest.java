package language.arith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import language.Operand;
import language.Operator;

import org.junit.Before;
import org.junit.Test;

public class PublicNegateOperatorTest {
	Operator<Integer> operator;
	Operand<Integer> op0;
	Operand<Integer> op1;

	@Before
	public void setup(){
		operator = new NegateOperator();
		op0 = new Operand<Integer>(5);
		op1 = new Operand<Integer>(7);
	}

	@Test (timeout = 500)
	public void testGetNumberOfArguments() {
		assertEquals("Unary operator should have 1 argument.", operator.getNumberOfArguments(), 1);
	}

	@Test (timeout = 5000, expected = IllegalArgumentException.class)
	public void testIllegalArgumentException(){
		operator.setOperand(2, op0);
		fail("Unary operator should not except input to position 2");
	}

	@Test (timeout = 5000, expected = NullPointerException.class)
	public void testNullArgumentException(){
		operator.setOperand(0, null);
		fail("Operator should not allow null arguments");
	}

}
