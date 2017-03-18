package datastructures.queue;

/**
 * Created by MHSL on 18.03.2017.
 *
 * This is a base interface of any queue
 */
public interface Queue<T> {
    
    T pop();
    T peek();
    void push(T element);
    boolean isEmpty();
    int size();
}
