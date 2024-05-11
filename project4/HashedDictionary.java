//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//

import java.util.ArrayList;
import java.util.Iterator;

public class HashedDictionary<K, V> implements DictionaryInterface<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private Entry<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashedDictionary() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        boolean isActive; // to handle deleted items

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isActive = true;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public void add(K key, V value) {
        int index = hash(key);
        int originalIndex = index;
        boolean inserted = false;

        do {
            if (table[index] == null || !table[index].isActive) {
                table[index] = new Entry<>(key, value);
                size++;
                inserted = true;
            } else if (table[index].key.equals(key)) {
                table[index].value = value; // Overwrite existing value
                inserted = true;
            }
            index = (index + 1) % table.length;
        } while (!inserted && index != originalIndex);

        if (!inserted) {
            // Rehash or resize logic (needed here if the table is full)
            add(key, value); // retry to add again after resizing
        }
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry.isActive) {
                add(entry.key, entry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return table[index].value;
        }
        return null;
    }

    private int findIndex(K key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key) && table[index].isActive) {
                return index;
            }
            index = (index + 1) % table.length;
        }
        return -1; // unable to find the index i.e Not found
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        if (index != -1) {
            V value = table[index].value;
            table[index].isActive = false;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return findIndex(key) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> getValueIterator() {
        ArrayList<V> activeValues = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null && entry.isActive) {
                activeValues.add(entry.value);
            }
        }
        return activeValues.iterator();
    }

}
