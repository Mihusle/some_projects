package datastructures.stack;

import datastructures.linkedlist.FirstLinkedList;

/**
 * Created by MHSL on 09.04.2017.
 */
public class LinkedStack<T> implements Stack<T> {
    
    private FirstLinkedList<T> linkedList;
    
    public LinkedStack() {
        linkedList = new FirstLinkedList<>();
    }
    
    @Override
    public void push(T element) {
        linkedList.add(element);
    }
    
    @Override
    public T peek() {
        return linkedList.getFirst();
    }
    
    @Override
    public T pop() {
        return linkedList.removeFirst();
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
