package Main;

/**
 * A simple implementation of a Stack data structure using an integer array.
 */
public class Stack {

	// Maximum size of the stack
	private int maxSize;
	// Current position of the top element in the stack
	private int pos = -1;
	// Array to store stack elements
	private int[] stackArr;

	/**
	 * Constructor to initialize the stack with a specific size.
	 * @param size The maximum size of the stack.
	 */
	public Stack(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Stack size must be greater than zero.");
		}
		this.maxSize = size;
		this.stackArr = new int[size];
	}

	/**
	 * Checks if the stack is empty.
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Removes and returns the top element of the stack.
	 * @return The top element of the stack, or -1 if the stack is empty.
	 */
	public int pop() {
		if (pos == -1) {
			return -1; // Indicates that the stack is empty
		}
		int element = stackArr[pos];
		stackArr[pos] = -1; // Clear the popped element (optional)
		pos--;
		return element;
	}

	/**
	 * Adds a new element to the top of the stack.
	 * @param element The element to be added to the stack. Must be non-negative.
	 * @throws StackOverflowError if the stack is full.
	 * @throws IllegalArgumentException if the element is negative.
	 */
	public void push(int element) throws StackOverflowError, IllegalArgumentException {
		if (element < 0) {
			throw new IllegalArgumentException("Element must be non-negative.");
		}
		int npos = pos + 1;
		if (npos == maxSize) {
			throw new StackOverflowError("Stack is full"); // Stack overflow error
		}
		pos = npos;
		stackArr[pos] = element;
	}

	/**
	 * Returns the current size of the stack.
	 * @return The number of elements in the stack.
	 */
	public int size() {
		return pos + 1;
	}

	/**
	 * Returns the top element of the stack without removing it.
	 * @return The top element of the stack, or -1 if the stack is empty.
	 */
	public int top() {
		if (pos == -1) {
			return -1; // Indicates that the stack is empty
		}
		return stackArr[pos]; // Return the top element
	}
}
