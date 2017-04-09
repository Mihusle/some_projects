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
        Assert.assertEquals("Unexpected value after ger first", testValue, actualValue);
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
        int actualValue = linkedList.get(5 - 3 - 1); //In order to take anotherTestValue from the list
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
        int actualValue = linkedList.remove(5 - 3 - 1); //In order to take anotherTestValue from the list.
        Assert.assertEquals("Unexpected value after remove", anotherTestValue, actualValue);
        Assert.assertEquals("Unexpected size of the list after remove", 4, linkedList.size());
    }
    
    @Test
    public void testRemoveFirst() {
        int anotherTestValue = 2;
        int expectedSize = 1;
        linkedList.add(anotherTestValue);
        linkedList.add(testValue);
        int actualValue = linkedList.removeFirst();
        Assert.assertEquals("Unexpected value after removing the first element", testValue, actualValue);
        Assert.assertEquals("Unexpected first element in the list after removing the first element", Integer.valueOf(anotherTestValue), linkedList.getFirst());
        Assert.assertEquals("Unexpected size of the list after removing the first element", expectedSize, linkedList.size());
    }
    
    @Test
    public void testIsEmpty() {
        Assert.assertEquals("The list should be empty", true, linkedList.isEmpty());
        linkedList.add(testValue);
        Assert.assertEquals("The list shouldn't be empty", false, linkedList.isEmpty());
    }
}
