package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 * 
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

	/** indicates number of elements stored */
	private int count;
	/** pointer to top of stack */
	private LinearNode<T> top;

	public LinkedStack() {
		count = 0;
		top = null;

	}

	/**
	 * Removes the element at the top of this stack and returns a reference to it.
	 * Throws an EmptyCollectionException if the stack is empty.
	 * 
	 * @return T element from top of stack
	 * @throws EmptyStackException on pop from empty stack {@inheritDoc}.
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException("Stack");

		T result = top.getElement();
		top = top.getNext();
		count--;

		return result;
	}

	/**
	 * Returns the top most element of this stack.
	 * 
	 * @return the top most element of this stack.
	 * @throws StackUnderflowException if the stack is empty
	 * 
	 *                                 {@inheritDoc}.
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException("Stack");

		return top.getElement();

	}

	/**
	 * 
	 * Returns {@code true} if the stack contains no elements and {@code false}
	 * otherwise.
	 * 
	 * @return {@code true} if the stack contains no elements and {@code false}
	 *         otherwise. {@inheritDoc}.
	 */
	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;

		} else {
			return false;

		}
	}

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in this stack. {@inheritDoc}.
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * Adds the specified element to the top of this stack.
	 * 
	 * @param element element to be pushed on stack
	 * 
	 *                {@inheritDoc}.
	 */
	@Override
	public void push(T elem) {
		LinearNode<T> temp = new LinearNode<T>(elem);
		temp.setNext(top);
		top = temp;
		count++;
	}
}
