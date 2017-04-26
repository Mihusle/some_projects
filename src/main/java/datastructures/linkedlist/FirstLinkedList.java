package datastructures.linkedlist;


/**
 * Created by MHSL on 18.03.2017.
 *
 * This is the realization of a linked list with access only from the beginning.
 */
public class FirstLinkedList<T> implements LinkedList<T> {
    
    protected Entry<T> first;
    protected int size;
    
    /*I couldn't make this constructor, but it shows meaning of initial value clearly.*/
    public FirstLinkedList() {
        first = null;
        size = 0;
    }
    
    @Override
    public T getFirst() {
        if (!isEmpty()) {
            return first.getElement();
        }
        return null;
    }
    
    @Override
    public void add(T element) {
        Entry<T> entry = new Entry<>(element);
        entry.setNext(first);
        first = entry;
        size++;
    }
    
    @Override
    public T get(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                return first.getElement();
            } else {
                return findEntryWithIndex(index).getElement();
            }
        }
        return null;
    }
    
    @Override
    public T remove(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                removeFirst();
            } else {
                Entry<T> previousEntry = first;
                Entry<T> currentEntry = first;
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
        return first == null && size == 0;
    }
    
    private Entry<T> findEntryWithIndex(int index) {
        Entry<T> currentEntry = first;
        for (int i = 0; i < index; i++) {
            currentEntry = currentEntry.getNext();
        }
        return currentEntry;
    }
    
    protected class Entry<E> {
        
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
