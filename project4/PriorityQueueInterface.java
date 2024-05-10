
//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/08/2024
// Course: cs-2400-03-sp24
//
// Description:
// Distances and Shortest Path between Airports
//


/** An interface for the ADT priority queue. */

// PriorityQueueInterface.java
public interface PriorityQueueInterface<T extends Comparable<? super T>> {
    /**
     * Add an element to the priority queue with a specified priority.
     * 
     * @param value The value to be added.
     * @param priority The priority of the element to be added.
     */
    void add(T value, int priority);

    /**
     * Removes and returns the smallest element (according to the min-heap property) from the priority queue.
     * 
     * @return The value of the smallest element.
     * @throws IllegalStateException if the priority queue is empty.
     */
    T removeMin();

    /**
     * Returns (without removing) the smallest element (according to the min-heap property) from the priority queue.
     * 
     * @return The value of the smallest element.
     * @throws IllegalStateException if the priority queue is empty.
     */
    T getMin();

    /**
     * Returns whether the priority queue is empty.
     * 
     * @return True if the priority queue is empty, false otherwise.
     */
    boolean isEmpty();
}

