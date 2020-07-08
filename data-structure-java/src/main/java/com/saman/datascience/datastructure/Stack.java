package com.saman.datascience.datastructure;


/**
 * @param <T> the item type
 * @author Saman Alishirishahrbabak
 */
public interface Stack<T> {

    /**
     * Pushes an element on the top of the stack.
     *
     * @param item supposed to add to the stack
     */
    void push(T item);

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     */
    T pop();

    /**
     * Returns the element on the top of the stack, but does not remove it.
     *
     * @return an object that pushed as a last element
     */
    T peek();

    /**
     * Return top index.
     *
     * @return an integer that show last index
     */
    int top();

    /**
     * Check the stack is empty or no. Return {@code true} if there is no element, otherwise
     * return {@code false}
     *
     * @return {@code true} if there is no element, otherwise return {@code false}
     */
    boolean isEmpty();

    /**
     * Check the stack is full or no. Return {@code true} if stack is full, otherwise
     * return {@code false}
     *
     * @return {@code true} if stack is full, otherwise return {@code false}
     */
    boolean isFull();

    void clear();
}
