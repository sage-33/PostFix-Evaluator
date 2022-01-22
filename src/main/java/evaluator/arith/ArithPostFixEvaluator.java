package evaluator.arith;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;

/**
 * @author sagesilberman
 * 
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple
 * arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;

	/**
	 * Constructs an {@link ArithPostFixEvaluator}.
	 */
	public ArithPostFixEvaluator() {
		this.stack = new LinkedStack<Operand<Integer>>();

	}

	/**
	 * Evaluates a postfix expression.
	 * 
	 * @return the result
	 */
	@Override
	public Integer evaluate(String expr) {

		ArithPostFixParser parser = new ArithPostFixParser(expr);
		while (parser.hasNext()) {
			switch (parser.nextType()) {
			case OPERAND:
				stack.push(parser.nextOperand());
				break;
			case OPERATOR:
				// grab operator from parser
				Operator<Integer> operator = parser.nextOperator();
				if (stack.size() < operator.getNumberOfArguments()) {
					throw new IllegalPostFixExpressionException(
							"Could not perform operation with an invalid post fix expression.");

				}
				// based on number of arguments pop appropriate amount from stack
				for (int i = operator.getNumberOfArguments() - 1; i >= 0; i--) {
					// set operands
					operator.setOperand(i, stack.pop());
				}
				// perform operations and push the results onto the stack
				stack.push(operator.performOperation());
				break;
			default:
				// throw exception
				throw new IllegalPostFixExpressionException(
						"Could not perform operation with an invalid post fix expression.");
			}
		}
		if (stack.size() != 1) {
			throw new IllegalPostFixExpressionException(
					"Could not perform operation with a invalid post fix expression.");
		}

		// return whatever is on the stack
		return stack.pop().getValue();
	}

}
