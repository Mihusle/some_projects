package datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by MHSL on 09.04.2017.
 */
public class FirstLastLinkedListTest {
    
    private FirstLastLinkedList<Integer> linkedList;
    private int testValue;
    
    @Before
    public void setUp() {
        linkedList = new FirstLastLinkedList<>();
        testValue = 1;
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
        int anotherTestValue = 2;
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                linkedList.add(anotherTestValue);
            } else {
                linkedList.add(testValue);
            }
        }
        int actualValue = linkedList.get(5 - 3 - 1); //In order to take anotherTestValue from the list
        assertEquals("Unexpected value after get", anotherTestValue, actualValue);
        assertEquals("Unexpected size of the list after get", 5, linkedList.size());
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
        int anotherTestValue = 2;
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                linkedList.add(anotherTestValue);
            } else {
                linkedList.add(testValue);
            }
        }
        int actualValue = linkedList.remove(5 - 3 - 1); //In order to take anotherTestValue from the list.
        assertEquals("Unexpected value after remove", anotherTestValue, actualValue);
        assertEquals("Unexpected size of the list after remove", 4, linkedList.size());
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
        assertEquals("The list should be empty", true, linkedList.isEmpty());
        linkedList.add(testValue);
        assertEquals("The list shouldn't be empty", false, linkedList.isEmpty());
    }
}
