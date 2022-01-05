package language.arith;

import language.Operand;
import language.Operator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single integer
 * @author jcollard, jddevaug
 *
 */
public class NegateOperator implements Operator<Integer> {

  //TODO Have you taken a look at the PlusOperator yet?
  //You will notice that it extends the abstract class BinaryOperator
  // You should take a moment and review that class before trying to
  // implement this one. Although it is not required, 
  // it might be a good idea to first write
  // an abstract class called UnaryOperator that abstracts out
  // all the bits for UnaryOperators.


  /**
   * {@inheritDoc}
   */
  @Override
  public int getNumberOfArguments() {
    //TODO Have you taken a look at the PlusOperator yet?
    //You will notice that it extends the abstract class BinaryOperator
    // You should take a moment and review that class before trying to
    // implement this one. Although it is not required, 
    // it might be a good idea to first write
    // an abstract class called UnaryOperator that abstracts out
    // all the bits for UnaryOperators.
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Operand<Integer> performOperation() {
    //TODO Have you taken a look at the PlusOperator yet?
    //You will notice that it extends the abstract class BinaryOperator
    // You should take a moment and review that class before trying to
    // implement this one. Although it is not required, 
    // it might be a good idea to first write
    // an abstract class called UnaryOperator that abstracts out
    // all the bits for UnaryOperators.
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setOperand(int i, Operand<Integer> operand) {
    //TODO Have you taken a look at the PlusOperator yet?
    //You will notice that it extends the abstract class BinaryOperator
    // You should take a moment and review that class before trying to
    // implement this one. Although it is not required, 
    // it might be a good idea to first write
    // an abstract class called UnaryOperator that abstracts out
    // all the bits for UnaryOperators.

    //TODO Negation on an integer is simply flipping its sign
    //So the negation of some int value i is -i.

  }


}
