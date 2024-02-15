// Name: Hakeem, Ayomide
// Project: 1
// Due: 02/15/2024
// Course: cs-2400-03-SP24

// Description:
// The project involves implementing an interface `BagInterface` and a class `ArrayBag` in Java
// and creating an application `JavaKeywords` that utilizes the implemented interface and class to
// to determine Java keywords from input.

public interface BagInterface<T> {
  public int getCurrentSize();

  public boolean isEmpty();

  public boolean add(T newEntry);

  public T remove();

  public boolean remove(T anEntry);

  public void clear();

  public int getFrequencyOf(T anEntry);

  public boolean contains(T anEntry);

  public T[] toArray();
}
