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

public class DirectedGraph<T> implements GraphInterface<T> {
    private DictionaryInterface<T, VertexInterface<T>> vertices; // Using your HashedDictionary
    private int edgeCount;

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
        // Since your HashedDictionary doesn't have a clear method, recreate it
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
