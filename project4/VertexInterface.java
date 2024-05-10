
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

/**
 * Interface for a vertex in a graph.
 *
 * @param <T> The type of data that this vertex stores.
 */
public interface VertexInterface<T> {

    /**
     * Gets the label of this vertex.
     *
     * @return The label of this vertex.
     */
    T getLabel();

    /**
     * Marks this vertex as visited.
     */
    void visit();

    /**
     * Marks this vertex as not visited.
     */
    void unvisit();

    /**
     * Checks if this vertex has been visited.
     *
     * @return True if this vertex has been visited, false otherwise.
     */
    boolean isVisited();

    /**
     * Connects this vertex to another vertex with a specified weight.
     *
     * @param endVertex The vertex to connect to.
     * @param edgeWeight The weight of the edge.
     * @return True if the connection is successful, false otherwise.
     */
    boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    /**
     * Connects this vertex to another vertex.
     *
     * @param endVertex The vertex to connect to.
     * @return True if the connection is successful, false otherwise.
     */
    boolean connect(VertexInterface<T> endVertex);

    /**
     * Gets an iterator for the neighbors of this vertex.
     *
     * @return An iterator for the neighbors of this vertex.
     */
    Iterator<VertexInterface<T>> getNeighborIterator();

    /**
     * Gets an iterator for the weights of the edges to each neighbor.
     *
     * @return An iterator for the weights of the edges to each neighbor.
     */
    Iterator<Double> getWeightIterator();

    /**
     * Checks if this vertex has any neighbors.
     *
     * @return True if this vertex has any neighbors, false otherwise.
     */
    boolean hasNeighbor();

    /**
     * Gets an unvisited neighbor of this vertex, if any.
     *
     * @return An unvisited neighbor of this vertex, or null if there are no unvisited neighbors.
     */
    VertexInterface<T> getUnvisitedNeighbor();

    /**
     * Sets the predecessor of this vertex.
     *
     * @param predecessor The vertex to set as predecessor.
     */
    void setPredecessor(VertexInterface<T> predecessor);

    /**
     * Gets the predecessor of this vertex.
     *
     * @return The predecessor of this vertex.
     */
    VertexInterface<T> getPredecessor();

    /**
     * Checks if this vertex has a predecessor.
     *
     * @return True if this vertex has a predecessor, false otherwise.
     */
    boolean hasPredecessor();

    /**
     * Sets the cost associated with this vertex.
     *
     * @param newCost The cost to set.
     */
    void setCost(double newCost);

    /**
     * Gets the cost associated with this vertex.
     *
     * @return The cost associated with this vertex.
     */
    double getCost();
}