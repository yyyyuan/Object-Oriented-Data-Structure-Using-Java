package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	Operator<Integer> operator;
	Operand<Integer> result;
	Operand<Integer> value;
	Operand<Integer> operand0;
	Operand<Integer> operand1;
	Integer finalResult;
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
        // TODO Initialize to your LinkedStack
		stack = new LinkedStack();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
			// TODO What do we do when we see an operand?
				value = token.getOperand();
				stack.push(value);
				break;
			case OPERATOR:
            // TODO What do we do when we see an operator?
				operator = token.getOperator();
				
				if (operator.getNumberOfArguments() == 2) {
					if (stack.isEmpty()) {
						throw new PostFixException("Not enpugh operands - stack" + "underflow");
					}
					operand1 = stack.pop();
					
					if (stack.isEmpty()) {
						throw new PostFixException("Not enough operands - stack" + "underflow");
					}
					operand0 = stack.pop();
					
					//Perform operation
					operator.setOperand(0, operand0);
					operator.setOperand(1, operand1);
					
					result = operator.performOperation();
					stack.push(result);
					
					operand0 = null;
					operand1 = null;
				}
			
				else {
					if (stack.isEmpty())
						throw new PostFixException("Not enough operands - stack " + "underflow");
					operand0 = stack.pop();
					
					operator.setOperand(0, operand0);
					result = operator.performOperation();
					
					stack.push(result);
					
					operand0 = null;
				}
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}						
		}		
		// Test if stack is empty now to get a result having more detils
		if (stack.isEmpty()) {
			throw new IllegalPostfixExpressionException("Not enough operands - stack underflow");
		}
		
		result = stack.pop(); 
		
		if (!stack.isEmpty()) {
			throw new IllegalPostfixExpressionException("Too many operands - operands left over");
		}
		
		finalResult = result.getValue();
		
		return finalResult;
	}

}
