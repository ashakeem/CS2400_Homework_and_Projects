//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//


/**
 * An interface of methods that process an existing graph.
 * This interface defines the essential algorithms used in graph processing,
 * including breadth-first and depth-first traversals, topological sorting, and
 * pathfinding algorithms for shortest and cheapest paths.
 * 
 * @param <T> the type of data stored in the graph's vertices
 */
public interface GraphAlgorithmsInterface<T> {

    /**
     * Performs a breadth-first traversal of this graph.
     * 
     * @param origin An object that labels the origin vertex of the traversal.
     * @return A queue of labels of the vertices in the traversal, with
     *         the label of the origin vertex at the queue's front.
     */
    QueueInterface<T> getBreadthFirstTraversal(T origin);

    /**
     * Performs a depth-first traversal of this graph.
     * 
     * @param origin An object that labels the origin vertex of the traversal.
     * @return A queue of labels of the vertices in the traversal, with
     *         the label of the origin vertex at the queue's front.
     */
    QueueInterface<T> getDepthFirstTraversal(T origin);

    /**
     * Performs a topological sort of the vertices in this graph without cycles.
     * 
     * @return A stack of vertex labels in topological order, beginning
     *         with the stack's top.
     */
    StackInterface<T> getTopologicalOrder();

    /**
     * Finds the shortest-length path between two given vertices in this graph.
     * 
     * @param begin An object that labels the path's origin vertex.
     * @param end An object that labels the path's destination vertex.
     * @param path A stack of labels that is empty initially; at the completion
     *             of the method, this stack contains the labels of the vertices
     *             along the shortest path; the label of the origin vertex is at the top,
     *             and the label of the destination vertex is at the bottom.
     * @return The length of the shortest path.
     */
    int getShortestPath(T begin, T end, StackInterface<T> path);

    /**
     * Finds the least-cost path between two given vertices in this graph.
     * 
     * @param begin An object that labels the path's origin vertex.
     * @param end An object that labels the path's destination vertex.
     * @param path A stack of labels that is empty initially; at the completion
     *             of the method, this stack contains the labels of the vertices
     *             along the cheapest path; the label of the origin vertex is at the top,
     *             and the label of the destination vertex is at the bottom.
     * @return The cost of the cheapest path.
     */
    double getCheapestPath(T begin, T end, StackInterface<T> path);
}
