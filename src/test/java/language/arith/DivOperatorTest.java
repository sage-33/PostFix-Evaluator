package language.arith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import language.Operand;
import language.Operator;

import org.junit.Before;
import org.junit.Test;

public class DivOperatorTest {
  Operator<Integer> operator;
  Operand<Integer> op0;
  Operand<Integer> op1;

  /**
   * Runs before each test.
   */
  @Before
  public void setup() {
    operator = new DivOperator();
    op0 = new Operand<Integer>(5);
    op1 = new Operand<Integer>(7);
  }

  @Test (timeout = 5000)
  public void testPerformOperation() {
    operator.setOperand(0, op0);
    operator.setOperand(1, op1);

    Operand<Integer> result = operator.performOperation();
    int value = result.getValue();
    assertEquals("Operator applied to 5 and 7 should produce 0.", 0,  value);
  }

  @Test (timeout = 5000)
  public void testPerformOperationPositiveNumbers() {
    operator.setOperand(0, new Operand<Integer>(12));
    operator.setOperand(1, new Operand<Integer>(4));

    Operand<Integer> result = operator.performOperation();
    int value = result.getValue();
    assertEquals("Operator applied to 12 and 4 should produce 3.", 3,  value);
  }

  @Test (timeout = 5000)
  public void testPerformOperationNegativeNumbers() {
    operator.setOperand(0, new Operand<Integer>(-20));
    operator.setOperand(1, new Operand<Integer>(-5));

    Operand<Integer> result = operator.performOperation();
    int value = result.getValue();
    assertEquals("Operator applied to -20 and -5 should produce 4.", 4,  value);
  }

  @Test (timeout = 5000)
  public void testPerformOperationNegativeResult() {
    operator.setOperand(0, new Operand<Integer>(-20));
    operator.setOperand(1, new Operand<Integer>(5));

    Operand<Integer> result = operator.performOperation();
    int value = result.getValue();
    assertEquals("Operator applied to -20 and 5 should produce -4.", -4,  value);
  }

  @Test (timeout = 5000, expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    operator.setOperand(2, op0);
    fail("Binary operator should not except input to position 2");
  }

  @Test (timeout = 5000)
  public void testGetNumberOfArguments() {
    assertEquals("Binary operator should have 2 arguments.", operator.getNumberOfArguments(), 2);
  }

  @Test (timeout = 5000, expected = NullPointerException.class)
  public void testNullArgumentException() {
    operator.setOperand(0, null);
    fail("Operator should not allow null arguments");
  }

  @Test (timeout = 5000, expected = IllegalStateException.class)
  public void testIllegalStateException() {
    operator.setOperand(0, new Operand<Integer>(5));
    operator.setOperand(0, new Operand<Integer>(12));
    fail("Operator should not allow the same operand position to be set more than once");
  }

  @Test (timeout = 5000, expected = IllegalStateException.class)
  public void testIllegalStateExceptionPerform() {
    operator.performOperation();
    fail("Operator should not compute when all arguments have not been set.");
  }

  @Test (timeout = 5000, expected = IllegalStateException.class)
  public void testIllegalStateExceptionZeroDenominator() {
    operator.setOperand(1, new Operand<Integer>(0));
    fail("Operator should not allow the denominator to be set to zero");
  }

}
