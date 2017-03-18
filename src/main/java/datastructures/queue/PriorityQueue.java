package datastructures.queue;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by MHSL on 17.03.2017.
 *
 * This is a simple realization of a priority queue with an array as a base.
 * In this realization elements is got from the lowest to the biggest.
 */
public class PriorityQueue<T> implements Queue<T>{
    
    private Comparator<T> comparator;
    private T[] array;
    private int size;
    
    public PriorityQueue(Class<T> clazz, int length, Comparator<T> comparator) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(clazz, length);
        this.array = array;
        this.comparator = comparator;
        size = 0;
    }
    
    @Override
    public T pop() {
        return array[--size];
    }
    
    @Override
    public T peek() {
        return array[size-1];
    }
    
    @Override
    public void push(T element) {
        if (!isFull()) {
            if (isEmpty()) {
                array[size++] = element;
            } else {
                int i;
                for (i = size - 1; i >= 0; i--) {
                    if (comparator.compare(element, array[i]) > 0) {
                        array[i+1] = array[i];
                    } else break;
                }
                array[i+1] = element;
                size++;
            }
        }
        //It should throw some exception otherwise.
    }
    
    public boolean isFull() {
        return size == array.length;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size() {
        return size;
    }
}
