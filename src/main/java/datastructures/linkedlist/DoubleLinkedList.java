package datastructures.linkedlist;

/**
 * Created by MHSL on 26.04.2017.
 */
public class DoubleLinkedList<T> implements LinkedList<T> {
    private Entry<T> first, last;
    private int size;
    
    @Override
    public T getFirst() {
        return first.getElement();
    }
    
    public T getLast() {
        return last.getElement();
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
    public void add(T element) {
        Entry<T> entry = new Entry<>(element);
        if (isEmpty()) {
            last = entry;
        } else {
            first.setPrevious(entry);
        }
        entry.setNext(first);
        first = entry;
        size++;
    }
    
    public void addAfter(int index, T element) {
        if (index == size - 1) {
            addLast(element);
        } else {
            Entry<T> entry = new Entry<>(element);
            Entry<T> currentEntry = findEntryWithIndex(index);
            Entry<T> nextEntry = currentEntry.getNext();
            currentEntry.setNext(entry);
            entry.setPrevious(currentEntry);
            nextEntry.setPrevious(entry);
            entry.setNext(nextEntry);
            size++;
        }
    }
    
    public void addLast(T element) {
        Entry<T> entry = new Entry<>(element);
        if (isEmpty()) {
            first = entry;
        } else {
            last.setNext(entry);
            entry.setPrevious(last);
        }
        last = entry;
        size++;
    }
    
    @Override
    public T remove(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                return removeFirst();
            } else if (index == size - 1) {
                return removeLast();
            } else {
                Entry<T> removedEntry = findEntryWithIndex(index);
                Entry<T> previousEntry = removedEntry.getPrevious();
                Entry<T> nextEntry = removedEntry.getNext();
                previousEntry.setNext(nextEntry);
                nextEntry.setPrevious(previousEntry);
                size--;
                return removedEntry.getElement();
            }
        }
        return null;
    }
    
    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            T element = first.getElement();
            if (first.getNext() == null) {
                last = null;
            } else {
                first.getNext().setPrevious(null);
            }
            first = first.getNext();
            size--;
            return element;
        }
        return null;
    }
    
    public T removeLast() {
        if (!isEmpty()) {
            T element = last.getElement();
            if (last.getPrevious() == null) {
                first = null;
            } else {
                last.getPrevious().setNext(null);
            }
            last = last.getPrevious();
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
    
    private Entry<T> findEntryWithIndex(int index) {
        Entry<T> currentEntry = first;
        for (int i = 0; i < index; i++) {
            currentEntry = currentEntry.getNext();
        }
        return currentEntry;
    }
    
    private class Entry<E> {
        private E element;
        private Entry<E> next;
        private Entry<E> previous;
        
        Entry(E element) {
            this.element = element;
        }
    
        public E getElement() {
            return element;
        }
    
        public void setElement(E element) {
            this.element = element;
        }
    
        public Entry<E> getNext() {
            return next;
        }
    
        public void setNext(Entry<E> next) {
            this.next = next;
        }
    
        public Entry<E> getPrevious() {
            return previous;
        }
    
        public void setPrevious(Entry<E> previous) {
            this.previous = previous;
        }
    }
}
