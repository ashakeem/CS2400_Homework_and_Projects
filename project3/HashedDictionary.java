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

// HashedDictionary class implementing DictionaryInterface
public class HashedDictionary<K, V> implements DictionaryInterface<K, V> {
    // Array of Entry objects for storing key-value pairs
    protected Entry<K, V>[] hashDictionary;
    // Number of entries in the dictionary
    private int numberOfEntries;
    // Number of collisions occurred during hash operations
    private int collisionCount;
    // Capacity of the dictionary
    private int capacity;
    // Count of unique words in the dictionary
    private int uniqueWordCount = 0;
    // Default capacity of the dictionary
    private static final int DEFAULT_CAPACITY = 31;
    // Entry object representing an available slot in the dictionary
    protected final Entry<K, V> AVAILABLE = new Entry<>(null, null);

    // Default constructor initializing the dictionary with default capacity
    public HashedDictionary() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor initializing the dictionary with given initial capacity
    public HashedDictionary(int initialCapacity) {
        capacity = initialCapacity;
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        // Creating an array of Entry objects
        Entry<K, V>[] temp = (Entry<K, V>[]) new Entry[initialCapacity];
        hashDictionary = temp;
        collisionCount = 0;
    }

    // Inner class representing an entry in the dictionary
    private class Entry<K, V> {
        private K key;
        private V value;

        // Constructor initializing the entry with given key and value
        private Entry(K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
        }

        // Method to get the key of the entry
        private K getKey() {
            return key;
        }

        // Method to get the value of the entry
        private V getValue() {
            return value;
        }

        // Method to set the value of the entry
        private void setValue(V newValue) {
            value = newValue;
        }
    }

    // Inner class for iterating over the keys in the dictionary
    private class KeyIterator<T> implements Iterator<K> {
        private int currentIndex;
        private int numberLeft;

        // Constructor initializing the iterator
        private KeyIterator() {
            currentIndex = 0;
            numberLeft = 0;
            for (Entry<K, V> entry : hashDictionary) {
                if (entry != null) {
                    numberLeft++;
                }
            }
        }

        // Method to check if there are more keys to iterate over
        public boolean hasNext() {
            return currentIndex < numberLeft;
        }

        // Method to get the next key in the iteration
        public K next() {
            K result;
            while ((hashDictionary[currentIndex] == null) && (currentIndex < capacity)) {
                currentIndex++;
            }
            if (currentIndex < capacity) {
                result = hashDictionary[currentIndex].getKey();
                currentIndex++;
            } else {
                throw new RuntimeException("Can not call next");
            }

            return result;
        }
    }

    // Method to get the hash index of a given key
    private int getHashIndex(K key) {
        int index = key.hashCode() % hashDictionary.length;
        if (index < 0) {
            index = index + hashDictionary.length;
            index = linearProbe(index, key);
        }
        return index;
    }

    // Method to perform linear probing in case of collision
    private int linearProbe(int index, K key) {
        boolean found = false;
        int availableStateIndex = -1;

        while (!found && (hashDictionary[index] != null)) {
            if (hashDictionary[index] != AVAILABLE) {
                if (key.equals(hashDictionary[index].getKey()))
                    found = true;
                else
                    index = (index + 1) % hashDictionary.length;
            } else {
                if (availableStateIndex == -1)
                    availableStateIndex = index;
                index = (index + 1) % hashDictionary.length;
            }
        }
        if (found || (availableStateIndex == -1))
            return index;
        else
            return availableStateIndex;
    }

    // Method to add a key-value pair to the dictionary
    public V add(K key, V value) {
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        }

        else {
            V result;
            int index = getHashIndex(key);
           
           
            if (hashDictionary[index] == null) {
                collisionCount++;
                hashDictionary[index] = new Entry<>(key, value);
                numberOfEntries++;
                uniqueWordCount++;
                result = null;
            } else {
                result = hashDictionary[index].getValue();
                hashDictionary[index].setValue(value);

            }

            return result;
        }
    }

    // Method to get the value of a given key
    public V getValue(K key) {
        V result = null;
        int index = getHashIndex(key);
        if ((hashDictionary[index] != null) && (hashDictionary[index] != AVAILABLE)) {
            result = hashDictionary[index].getValue();
        }
        return result;
    }

    // Method to get an iterator over the keys in the dictionary
    public Iterator<K> getKeyIterator() {
        return new KeyIterator<>();
    }

    // Method to check if the dictionary is empty
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Unimplemented method.");
    }

    // Method to get the number of collisions occurred during hash operations
    public int getCollisionCount() {
        return collisionCount;
    }

    // Method to get the count of unique words in the dictionary
    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    // Method to remove a key-value pair from the dictionary
    public V remove(K key) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    // Method to check if a key exists in the dictionary
    public boolean contains(K key) {
        throw new UnsupportedOperationException("Unimplemented method.");
    }

    // Method to get an iterator over the values in the dictionary
    public Iterator<V> getValueIterator() {
        throw new UnsupportedOperationException("Unimplemented method.");
    }

    // Method to clear the dictionary
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method.");
    }

    // Method to get the size of the dictionary
    public int getSize() {
        return hashDictionary.length;
    }
}