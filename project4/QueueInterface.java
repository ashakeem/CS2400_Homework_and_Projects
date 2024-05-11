//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//

public interface QueueInterface<T> {

    /**
     * Adds a new entry to the back of this queue.
     *
     * @param newEntry An object to be added.
     */
    public void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront();

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty.
     */
    public boolean isEmpty();

    /** Removes all entries from this queue. */
    public void clear();
}

    
