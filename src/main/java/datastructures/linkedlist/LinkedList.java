package datastructures.linkedlist;

/**
 * Created by MHSL on 18.03.2017.
 *
 * This is a base interface of every linked list realization.
 */
public interface LinkedList<T> {
    
    /**
     * @return first element of a linked list
     */
    T getFirst();
    
    /**
     * Add new element in a linked list.
     * @param element - element which will be added in a linked list.
     */
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
    
    /**
     * @return size of a linked list
     */
    int size();
    
    /**
     * @return true if a linked list is empty
     *         false if the linked list isn't empty*/
    boolean isEmpty();
}
