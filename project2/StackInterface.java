//
// Name: Hakeem, Ayomide
// Project: #2
// Due: 19th March, 2024
// Course: cs-2400-03-sp24
//
// Description:
// This program takes in a list of infix expressions and converts 
// them to postfix expressions and evaluates them.
//

public interface StackInterface<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
