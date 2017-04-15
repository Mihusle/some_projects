package datastructures.linkedlist;

import java.util.Comparator;

/**
 * Created by MHSL on 15.04.2017.
 */
public class SortedLinkedList<T extends Comparable<T>> extends FirstLinkedList<T> {
    private Comparator<T> comparator;
    
    public SortedLinkedList() {
        first = null;
        size = 0;
        comparator = (Comparable::compareTo);
    }
    
    public SortedLinkedList(Comparator<T> comparator) {
        this();
        this.comparator = comparator;
    }
    
    @Override
    public void add(T element) {
        Entry<T> previous = null;
        Entry<T> current = first;
        Entry<T> newEntry = new Entry<>(element);
        while (current != null && comparator.compare(current.getElement(), element) < 0) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            first = newEntry;
        } else {
            previous.setNext(newEntry);
        }
        newEntry.setNext(current);
        size++;
    }
}
