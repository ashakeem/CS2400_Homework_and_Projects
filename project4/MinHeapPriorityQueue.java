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

public final class MinHeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
    private T[] pqArray; // Array representing the priority queue
    private int lastIndex; // Index of the last entry
    private boolean integrityOK = false;

    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MinHeapPriorityQueue(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempPQ = (T[]) new Comparable[initialCapacity + 1];
        pqArray = tempPQ;
        lastIndex = 0;
        integrityOK = true;
    }

    public MinHeapPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T newEntry) {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while (parentIndex > 0 && newEntry.compareTo(pqArray[parentIndex]) < 0) {
            pqArray[newIndex] = pqArray[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        pqArray[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    @Override
    public T removeMin() {
        checkIntegrity();
        T root = null;
        if (!isEmpty()) {
            root = pqArray[1];
            pqArray[1] = pqArray[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    @Override
    public T getMin() {
        checkIntegrity();
        return !isEmpty() ? pqArray[1] : null;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex < 1;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void clear() {
        checkIntegrity();
        while (lastIndex > -1) {
            pqArray[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }

    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = pqArray[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && (leftChildIndex <= lastIndex)) {
            int smallerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex <= lastIndex &&
                pqArray[rightChildIndex].compareTo(pqArray[smallerChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(pqArray[smallerChildIndex]) > 0) {
                pqArray[rootIndex] = pqArray[smallerChildIndex];
                rootIndex = smallerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else {
                done = true;
            }
        }
        pqArray[rootIndex] = orphan;
    }

    private void ensureCapacity() {
        if (lastIndex >= pqArray.length - 1) {
            int newLength = Math.min(pqArray.length * 2, MAX_CAPACITY);
            pqArray = java.util.Arrays.copyOf(pqArray, newLength);
        }
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("Priority queue is not initialized properly.");
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a priority queue exceeding the allowed capacity.");
        }
    }
}
