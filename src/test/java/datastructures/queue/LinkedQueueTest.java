package datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by MHSL on 09.04.2017.
 */
public class LinkedQueueTest {
    
    private LinkedQueue<Integer> linkedQueue;
    private int testValue;
    
    @Before
    public void setUp() {
        linkedQueue = new LinkedQueue<>();
        testValue = 1;
    }
    
    @Test
    public void testPush() {
        assertEquals("Unexpected initial size of the queue", 0, linkedQueue.size());
        linkedQueue.push(testValue);
        assertEquals("Unexpected size after pushing", 1, linkedQueue.size());
    }
    
    @Test
    public void testPeek() {
        int anotherTestValue = 2;
        linkedQueue.push(testValue);
        linkedQueue.push(anotherTestValue);
        int actualValue = linkedQueue.peek();
        assertEquals("Unexpected value after peeking", testValue, actualValue);
        assertEquals("Unexpected size of the queue after peeking", 2, linkedQueue.size());
    }
    
    @Test
    public void testPop() {
        int anotherTestValue = 2;
        linkedQueue.push(testValue);
        linkedQueue.push(anotherTestValue);
        int actualValue = linkedQueue.pop();
        assertEquals("Unexpected value after popping", testValue, actualValue);
        assertEquals("Unexpected size of the queue after popping", 1, linkedQueue.size());
    }
    
    @Test
    public void testIsEmpty() {
        assertEquals("The queue should be empty by default", true, linkedQueue.isEmpty());
        linkedQueue.push(testValue);
        assertEquals("The queue shouldn't be empty after adding an element", false, linkedQueue.isEmpty());
    }
}
