package datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MHSL on 26.04.2017.
 */
public class DoubleLinkedListTest {
    
    private DoubleLinkedList<Integer> linkedList;
    private int expectedValue = 1;
    private int anotherExpectedValue = 2;
    
    @Before
    public void setUp() {
        linkedList = new DoubleLinkedList<>();
    }
    
    @Test
    public void testGetFirst() {
        linkedList.add(expectedValue);
        linkedList.add(anotherExpectedValue);
        int actualValue = linkedList.getFirst();
        assertEquals("Unexpected value of the first element of the linked list", anotherExpectedValue, actualValue);
    }
    
    @Test
    public void testGetLast() {
        linkedList.add(expectedValue);
        linkedList.add(anotherExpectedValue);
        int actualValue = linkedList.getLast();
        assertEquals("Unexpected value of the last element of the linked list", expectedValue, actualValue);
    }
    
    @Test
    public void testGet() {
        int position = 1;
        linkedList.add(expectedValue);
        linkedList.add(anotherExpectedValue);
        linkedList.add(expectedValue);
        int actualValue = linkedList.get(position);
        assertEquals(String.format("Unexpected value of the element on position %d", position), anotherExpectedValue, actualValue);
    }
    
    @Test
    public void testAdd() {
        int expectedSize = 1;
        linkedList.add(expectedValue);
        assertFalse("The linked list shouldn't be empty", linkedList.isEmpty());
        assertEquals("Unexpected size of the linked list", expectedSize, linkedList.size());
    }
    
    @Test
    public void testAddAfter() {
        int expectedSize = 3, position = 1;
        linkedList.add(expectedValue);
        linkedList.add(expectedValue);
        linkedList.addAfter(0, anotherExpectedValue);
        int actualValue = linkedList.get(position);
        assertEquals(String.format("Unexpected value of the element on position %d", position), anotherExpectedValue, actualValue);
        assertEquals("Unexpected size of the linked list", expectedSize, linkedList.size());
    }
    
    @Test
    public void testAddLast() {
        int expectedSize = 2;
        linkedList.add(anotherExpectedValue);
        linkedList.addLast(expectedValue);
        int actualValue = linkedList.getLast();
        assertEquals("Unexpected value of the last element of the linked list", expectedValue, actualValue);
        assertEquals("Unexpected size of the linked list", expectedSize, linkedList.size());
    }
    
    @Test
    public void testRemove() {
        int expectedSize = 2, position = 1;
        linkedList.add(expectedValue);
        linkedList.add(anotherExpectedValue);
        linkedList.add(expectedValue);
        int actualValue = linkedList.remove(position);
        assertEquals(String.format("Unexpected value of the element from the position %d", position), anotherExpectedValue, actualValue);
        assertEquals("Unexpected size of the linked list", expectedSize, linkedList.size());
        for (int i = 0; i < expectedSize; i++) {
            int actualValueOnCurrentPosition = linkedList.get(i);
            assertEquals(String.format("Unexpected element of the position %d", i), expectedValue, actualValueOnCurrentPosition);
        }
    }
    
    @Test
    public void testRemoveFirst() {
        int expectedSize = 1;
        linkedList.add(anotherExpectedValue);
        linkedList.add(expectedValue);
        int actualValue = linkedList.removeFirst();
        assertEquals("Unexpected value of the first element after removing", expectedValue, actualValue);
        assertEquals("Unexpected size of the linked list", expectedSize, linkedList.size());
    }
    
    @Test
    public void testRemoveLast() {
        int expectedSize = 1;
        linkedList.add(expectedValue);
        linkedList.add(anotherExpectedValue);
        int actualValue = linkedList.removeLast();
        assertEquals("Unexpected value of the last element after removing", expectedValue, actualValue);
        assertEquals("Unexpected size of the linked list", expectedSize, linkedList.size());
    }
}
