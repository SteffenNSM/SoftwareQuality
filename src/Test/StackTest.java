package Test;

import Main.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class StackTest {

    private Stack stack;

    /**
     * Sets up a new Stack instance before each test.
     */
    @Before
    public void setUp() {
        stack = new Stack(5); // Stack with a size of 5 for testing
    }

    /**
     * Tests if the stack is empty when initialized and not empty after pushing an element.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("Stack should be empty initially", stack.isEmpty());
        stack.push(1);
        assertFalse("Stack should not be empty after pushing an element", stack.isEmpty());
    }

    /**
     * Tests the push method for correct behavior, including exceptions for full stack and negative values.
     */
    @Test
    public void testPush() {
        stack.push(10);
        assertEquals("Stack size should be 1 after one push", 1, stack.size());

        stack.push(20);
        assertEquals("Stack size should be 2 after two pushes", 2, stack.size());

        // Fill the stack completely
        stack.push(30);
        stack.push(40);
        stack.push(50); // Stack is now full

        // Test StackOverflowError when pushing into a full stack
        try {
            stack.push(60);
            fail("Expected StackOverflowError when pushing into a full stack");
        } catch (StackOverflowError e) {
            // Expected exception, test passed
        }

        // Test IllegalArgumentException for negative values
        try {
            stack.push(-1);
            fail("Expected IllegalArgumentException when pushing a negative value");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passed
        }
    }

    /**
     * Tests the pop method for correct behavior, including popping from an empty stack.
     */
    @Test
    public void testPop() {
        assertEquals("Popping from an empty stack should return -1", -1, stack.pop());

        stack.push(10);
        stack.push(20);

        assertEquals("Popping should return the last pushed element (LIFO)", 20, stack.pop());
        assertEquals("Popping should return the next element", 10, stack.pop());
        assertEquals("Popping from an empty stack should return -1 again", -1, stack.pop());
    }

    /**
     * Tests the size method for correct size tracking.
     */
    @Test
    public void testSize() {
        assertEquals("Initial stack size should be 0", 0, stack.size());

        stack.push(10);
        assertEquals("Stack size should be 1 after one push", 1, stack.size());

        stack.push(20);
        assertEquals("Stack size should be 2 after two pushes", 2, stack.size());

        stack.pop();
        assertEquals("Stack size should be 1 after one pop", 1, stack.size());

        stack.pop();
        assertEquals("Stack size should be 0 after popping all elements", 0, stack.size());
    }

    /**
     * Tests the top method for correct behavior, including checking the top element in various scenarios.
     */
    @Test
    public void testTop() {
        assertEquals("Top of an empty stack should be -1", -1, stack.top());

        stack.push(10);
        assertEquals("Top should be 10 after pushing 10", 10, stack.top());

        stack.push(20);
        assertEquals("Top should be 20 after pushing 20", 20, stack.top());

        stack.pop();
        assertEquals("Top should be 10 after popping 20", 10, stack.top());
    }
}
