
//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/08/2024
// Course: cs-2400-03-sp24
//
// Description:
// Distances and Shortest Path between Airports
//


import java.util.Arrays;

// PriorityQueue.java
public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private EntryPQ<T>[] heap;
    private int size;

    // Constructor to initialize the heap with the default capacity
    public PriorityQueue() {
        this.heap = new EntryPQ[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Inner class for priority queue entries
    private static class EntryPQ<T> implements Comparable<EntryPQ<T>> {
        private final T value;
        private final int priority;

        public EntryPQ(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public T getValue() {
            return value;
        }

        @Override
        public int compareTo(EntryPQ<T> other) {
            return Integer.compare(this.priority, other.priority);
        }
    }

    // Add an entry to the priority queue
    @Override
    public void add(T value, int priority) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = new EntryPQ<>(value, priority);
        siftUp(size);
        size++;
    }

    // Remove and return the minimum (smallest priority) element
    @Override
    public T removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        EntryPQ<T> minEntry = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return minEntry.getValue();
    }

    // Get the minimum (smallest priority) element without removing it
    @Override
    public T getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        return heap[0].getValue();
    }

    // Check if the priority queue is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Move up an element to maintain heap property
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index].compareTo(heap[parentIndex]) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // Move down an element to maintain heap property
    private void siftDown(int index) {
        while (index < size / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (heap[index].compareTo(heap[smallerChildIndex]) <= 0) {
                break;
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    // Swap two entries in the heap array
    private void swap(int i, int j) {
        EntryPQ<T> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Resize the array to double its capacity
    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }
}
