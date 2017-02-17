package parser.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser;
import parser.PostfixParser.Type;
import parser.Token;

public class ArithPostfixParserExample {

	public static void main(String[] args) throws IllegalPostfixExpressionException {
		
		PostfixParser<Integer> parser = new ArithPostfixParser("1 2 +");
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			System.out.print("Parsed token of type: " + type + "; value: ");
			switch (type) {
			case OPERAND:
				Operand<Integer> v = token.getOperand();
				System.out.println(v);
				break;
			case OPERATOR:
				Operator<Integer> o = token.getOperator();
				System.out.println(o);
				break;
			default:
				throw new IllegalStateException();
			}
		}
	}
}
