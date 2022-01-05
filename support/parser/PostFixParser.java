package parser;

import language.Operand;
import language.Operator;

/**
 * A {@link PostFixParser} is used to parse post fix expressions made up of operands and operators.
 * @author jcollard, jddevaug
 *
 * @param <T> - the type of data held in an operand
 */
public interface PostFixParser<T> {

  /**
   * A {@link PostFixParser} can produce different types.
   * @author jcollard, jddevaug
   *
   */
  public static enum Type {

    /**
     * Indicates that the value being parsed is an {@link Operand}.
     */
    OPERAND,

    /**
     * Indicates that the value being parsed is an {@link Operator}. 
     */
    OPERATOR;
  }


  /**
   * Returns {@code true} if this parser has more parsables and {@code false} otherwise. 
   * @return {@code true} if this parser has more parsables and {@code false} otherwise.
   */
  public boolean hasNext();

  /**
   * Returns the type of the next parsable.
   * @return the type of the next parsable.
   * @throws IllegalStateException if there are no more parsables.
   */
  public Type nextType();

  /**
   * Returns the next {@link Operand}.
   * @return the next {@link Operand}.
   * @Throws IllegalStateException if the next parsable was not an Operand 
   *         or there are no more parsables.
   */
  public Operand<T> nextOperand();

  /**
   * Returns the next {@link Operator}.
   * @return the next {@link Operator}.
   * @Throws IllegalStateException if the next parsable was not an {@link Operator} 
   *         or there are no more parsables.
   */
  public Operator<T> nextOperator();

}
