package datastructures.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MHSL on 18.03.2017.
 */
public class PriorityQueueTest {
    
    private static final int LENGTH = 5;
    private PriorityQueue<Integer> queue;
    private int testValue;
    
    @Before
    public void setUp() {
        queue = new PriorityQueue<>(Integer.class, LENGTH, (first, second) -> first - second);
        testValue = 1;
    }
    
    @Test
    public void priorityQueuePushTest() {
        Assert.assertEquals("Unexpected initial size of queue", 0, queue.size());
        queue.push(testValue);
        Assert.assertEquals("Unexpected size of queue after push", 1, queue.size());
    }
    
    @Test
    public void priorityQueuePopTest() {
        queue.push(testValue);
        int actualValue = queue.pop();
        Assert.assertEquals("Unexpected value after pop", testValue, actualValue);
        Assert.assertEquals("Unexpected size of queue after pop", 0, queue.size());
    }
    
    @Test
    public void priorityQueuePeekTest() {
        queue.push(testValue);
        int actualValue = queue.peek();
        Assert.assertEquals("Unexpected value after peek", testValue, actualValue);
        Assert.assertEquals("Unexpected size of queue after peek", 1, queue.size());
    }
    
    @Test
    public void priorityQueueIsEmptyTest() {
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
    public void priorityQueueIsFullTest() {
        Assert.assertEquals("The queue shouldn't be full", false, queue.isFull());
        for (int i = 0; i < LENGTH; i++) {
            queue.push(testValue);
        }
        Assert.assertEquals("The queue should be full", true, queue.isFull());
    }
    
    @Test
    public void priorityQueuePriorityTest() {
        int[] expectedValues = {1, 2, 3, 4, 5};
        for (int i = LENGTH-1; i >= 0; i--) {
            queue.push(expectedValues[i]);
        }
        int[] actualValues = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            actualValues[i] = queue.pop();
        }
        Assert.assertArrayEquals("Wrong order of elements after getting by priority", actualValues, expectedValues);
    }
}
