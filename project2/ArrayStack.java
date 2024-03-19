//
// Name: Hakeem, Ayomide
// Project: #2
// Due: 19th March, 2024
// Course: cs-2400-03-sp24
//
// Description:
// This program takes in a list of infix expressions and converts 
// them to postfix expressions and evaluates them.
//

import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T item) {
        if (size == elements.length) {
            resize(2 * elements.length);
        }
        elements[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        T item = elements[--size];
        elements[size] = null; // to avoid loitering
        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        elements = Arrays.copyOf(elements, capacity);
    }
}
