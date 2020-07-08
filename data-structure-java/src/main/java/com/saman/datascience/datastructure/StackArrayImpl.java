package com.saman.datascience.datastructure;

import java.lang.reflect.Array;

/**
 * @author Saman Alishirishahrbabak
 */
public class StackArrayImpl<T> implements Stack<T> {

    private T[] array;

    private int top = -1;
    private int capacity;

    public StackArrayImpl(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) Array.newInstance(Object[].class.getComponentType(), capacity);
    }

    public StackArrayImpl() {
        this(10);
    }

    @Override
    public void push(T item) {
        top++;
        if (isFull())
            throw new RuntimeException("stack is full");

        array[top] = item;
    }

    @Override
    public T pop() {

        if (isEmpty())
            throw new RuntimeException("stack is empty");

        T item = array[top];

        array[top] = null;
        top--;

        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("stack is empty");

        return array[top];
    }

    @Override
    public int top() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity;
    }

    @Override
    public void clear() {
        this.array = (T[]) Array.newInstance(Object[].class.getComponentType(), capacity);
    }
}
