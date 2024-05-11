//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//

import java.util.Iterator;

/**
 * Interface for a dictionary.
 *
 * @param <K> The type of keys stored in the dictionary.
 * @param <V> The type of values stored in the dictionary.
 */
public interface DictionaryInterface<K, V> {

    /**
     * Adds a new entry to this dictionary.
     *
     * @param key   The key for the new entry.
     * @param value The value for the new entry.
     */
    void add(K key, V value);

    /**
     * Retrieves the value associated with a given key.
     *
     * @param key The key of the entry to retrieve.
     * @return The value associated with the key, or null if no such key exists.
     */
    V get(K key);

    /**
     * Removes an entry from this dictionary.
     *
     * @param key The key of the entry to remove.
     * @return The value that was associated with the key, or null if no such key
     *         existed.
     */
    V remove(K key);

    /**
     * Checks if this dictionary contains a given key.
     *
     * @param key The key to check for.
     * @return True if the key is in the dictionary, false otherwise.
     */
    boolean containsKey(K key);

    /**
     * Gets the number of entries in this dictionary.
     *
     * @return The number of entries in the dictionary.
     */
    int size();

    /**
     * Gets an iterator that provides sequential access to the values in this
     * dictionary.
     *
     * @return An iterator that provides sequential access to the values in this
     *         dictionary.
     */
    Iterator<V> getValueIterator();
}