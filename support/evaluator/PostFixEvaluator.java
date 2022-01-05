package evaluator;

/**
 * A {@code PostFixEvaluator} evaluates post fix expressions.
 * @author jcollard, jddevaug
 *
 * @param <T> the type of result to be evaluated
 */
public interface PostFixEvaluator<T> {

  /**
   * Evaluates the post fix expression and returns a value.
   * @param expr the expression to be evaluate
   * @return the value of evaluating expr
   * @throws IllegalPostFixExpressionException if the expression is not a valid post fix expression
   */
  public T evaluate(String expr);

}
