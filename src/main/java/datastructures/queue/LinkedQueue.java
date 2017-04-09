package datastructures.queue;

import datastructures.linkedlist.FirstLastLinkedList;

/**
 * Created by MHSL on 09.04.2017.
 */
public class LinkedQueue<T> implements Queue<T> {
    
    private FirstLastLinkedList<T> linkedList;
    
    public LinkedQueue() {
        linkedList = new FirstLastLinkedList<>();
    }
    
    @Override
    public T pop() {
        return linkedList.removeFirst();
    }
    
    @Override
    public T peek() {
        return linkedList.getFirst();
    }
    
    @Override
    public void push(T element) {
        linkedList.addLast(element);
    }
    
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    
    @Override
    public int size() {
        return linkedList.size();
    }
}
