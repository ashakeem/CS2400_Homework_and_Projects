//
// Name: Hakeem, Ayomide
// Project: 3
// Due: 03/29/2024
// Course: cs-2400-03-sp24
//
// Description: This program reads a text file and counts the frequency of each word in the file. It then prints  the frequency of each word in the file. 
// The program also prints the number of unique words in the file and the number of collisions that occurred when adding the words to the dictionary. 
// 
// 
//


import java.util.Iterator;

/**
 * Defines the structure for a dictionary data type.
 * @param <K> Represents the type of keys.
 * @param <V> Represents the type of values.
 */
public interface DictionaryInterface<K, V> {

    /**
     * Inserts a new entry into the dictionary. If the key already exists,
     * the corresponding value is updated with the new entry.
     * @param key The key of the new entry.
     * @param value The value associated with the key.
     * @return The value being replaced. If there is no existing value, returns null.
     */
    public V add(K key, V value);

    /**
     * Deletes a specific entry from the dictionary using a key.
     * @param key The key of the entry to be deleted.
     * @return The value associated with the key. If there is no such value, returns null.
     */
    public V remove(K key);

    /**
     * Fetches a value associated with the given key.
     * @param key The key of the value to be fetched.
     * @return The value associated with the key. If there is no such entry, returns null.
     */
    public V getValue(K key);

    /**
     * Checks if a specific entry exists in the dictionary.
     * @param key The key of the desired entry.
     * @return True if the key is associated with an entry in the dictionary.
     */
    public boolean contains(K key);

    /**
     * Generates an iterator to traverse the keys in the dictionary.
     * @return An iterator that provides sequential access to the keys in the dictionary.
     */
    public Iterator<K> getKeyIterator();

    /**
     * Generates an iterator to traverse the values in the dictionary.
     * @return An iterator that provides sequential access to the values in the dictionary.
     */
    public Iterator<V> getValueIterator();

    /**
     * Checks if the dictionary is empty.
     * @return True if the dictionary has no entries.
     */
    public boolean isEmpty();

    /**
     * Retrieves the number of entries in the dictionary.
     * @return The count of entries, or key-value pairs, in the dictionary.
     */
    public int getSize();

    /**
     * Removes all entries from the dictionary.
     */
    public void clear();

    /**
     * Returns the count of collisions that occur in the dictionary.
     * @return The count of collisions.
     */
    public int getCollisionCount();

    /**
     * Retrieves the count of unique words in the dictionary.
     * @return The count of unique words in the dictionary.
     */
    public int getUniqueWordCount();
}