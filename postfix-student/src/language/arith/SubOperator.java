package language.arith;

import language.BinaryOperator;
import language.Operand;


/**
 * The {@code SubOperator} is an operator that performs subtraction on two
 * integers.
 * @author jcollard
 *
 */
public class SubOperator extends BinaryOperator<Integer> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Operand<Integer> performOperation() {
            //TODO Before you get started, have you looked at the
            // PlusOperator class? You'll notice that it is taking advantage
            // of the abstract BinaryOperator class. Take a moment to
            // also look at that class. Finally, you should implement
            // this class.
			if(op0 == null || op1 == null)
				throw new IllegalStateException("Could not perform operation prior to operands being set.");
			Integer result = op0.getValue() - op1.getValue();
			return new Operand<Integer>(result);
	}

		public String toString() {
			return "-";
		}
	}


