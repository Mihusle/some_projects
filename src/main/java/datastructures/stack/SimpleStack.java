package datastructures.stack;

import java.lang.reflect.Array;

/**
 * Created by MHSL on 15.03.2017.
 *
 * This is a realization of the stack with array as a base. So size of this stack is fixed.
 */
public class SimpleStack<T> {
    
    private T[] array;
    private int currentPosition;
    
    public SimpleStack(Class<T> clazz, int length) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(clazz, length);
        this.array = array;
        currentPosition = 0;
    }
    
    public void push(T element) {
        if (!isFull()) {
            array[currentPosition++] = element;
        }
    }
    
    public T peek() {
        if (!isEmpty()) {
            T element = array[--currentPosition];
            currentPosition++;
            return element;
        }
        return null;
    }
    
    public T pop() {
        if (!isEmpty()) {
            return array[--currentPosition];
        }
        return null;
    }
    
    public boolean isFull() {
        return currentPosition == array.length;
    }
    
    public boolean isEmpty() {
        return currentPosition == 0;
    }
    
    public int size() {
        return currentPosition;
    }
}
