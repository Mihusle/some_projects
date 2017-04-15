package datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;
/**
 * Created by MHSL on 15.04.2017.
 */
public class SortedLinkedListTest {
    
    private SortedLinkedList<Integer> linkedList;
    
    @Before
    public void setUp() {
        linkedList = new SortedLinkedList<>();
    }
    
    @Test
    public void testAddWithDefaultComparator() {
        Integer[] expectedElements = new Integer[5], actualElements = new Integer[5];
        fillExpectedArrayAndList(expectedElements, linkedList);
        Arrays.sort(expectedElements);
        fillActualArray(actualElements, linkedList);
        assertArrayEquals("Unexpected elements positions after adding with a default comparator", expectedElements, actualElements);
    }
    
    @Test
    public void testAddWithCustomComparator() {
        Comparator<Integer> comparator = (first, second) -> second - first;
        linkedList = new SortedLinkedList<>(comparator);
        Integer[] expectedElements = new Integer[5], actualElements = new Integer[5];
        fillExpectedArrayAndList(expectedElements, linkedList);
        Arrays.sort(expectedElements, comparator);
        fillActualArray(actualElements, linkedList);
        assertArrayEquals("Unexpected elements positions after adding with a custom comparator", expectedElements, actualElements);
    }
    
    private void fillExpectedArrayAndList(Integer[] expectedElements, SortedLinkedList<Integer> linkedList) {
        for (int i = 0; i < expectedElements.length; i++) {
            int randomValue = (int) (Math.random() * 99);
            expectedElements[i] = randomValue;
            linkedList.add(randomValue);
        }
    }
    
    private void fillActualArray(Integer[] actualElements, SortedLinkedList<Integer> linkedList) {
        int i = 0;
        while (!linkedList.isEmpty()) {
            actualElements[i++] = linkedList.removeFirst();
        }
    }
}
