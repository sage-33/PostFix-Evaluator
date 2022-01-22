package evaluator.arith;

import static org.junit.Assert.assertEquals;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;

import org.junit.Before;
import org.junit.Test;

public class ArthInFixEvaluatorTest {

	private PostFixEvaluator<Integer> evaluator;

	@Before
	public void setup() {
		evaluator = new ArthInFixEvaluator();
	}

	@Test(timeout = 5000)
	public void testEvaluateSimple() {
		Integer result = evaluator.evaluate("1");
		assertEquals(new Integer(1), result);
	}

	@Test(timeout = 5000)
	public void testEvaluatePlus() {
		Integer result = evaluator.evaluate("1 + 2");
		assertEquals(new Integer(1 + 2), result);

		result = evaluator.evaluate("1 + 2 + 3");
		assertEquals(new Integer(1 + 2 + 3), result);

		result = evaluator.evaluate("10000 + 1000 + 100 + 10 + 1");
		assertEquals(new Integer(11111), result);
	}

	@Test(timeout = 5000)
	public void testEvaluateSub() {
		Integer result = evaluator.evaluate("1 - 2");
		assertEquals(new Integer(1 - 2), result);

		result = evaluator.evaluate("1 - 2 - 3");
		assertEquals(new Integer(1 - 2 - 3), result);

		result = evaluator.evaluate("1000 - 100 - 10 - 1");
		assertEquals(new Integer(1000 - 100 - 10 - 1), result);
	}

	@Test(timeout = 5000)
	public void testEvaluateMult() {
		Integer result = evaluator.evaluate("1 * 2");
		assertEquals(new Integer(1 * 2), result);

		result = evaluator.evaluate("1 * 2 * 3");
		assertEquals(new Integer(1 * 2 * 3), result);

		result = evaluator.evaluate("1 * 2 * 3 * 4");
		assertEquals(new Integer(1 * 2 * 3 * 4), result);
	}

	@Test(timeout = 5000, expected = IllegalPostFixExpressionException.class)
	public void testInvalidExpression() {
		evaluator.evaluate("1 2");
	}

	@Test(timeout = 5000)
	public void testEvaluateMult2() {
		Integer result = evaluator.evaluate("5 * 8");
		assertEquals(new Integer(5 * 8), result);

		result = evaluator.evaluate("5 * 7 * 9");
		assertEquals(new Integer(5 * 7 * 9), result);

		result = evaluator.evaluate("5 * 4 * 3 * 2");
		assertEquals(new Integer(5 * 4 * 3 * 2), result);
	}

	@Test(timeout = 5000)
	public void testEvaluateDiv() {
		Integer result = evaluator.evaluate("45 / 5");
		assertEquals(new Integer(45 / 5), result);

		result = evaluator.evaluate("4 / 2");
		assertEquals(new Integer(4 / 2), result);

		result = evaluator.evaluate("8 / 2 / 1");
		assertEquals(new Integer(8 / 2 / 1), result);
	}

	@Test(timeout = 5000)
	public void testEvaluateExponent() {
		Integer result = evaluator.evaluate("2 ^ 3");
		assertEquals(new Integer(8), result);

		result = evaluator.evaluate("4 ^ 2");
		assertEquals(new Integer(16), result);

		result = evaluator.evaluate("8 ^ 2");
		assertEquals(new Integer(64), result);
	}

	@Test(timeout = 5000, expected = IllegalPostFixExpressionException.class)
	public void testExpressionException() {
		evaluator.evaluate("5 6");
	}

}
