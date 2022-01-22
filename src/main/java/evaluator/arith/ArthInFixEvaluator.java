package evaluator.arith;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import language.Operand;
import language.Operator;
import language.arith.DivOperator;
import language.arith.ExponentOperator;
import language.arith.MultOperator;
import language.arith.PlusOperator;
import language.arith.SubOperator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;

/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple
 * arithmetic expressions.
 *
 */

/**
 * @author sagesilberman
 *
 */
public class ArthInFixEvaluator implements PostFixEvaluator<Integer> {

	private final StackInterface<Operator<Integer>> operatorStack;
	private final StackInterface<Operand<Integer>> operandStack;

	/**
	 * Constructs an {@link ArithPostFixEvaluator}.
	 */
	public ArthInFixEvaluator() {
		this.operandStack = new LinkedStack<Operand<Integer>>();
		this.operatorStack = new LinkedStack<Operator<Integer>>();

	}

	/**
	 * Assign a priority to an operator by giving it a level.
	 * 
	 * @param operator
	 * @return priority level of a given operator
	 */
	public int checkPriority(Operator operator) {
		if (operator instanceof ExponentOperator) {
			return 3;
		} else if (operator instanceof MultOperator || operator instanceof DivOperator) {
			return 2;
		} else if (operator instanceof PlusOperator || operator instanceof SubOperator) {
			return 1;
		} else {
			throw new IllegalPostFixExpressionException("Could not perform operation with an invalid operator.");
		}

	}

	/**
	 * Evaluates an infix expression.
	 * 
	 * @return the result
	 */
	@Override
	public Integer evaluate(String expr) {

		ArithPostFixParser parser = new ArithPostFixParser(expr);
		while (parser.hasNext()) {
			switch (parser.nextType()) {
			case OPERAND:
				operandStack.push(parser.nextOperand());
				break;
			case OPERATOR:
				// grab operator from parser
				Operator<Integer> operator = parser.nextOperator();
				if (operatorStack.isEmpty()) {
					operatorStack.push(operator);
				} else {
					// current operator at the top of the stack
					Operator<Integer> topOperator = operatorStack.top();
					if (checkPriority(operator) > checkPriority(topOperator)) {
						operatorStack.push(operator);
					} else {
						for (int i = topOperator.getNumberOfArguments() - 1; i >= 0; i--) {
							topOperator.setOperand(i, operandStack.pop());
						}
						operandStack.push(topOperator.performOperation());
						operatorStack.pop();
						operatorStack.push(operator);

					}
				}
				break;
			default:
				throw new IllegalPostFixExpressionException(
						"Could not perform operation with an invalid post fix expression.");
			}
		}
		if (operatorStack.size() != 0) {
			// operator at the top of the stack
			Operator<Integer> operator = operatorStack.top();
			for (int i = operator.getNumberOfArguments() - 1; i >= 0; i--) {
				operator.setOperand(i, operandStack.pop());
			}
			operandStack.push(operator.performOperation());
			operatorStack.pop();
		}
		if (operandStack.size() != 1) {
			throw new IllegalPostFixExpressionException(
					"Could not perform operation with an invalid post fix expression");
		}
		return operandStack.pop().getValue();
	}
}
