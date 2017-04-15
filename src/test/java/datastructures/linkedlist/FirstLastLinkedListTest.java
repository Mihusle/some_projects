package datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by MHSL on 09.04.2017.
 */
public class FirstLastLinkedListTest {
    
    private FirstLastLinkedList<Integer> linkedList;
    private int testValue;
    private int anotherTestValue;
    
    @Before
    public void setUp() {
        linkedList = new FirstLastLinkedList<>();
        testValue = 1;
        anotherTestValue = 2;
    }
    
    @Test
    public void testGetFirst() {
        linkedList.add(testValue);
        int actualValue = linkedList.getFirst();
        assertEquals("Unexpected value after getting the first element", testValue, actualValue);
        assertEquals("Unexpected size of the list after getting the first element", 1, linkedList.size());
    }
    
    @Test
    public void testGetLast() {
        int anotherTestValue = 2;
        linkedList.add(anotherTestValue);
        linkedList.add(testValue);
        int actualValue = linkedList.getLast();
        assertEquals("Unexpected value after getting the last element", anotherTestValue, actualValue);
        assertEquals("Unexpected size of the list after getting the last element", 2, linkedList.size());
    }
    
    @Test
    public void testGet() {
        int expectedPosition = 1, expectedSize = 5;
        fillListWithAnotherValue(linkedList, expectedSize, expectedPosition);
        int actualValue = linkedList.get(expectedPosition);
        assertEquals("Unexpected value after get", anotherTestValue, actualValue);
        assertEquals("Unexpected size of the list after get", expectedSize, linkedList.size());
    }
    
    @Test
    public void testAdd() {
        assertEquals("Unexpected initial size of the list", 0, linkedList.size());
        linkedList.add(testValue);
        assertEquals("Unexpected size of the list after add", 1, linkedList.size());
    }
    
    @Test
    public void testAddLast() {
        assertEquals("Unexpected initial size of the list", 0, linkedList.size());
        linkedList.addLast(testValue);
        assertEquals("Unexpected size of the list after adding in the end", 1, linkedList.size());
        
        int anotherTestValue = 2;
        linkedList.addLast(anotherTestValue);
        int actualValue = linkedList.getLast();
        assertEquals("Unexpected value in the end of the list", anotherTestValue, actualValue);
    }
    
    @Test
    public void testRemove() {
        int expectedPosition = 1, size = 5, expectedSize = size - 1;
        fillListWithAnotherValue(linkedList, size, expectedPosition);
        int actualValue = linkedList.remove(expectedPosition);
        assertEquals("Unexpected value after remove", anotherTestValue, actualValue);
        assertEquals("Unexpected size of the list after remove", expectedSize, linkedList.size());
    }
    
    @Test
    public void testRemoveFirst() {
        int anotherTestValue = 2;
        int expectedSize = 1;
        linkedList.add(anotherTestValue);
        linkedList.add(testValue);
        int actualValue = linkedList.removeFirst();
        assertEquals("Unexpected value after removing the first element", testValue, actualValue);
        assertEquals("Unexpected first element in the list after removing the first element", Integer.valueOf(anotherTestValue), linkedList.getFirst());
        assertEquals("Unexpected size of the list after removing the first element", expectedSize, linkedList.size());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue("The list should be empty", linkedList.isEmpty());
        linkedList.add(testValue);
        assertFalse("The list shouldn't be empty", linkedList.isEmpty());
    }
    
    private void fillListWithAnotherValue(FirstLastLinkedList<Integer> linkedList, int size, int expectedPosition) {
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
