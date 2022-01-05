package evaluator.arith;

import evaluator.PostFixEvaluator;
import language.Operand;
import parser.arith.ArithPostFixParser;
import stack.StackInterface;


/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

  private final StackInterface<Operand<Integer>> stack;

  /**
   * Constructs an {@link ArithPostFixEvaluator}.
   */
  public ArithPostFixEvaluator() {
    this.stack = null; //TODO Initialize to your LinkedStack
  }

  /**
   * Evaluates a postfix expression.
   * @return the result 
   */
  @Override
  public Integer evaluate(String expr) {
    // TODO Use all of the things they've built so far to 
    // create the algorithm to do post fix evaluation

    ArithPostFixParser parser = new ArithPostFixParser(expr);
    while (parser.hasNext()) {
      switch (parser.nextType()) { 
        case OPERAND:
          //TODO What do we do when we see an operand?
          break;
        case OPERATOR:
          //TODO What do we do when we see an operator?
          break;
        default:
          //TODO If we get here, something went terribly wrong
      }
    }

    //TODO What do we return?
    return null;
  }

}
