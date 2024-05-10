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

/**
 * Interface for Graph.
 *
 * @param <T> the type of the vertex label
 */

public interface GraphInterface<T> {
    /**
     * Adds a vertex with the given label to the graph.
     *
     * @param vertexLabel the label of the vertex to be added
     * @return true if the vertex is successfully added, false otherwise
     */
    boolean addVertex(T vertexLabel);

    /**
     * Adds an edge between the vertices with the given labels and assigns it the
     * given weight.
     *
     * @param begin      the label of the starting vertex
     * @param end        the label of the ending vertex
     * @param edgeWeight the weight of the edge
     * @return true if the edge is successfully added, false otherwise
     */
    boolean addEdge(T begin, T end, double edgeWeight);

    /**
     * Checks if an edge exists between the vertices with the given labels.
     *
     * @param begin the label of the starting vertex
     * @param end   the label of the ending vertex
     * @return true if an edge exists between the vertices, false otherwise
     */
    boolean hasEdge(T begin, T end);

    /**
     * Checks if the graph is empty.
     *
     * @return true if the graph is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Clears the graph, removing all vertices and edges.
     */
    void clear();

    /**
     * Gets the number of vertices in the graph.
     *
     * @return the number of vertices in the graph
     */
    int getNumberOfVertices();

    /**
     * Gets the number of edges in the graph.
     *
     * @return the number of edges in the graph
     */
    int getNumberOfEdges();

    /**
     * Resets the visited flags of all vertices in the graph.
     */
    void resetVertices();

    /**
     * Displays the graph.
     */
    void show();
}
