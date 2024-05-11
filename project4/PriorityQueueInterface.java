//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//


/** An interface for the ADT priority queue. */

/**
 * The PriorityQueueInterface represents the interface for a priority queue data structure.
 * A priority queue is a collection of elements where each element has a priority associated with it.
 * Elements with higher priority are dequeued before elements with lower priority.
 * This interface provides methods to add elements, remove the minimum element, get the minimum element,
 * check if the priority queue is empty, get the size of the priority queue, and clear the priority queue.
 *
 * @param <T> The type of elements stored in the priority queue.
 */
 
 
public interface PriorityQueueInterface<T extends Comparable<? super T>> {

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param newEntry the element to add
     */
    void add(T newEntry);

    /**
     * Retrieves and removes the minimum element of this priority queue.
     *
     * @return the minimum element of this priority queue
     */
    T removeMin();

    /**
     * Retrieves, but does not remove, the minimum element of this priority queue.
     *
     * @return the minimum element of this priority queue, or null if this queue is empty
     */
    T getMin();

    /**
     * Returns true if this priority queue contains no elements.
     *
     * @return true if this priority queue contains no elements
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this priority queue.
     *
     * @return the number of elements in this priority queue
     */
    int getSize();

    /**
     * Removes all of the elements from this priority queue.
     */
    void clear();
}