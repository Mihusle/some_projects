package datastructures.linkedlist;

/**
 * Created by MHSL on 01.04.2017.
 */
public class FirstLastLinkedList<T> implements LinkedList<T> {
    
    private Entry<T> first, last;
    private int size;
    
    public FirstLastLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    @Override
    public T getFirst() {
        if (!isEmpty()) {
            return first.getElement();
        }
        return null;
    }
    
    public T getLast() {
        if (!isEmpty()) {
            return last.getElement();
        }
        return null;
    }
    
    @Override
    public T get(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                return first.getElement();
            } else {
                Entry<T> currentEntry = first;
                for (int i = 0; i < index; i++) {
                    currentEntry = currentEntry.getNext();
                }
                return currentEntry.getElement();
            }
        }
        return null;
    }
    
    @Override
    public void add(T element) {
        Entry<T> entry = new Entry<>(element);
        entry.setNext(first);
        first = entry;
        if (isEmpty()) {
            last = entry;
        }
        size++;
    }
    
    public void addLast(T element) {
        Entry<T> entry = new Entry<>(element);
        if (isEmpty()) {
            first = entry;
        } else {
            last.setNext(entry);
        }
        last = entry;
        size++;
    }
    
    @Override
    public T remove(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                Entry<T> temp = first;
                first = first.getNext();
                size--;
                return temp.getElement();
            } else {
                Entry<T> currentEntry = first;
                Entry<T> previousEntry = first;
                for (int i = 0; i < index; i++) {
                    previousEntry = currentEntry;
                    currentEntry = currentEntry.getNext();
                }
                previousEntry.setNext(currentEntry.getNext());
                size--;
                return currentEntry.getElement();
            }
        }
        return null;
    }
    
    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            T element = first.getElement();
            first = first.getNext();
            if (first == null) {
                last = null;
            }
            size--;
            return element;
        }
        return null;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    private class Entry<E> {
        
        private E element;
        private Entry<E> next;
        
        Entry(E element) {
            this.element = element;
        }
        
        E getElement() {
            return element;
        }
        
        void setElement(E element) {
            this.element = element;
        }
        
        Entry<E> getNext() {
            return next;
        }
        
        void setNext(Entry<E> next) {
            this.next = next;
        }
    }
}
