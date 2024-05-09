//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 04/30/2024
// Course: cs-2400-03-sp24
//
// Description:
// Menu System for Project 4
//

import java.util.Iterator;

public interface DictionaryInterface<K, V> {
    void add(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    int size();

    Iterator<V> getValueIterator();

}
