package datastructures.stack;

import java.lang.reflect.Array;

/**
 * Created by MHSL on 15.03.2017.
 *
 * This is a realization of the stack with array as a base. So size of this stack is fixed.
 */
public class SimpleStack<T> implements Stack<T> {
    
    private T[] array;
    private int currentPosition;
    
    public SimpleStack(Class<T> clazz, int length) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(clazz, length);
        this.array = array;
        currentPosition = 0;
    }
    
    @Override
    public void push(T element) {
        if (!isFull()) {
            array[currentPosition++] = element;
        }
        //It should throw some exception otherwise.
    }
    
    @Override
    public T peek() {
        if (!isEmpty()) {
            T element = array[currentPosition-1];
            return element;
        }
        return null;
    }
    
    @Override
    public T pop() {
        if (!isEmpty()) {
            return array[--currentPosition];
        }
        return null;
    }
    
    public boolean isFull() {
        return currentPosition == array.length;
    }
    
    @Override
    public boolean isEmpty() {
        return currentPosition == 0;
    }
    
    @Override
    public int size() {
        return currentPosition;
    }
}
