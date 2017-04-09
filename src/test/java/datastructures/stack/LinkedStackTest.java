package datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by MHSL on 09.04.2017.
 */
public class LinkedStackTest {
    
    private LinkedStack<Integer> linkedStack;
    private int testValue;
    
    @Before
    public void setUp() {
        linkedStack = new LinkedStack<>();
        testValue = 1;
    }
    
    @Test
    public void pushTest() {
        assertEquals("Unexpected initial size of the stack", 0, linkedStack.size());
        linkedStack.push(testValue);
        assertEquals("Unexpected size of the stack after pushing", 1, linkedStack.size());
        assertEquals("Unexpected value in the stack after pushing", Integer.valueOf(testValue), linkedStack.peek());
    }
    
    @Test
    public void peekTest() {
        int anotherTestValue = 2;
        linkedStack.push(testValue);
        linkedStack.push(anotherTestValue);
        int actualValue = linkedStack.peek();
        assertEquals("Unexpected size of the stack after peeking", 2, linkedStack.size());
        assertEquals("Unexpected value after peeking", anotherTestValue, actualValue);
    }
    
    @Test
    public void popTest() {
        int anotherTestValue = 2;
        linkedStack.push(testValue);
        linkedStack.push(anotherTestValue);
        int actualValue = linkedStack.pop();
        assertEquals("Unexpected size of the stack after popping", 1, linkedStack.size());
        assertEquals("Unexpected value after popping", anotherTestValue, actualValue);
    }
    
    @Test
    public void isEmptyTest() {
        assertEquals("The stack should be empty by default", true, linkedStack.isEmpty());
        linkedStack.push(testValue);
        assertEquals("Test stack shouldn't be empty after adding an element", false, linkedStack.isEmpty());
    }
}
