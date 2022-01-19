package language.arith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import language.Operand;
import language.Operator;

import org.junit.Before;
import org.junit.Test;

public class ExponentOperatorTest {
	private Operator<Integer> operator;
	private Operand<Integer> op0;
	private Operand<Integer> op1;

	/**
	 * Runs before each test.
	 */
	@Before
	public void setup() {
		operator = new ExponentOperator();
		op0 = new Operand<Integer>(2);
		op1 = new Operand<Integer>(4);
	}

	@Test(timeout = 5000)
	public void testGetNumberOfArguments() {
		assertEquals("Binary operator should have 2 arguments.", operator.getNumberOfArguments(), 2);
	}

	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		operator.setOperand(2, op0);
		fail("Binary operator should not except input to position 2");
	}

	@Test(timeout = 5000, expected = NullPointerException.class)
	public void testNullArgumentException() {
		operator.setOperand(0, null);
		fail("Operator should not allow null arguments");
	}

	@Test(timeout = 5000, expected = IllegalStateException.class)
	public void testIllegalStateException() {
		operator.setOperand(0, op0);
		operator.setOperand(0, op0);

		fail("Operator should not allow position 0 to be set more than once");
	}

	@Test(timeout = 5000, expected = IllegalStateException.class)
	public void testIllegalStateExceptionPerform() {
		operator.performOperation();
		fail("Operator should not compute when all arguments have not been set.");
	}

	// 1st new test case that passes
	@Test(timeout = 5000)
	public void testPerformOperationSetDiff() {
		operator.setOperand(0, new Operand<Integer>(4));
		operator.setOperand(1, new Operand<Integer>(3));

		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 4 and 3 should produce 64", 64, value);
	}

	// 2nd new test case that passes
	@Test(timeout = 5000)
	public void testPerformOperationSetDiff2() {
		operator.setOperand(0, op0);
		operator.setOperand(1, op1);

		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 2 and 4 should produce 16.", 16, value);
	}

	// test case that fails
	@Test(timeout = 5000, expected = IllegalArgumentException.class)
	public void testIllegalArgumentExceptionSetDiff() {
		operator.setOperand(8, op0);
		fail("Binary operator should not except input to position 7");
	}

}
