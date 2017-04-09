package datastructures.linkedlist;

/**
 * Created by MHSL on 18.03.2017.
 *
 * This is a base interface of every linked list realization.
 */
public interface LinkedList<T> {
    
    T getFirst();
    
    void add(T element);
    
    /**
     * Get element with the according index from a linked list.
     * @param index - index of an element in a linked list.
     * @return element with the according index from a linked list.
     */
    T get(int index);
    
    /**
     * Remove element with the according index from a linked list.
     * @param index - index of an element in a linked list
     * @return element with the according index from a linked list.
     */
    T remove(int index);
    
    T removeFirst();
    
    int size();
    
    boolean isEmpty();
}
