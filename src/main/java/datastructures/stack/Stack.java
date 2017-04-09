package datastructures.stack;

/**
 * Created by MHSL on 09.04.2017.
 */
public interface Stack<T> {
    
    void push(T element);
    T peek();
    T pop();
    boolean isEmpty();
    int size();
}
