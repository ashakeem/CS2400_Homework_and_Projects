// Name: Hakeem, Ayomide
// Project: 1
// Due: 02/15/2024
// Course: cs-2400-03-SP24

// Description:
// The project involves implementing an interface `BagInterface` and a class `ArrayBag` in Java
// and creating an application `JavaKeywords` that utilizes the implemented interface and class to
// to determine Java keywords from input.

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T> {

  private T[] bag;
  private int numberOfEntries;
  private static final int DEFAULT_CAPACITY = 100;

  public ArrayBag() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int capacity) {
    @SuppressWarnings("unchecked")
    T[] tempBag = (T[]) new Object[capacity];
    bag = tempBag;
    numberOfEntries = 0;
  }

  public int getCurrentSize() {
    return numberOfEntries;
  }

  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  public boolean add(T newEntry) {
    boolean result = true;
    if (isArrayFull()) {
      result = false;
    } else {
      bag[numberOfEntries] = newEntry;
      numberOfEntries++;
    }
    return result;
  }

  public T remove() {
    T result = removeEntry(numberOfEntries - 1);
    return result;
  }

  public boolean remove(T anEntry) {
    int index = getIndexOf(anEntry);
    T result = removeEntry(index);
    return anEntry.equals(result);
  }

  public void clear() {
    while (!isEmpty()) {
      remove();
    }
  }

  public int getFrequencyOf(T anEntry) {
    int frequency = 0;
    for (int i = 0; i < numberOfEntries; i++) {
      if (anEntry.equals(bag[i])) {
        frequency++;
      }
    }
    return frequency;
  }

  public boolean contains(T anEntry) {
    return getIndexOf(anEntry) > -1;
  }

  public T[] toArray() {
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[numberOfEntries];
    for (int i = 0; i < numberOfEntries; i++) {
      result[i] = bag[i];
    }
    return result;
  }

  private boolean isArrayFull() {
    return numberOfEntries >= bag.length;
  }

  private int getIndexOf(T anEntry) {
    int where = -1;
    boolean found = false;
    int index = 0;
    while (!found && (index < numberOfEntries)) {
      if (anEntry.equals(bag[index])) {
        found = true;
        where = index;
      }
      index++;
    }
    return where;
  }

  private T removeEntry(int givenIndex) {
    T result = null;
    if (!isEmpty() && (givenIndex >= 0)) {
      result = bag[givenIndex];
      bag[givenIndex] = bag[numberOfEntries - 1];
      bag[numberOfEntries - 1] = null;
      numberOfEntries--;
    }
    return result;
  }
}
