//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//

import java.util.Iterator;
import java.util.PriorityQueue;

public class DirectedGraph<T extends Comparable<? super T>> implements GraphInterface<T> {
    private DictionaryInterface<T, VertexInterface<T>> vertices; // Using your HashedDictionary
    private int edgeCount;

    public class EntryPQ implements Comparable<EntryPQ> {
        T vertexLabel;
        double cost;
        T predecessor;

        public EntryPQ(T vertexLabel, double cost, T predecessor) {
            this.vertexLabel = vertexLabel;
            this.cost = cost;
            this.predecessor = predecessor;
        }

        public T getVertexLabel() {
            return vertexLabel;
        }

        public double getCost() {
            return cost;
        }

        public T getPredecessor() {
            return predecessor;
        }

        @Override
        public int compareTo(EntryPQ other) {
            if (this.cost == other.cost)
                return 0;
            else if (this.cost > other.cost)
                return 1;
            else
                return -1;
        }
    }

    public DirectedGraph() {
        vertices = new HashedDictionary<>(); // Initialized with your custom dictionary
        edgeCount = 0;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        VertexInterface<T> addOutcome = vertices.get(vertexLabel);
        if (addOutcome == null) { // vertex not already present
            vertices.add(vertexLabel, new Vertex<>(vertexLabel));
            return true;
        }
        return false; // vertex already exists
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if (beginVertex != null && endVertex != null) {
            result = beginVertex.connect(endVertex, edgeWeight);
            if (result) {
                edgeCount++;
            }
        }
        return result;
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if (beginVertex != null && endVertex != null) {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return vertices.size() == 0;
    }

    @Override
    public void clear() {

        vertices = new HashedDictionary<>();
        edgeCount = 0;
    }

    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    }

    @Override
    public void resetVertices() {
        // Iterate through all vertices and reset them
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext()) {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    @Override
    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        return null;
    }

    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        return null;
    }

    @Override
    public StackInterface<T> getTopologicalOrder() {
        return null;
    }

    @Override
    public int getShortestPath(T begin, T end, StackInterface<T> path) {
        return 0;
    }

    @Override

    public double getCheapestPath(T begin, T end, StackInterface<T> path) {
        resetVertices();
        PriorityQueueInterface<EntryPQ> priorityQueue = new MinHeapPriorityQueue<>();

        priorityQueue.add(new EntryPQ(begin, 0, null));

        VertexInterface<T> startVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        boolean done = false;
        while (!done && !priorityQueue.isEmpty()) {
            EntryPQ frontEntry = priorityQueue.removeMin();
            T frontVertexLabel = frontEntry.getVertexLabel();
            VertexInterface<T> frontVertex = vertices.get(frontVertexLabel);

            frontVertex.visit(); // Mark the front vertex as visited

            if (frontVertex.equals(endVertex)) {
                done = true; // We've reached the end vertex, stop the algorithm
            } else {
                Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                Iterator<Double> weights = frontVertex.getWeightIterator();

                while (neighbors.hasNext()) {
                    VertexInterface<T> nextNeighbor = neighbors.next();
                    double weightOfEdgeToNeighbor = weights.next();
                    if (!nextNeighbor.isVisited()) {
                        double edgeWeight = weightOfEdgeToNeighbor;
                        double newCost = frontVertex.getCost() + edgeWeight;
                        if (newCost < nextNeighbor.getCost()) {
                            nextNeighbor.setCost(newCost);
                            nextNeighbor.setPredecessor(frontVertex);
                            priorityQueue.add(new EntryPQ(nextNeighbor.getLabel(), newCost,
                                    frontVertex.getLabel()));
                        }
                    }
                }
            }
        }

        // Reconstruct the path from the end vertex to the start using predecessors
        path.clear();
        VertexInterface<T> vertex = endVertex;
        path.push(vertex.getLabel());
        while (vertex.hasPredecessor()) {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        }

        return endVertex.getCost(); // Return the cost of the path found
    }

    // add this debug method to your DirectedGraph
    public void show() {
        Iterator<VertexInterface<T>> verticesIt = vertices.getValueIterator();

        while (verticesIt.hasNext()) {
            VertexInterface<T> vertex = verticesIt.next();
            System.out.printf("%s ->", vertex.getLabel());
            Iterator<VertexInterface<T>> neighborIt = vertex.getNeighborIterator();
            if (neighborIt.hasNext()) {
                while (neighborIt.hasNext()) {
                    vertex = neighborIt.next();
                    System.out.printf(" %s", vertex.getLabel());
                }
                System.out.println();
            } else {
                System.out.println("no neighbors");
            }
        }
    }
}
