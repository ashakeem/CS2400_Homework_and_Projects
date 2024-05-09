
//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/08/2024
// Course: cs-2400-03-sp24
//
// Description:
// Distances and Shortest Path between Airports
//

import java.util.Iterator;

public interface VertexInterface<T> {
    T getLabel();

    void visit();

    void unvisit();

    boolean isVisited();

    boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    boolean connect(VertexInterface<T> endVertex);

    Iterator<VertexInterface<T>> getNeighborIterator();

    Iterator<Double> getWeightIterator();

    boolean hasNeighbor();

    VertexInterface<T> getUnvisitedNeighbor();

    void setPredecessor(VertexInterface<T> predecessor);

    VertexInterface<T> getPredecessor();

    boolean hasPredecessor();

    void setCost(double newCost);

    double getCost();
}
