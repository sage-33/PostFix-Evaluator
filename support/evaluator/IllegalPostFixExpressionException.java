package evaluator;

/**
 * A {@link IllegalPostFixExpressionException} is thrown at runtime when an invalid
 * PostFixExpression is encountered.
 * @author jcollard, jddevaug
 *
 */
public class IllegalPostFixExpressionException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;

  public IllegalPostFixExpressionException() {
    super();
  }

  public IllegalPostFixExpressionException(String message) {
    super(message);
  }
}