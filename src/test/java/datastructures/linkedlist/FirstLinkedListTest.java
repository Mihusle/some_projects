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
    private int anotherTestValue;
    
    @Before
    public void setUp() {
        linkedList = new FirstLinkedList<>();
        testValue = 1;
        anotherTestValue = 2;
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
        int expectedSize = 5, expectedPosition = 1;
        fillListWithAnotherValue(linkedList, expectedSize, expectedPosition);
        int actualValue = linkedList.get(expectedPosition);
        Assert.assertEquals("Unexpected value after get", anotherTestValue, actualValue);
        Assert.assertEquals("Unexpected size of the list after get", 5, linkedList.size());
    }
    
    @Test
    public void testRemove() {
        int size = 5, expectedSize = size - 1, expectedPosition = 1;
        fillListWithAnotherValue(linkedList, size, expectedPosition);
        int actualValue = linkedList.remove(expectedPosition);
        Assert.assertEquals("Unexpected value after remove", anotherTestValue, actualValue);
        Assert.assertEquals("Unexpected size of the list after remove", expectedSize, linkedList.size());
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
        Assert.assertTrue("The list should be empty", linkedList.isEmpty());
        linkedList.add(testValue);
        Assert.assertFalse("The list shouldn't be empty",linkedList.isEmpty());
    }
    
    private void fillListWithAnotherValue(FirstLinkedList<Integer> linkedList, int size, int expectedPosition) {
        for (int i = 0; i < size; i++) {
            //Elements are put in the beginning of the list. So it's necessary to calculate the index of an insertion.
            if (i == size - expectedPosition - 1) {
                linkedList.add(anotherTestValue);
            } else {
                linkedList.add(testValue);
            }
        }
    }
}
