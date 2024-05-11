//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//

import java.util.Arrays;
import java.util.EmptyStackException;

/** A class of stacks whose entries are stored in an array. */
public final class ArrayStack<T> implements StackInterface<T> {
    private T[] stack; // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor
      // < Implementations of the stack operations go here. >
      // . . .

    public void push(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    private void ensureCapacity() {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    public T peek() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public T pop() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public boolean isEmpty() {
        return topIndex < 0;
    } // end isEmpty

    public void clear() {
        checkIntegrity();
        while (topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        } // end while
    } // end clear


    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayStack object is corrupt.");
    } // end checkIntegrity

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException(
                    "Attempt to create a stack " + "whose capacity exceeds " + "allowed maximum.");
    } // end checkCapacity




}
// end ArrayStack
