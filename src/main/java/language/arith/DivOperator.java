package language.arith;

import language.Operand;

import language.Operator;

import language.BinaryOperator;

/**
 * The {@link DivOperator} is an operator that performs division on two
 * integers.
 * 
 * @author sagesilberman
 * 
 * @author jcollard, jddevaug
 *
 */
public class DivOperator extends BinaryOperator<Integer> {

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
		Operand<Integer> op1 = this.getOp1();
		if (op0 == null || op1 == null) {
			throw new IllegalStateException("Could not perform operation prior to operands being set.");
		}
		Integer result = op0.getValue() / op1.getValue();
		return new Operand<Integer>(result);
	}

	/**
	 * <p>
	 * Sets the specified {@link Operand}.
	 * </p>
	 * <p>
	 * <b>Note</b>: {@link Operand}s positions are indexed by 0 so the first
	 * {@link Operand} should be set with 0, the second with 1, third with 2, etc...
	 * </p>
	 * 
	 * @param position the position of the operand
	 * @param operand  the {@link Operand} to set.
	 * @throws IllegalStateException if the position was previously set.
	 * @throws NullPointerException  if the operand provided is null. {@inheritDoc}
	 */
	@Override
	public void setOperand(int i, Operand<Integer> operand) {
		if (operand != null && operand.getValue() == 0 && i == 1) {
			throw new IllegalStateException("Could not perform operation due to illegal denominator");
		} else {
			// Call BinaryOperator's setOperand
			super.setOperand(i, operand);
		}
	}

}