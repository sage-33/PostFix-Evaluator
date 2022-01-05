package evaluator.arith;

import static org.junit.Assert.assertEquals;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;

import org.junit.Before;
import org.junit.Test;

public class ArithPostFixEvaluatorTest {

  private PostFixEvaluator<Integer> evaluator;

  @Before
  public void setup() {
    evaluator = new ArithPostFixEvaluator();
  }

  @Test (timeout = 5000)
  public void testEvaluateSimple() {
    Integer result = evaluator.evaluate("1");
    assertEquals(new Integer(1), result);
  }

  @Test (timeout = 5000)
  public void testEvaluatePlus() {
    Integer result = evaluator.evaluate("1 2 +");
    assertEquals(new Integer(3), result);

    result = evaluator.evaluate("1 2 3 + +");
    assertEquals(new Integer(6), result);

    result = evaluator.evaluate("10000 1000 100 10 1 + + + +");
    assertEquals(new Integer(11111), result);
  }

  @Test (timeout = 5000)
  public void testEvaluateSub() {
    Integer result = evaluator.evaluate("1 2 -");
    assertEquals(new Integer(-1), result);

    result = evaluator.evaluate("1 2 3 - -");
    assertEquals(new Integer(2), result);

    result = evaluator.evaluate("1000 100 10 1 - - -");
    assertEquals(new Integer(909), result);
  }

  @Test (timeout = 5000)
  public void testEvaluateMult() {
    Integer result = evaluator.evaluate("1 2 *");
    assertEquals(new Integer(2), result);

    result = evaluator.evaluate("1 2 3 * *");
    assertEquals(new Integer(6), result);

    result = evaluator.evaluate("1 2 3 4 * * *");
    assertEquals(new Integer(24), result);
  }

  @Test (timeout = 5000)
  public void testEvaluateNegate() {
    Integer result = evaluator.evaluate("1 !");
    assertEquals(new Integer(-1), result);

    result = evaluator.evaluate("2 !");
    assertEquals(new Integer(-2), result);

    result = evaluator.evaluate("-15 !");
    assertEquals(new Integer(15), result);
  }

  @Test (timeout = 5000, expected = IllegalPostFixExpressionException.class)
  public void testInvalidExpression() {
    evaluator.evaluate("1 2");
  }


}
