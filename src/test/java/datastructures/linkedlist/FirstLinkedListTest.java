package datastructures.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MHSL on 25.03.2017.
 */
public class FirstLinkedListTest {
    
    private FirstLinkedList<Integer> linkedList;
    private int testValue;
    
    @Before
    public void setUp() {
        linkedList = new FirstLinkedList<>();
        testValue = 1;
    }
    
    @Test
    public void testGetFirst() {
        linkedList.add(testValue);
        int actualValue = linkedList.getFirst();
        Assert.assertEquals("Unexpected size of the list after get first", 1, linkedList.size());
        Assert.assertEquals("Unexpected value after ger first", actualValue, testValue);
    }
    
    @Test
    public void testAdd() {
        Assert.assertEquals("Unexpected initial size of the list", 0, linkedList.size());
        linkedList.add(testValue);
        Assert.assertEquals("Unexpected size of the list after add", 1, linkedList.size());
    }
    
    @Test
    public void testGet() {
        int anotherTestValue = 2;
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                linkedList.add(anotherTestValue);
            } else {
                linkedList.add(testValue);
            }
        }
        int actualValue = linkedList.get(5 - 3 - 1);
        Assert.assertEquals("Unexpected value after get", anotherTestValue, actualValue);
        Assert.assertEquals("Unexpected size of the list after get", 5, linkedList.size());
    }
    
    @Test
    public void testRemove() {
        int anotherTestValue = 2;
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                linkedList.add(anotherTestValue);
            } else {
                linkedList.add(testValue);
            }
        }
        int actualValue = linkedList.remove(5 - 3 - 1);
        Assert.assertEquals("Unexpected value after remove", anotherTestValue, actualValue);
        Assert.assertEquals("Unexpected size of the list after remove", 4, linkedList.size());
    }
    
    @Test
    public void testIsEmpty() {
        Assert.assertEquals("The list should be empty", linkedList.isEmpty(), true);
        linkedList.add(testValue);
        Assert.assertEquals("The list shouldn't be empty", linkedList.isEmpty(), false);
    }
}
