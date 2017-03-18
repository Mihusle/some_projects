package datastructures.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MHSL on 17.03.2017.
 */
public class SimpleQueueTest {
    
    private static final int LENGTH = 5;
    private SimpleQueue<Integer> queue;
    private int testValue;
    
    @Before
    public void setUp() {
        queue = new SimpleQueue<>(Integer.class, LENGTH);
        testValue = 1;
    }
    
    @Test
    public void simpleQueuePushTest() {
        Assert.assertEquals("Unexpected initial size of queue", 0, queue.size());
        queue.push(testValue);
        Assert.assertEquals("Unexpected size of queue after push", 1, queue.size());
    }
    
    @Test
    public void simpleQueuePopTest() {
        queue.push(testValue);
        int actualValue = queue.pop();
        Assert.assertEquals("Unexpected value after pop", testValue, actualValue);
        Assert.assertEquals("Unexpected size of queue after pop", 0, queue.size());
    }
    
    @Test
    public void simpleQueuePeekTest() {
        queue.push(testValue);
        int actualValue = queue.peek();
        Assert.assertEquals("Unexpected value after peek", testValue, actualValue);
        Assert.assertEquals("Unexpected size of queue after peek", 1, queue.size());
    }
    
    @Test
    public void simpleQueueIsFullTest() {
        Assert.assertEquals("The queue shouldn't be full", false, queue.isFull());
        for (int i = 0; i < LENGTH; i++) {
            queue.push(testValue);
        }
        Assert.assertEquals("The queue should be full", true, queue.isFull());
    }
    
    @Test
    public void simpleQueueIsEmptyTest() {
        Assert.assertEquals("The queue should be empty", true, queue.isEmpty());
        for (int i = 0; i < LENGTH; i++) {
            queue.push(testValue);
        }
        Assert.assertEquals("The queue shouldn't be empty", false, queue.isEmpty());
        for (int i = 0; i < LENGTH; i++) {
            queue.pop();
        }
        Assert.assertEquals("The queue should be empty", true, queue.isEmpty());
    }
    
    @Test
    public void simpleQueueLoopTest() {
        while (!queue.isFull()) {
            queue.push(testValue);
        }
        queue.pop();
        int anotherTestValue = 2;
        queue.push(anotherTestValue);
        int actualValue = 0;
        while (!queue.isEmpty()) {
            actualValue = queue.pop();
        }
        Assert.assertEquals("Unexpected value after pop", anotherTestValue, actualValue);
    }
}
