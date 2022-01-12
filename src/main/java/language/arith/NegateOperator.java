package language.arith;

import language.Operand;
import language.Operator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single
 * integer
 * 
 * @author jcollard, jddevaug
 *
 */
public class NegateOperator extends UnaryOperator<Integer> {

	/**
	 * Performs this operation on values supplied via the
	 * {@link Operator#setOperand(int, Operand)} method and returns the resulting
	 * {@link Operand}.
	 * 
	 * @return the result of applying this {@link Operator} to its {@link Operand}s
	 * @throws IllegalStateException if the required {@link Operand}s were not set.
	 */
	@Override
	public Operand<Integer> performOperation() {
		Operand<Integer> op0 = this.getOp0();
		if (op0 == null) {
			throw new IllegalStateException("Could not perform operation");
		}
		Integer result = op0.getValue() * -1;
		return new Operand<Integer>(result);
	}

}
