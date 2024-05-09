//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/08/2024
// Course: cs-2400-03-sp24
//
// Description:
// Distances and Shortest Path between Airports
//

import java.util.*;
import java.util.Iterator;

public interface GraphInterface<T> {
    boolean addVertex(T vertexLabel);

    boolean addEdge(T begin, T end, double edgeWeight);

    boolean hasEdge(T begin, T end);

    boolean isEmpty();

    void clear();

    int getNumberOfVertices();

    int getNumberOfEdges();

    void resetVertices();

    void show();
}
