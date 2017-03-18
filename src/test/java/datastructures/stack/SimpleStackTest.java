package datastructures.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MHSL on 15.03.2017.
 */
public class SimpleStackTest {
    
    private static final int LENGTH = 5;
    private SimpleStack<Integer> stack;
    private int testValue;
    
    @Before
    public void setUp() {
        stack = new SimpleStack<>(Integer.class, LENGTH);
        testValue = 1;
    }
    
    @Test
    public void simpleStackPushTest() {
        Assert.assertEquals("Unexpected initial size of stack", 0, stack.size());
        stack.push(testValue);
        Assert.assertEquals("Unexpected size of stack after push", 1, stack.size());
    }
    
    @Test
    public void simpleStackPeekTest() {
        stack.push(testValue);
        final int actualValue = stack.peek();
        Assert.assertEquals("Unexpected value after peek", testValue, actualValue);
        Assert.assertEquals("Unexpected size of stack after peek", 1, stack.size());
    }
    
    @Test
    public void simpleStackPopTest() {
        stack.push(testValue);
        final int actualValue = stack.pop();
        Assert.assertEquals("Unexpected value after pop", testValue, actualValue);
        Assert.assertEquals("Unexpected size of stack after pop", 0, stack.size());
    }
    
    @Test
    public void simpleStackIsFullTest() {
        for (int i = 0; i < LENGTH; i++) {
            stack.push(testValue);
        }
        Assert.assertEquals("The stack should be full", true, stack.isFull());
    }
    
    @Test
    public void simpleStackIsEmptyTest() {
        Assert.assertEquals("The stack should be empty", true, stack.isEmpty());
        for (int i = 0; i < LENGTH; i++) {
            stack.push(testValue);
        }
        for (int i = 0; i < LENGTH; i++) {
            stack.pop();
        }
        Assert.assertEquals("The stack should be empty", true, stack.isEmpty());
    }
}
