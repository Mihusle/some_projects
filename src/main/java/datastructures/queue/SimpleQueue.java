package datastructures.queue;

import java.lang.reflect.Array;

/**
 * Created by MHSL on 17.03.2017.
 *
 * This is a simple realization of the queue with an array as a base.
 */
public class SimpleQueue<T> implements Queue<T>{
    
    private int front;
    private int index;
    private T[] array;
    private int size;
    
    public SimpleQueue(Class<T> clazz, int length) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(clazz, length);
        this.array = array;
        front = 0;
        index = -1;
        size = 0;
    }
    
    @Override
    public void push(T element) {
        if (!isFull()) {
            if (index == array.length - 1) {
                index = -1;
            }
            array[++index] = element;
            size++;
        }
        //It should throw some exception otherwise.
    }
    
    @Override
    public T pop() {
        if (!isEmpty()) {
            if (front == array.length) {
                front = 0;
            }
            size--;
            return array[front++];
        }
        return null;
    }
    
    @Override
    public T peek() {
        if (!isEmpty()) {
            return array[front];
        }
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == array.length;
    }
    
    @Override
    public int size() {
        return size;
    }
}
