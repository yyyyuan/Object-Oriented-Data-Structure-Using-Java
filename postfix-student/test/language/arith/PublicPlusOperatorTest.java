package language.arith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import language.Operand;
import language.Operator;

import org.junit.Before;
import org.junit.Test;

public class PublicPlusOperatorTest {
	Operator<Integer> operator;
	Operand<Integer> op0;
	Operand<Integer> op1;

	@Before
	public void setup(){
		operator = new PlusOperator();
		op0 = new Operand<Integer>(5);
		op1 = new Operand<Integer>(7);
	}

	@Test (timeout = 5000)
	public void testPerformOperation() {
		operator.setOperand(0, op0);
		operator.setOperand(1, op1);

		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 5 and 7 should produce 12.", 5 + 7,  value);
	}

	@Test (timeout = 5000)
	public void testGetNumberOfArguments() {
		assertEquals("Binary operator should have 2 arguments.", operator.getNumberOfArguments(), 2);
	}

	@Test (timeout = 5000, expected = IllegalArgumentException.class)
  public void testIllegalArgumentException(){
		operator.setOperand(2, op0);
		fail("Binary operator should not except input to position 2");
	}

	@Test (timeout = 5000, expected = NullPointerException.class)
  public void testNullArgumentException(){
		operator.setOperand(0, null);
		fail("Operator should not allow null arguments");
	}

	@Test (timeout = 5000, expected = IllegalStateException.class)
  public void testIllegalStateException(){
		operator.setOperand(0, op0);
		operator.setOperand(0, op0);

		fail("Operator should not allow position 0 to be set more than once");
	}

	@Test (timeout = 5000, expected = IllegalStateException.class)
  public void testIllegalStateExceptionPerform(){
		operator.performOperation();
		fail("Operator should not compute when all arguments have not been set.");
	}
}
