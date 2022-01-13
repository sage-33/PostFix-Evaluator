package language.arith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import language.Operand;
import language.Operator;

import org.junit.Before;
import org.junit.Test;

public class MultOperatorTest {
	Operator<Integer> operator;
	Operand<Integer> op0;
	Operand<Integer> op1;

	/**
	 * Runs before each test.
	 */
	@Before
	public void setup() {
		operator = new MultOperator();
		op0 = new Operand<Integer>(5);
		op1 = new Operand<Integer>(7);
	}

	@Test(timeout = 5000)
	public void testPerformOperation() {
		operator.setOperand(0, op0);
		operator.setOperand(1, op1);

		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 5 and 7 should produce 35.", 35, value);
	}

	@Test(timeout = 5000, expected = IllegalStateException.class)
	public void testIllegalStateException() {
		operator.setOperand(0, new Operand<Integer>(5));
		operator.setOperand(0, new Operand<Integer>(12));
		fail("Operator should not allow the same operand position to be set more than once");
	}

	@Test(timeout = 5000, expected = IllegalStateException.class)
	public void testIllegalStateExceptionPerform() {
		operator.performOperation();
		fail("Operator should not compute when all arguments have not been set.");
	}

	@Test(timeout = 5000, expected = NullPointerException.class)
	public void testNullArgumentException() {
		operator.setOperand(0, null);
		fail("Operator should not allow null arguments");
	}

	// Test that passes 1
	@Test(timeout = 5000)
	public void testPerformOperationSetDiff() {
		operator.setOperand(0, new Operand<Integer>(420));
		operator.setOperand(1, new Operand<Integer>(1));

		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 420 and 1 should produce 420.", 420, value);
	}

	// Test that passes 2
	@Test(timeout = 5000)
	public void testPerformOperationSetDiff2() {
		operator.setOperand(0, new Operand<Integer>(69));
		operator.setOperand(1, new Operand<Integer>(1));

		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 69 and 1 should produce 69.", 69, value);
	}

	// Test that fails
	@Test(timeout = 5000, expected = IllegalStateException.class)
	public void testIllegalStateExceptionSetDiff() {
		operator.setOperand(0, new Operand<Integer>(12));
		operator.setOperand(0, new Operand<Integer>(21));
		fail("Operator should not allow the same operand position to be set more than once");
	}

}
