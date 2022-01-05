package parser.arith;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import language.Operand;
import language.Operator;
import language.arith.DivOperator;
import language.arith.MultOperator;
import language.arith.NegateOperator;
import language.arith.PlusOperator;
import language.arith.SubOperator;
import parser.PostFixParser;

/**
 * <p>
 * An {@code ArithPostFixParser} is a post fix parser for arithmetic
 * expressions.
 * </p>
 * <p>
 * You shouldn't worry about how this class is implemented but you should be
 * aware of its usage.
 * </p>
 * 
 * <pre>
 * Example:
 *   PostFixParser<Integer> parser = new ArithPostFixParser("1 2 +");
 *  boolean next = parser.hasNext(); // Returns true because there are more elements to be consumed
 *  Type nextP = parser.nextType(); // Returns OPERAND because the next element is an operand
 *  Operand<Integer> o0 = parser.nextOperand(); // Returns an operand wrapping 1
 *  next = parser.hasNext(); // Returns true because there are more elements to be consumed
 *  nextP = parser.nextType(); // Returns OPERAND because the next element is an operand
 *  Operand<Integer> o1 = parser.nextOperand(); // Returns an operand wrapping 2
 *  next = parser.hasNext(); // Returns true because there are more elements to be consumed
 *  nextP = parser.nextType(); // Returns OPERATOR because the next element is an operand
 *  Operator<Integer> operator = parser.nextOperator(); // Returns the PlusOperator
 *  next = parser.hasNext(); // Returns false because all of the elements have been consumed
 * </pre>
 * 
 * 
 * @author jcollard, jddevaug
 * 
 */
public class ArithPostFixParser implements PostFixParser<Integer> {

  private static interface OperatorConstructor {
    public Operator<Integer> construct();
  }

  private static final Map<String, OperatorConstructor> operators;

  private static boolean isParseable(String expr) {
    Scanner s = new Scanner(expr);
    while (s.hasNext()) {
      // If we find an integer, we are good.
      if (s.hasNextInt()) {
        s.nextInt();
        continue;
      }
      String token = s.next();
      // If we find a string that is not an operator
      // return false
      if (!operators.containsKey(token)) {
        s.close();
        return false;
      }
    }
    s.close();
    // If we make it to the end of the expression we are good
    return true;
  }

  static {
    operators = new HashMap<String, ArithPostFixParser.OperatorConstructor>();

    operators.put("+", new OperatorConstructor() {

      @Override
      public Operator<Integer> construct() {
        return new PlusOperator();
      }
    });

    operators.put("*", new OperatorConstructor() {

      @Override
      public Operator<Integer> construct() {
        return new MultOperator();
      }
    });

    operators.put("-", new OperatorConstructor() {

      @Override
      public Operator<Integer> construct() {
        return new SubOperator();
      }
    });

    operators.put("/", new OperatorConstructor() {

      @Override
      public Operator<Integer> construct() {
        return new DivOperator();
      }
    });

    operators.put("!", new OperatorConstructor() {

      @Override
      public Operator<Integer> construct() {
        return new NegateOperator();
      }
    });
  }

  private final String expr;
  private final Scanner tokenizer;
  private Operand<Integer> nextOperand;
  private Operator<Integer> nextOperator;

  /**
   * Creates an {@link ArithPostFixParser} over {@code expr}.
   * 
   * @param expr
   *            the arithmetic expression to parse
   * @throws NullPointerException if expr is null
   * @throws IllegalArgumentException if expr is no a valid arithmetic
   *         expression.
   */
  public ArithPostFixParser(String expr) {
    if (expr == null) {
      throw new NullPointerException("The expression must be non-null.");
    }
    if (!isParseable(expr)) {
      throw new IllegalArgumentException("The string \"" + expr
          + "\" is not a valid ArithPostFix expression.");
    }
    this.expr = expr;
    this.tokenizer = new Scanner(this.expr);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean hasNext() {
    getNextParsable();
    return nextOperand != null || nextOperator != null;
  }

  private final void getNextParsable() {
    // If the next parseable has not been given, do nothing.
    if (nextOperand != null || nextOperator != null) {
      return;
    }
    // If the token is an int, generate an integer operand
    if (tokenizer.hasNextInt()) {
      int token = tokenizer.nextInt();
      nextOperand = new Operand<Integer>(token);
      return;
    } else if (tokenizer.hasNext()) {
      // Otherwise return the associated operator
      String token = tokenizer.next();
      nextOperator = operators.get(token).construct();
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Type nextType() {
    if (!hasNext()) {
      throw new IllegalStateException("End of expression was reached.");
    }
    if (nextOperator != null) {
      return Type.OPERATOR;
    }
    return Type.OPERAND;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Operand<Integer> nextOperand() {
    if (nextType() != PostFixParser.Type.OPERAND) {
      throw new IllegalStateException("Operand could not be parsed.");
    }
    Operand<Integer> temp = nextOperand;
    nextOperand = null;
    return temp;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Operator<Integer> nextOperator() {
    if (nextType() != PostFixParser.Type.OPERATOR) {
      throw new IllegalStateException("Operator could not be parsed.");
    }
    Operator<Integer> temp = nextOperator;
    nextOperator = null;
    return temp;
  }

}
